package negocio;

/**
 * Created by Adriel on 10/05/2017.
 */
import java.util.Date;

/**
 *
 * @author Adriel
 */
public class Paciente {
    protected int id;
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected String dataNascimento;
    protected String tipoConsulta;
    protected String sexo;
    protected String pesquisa;


    @Override
    public String toString() {
        return "Paciente{" + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", dataNascimento=" + dataNascimento + ", tipoConsulta=" + tipoConsulta + ", sexo=" + sexo + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
//         if(telefone.matches("^\\([0-9]{2}\\) [0-9]{4}-[0-9]{4}$"))
        this.telefone = telefone;
//        else
//            throw new IllegalArgumentException("Telefone inválido!");
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

}
