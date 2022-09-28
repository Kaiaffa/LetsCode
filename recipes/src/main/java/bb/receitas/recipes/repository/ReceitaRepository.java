package bb.receitas.recipes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bb.receitas.recipes.entity.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    @Query("select * from Receita rec where upper(rec.ingredientes) like %:filter%")
    Page<Receita> findByIngrediente(@Param("filter") String filter, Pageable pageable);
}
