package bb.receitas.recipes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bb.receitas.recipes.entity.Autor;
// import bb.receitas.recipes.service.AutorService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/autor")
public class AutorController {

    // final AutorService autorService;

    // public AutorController(AutorService autorService){
    //     this.autorService = autorService;
    // }

    @PostMapping
    public ResponseEntity<Autor> insert(@RequestBody Autor autor) {
        return ResponseEntity.ok(new Autor());
        // return ResponseEntity.ok(autorService.save(autor));
    }

    @GetMapping
    public ResponseEntity<List<Autor>> todosAutores(){
        Autor sabrina = new Autor();
        sabrina.setId(2L);
        sabrina.setNome("Sabrina");
        return ResponseEntity.ok(List.of(sabrina));
        // return ResponseEntity.ok(autorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getById(@PathVariable(value = "id") Long autorId) {
        return ResponseEntity.ok(new Autor());
        // return ResponseEntity.ok(autorService.getById(autorId));
    }



    // @GetMapping("/{id}")
    // public Autor
}
