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
import bb.receitas.recipes.entity.RefeicaoCompleta;
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
    public ResponseEntity<List<RefeicaoCompleta>> todoasRefeicoes(){
        RefeicaoCompleta janta = new RefeicaoCompleta();
        Autor sabrina = new Autor();
        sabrina.setNome("Sabrina");
        janta.setAutor(sabrina);
        janta.setEntrada(new Receita());
        janta.setPrincipal(new Receita());
        janta.setSobremesa(new Receita());
        janta.setNome("bolo");
        return ResponseEntity.ok(List.of(janta));
    }

    @PostMapping
    public ResponseEntity<RefeicaoCompleta> novaRefeicao(@RequestBody RefeicaoCompleta refeicao) {
        RefeicaoCompleta janta = new RefeicaoCompleta();
        Autor sabrina = new Autor();
        sabrina.setNome("Sabrina");
        janta.setAutor(sabrina);
        janta.setEntrada(new Receita());
        janta.setPrincipal(new Receita());
        janta.setSobremesa(new Receita());
        janta.setNome("bolo");
        return ResponseEntity.ok(janta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RefeicaoCompleta> getById(@PathVariable(value = "id") Long refeicaoId) {
        return ResponseEntity.ok(new RefeicaoCompleta());
        // return ResponseEntity.ok(refeicaoService.getById(refeicaoId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> alterarReceita(@PathVariable(value = "id") Long refeicaoId, @RequestBody RefeicaoCompleta novaRefeicao) {
        return ResponseEntity.ok(new Receita());
        // return ResponseEntity.ok(refeicaoService.alterarRefeicao(refeicaoId, novaRefeicao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Receita> removerPorId(@PathVariable(value = "id") Long refeicaoId) {
        return ResponseEntity.ok(new Receita());
        // return ResponseEntity.ok(refeicaoService.remove(refeicaoId));
    }

    @DeleteMapping("/remover")
    public ResponseEntity<Receita> removerRefei(@RequestBody RefeicaoCompleta refeicao) {
        return ResponseEntity.ok(new Receita());
        // return ResponseEntity.ok(refeicaoService.remove(refeicao));
    }

    @GetMapping("/entrada")
    public ResponseEntity<List<RefeicaoCompleta>> refeicoesPorEntrada(@RequestBody Receita entrada) {
        RefeicaoCompleta janta = new RefeicaoCompleta();
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
    public ResponseEntity<List<RefeicaoCompleta>> refeicoesPorPrincipal(@RequestBody Receita principal) {
        RefeicaoCompleta janta = new RefeicaoCompleta();
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
    public ResponseEntity<List<RefeicaoCompleta>> refeicoesPorSobremesa(@RequestBody Receita sobremesa) {
        RefeicaoCompleta janta = new RefeicaoCompleta();
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
