package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author adril
 */
public class ConectaBanco {


    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/clinica";
    private String usuario = "root";
    private String senha = "1234";
    public Connection con;

    public void  Conexão(){
        System.setProperty("jdbc.Drivers", driver);
        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
            // JOptionPane.showMessageDialog(null,"conectado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar o banco de dados" + ex.getMessage());
        }
    }

    public void ExecutaSql(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no executaSQL() \n" + ex);
        }

    }
    public void Desconecta(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao fechar a conexão" + ex.getMessage());
        }
    }
}
//-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
//        --
//        -- Host: localhost    Database: clinica
//        -- ------------------------------------------------------
//        -- Server version	5.7.17-log
//
///*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
///*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
///*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
///*!40101 SET NAMES utf8 */;
///*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
///*!40103 SET TIME_ZONE='+00:00' */;
///*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
///*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
///*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
///*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
//
//        --
//        -- Table structure for table `agenda`
//        --
//        CREATE DATABASE 'clinica';
//        use clinica;
//
//        DROP TABLE IF EXISTS `agenda`;
///*!40101 SET @saved_cs_client     = @@character_set_client */;
///*!40101 SET character_set_client = utf8 */;
//        CREATE TABLE `agenda` (
//        `id` int(11) NOT NULL AUTO_INCREMENT,
//        `id_paciente` int(11) DEFAULT NULL,
//        `turno` varchar(100) DEFAULT NULL,
//        `id_medico` int(11) DEFAULT NULL,
//        `dataConsulta` varchar(50) DEFAULT NULL,
//        `Motivo` varchar(300) DEFAULT NULL,
//        `agenda_status` varchar(300) DEFAULT NULL,
//        PRIMARY KEY (`id`),
//        KEY `agenda_paciente_fk_idx` (`id_paciente`),
//        KEY `agenda_medico_fk_idx` (`id_medico`),
//        CONSTRAINT `agenda_medico_fk` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
//        CONSTRAINT `agenda_paciente_fk` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
//        ) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
///*!40101 SET character_set_client = @saved_cs_client */;
//
//        --
//        -- Dumping data for table `agenda`
//        --
//
//        LOCK TABLES `agenda` WRITE;
///*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
//        INSERT INTO `agenda` VALUES (6,3,'Manhã',1,'2017-05-18','ksoa','Aberto'),(7,4,'Tarde',1,'2017-05-18','dor de estomago','Aberto'),(8,3,'Manhã',1,'2017-05-10','jsuhushu','Aberto'),(9,3,'Tarde',3,'2017-05-18','sjaushuashuahsa','Aberto'),(10,4,'Tarde',1,'2017-05-11','ajjsiajsiajs','Aberto'),(11,3,'Manhã',1,'2017-05-18','qualquer','Aberto'),(12,3,'Manhã',2,'2017-05-12','kl','Aberto'),(13,4,'Manhã',4,'2017-05-18','sjaushuahsua','Aberto'),(14,3,'Manhã',2,'2017-05-18','ushuahsuahsuash','Aberto'),(15,4,'Manhã',4,'12/05/2017','qualquer','Aberto'),(16,4,'Noite',9,'13/05/2017','qualquer','Aberto');
///*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
//        UNLOCK TABLES;
//
//        --
//        -- Table structure for table `medico`
//        --
//
//        DROP TABLE IF EXISTS `medico`;
///*!40101 SET @saved_cs_client     = @@character_set_client */;
///*!40101 SET character_set_client = utf8 */;
//        CREATE TABLE `medico` (
//        `id` int(11) NOT NULL AUTO_INCREMENT,
//        `nome` varchar(150) DEFAULT NULL,
//        `crm` varchar(150) DEFAULT NULL,
//        `cpf` varchar(150) DEFAULT NULL,
//        `telefone` varchar(100) DEFAULT NULL,
//        `email` varchar(100) DEFAULT NULL,
//        `dataNascimento` varchar(50) DEFAULT NULL,
//        `especialidade` varchar(100) DEFAULT NULL,
//        `sexo` varchar(50) DEFAULT NULL,
//        `endereco` varchar(200) DEFAULT NULL,
//        PRIMARY KEY (`id`)
//        ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
///*!40101 SET character_set_client = @saved_cs_client */;
//
//        --
//        -- Dumping data for table `medico`
//        --
//
//        LOCK TABLES `medico` WRITE;
///*!40000 ALTER TABLE `medico` DISABLE KEYS */;
//        INSERT INTO `medico` VALUES (1,'adriel','121.212.121-21','878.987.655-55','(51)99099.0999','adriel.soares@gmail.com','14/03/1997','psicologo','masculino','rua armando pedro'),(2,'elias ferreira soares','870.950.288-12','281.989.189-28','(51)90182.8191','elias.ferreira@gmail.com','12/02/1990','medico','masculino','rua jose callos barbosa'),(3,'Paulo Perrone','832901839-8/BR','192.830.192-83','(51)98909.0900','paulo.perrone@gmail.com','21/21/2122','cerurgião','masvulino','rua tals'),(4,'fabia domagalski','378189728-9/BR','932.039.029-32','(51)00000.0000','fabia@gmail.com','21/21/2121','Perita','feminino','rua vicente'),(5,'ajsiahsuhushu','932803981-2/BR','392.183.129-38','(12)93821.9382','adrieel@gmail.com','17/26/1782','jaijsiajsiajs','masculino','rua chavez'),(6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'Jose','212121221-2/BR','121.212.121-21','(51)99090.9090','jose@gmail.com','12/21/3112','qualquer','feminino','rua silva'),(10,'Nicolas Peruch','121212121-2/BR','232.321.321-32','(51)90909.9090','adriel.soares3@gmail.com','13/12/2013','Ginecologista','masculino','rua pagao');
///*!40000 ALTER TABLE `medico` ENABLE KEYS */;
//        UNLOCK TABLES;
//
//        --
//        -- Table structure for table `paciente`
//        --
//
//        DROP TABLE IF EXISTS `paciente`;
///*!40101 SET @saved_cs_client     = @@character_set_client */;
///*!40101 SET character_set_client = utf8 */;
//        CREATE TABLE `paciente` (
//        `id` int(11) NOT NULL AUTO_INCREMENT,
//        `nome` varchar(200) DEFAULT NULL,
//        `cpf` varchar(60) DEFAULT NULL,
//        `telefone` varchar(60) DEFAULT NULL,
//        `dataNascimento` varchar(50) DEFAULT NULL,
//        `tipoConsulta` varchar(100) DEFAULT NULL,
//        `sexo` varchar(50) DEFAULT NULL,
//        PRIMARY KEY (`id`)
//        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
///*!40101 SET character_set_client = @saved_cs_client */;
//
//        --
//        -- Dumping data for table `paciente`
//        --
//
//        LOCK TABLES `paciente` WRITE;
///*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
//        INSERT INTO `paciente` VALUES (1,'elias','213.232.324-32','(51)98089.6969','masculino','14/03/1998','psiclogo'),(2,'adriel','318.938.138-91','(51)90910.9090','14/03/1999','psiclogo','masculino'),(3,'Suellen Zanotelli','121.212.121-21','(89)18209.8120','12/12/1212','sjiajsiajs','feminino'),(4,'Isadora Domagalski','392.382.903-82','(19)21092.0192','13/09/0390','soaksoapksp','feminino');
///*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
//        UNLOCK TABLES;
///*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
//
///*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
///*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
///*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
///*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
///*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
///*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
///*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
//
//        -- Dump completed on 2017-05-11 22:03:59
