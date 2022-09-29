package bb.receitas.recipes.service;

import java.util.List;

import bb.receitas.recipes.entity.Refeicao;

public interface RefeicaoService {
    Refeicao save(Refeicao refeicao);

    List<Refeicao> findAll();

    Refeicao getById(Long refeicaoId);

    Refeicao remove(Refeicao refeicao);
    Refeicao remove(Long refeicaoId);

    List<Refeicao> filtradoPorEntrada(String entrada);
    List<Refeicao> filtradoPorPrincipal(String principal);
    List<Refeicao> filtradoPorSobremesa(String sobremesa);

    Refeicao alterarRefeicao(Long refeicaoId, Refeicao novaRefeicao);
}
