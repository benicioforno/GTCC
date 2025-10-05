package br.com.benicioforno.GTCC.Controller;

import br.com.benicioforno.GTCC.Model.PropostaTCC;
import br.com.benicioforno.GTCC.Model.Status;
import br.com.benicioforno.GTCC.Service.PropostaTCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propostasTCC")
public class PropostaTCCController {

    @Autowired
    private PropostaTCCService propostaTCCService;

    @PutMapping("/mudar/status/{idProposta}")
    private ResponseEntity<?> mudarStatus(@PathVariable Long idProposta,
                                             @RequestParam("status") Status novoStatus,
                                             @RequestParam(value = "idAluno", required = false) Long idAluno){
        try {
            propostaTCCService.mudarStatus(idProposta, novoStatus, idAluno);
            ResponseEntity.ok().build();
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return null;
    }

    @GetMapping
    public List<PropostaTCC> listar(){
        return propostaTCCService.listar();
    }

    @PostMapping("/inserir")
    public ResponseEntity<?> inserir(@RequestBody PropostaTCC propostaTCC){
        try{
            propostaTCCService.inserir(propostaTCC);
            return ResponseEntity.ok().build();
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        try {
            propostaTCCService.deletar(id);
            return ResponseEntity.ok().build();
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscarPeloProfessor/{nomeProfessor}")
    public List<PropostaTCC> buscarPeloProfessor(@PathVariable String nomeProfessor){
        return propostaTCCService.buscarPeloProfessor(nomeProfessor);
    }

    @GetMapping("/buscarPeloConhecimentoNecessario/{conhecimentoNecessario}")
    public List<PropostaTCC> buscarPeloConhecimentoNecessario(@PathVariable String conhecimentoNecessario){
        return propostaTCCService.buscarPeloConhecimentoNecessario(conhecimentoNecessario);
    }
}
