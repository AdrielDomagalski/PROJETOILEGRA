package persistencia;

import java.sql.PreparedStatement;
import database.ConectaBanco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.Medico;

public class MedicoDAO {
    ConectaBanco conn = new ConectaBanco();
    private PreparedStatement sqlListar;
    private PreparedStatement sqlCarregar;
    Medico medico = new Medico();

    public boolean salvar(Medico medico) throws SQLException{
        conn.Conexão();

        try {
            PreparedStatement stmt = conn.con.prepareStatement("INSERT INTO medico ( nome, crm, cpf,  telefone, email, dataNascimento, especialidade, sexo, endereco) VALUES(?,?,?,?,?,?,?,?,?);");

            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.setString(3, medico.getCpf());
            stmt.setString(4, medico.getTelefone());
            stmt.setString(5, medico.getEmail());
            stmt.setString(6, medico.getDataNascimento());
            stmt.setString(7, medico.getEspecialidade());
            stmt.setString(8, medico.getSexo());
            stmt.setString(9, medico.getEndereco());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally{

            conn.con.close();
        }
    }


    public boolean excluir(Medico medico){
        conn.Conexão();

        try {
            PreparedStatement stmt = conn.con.prepareStatement("DELETE FROM medico WHERE id = ?");
            stmt.setInt(1, medico.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally{

        }

    }

    public Medico BuscaMedico(Medico med){
        conn.Conexão();
        try {
            conn.ExecutaSql("SELECT * FROM medico WHERE nome LIKE'%" + medico.getPesquisa()+"%'" );
            conn.rs.first();
            medico.setId(conn.rs.getInt("id"));
            medico.setNome(conn.rs.getString("nome"));
            medico.setCrm(conn.rs.getString("crm"));
            medico.setCpf(conn.rs.getString("cpf"));
            medico.setTelefone(conn.rs.getString("telefone"));
            medico.setEmail(conn.rs.getString("email"));
            medico.setDataNascimento(conn.rs.getString("dataNascimento"));
            medico.setEspecialidade(conn.rs.getString("especialidade"));
            medico.setSexo(conn.rs.getString("sexo"));
            medico.setEndereco(conn.rs.getString("endereco"));

        } catch (SQLException ex) {
            JOptionPane.showInputDialog("Erro ao buscar medico", ex);
        }
        return medico;
    }
}
