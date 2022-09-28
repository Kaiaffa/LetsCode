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
import bb.receitas.recipes.service.RefeicaoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/refeicao")
public class RefeicaoController {
    final RefeicaoService refeicaoService;

    public RefeicaoController(RefeicaoService refeicaoService){
        this.refeicaoService = refeicaoService;
    }

    @GetMapping
    public ResponseEntity<List<Refeicao>> todoasRefeicoes(){
        // Refeicao janta = new Refeicao();
        // Autor sabrina = new Autor();
        // sabrina.setNome("Sabrina");
        // janta.setAutor(sabrina);
        // janta.setEntrada(new Receita());
        // janta.setPrincipal(new Receita());
        // janta.setSobremesa(new Receita());
        // janta.setNome("bolo");
        // return ResponseEntity.ok(List.of(janta));
        return ResponseEntity.ok(refeicaoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Refeicao> novaRefeicao(@RequestBody Refeicao refeicao) {
        // Refeicao janta = new Refeicao();
        // Autor sabrina = new Autor();
        // sabrina.setNome("Sabrina");
        // janta.setAutor(sabrina);
        // janta.setEntrada(new Receita());
        // janta.setPrincipal(new Receita());
        // janta.setSobremesa(new Receita());
        // janta.setNome("bolo");
        // return ResponseEntity.ok(janta);
        return ResponseEntity.ok(refeicaoService.save(refeicao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refeicao> getById(@PathVariable(value = "id") Long refeicaoId) {
        // return ResponseEntity.ok(new Refeicao());
        return ResponseEntity.ok(refeicaoService.getById(refeicaoId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Refeicao> alterarReceita(@PathVariable(value = "id") Long refeicaoId, @RequestBody Refeicao novaRefeicao) {
        return ResponseEntity.ok(new Refeicao());
        // return ResponseEntity.ok(refeicaoService.alterarRefeicao(refeicaoId, novaRefeicao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Refeicao> removerPorId(@PathVariable(value = "id") Long refeicaoId) {
        return ResponseEntity.ok(refeicaoService.remove(refeicaoId));
    }

    @DeleteMapping("/remover")
    public ResponseEntity<Refeicao> removerRefei(@RequestBody Refeicao refeicao) {
        // return ResponseEntity.ok(new Refeicao());
        return ResponseEntity.ok(refeicaoService.remove(refeicao));
    }

    @GetMapping("/entrada")
    public ResponseEntity<List<Refeicao>> refeicoesPorEntrada(@RequestBody Receita entrada) {
        Refeicao janta = new Refeicao();
        Autor sabrina = new Autor();
        sabrina.setNome("Sabrina");
        janta.setAutor(sabrina);
        janta.setEntrada(new Receita());
        janta.setPrincipal(new Receita());
        janta.setSobremesa(new Receita());
        janta.setNome("bolo");
        return ResponseEntity.ok(List.of(janta));
        // return ResponseEntity.ok(refeicaoService.filtradoPorEntrada(entrada));
    }

    @GetMapping("/principal")
    public ResponseEntity<List<Refeicao>> refeicoesPorPrincipal(@RequestBody Receita principal) {
        Refeicao janta = new Refeicao();
        Autor sabrina = new Autor();
        sabrina.setNome("Sabrina");
        janta.setAutor(sabrina);
        janta.setEntrada(new Receita());
        janta.setPrincipal(new Receita());
        janta.setSobremesa(new Receita());
        janta.setNome("bolo");
        return ResponseEntity.ok(List.of(janta));
        // return ResponseEntity.ok(refeicaoService.filtradoPorPrincipal(principal));
    }

    @GetMapping("/sobremesa")
    public ResponseEntity<List<Refeicao>> refeicoesPorSobremesa(@RequestBody Receita sobremesa) {
        Refeicao janta = new Refeicao();
        Autor sabrina = new Autor();
        sabrina.setNome("Sabrina");
        janta.setAutor(sabrina);
        janta.setEntrada(new Receita());
        janta.setPrincipal(new Receita());
        janta.setSobremesa(new Receita());
        janta.setNome("bolo");
        return ResponseEntity.ok(List.of(janta));
        // return ResponseEntity.ok(refeicaoService.filtradoPorSobremesa(sobremesa));
    }
}
