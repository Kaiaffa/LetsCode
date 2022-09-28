package bb.receitas.recipes.service.impl;

import java.util.List;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Receita> filtradoPorIngredientes(List<String> ingredientes) {
        // TODO Auto-generated method stub
        return null;
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
