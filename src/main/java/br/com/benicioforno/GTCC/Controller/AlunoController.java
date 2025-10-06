package br.com.benicioforno.GTCC.Controller;

import br.com.benicioforno.GTCC.Model.Aluno;
import br.com.benicioforno.GTCC.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listar(){
        return alunoService.listar();
    }

    @PostMapping("/inserir")
    public ResponseEntity<?> inserir(@RequestBody Aluno aluno){
        alunoService.inserir(aluno);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deletar/{id}")
    public ResponseEntity<?> deletarPeloId(@PathVariable Long id){
        alunoService.deletarPeloId(id);
        return ResponseEntity.ok().build();
        return null;
    }

    @PostMapping("/deletar/{id}")
    public void deletarPeloId(@PathVariable Long id){
        alunoService.deletarPeloId(id);
        ResponseEntity.ok().build();
    }

    @GetMapping("/buscarPeloNome/{nome}")
    public List<Aluno> buscarPeloNome(@PathVariable String nome){
        return alunoService.buscarPeloNome(nome);
    }

    @GetMapping("/buscarPelaMatricula/{matricula}")
    public List<Aluno> buscarPelaMatricula(@PathVariable String matricula){
        return alunoService.buscarPelaMatricula(matricula);
    }
}
