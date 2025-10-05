package br.com.benicioforno.GTCC.Controller;

import br.com.benicioforno.GTCC.Model.Professor;
import br.com.benicioforno.GTCC.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> listar(){
        return professorService.listar();
    }

    @PostMapping("/inserir")
    public ResponseEntity<?> inserir(@RequestBody Professor professor){
        try{
            professorService.inserir(professor);
            ResponseEntity.ok().build();
        } catch(RuntimeException e){
            ResponseEntity.badRequest().body(e.getMessage());
        }
        return null;
    }

    @PostMapping("/deletar/{id}")
    public ResponseEntity<?> deletarPeloId(Long id){
        try{
            professorService.deletarPeloId(id);
            ResponseEntity.ok().build();
        } catch (RuntimeException e){
            ResponseEntity.badRequest().body(e.getMessage());
        }
        return null;
    }

    @GetMapping("/buscarPeloNome/{nome}")
    public List<Professor> buscarPeloNome(@PathVariable String nome){
        return professorService.buscarPeloNome(nome);
    }
}
