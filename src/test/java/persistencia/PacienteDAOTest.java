package persistencia;

import negocio.Paciente;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adriel on 11/05/2017.
 */
public class PacienteDAOTest {
    PacienteDAO dao = mock(PacienteDAO.class);
    Paciente paciente = new Paciente();
    @Test
    public void salvarTest(){
        when(dao.salvar(paciente)).thenReturn(true);

        Assert.assertTrue(dao.salvar(paciente));
    }
}
