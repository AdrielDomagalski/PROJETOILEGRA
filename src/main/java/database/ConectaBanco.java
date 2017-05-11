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