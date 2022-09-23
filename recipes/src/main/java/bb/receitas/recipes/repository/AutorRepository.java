package bb.receitas.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bb.receitas.recipes.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
    
}
