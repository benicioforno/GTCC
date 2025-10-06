package br.com.benicioforno.GTCC.Repository;

import br.com.benicioforno.GTCC.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    public List<Aluno> findByNomeContainingIgnoreCase(String nome);
    public List<Aluno> findByMatriculaContaining(String matricula);
}
