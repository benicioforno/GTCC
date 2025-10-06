package br.com.benicioforno.GTCC.Controller;

import br.com.benicioforno.GTCC.Model.Professor;
import br.com.benicioforno.GTCC.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/listar")
    public List<Professor> listar(){
        return professorService.listar();
    }

    @PostMapping("/inserir")
    public ResponseEntity<?> inserir(@RequestBody Professor professor){
        professorService.inserir(professor);
        ResponseEntity.ok().build();
        return null;
    }

    @PostMapping("/deletar/{id}")
    public ResponseEntity<?> deletarPeloId(Long id){
        professorService.deletarPeloId(id);
        ResponseEntity.ok().build();
        return null;
    }

    @GetMapping("/buscarPeloNome/{nome}")
    public List<Professor> buscarPeloNome(@PathVariable String nome){
        return professorService.buscarPeloNome(nome);
    }
}
