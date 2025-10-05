package br.com.benicioforno.GTCC.Repository;

import br.com.benicioforno.GTCC.Model.PropostaTCC;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropostaTCCRepository extends JpaRepository<PropostaTCC, Long> {
    public List<PropostaTCC> findByNomeProfessorIgnoreCase(String nome);
    public List<PropostaTCC> findByConhecimentoNecessarioContainingIgnoreCase(String conhecimentoNecessario);
}
