package bb.receitas.recipes.controller;

import java.util.List;

import javax.validation.Valid;

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
import bb.receitas.recipes.service.AutorService;
import bb.receitas.recipes.service.ReceitaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
    final ReceitaService receitaService;
    final AutorService autorService;

    public ReceitaController(ReceitaService receitaService, AutorService autorService){
        this.receitaService = receitaService;
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<Receita>> todoasReceitas(){
        return ResponseEntity.ok(receitaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Receita> novaReceita(@RequestBody @Valid Receita receita) {
        return ResponseEntity.ok(receitaService.save(receita));
    }

    @PostMapping("/{autorId}")
    public ResponseEntity<Receita> novaReceitaAutorPath(@RequestBody @Valid Receita receita, @PathVariable(value = "autorId") Long autorId) {
        Autor autor = autorService.getById(autorId);
        receita.setAutor(autor);
        return ResponseEntity.ok(receitaService.save(receita));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> getById(@PathVariable(value = "id") Long receitaId) {
        return ResponseEntity.ok(receitaService.getById(receitaId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> alterarReceita(@PathVariable(value = "id") Long receitaId, @RequestBody Receita novaReceita) {
        return ResponseEntity.ok(receitaService.alterarReceita(receitaId, novaReceita));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Receita> removerPorId(@PathVariable(value = "id") Long receitaId) {
        return ResponseEntity.ok(receitaService.remove(receitaId));
    }

    @DeleteMapping("/remover")
    public ResponseEntity<Receita> removerReceita(@RequestBody Receita receita) {
        return ResponseEntity.ok(receitaService.remove(receita));
    }

    @GetMapping("/ingrediente/{ingrediente}")
    public ResponseEntity<List<Receita>> receitasPorIngredientes(@PathVariable(value = "ingrediente") String ingrediente) {
        return ResponseEntity.ok(receitaService.filtradoPorIngrediente(ingrediente));
    }
}
