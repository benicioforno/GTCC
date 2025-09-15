package br.com.benicioforno.GTCC.Controller;

import br.com.benicioforno.GTCC.Model.Aluno;
import br.com.benicioforno.GTCC.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> listar(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }

    @PostMapping("/inserir")
    public void inserir(@RequestBody Aluno aluno){
        alunoRepository.save(aluno);
    }

    @PostMapping("/deletar/{id}")
    public void deletarPeloId(@PathVariable Long id){
        alunoRepository.deleteById(id);
    }

    @GetMapping("/buscarPeloNome/{nome}")
    public List<Aluno> buscarPeloNome(@PathVariable String nome){
        List<Aluno> alunos = alunoRepository.findAll();
        alunos.removeIf(aluno -> !aluno.getNome().toLowerCase().contains(nome.toLowerCase()));
        return alunos;
    }

    @GetMapping("/buscarPelaMatricula/{matricula}")
    public List<Aluno> buscarPelaMatricula(@PathVariable String matricula){
        List<Aluno> alunos = alunoRepository.findAll();
        alunos.removeIf(aluno -> !aluno.getMatricula().equals(matricula));
        return alunos;
    }
}
