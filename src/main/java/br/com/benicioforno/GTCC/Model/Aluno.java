package br.com.benicioforno.GTCC.Model;

import java.util.Objects;

public class Aluno {
    private Long id;
    private String matricula;
    private String nome;
    private String email;
    private String telefone;

    public Aluno(String matricula, String nome, String email, String telefone) {
        setMatricula(matricula);
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id) && Objects.equals(matricula, aluno.matricula) && Objects.equals(nome, aluno.nome) && Objects.equals(email, aluno.email) && Objects.equals(telefone, aluno.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matricula, nome, email, telefone);
    }
}
