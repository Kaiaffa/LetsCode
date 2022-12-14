package bb.receitas.recipes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bb.receitas.recipes.entity.Autor;
import bb.receitas.recipes.entity.Receita;
import bb.receitas.recipes.entity.Refeicao;
import bb.receitas.recipes.service.AutorService;
import bb.receitas.recipes.service.ReceitaService;
import bb.receitas.recipes.service.RefeicaoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/refeicao")
public class RefeicaoController {
    final RefeicaoService refeicaoService;
    final ReceitaService receitaService;
    final AutorService autorService;

    public RefeicaoController(RefeicaoService refeicaoService, ReceitaService receitaService, AutorService autorService){
        this.refeicaoService = refeicaoService;
        this.receitaService = receitaService;
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<Refeicao>> todoasRefeicoes(){
        return ResponseEntity.ok(refeicaoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Refeicao> novaRefeicao(@RequestBody Refeicao refeicao) {
        return ResponseEntity.ok(refeicaoService.save(refeicao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refeicao> getById(@PathVariable(value = "id") Long refeicaoId) {
        return ResponseEntity.ok(refeicaoService.getById(refeicaoId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Refeicao> alterarReceita(@PathVariable(value = "id") Long refeicaoId, @RequestBody Refeicao novaRefeicao) {
        return ResponseEntity.ok(refeicaoService.alterarRefeicao(refeicaoId, novaRefeicao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Refeicao> removerPorId(@PathVariable(value = "id") Long refeicaoId) {
        return ResponseEntity.ok(refeicaoService.remove(refeicaoId));
    }

    @DeleteMapping("/remover")
    public ResponseEntity<Refeicao> removerRefeicao(@RequestBody Refeicao refeicao) {
        return ResponseEntity.ok(refeicaoService.remove(refeicao));
    }

    @GetMapping("/entrada/{receita}")
    public ResponseEntity<List<Refeicao>> refeicoesPorEntrada(@PathVariable(value = "receita") String entrada) {
        return ResponseEntity.ok(refeicaoService.filtradoPorEntrada(entrada));
    }

    @GetMapping("/principal/{receita}")
    public ResponseEntity<List<Refeicao>> refeicoesPorPrincipal(@PathVariable(value = "receita") String principal) {
        return ResponseEntity.ok(refeicaoService.filtradoPorPrincipal(principal));
    }

    @GetMapping("/sobremesa/{receita}")
    public ResponseEntity<List<Refeicao>> refeicoesPorSobremesa(@PathVariable(value = "receita") String sobremesa) {
        return ResponseEntity.ok(refeicaoService.filtradoPorSobremesa(sobremesa));
    }

    @PostMapping("/{autorId}/{entradaId}/{principalId}/{sobremesaId}")
    public ResponseEntity<Refeicao> novaRefeicaoNomesReceitas(@RequestBody Refeicao refeicao, @PathVariable(value = "autorId") Long autorId,
                                    @PathVariable(value = "entradaId") Long entradaId, @PathVariable(value = "principalId") Long principalId,
                                    @PathVariable(value = "sobremesaId") Long sobremesaId ) {
        Autor autor = autorService.getById(autorId);
        Receita entradaRefeicao = receitaService.getById(entradaId);
        Receita principalRefeicao = receitaService.getById(principalId);
        Receita sobremesaRefeicao = receitaService.getById(sobremesaId);
        refeicao.setAutor(autor);
        refeicao.setEntrada(entradaRefeicao);
        refeicao.setPrincipal(principalRefeicao);
        refeicao.setSobremesa(sobremesaRefeicao);
        return ResponseEntity.ok(refeicaoService.save(refeicao));
    }
}
