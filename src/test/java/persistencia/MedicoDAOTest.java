package persistencia;

import negocio.Medico;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Created by Adriel on 11/05/2017.
 */
public class MedicoDAOTest {
   MedicoDAO dao = mock (MedicoDAO.class);
    Medico medico = new Medico();
    @Test
    public void salvarTest(){
        when(dao.salvar(medico)).thenReturn(true);

        Assert.assertTrue(dao.salvar(medico));

    }
}
