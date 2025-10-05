package br.com.benicioforno.GTCC.Repository;

import br.com.benicioforno.GTCC.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    public List<Professor> findByNomeContainingIgnoreCase(String nome);
}
