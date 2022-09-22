package bb.receitas.recipes.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceitaDto {
    private List<String> ingredientes = new ArrayList<>();
    private AutorDto autor;
    private String modoDePreparo;
    private String nomeReceita;
    @Override
    public String toString() {
        return "ReceitaDto [autor=" + autor.getNome() + ", ingredientes=" + ingredientes + ", modoDePreparo=" + modoDePreparo
                + ", nomeReceita=" + nomeReceita + "]";
    }

    
}
