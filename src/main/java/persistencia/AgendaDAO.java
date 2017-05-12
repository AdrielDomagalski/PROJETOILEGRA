package persistencia;

import database.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import negocio.Agenda;

/**
 *
 * @author ilegra0267
 */
public class AgendaDAO {
    ConectaBanco con = new ConectaBanco();
    ConectaBanco conPaciente = new ConectaBanco();
    ConectaBanco conMedico = new ConectaBanco();

    Agenda agenda  = new Agenda();
    int codMedico;
    int codPaciente;

    public boolean salvar(Agenda agenda) {
        buscaMedico(agenda.getNomeMedico());
        buscaPaciente(agenda.getNomePaciente());
        con.Conexão();
        try {
            PreparedStatement stmt = con.con.prepareStatement("INSERT INTO agenda ( id_paciente, turno, id_medico, dataConsulta, Motivo,  agenda_status) VALUES(?, ?, ?, ?, ?, ?);");

            stmt.setInt(1, codPaciente);
            stmt.setString(2, agenda.getTurno());
            stmt.setInt(3, codMedico);
            stmt.setString(4,agenda.getData());
            stmt.setString(5,agenda.getMotivo());
            stmt.setString(6, agenda.getStatus());
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showInputDialog("Erro ao salvar Agendamento", ex);
        }
        con.Desconecta();
        return false;
    }
    public boolean buscaMedico(String nomeMedico){
        conMedico.Conexão();
        conMedico.ExecutaSql("select * from medico where nome ='"+nomeMedico+"'");
        try {
            conMedico.rs.first();
            codMedico = conMedico.rs.getInt("id");
        } catch (SQLException ex) {
            JOptionPane.showInputDialog("Erro ao buscar medico", ex);
        }
        conMedico.Desconecta();

        return false;

    }

    public boolean buscaPaciente(String nomePaciente){
        conPaciente.Conexão();
        conPaciente.ExecutaSql("select * from paciente where nome ='"+nomePaciente+"'");
        try {
            conPaciente.rs.first();
            codPaciente = conPaciente.rs.getInt("id");
        } catch (SQLException ex) {
            JOptionPane.showInputDialog("Erro ao buscar Paciente", ex);
        }
        conPaciente.Desconecta();

        return false;


    }
}