package bb.receitas.recipes.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
        Refeicao refeicao = refeicaoRepository.findById(refeicaoId).get();
        refeicaoRepository.delete(refeicao);
        return refeicaoRepository.save(novaRefeicao);
    }

    @Override
    public List<Refeicao> filtradoPorEntrada(String entrada) {
        Refeicao refeicao = new Refeicao();
        Receita receita = new Receita();
        refeicao.setEntrada(receita);
        refeicao.getEntrada().setNome(entrada);

        final ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                                            .withIgnoreCase()
                                            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Refeicao> receitaExample = Example.of(refeicao, exampleMatcher);
        return refeicaoRepository.findAll(receitaExample);
    }

    @Override
    public List<Refeicao> filtradoPorPrincipal(String principal) {
        Refeicao refeicao = new Refeicao();
        Receita receita = new Receita();
        refeicao.setPrincipal(receita);
        refeicao.getPrincipal().setNome(principal);

        final ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                                            .withIgnoreCase()
                                            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Refeicao> receitaExample = Example.of(refeicao, exampleMatcher);
        return refeicaoRepository.findAll(receitaExample);
    }

    @Override
    public List<Refeicao> filtradoPorSobremesa(String sobremesa) {
        Refeicao refeicao = new Refeicao();
        Receita receita = new Receita();
        refeicao.setSobremesa(receita);
        refeicao.getSobremesa().setNome(sobremesa);

        final ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                                            .withIgnoreCase()
                                            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Refeicao> receitaExample = Example.of(refeicao, exampleMatcher);
        return refeicaoRepository.findAll(receitaExample);
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
