package persistencia;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ilegra0267
 */
public class ModeloTabela extends AbstractTableModel{
    protected ArrayList linhas = null;
    protected String[] colunas = null;

    public ModeloTabela(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList dados) {
        this.linhas = dados;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] nomes) {
        this.colunas = nomes;
    }

    public int  getColumnCount(){
        return colunas.length;
    }
    public int getRowCount(){
        return linhas.size();
    }
    public String getColumnName(int numCol){
        return colunas[numCol];

    }
    public Object getValueAt(int numLin, int numCol){
        Object[] linha =(Object[])getLinhas().get(numLin);
        return linha [numCol];
    }
}
