package br.com.benicioforno.GTCC.Service;

import br.com.benicioforno.GTCC.Model.Aluno;
import br.com.benicioforno.GTCC.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listar(){
        return alunoRepository.findAll();
    }

    @Transactional
    public void inserir(Aluno aluno){
        if(aluno == null){
            throw new RuntimeException("Aluno nulo.");
        }
        alunoRepository.save(aluno);
    }

    @Transactional
    public void deletarPeloId(Long id){
        if(id == null){
            throw new RuntimeException("Id nulo.");
        }
        alunoRepository.deleteById(id);
    }

    public List<Aluno> buscarPeloNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            return new ArrayList<>();
        }
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Aluno> buscarPeloMatricula(String matricula){
        if(matricula == null || matricula.trim().isEmpty()){
            return new ArrayList<>();
        }
        return alunoRepository.findByMatriculaContainingIgnoreCase(matricula);
    }
}
