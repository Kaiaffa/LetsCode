package bb.receitas.recipes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Autor autor;

    @NotNull(message = "Nome deve ser preenchido")
    @Column(name = "nome", length = 80)
    private String nome;

    @ManyToOne
    private Receita entrada;
    @ManyToOne
    private Receita principal;
    @ManyToOne
    private Receita sobremesa;
    
}
