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
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String ingredientes;

    @ManyToOne
    private Autor autor;

    private String modoDePreparo;

    @NotNull(message = "Nome deve ser preenchido")
    @Column(name = "nome", length = 80)
    private String nome;
    
}
