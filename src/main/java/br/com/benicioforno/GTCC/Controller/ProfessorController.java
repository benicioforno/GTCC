package br.com.benicioforno.GTCC.Controller;

import br.com.benicioforno.GTCC.Model.Professor;
import br.com.benicioforno.GTCC.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> listar(){
        return professorRepository.findAll();
    }

    @PostMapping("/inserir")
    public void inserir(@RequestBody Professor professor){
        professorRepository.save(professor);
    }

    @PostMapping("/deletar/{id}")
    public void deletarPeloId(Long id){
        professorRepository.deleteById(id);
    }

    @GetMapping("/buscarPeloNome/{nome}")
    public List<Professor> buscarPeloNome(@PathVariable String nome){
        List<Professor> professores = professorRepository.findAll();
        professores.removeIf(professor -> !professor.getNome().toLowerCase().contains(nome.toLowerCase()));
        return professores;
    }
}
