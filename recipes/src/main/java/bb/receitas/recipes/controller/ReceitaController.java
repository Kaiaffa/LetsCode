package bb.receitas.recipes.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bb.receitas.recipes.auxiliarClasses.Ingradientes;
import bb.receitas.recipes.entity.Autor;
import bb.receitas.recipes.entity.Receita;
import bb.receitas.recipes.service.ReceitaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
    final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService){
        this.receitaService = receitaService;
    }

    @GetMapping
    public ResponseEntity<List<Receita>> todoasReceitas(){
        return ResponseEntity.ok(receitaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Receita> novaReceita(@RequestBody @Valid Receita receita) {
        return ResponseEntity.ok(receitaService.save(receita));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> getById(@PathVariable(value = "id") Long receitaId) {
        return ResponseEntity.ok(receitaService.getById(receitaId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> alterarReceita(@PathVariable(value = "id") Long receitaId, @RequestBody Receita novaReceita) {
        return ResponseEntity.ok(new Receita());
        // return ResponseEntity.ok(receitaService.alterarReceita(receitaId, novaReceita));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Receita> removerPorId(@PathVariable(value = "id") Long receitaId) {
        // return ResponseEntity.ok(new Receita());
        return ResponseEntity.ok(receitaService.remove(receitaId));
    }

    @DeleteMapping("/remover")
    public ResponseEntity<Receita> removerReceita(@RequestBody Receita receita) {
        // return ResponseEntity.ok(new Receita());
        return ResponseEntity.ok(receitaService.remove(receita));
    }

    @GetMapping("/ingredientes")
    public ResponseEntity<List<Receita>> receitasPorIngredientes(@RequestBody Ingradientes ingredientes) {
        Receita torta = new Receita();
        Autor sabrina = new Autor();
        sabrina.setNome("Sabrina");
        torta.setAutor(sabrina);
        torta.setIngredientes(ingredientes.getIngredientes().stream().collect(Collectors.joining(", ")));
        torta.setModoDePreparo("fazer os passos e assar");
        torta.setNome("torta");
        System.out.println(ingredientes.getIngredientes());
        return ResponseEntity.ok(List.of(torta));
        // return ResponseEntity.ok(receitaService.filtradoPorIngredientes(ingredientes));
    }
}
