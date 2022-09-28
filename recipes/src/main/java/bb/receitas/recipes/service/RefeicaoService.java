package bb.receitas.recipes.service;

import java.util.List;

import bb.receitas.recipes.entity.Receita;
import bb.receitas.recipes.entity.Refeicao;

public interface RefeicaoService {
    Refeicao save(Refeicao refeicao);

    List<Refeicao> findAll();

    Refeicao getById(Long refeicaoId);

    Refeicao remove(Refeicao refeicao);
    Refeicao remove(Long refeicaoId);

    List<Refeicao> filtradoPorEntrada(Receita entrada);
    List<Refeicao> filtradoPorPrincipal(Receita principal);
    List<Refeicao> filtradoPorSobremesa(Receita sobremesa);

    Refeicao alterarRefeicao(Long refeicaoId, Refeicao novaRefeicao);
}
