package br.com.benicioforno.GTCC.Service;

import br.com.benicioforno.GTCC.Model.PropostaTCC;
import br.com.benicioforno.GTCC.Model.Status;
import br.com.benicioforno.GTCC.Repository.PropostaTCCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

@Service
public class VerificadorDePrazosService {

    private static final Logger logger = LoggerFactory.getLogger(VerificadorDePrazosService.class);

    @Autowired
    private PropostaTCCRepository propostaTCCRepository;

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void verificarPrazosDasProposta(){
        logger.info("Iniciando verificação dos prazos das propostas.");

        LocalDate dataLimite = LocalDate.now().minusDays(7);

        List<PropostaTCC> propostasEmAnalise = propostaTCCRepository.findByStatus(Status.EM_ANALISE);

        int propostasExpiradas = 0;

        for (PropostaTCC proposta : propostasEmAnalise) {
            if (proposta.getDataAlteracaoStatus() != null && proposta.getDataAlteracaoStatus().isBefore(dataLimite)) {
                logger.info("Proposta ID {} expirou. Voltando para DISPONIVEL.", proposta.getId());

                proposta.setStatus(Status.DISPONIVEL);
                proposta.setAlunoInteressado(null);
                proposta.setDataAlteracaoStatus(LocalDate.now());
                propostasExpiradas++;
            }
        }

        logger.info("Verificação de prazos finalizada. {} propostas foram expiradas.", propostasExpiradas);
    }
}
