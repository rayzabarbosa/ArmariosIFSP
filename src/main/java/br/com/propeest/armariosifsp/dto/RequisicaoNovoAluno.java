package br.com.propeest.armariosifsp.dto;

import br.com.propeest.armariosifsp.models.Aluno;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//É uma classe DTO (Data Transfer Object)
public class RequisicaoNovoAluno {
    @NotBlank
    @NotNull
    private String nome;
    @NotBlank
    @NotNull
    private String rg;
    @NotBlank
    @NotNull
    @CPF
    private String cpf;
    @NotBlank
    @NotNull
    private String registro;
    @NotBlank
    @NotNull
    private String ano;
    @NotBlank
    @NotNull
    private String turma;
    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private String telefone;
    @NotBlank
    @NotNull
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Aluno toAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(this.nome);
        aluno.setRg(this.rg);
        aluno.setCpf(this.cpf);
        aluno.setRegistro(this.registro);
        aluno.setAno(this.ano);
        aluno.setTurma(this.turma);
        aluno.setEmail(this.email);
        aluno.setTelefone(this.telefone);
        aluno.setSenha(this.senha);

        return aluno;
    }

    @Override
    public String toString() {
        return "RequisicaoNovoAluno{" +
                "nome='" + nome + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", registro='" + registro + '\'' +
                ", ano='" + ano + '\'' +
                ", turma='" + turma + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
