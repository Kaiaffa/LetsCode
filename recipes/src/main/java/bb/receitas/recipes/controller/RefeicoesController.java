package bb.receitas.recipes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bb.receitas.recipes.entity.Autor;
import bb.receitas.recipes.entity.Receita;
import bb.receitas.recipes.entity.RefeicaoCompleta;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/refeicoes")
public class RefeicoesController {
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
}
