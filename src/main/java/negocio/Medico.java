package negocio;

import java.util.Date;

/**
 *
 * @author Adriel
 */
public class Medico {
    protected int id;
    protected String nome;
    protected String crm;
    protected String cpf;
    protected String telefone;
    protected String email;
    protected String dataNascimento;
    protected String especialidade;
    protected String sexo;
    protected String endereco;
    protected String pesquisa;

    @Override
    public String toString() {
        return "Medico{" + ", nome=" + nome + ", crm=" + crm + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + ", dataNascimento=" + dataNascimento + ", especialidade=" + especialidade + ", sexo=" + sexo + ", endereco=" + endereco + '}';
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
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
//        if(telefone.matches("^\\([0-9]{2}\\) [0-9]{4}-[0-9]{4}$"))
        this.telefone = telefone;
//        else
//            throw new IllegalArgumentException("Telefone inválido!");
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.matches("^[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\.]+$"))
            this.email = email;
        else
            throw new IllegalArgumentException("E-mail inválido!");
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
