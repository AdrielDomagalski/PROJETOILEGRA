package persistencia;

import junit.framework.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import negocio.Agenda;

/**
 * Created by Adriel on 11/05/2017.
 */
public class AgendaDAOTest {
    AgendaDAO dao = mock (AgendaDAO.class);
    Agenda agenda = new Agenda();
    @Test
    public void salvarTest(){
        when(dao.salvar(agenda)).thenReturn(true);

        Assert.assertTrue(dao.salvar(agenda));

    }
}
