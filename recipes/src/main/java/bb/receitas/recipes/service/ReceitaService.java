package bb.receitas.recipes.service;

import java.util.List;

import bb.receitas.recipes.entity.Receita;

public interface ReceitaService {
    Receita save(Receita receita);

    List<Receita> findAll();

    Receita getById(Long receitaId);

    Receita remove(Receita receita);
    Receita remove(Long receitaId);

    List<Receita> filtradoPorIngredientes(List<String> ingredientes);

    Receita alterarReceita(Long receitaId, Receita novaReceita);
}
