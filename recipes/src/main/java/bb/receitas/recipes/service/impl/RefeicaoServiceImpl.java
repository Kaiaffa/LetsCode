package bb.receitas.recipes.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import bb.receitas.recipes.entity.Receita;
import bb.receitas.recipes.entity.Refeicao;
import bb.receitas.recipes.repository.RefeicaoRepository;
import bb.receitas.recipes.service.RefeicaoService;

@Service
public class RefeicaoServiceImpl implements RefeicaoService {
    final RefeicaoRepository refeicaoRepository;

    public RefeicaoServiceImpl(RefeicaoRepository refeicaoRepository) {
        this.refeicaoRepository = refeicaoRepository;
    }

    @Override
    public Refeicao alterarRefeicao(Long refeicaoId, Refeicao novaRefeicao) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Refeicao> filtradoPorEntrada(Receita entrada) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Refeicao> filtradoPorPrincipal(Receita principal) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Refeicao> filtradoPorSobremesa(Receita sobremesa) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Refeicao> findAll() {
        return refeicaoRepository.findAll();
    }

    @Override
    public Refeicao getById(Long refeicaoId) {
        return refeicaoRepository.findById(refeicaoId).get();
    }

    @Override
    public Refeicao remove(Refeicao refeicao) {
        refeicaoRepository.delete(refeicao);
        return refeicao;
    }

    @Override
    public Refeicao remove(Long refeicaoId) {
        Refeicao refeicao = refeicaoRepository.findById(refeicaoId).get();
        refeicaoRepository.delete(refeicao);
        return refeicao;
    }

    @Override
    public Refeicao save(Refeicao refeicao) {
        return refeicaoRepository.save(refeicao);
    }

    
}
