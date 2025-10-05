package br.com.benicioforno.GTCC.Service;

import br.com.benicioforno.GTCC.Model.Professor;
import br.com.benicioforno.GTCC.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listar(){
        return professorRepository.findAll();
    }

    @Transactional
    public void inserir(Professor professor){
        if(professor == null){
            throw new RuntimeException("Professor nulo.");
        }
        professorRepository.save(professor);
    }

    @Transactional
    public void deletarPeloId(Long id){
        if(id == null){
            throw new RuntimeException("ID do professor nulo.");
        }
        professorRepository.deleteById(id);
    }

    public List<Professor> buscarPeloNome(String nome){
        if(nome == null){
            return new ArrayList<>();
        }
        return professorRepository.findByNomeContainingIgnoreCase(nome);
    }
}
