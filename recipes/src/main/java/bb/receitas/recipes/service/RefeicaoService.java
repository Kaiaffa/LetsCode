package bb.receitas.recipes.service;

import java.util.List;

import bb.receitas.recipes.entity.Receita;
import bb.receitas.recipes.entity.RefeicaoCompleta;

public interface RefeicaoService {
    RefeicaoCompleta save(RefeicaoCompleta refeicao);

    List<RefeicaoCompleta> findAll();

    RefeicaoCompleta getById(Long refeicaoId);

    RefeicaoCompleta remove(RefeicaoCompleta refeicao);
    RefeicaoCompleta remove(Long refeicaoId);

    List<RefeicaoCompleta> filtradoPorEntrada(Receita entrada);
    List<RefeicaoCompleta> filtradoPorPrincipal(Receita principal);
    List<RefeicaoCompleta> filtradoPorSobremesa(Receita sobremesa);

    RefeicaoCompleta alterarRefeicao(Long refeicaoId, RefeicaoCompleta novaRefeicao);
}
