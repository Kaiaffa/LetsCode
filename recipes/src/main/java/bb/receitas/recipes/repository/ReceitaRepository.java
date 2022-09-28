package bb.receitas.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bb.receitas.recipes.entity.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    
}
