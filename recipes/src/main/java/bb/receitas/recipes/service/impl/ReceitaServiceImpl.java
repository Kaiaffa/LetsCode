package bb.receitas.recipes.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bb.receitas.recipes.entity.Receita;
import bb.receitas.recipes.repository.ReceitaRepository;
import bb.receitas.recipes.service.ReceitaService;

@Service
public class ReceitaServiceImpl implements ReceitaService{

    final ReceitaRepository receitaRepository;

    public ReceitaServiceImpl(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @Override
    public Receita alterarReceita(Long receitaId, Receita novaReceita) {
        Receita receita = receitaRepository.findById(receitaId).get();
        novaReceita.setAutor(receita.getAutor());
        receitaRepository.delete(receita);
        return receitaRepository.save(novaReceita);
    }

    @Override
    public List<Receita> filtradoPorIngrediente(String ingrediente) {
        Receita receita = new Receita();
        receita.setIngredientes(ingrediente);

        final ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                                            .withIgnoreCase()
                                            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Receita> receitaExample = Example.of(receita, exampleMatcher);
        return receitaRepository.findAll(receitaExample);
    }

    @Override
    @Transactional(readOnly = false)
    public List<Receita> findAll() {
        return receitaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Receita getById(Long receitaId) {
        return receitaRepository.findById(receitaId).get();
    }

    @Override
    public Receita remove(Receita receita) {
        receitaRepository.delete(receita);
        return receita;
    }

    @Override
    public Receita remove(Long receitaId) {
        Receita receita = receitaRepository.findById(receitaId).get();
        receitaRepository.delete(receita);
        return receita;
    }

    @Override
    public Receita save(Receita receita) {
        return receitaRepository.save(receita);
    }

    
    
}
