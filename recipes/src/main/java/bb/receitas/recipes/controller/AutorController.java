package bb.receitas.recipes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bb.receitas.recipes.entity.Autor;
import bb.receitas.recipes.service.AutorService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/autor")
public class AutorController {

    final AutorService autorService;

    public AutorController(AutorService autorService){
        this.autorService = autorService;
    }

    @PostMapping
    @RequestBody
    public ResponseEntity<Autor> insert(@RequestBody @Valid Autor autor) {
        return ResponseEntity.ok(autorService.save(autor));
    }

    @GetMapping
    public ResponseEntity<List<Autor>> todosAutores(){
        return ResponseEntity.ok(autorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getById(@PathVariable(value = "id") Long autorId) {
        return ResponseEntity.ok(autorService.getById(autorId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Autor> removerPorId(@PathVariable(value = "id") Long autorId) {
        return ResponseEntity.ok(autorService.remove(autorId));
    }

    @DeleteMapping
    public ResponseEntity<Autor> removerAutor(@RequestBody Autor autor) {
        return ResponseEntity.ok(autorService.remove(autor));
    }
}
