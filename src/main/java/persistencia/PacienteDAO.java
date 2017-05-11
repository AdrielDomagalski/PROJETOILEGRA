package persistencia;

import java.sql.PreparedStatement;
import database.ConectaBanco;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import negocio.Paciente;

public class PacienteDAO {
    ConectaBanco conn = new ConectaBanco();
    private PreparedStatement sqlListar;
    private PreparedStatement sqlCarregar;
    Paciente paciente = new Paciente();

    public boolean salvar(Paciente paciente) throws SQLException{
        conn.Conexão();

        try {
            PreparedStatement stmt = conn.con.prepareStatement("INSERT INTO paciente ( nome, cpf, telefone, dataNascimento, tipoConsulta, sexo) VALUES(?,?,?,?,?,?);");

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getTelefone());
            stmt.setString(4,paciente.getDataNascimento());
            stmt.setString(5, paciente.getTipoConsulta());
            stmt.setString(6, paciente.getSexo());
            stmt.executeUpdate();


            return true;
        } catch (SQLException ex) {
            return false;
        } finally{

            conn.con.close();
        }
    }



    public boolean excluir(Paciente paciente) throws SQLException{
        conn.Conexão();

        try {
            PreparedStatement stmt = conn.con.prepareStatement("DELETE FROM paciente WHERE cpf = ?");
            stmt.setString(1, paciente.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally{
            conn.con.close();
        }

    }
    public Paciente BuscaPaciente(Paciente paciente){
        conn.Conexão();
        try {
            conn.ExecutaSql("SELECT * FROM paciente WHERE nome LIKE'%" + paciente.getPesquisa()+"%'" );
            conn.rs.first();
            paciente.setId(conn.rs.getInt("id"));
            paciente.setNome(conn.rs.getString("nome"));
            paciente.setTelefone(conn.rs.getString("Telefone"));
            paciente.setSexo(conn.rs.getString("sexo"));


        } catch (SQLException ex) {
            JOptionPane.showInputDialog("Erro ao buscar medico", ex);
        }
        return paciente;
    }
}