package br.com.benicioforno.GTCC.Controller;

import br.com.benicioforno.GTCC.Model.Aluno;
import br.com.benicioforno.GTCC.Service.AlunoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listar(){
        return alunoService.listar();
    }

    @PostMapping("/inserir")
    public ResponseEntity<?> inserir(@RequestBody Aluno aluno){
        try {
            alunoService.inserir(aluno);
            ResponseEntity.ok().build();
        }catch (RuntimeException e){
            ResponseEntity.badRequest().body(e.getMessage());
        }
        return null;
    }

    @PostMapping("/deletar/{id}")
    public void deletarPeloId(@PathVariable Long id){
        try {
            alunoService.deletarPeloId(id);
            ResponseEntity.ok().build();
        }catch(RuntimeException e){
            ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarPeloNome/{nome}")
    public List<Aluno> buscarPeloNome(@PathVariable String nome){
        return alunoService.buscarPeloNome(nome);
    }

    @GetMapping("/buscarPelaMatricula/{matricula}")
    public List<Aluno> buscarPelaMatricula(@PathVariable String matricula){
        return alunoService.buscarPeloMatricula(matricula);
    }
}
