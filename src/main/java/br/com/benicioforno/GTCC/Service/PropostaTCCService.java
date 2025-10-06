package br.com.benicioforno.GTCC.Service;

import br.com.benicioforno.GTCC.Model.Aluno;
import br.com.benicioforno.GTCC.Model.PropostaTCC;
import br.com.benicioforno.GTCC.Model.Status;
import br.com.benicioforno.GTCC.Repository.AlunoRepository;
import br.com.benicioforno.GTCC.Repository.PropostaTCCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PropostaTCCService {

    @Autowired
    private PropostaTCCRepository propostaTCCRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    public void mudarStatus(Long idProposta, Status novoStatus, Long idAluno){
        if(idProposta == null){
            throw new RuntimeException("ID da proposta nulo.");
        }
        if(idAluno == null){
            throw new RuntimeException("ID do aluno nulo.");
        }

        PropostaTCC propostaTCC = propostaTCCRepository.findById(idProposta).orElseThrow(() -> new RuntimeException("Proposta com ID " + idProposta + " não encontrado."));

        if(novoStatus == Status.EM_ANALISE || novoStatus == Status.ACEITA){
            Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(() -> new RuntimeException("Aluno com ID " + idAluno + " não encontrado."));
            propostaTCC.setAlunoInteressado(aluno);
            propostaTCC.setStatus(novoStatus);
            propostaTCC.setDataAlteracaoStatus(LocalDate.now());
            propostaTCCRepository.save(propostaTCC);
        } else if (novoStatus == Status.DISPONIVEL) {
            propostaTCC.setAlunoInteressado(null);
            propostaTCC.setStatus(novoStatus);
            propostaTCC.setDataAlteracaoStatus(null);
            propostaTCCRepository.save(propostaTCC);
        }
    }

    public List<PropostaTCC> listar(){
        return propostaTCCRepository.findAll();
    }

    @Transactional
    public void inserir(PropostaTCC propostaTCC){
        if(propostaTCC == null){
            throw new RuntimeException("Proposta de TCC nula"); //criar exception
        }
        propostaTCCRepository.save(propostaTCC);
    }

    @Transactional
    public void deletar(Long id){
        if(id == null){
            throw new RuntimeException("Id nullo.");
        }
        if(!propostaTCCRepository.existsById(id)){
            throw new RuntimeException("Proposta com id informado não encontrada.");
        }
        propostaTCCRepository.deleteById(id);
    }

    public List<PropostaTCC> buscarPeloProfessor(String nomeProfessor){
        if(nomeProfessor == null || nomeProfessor.trim().isEmpty()){
            return new ArrayList<>();
        }
        return propostaTCCRepository.findByProfessorNomeIgnoreCase(nomeProfessor);
    }

    public List<PropostaTCC> buscarPeloConhecimentoNecessario(String conhecimentoNecessario){
        if(conhecimentoNecessario == null || conhecimentoNecessario.trim().isEmpty()){
            return new ArrayList<>();
        }
        return propostaTCCRepository.findByConhecimentosNecessariosContainingIgnoreCase(conhecimentoNecessario);
    }
}
