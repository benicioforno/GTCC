package br.com.benicioforno.GTCC.Model;

import java.util.List;
import java.util.Objects;

public class Professor {
    private Long id;
    private String nome;
    private String email;
    private String areasDeInteresse;

    public Professor(String nome, String email, String areasDeInteresse) {
        setNome(nome);
        setEmail(email);
        setAreasDeInteresse(areasDeInteresse);
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
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

    public String getAreasDeInteresse() {
        return areasDeInteresse;
    }

    public void setAreasDeInteresse(String areasDeInteresse) {
        this.areasDeInteresse = areasDeInteresse;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", areasDeInteresse='" + areasDeInteresse + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id) && Objects.equals(nome, professor.nome) && Objects.equals(email, professor.email) && Objects.equals(areasDeInteresse, professor.areasDeInteresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, areasDeInteresse);
    }
}
