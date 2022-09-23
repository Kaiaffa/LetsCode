package bb.receitas.recipes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bb.receitas.recipes.entity.Autor;
import bb.receitas.recipes.entity.Receita;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
    @GetMapping
    public ResponseEntity<List<Receita>> todoasReceitas(){
        Receita bolo = new Receita();
        Autor sabrina = new Autor();
        sabrina.setNome("Sabrina");
        bolo.setAutor(sabrina);
        bolo.setIngredientes("acucar, leite etc");
        bolo.setModoDePreparo("fazer os passos e assar");
        bolo.setNome("bolo");
        return ResponseEntity.ok(List.of(bolo));
    }

    @PostMapping
    public ResponseEntity<Receita> novaReceita(@RequestBody Receita receita) {
        Receita torta = new Receita();
        Autor sabrina = new Autor();
        sabrina.setNome("Sabrina");
        torta.setAutor(sabrina);
        torta.setIngredientes("acucar, leite etc");
        torta.setModoDePreparo("fazer os passos e assar");
        torta.setNome("torta");
        return ResponseEntity.ok(torta);
    }
}
