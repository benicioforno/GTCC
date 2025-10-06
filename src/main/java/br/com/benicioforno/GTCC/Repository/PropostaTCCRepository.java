package br.com.benicioforno.GTCC.Repository;

import br.com.benicioforno.GTCC.Model.PropostaTCC;
import br.com.benicioforno.GTCC.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropostaTCCRepository extends JpaRepository<PropostaTCC, Long> {
    public List<PropostaTCC> findByProfessorNomeIgnoreCase(String nome);
    public List<PropostaTCC> findByConhecimentosNecessariosContainingIgnoreCase(String conhecimentoNecessario);
    public List<PropostaTCC> findByStatus(Status status);
}
