package bb.receitas.recipes.service;

import java.util.List;

import bb.receitas.recipes.entity.Autor;

public interface AutorService {
    Autor save(Autor autor);

    List<Autor> findAll();

    Autor getById(Long autorId);

    Autor remove(Autor autor);
    Autor remove(Long autorId);
}
