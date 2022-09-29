package bb.receitas.recipes.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bb.receitas.recipes.entity.Autor;
import bb.receitas.recipes.repository.AutorRepository;
import bb.receitas.recipes.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {
    final AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Autor getById(Long autorId) {
        return autorRepository.findById(autorId).get();
    }

    @Override
    public Autor remove(Autor autor) {
        autorRepository.delete(autor);
        return autor;
    }

    @Override
    public Autor remove(Long autorId) {
        Autor autor = autorRepository.findById(autorId).get();
        autorRepository.delete(autor);
        return autor;
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    
}
