package br.com.benicioforno.GTCC.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class PropostaTCC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "aluno_interessado_id")
    private Aluno alunoInteressado;

    private LocalDate dataAlteracaoStatus;
    private String titulo;
    private String descricao;
    private String conhecimentosNecessarios;
    private Status status;

    public PropostaTCC(){
    }

    public PropostaTCC(Professor professor, String titulo, String descricao, String conhecimentosNecessarios) {
        this.status = Status.DISPONIVEL;
        setProfessor(professor);
        setTitulo(titulo);
        setDescricao(descricao);
        setConhecimentosNecessarios(conhecimentosNecessarios);
    }

    public LocalDate getDataAlteracaoStatus() {
        return dataAlteracaoStatus;
    }

    public void setDataAlteracaoStatus(LocalDate dataAlteracaoStatus) {
        this.dataAlteracaoStatus = dataAlteracaoStatus;
    }

    public Aluno getAlunoInteressado() {
        return alunoInteressado;
    }

    public void setAlunoInteressado(Aluno alunoInteressado) {
        this.alunoInteressado = alunoInteressado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConhecimentosNecessarios() {
        return conhecimentosNecessarios;
    }

    public void setConhecimentosNecessarios(String conhecimentosNecessarios) {
        this.conhecimentosNecessarios = conhecimentosNecessarios;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PropostaTCCs{" +
                "id=" + id +
                ", professor=" + professor +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", conhecimentosNecessarios='" + conhecimentosNecessarios + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PropostaTCC that = (PropostaTCC) o;
        return Objects.equals(id, that.id) && Objects.equals(professor, that.professor) && Objects.equals(titulo, that.titulo) && Objects.equals(descricao, that.descricao) && Objects.equals(conhecimentosNecessarios, that.conhecimentosNecessarios) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, professor, titulo, descricao, conhecimentosNecessarios, status);
    }
}
