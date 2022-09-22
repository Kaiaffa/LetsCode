package bb.receitas.recipes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefeicaoCompletaDto {
    private AutorDto autor;
    private String nomeRefeicao;
    private ReceitaDto entrada;
    private ReceitaDto principal;
    private ReceitaDto sobremesa;
    @Override
    public String toString() {
        return "RefeicaoCompletaDto [autor=" + autor.getNome() + ", entrada=" + entrada + ", nomeRefeicao=" + nomeRefeicao
                + ", principal=" + principal + ", sobremesa=" + sobremesa + "]";
    }

    
}
