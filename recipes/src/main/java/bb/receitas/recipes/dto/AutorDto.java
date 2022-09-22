package bb.receitas.recipes.dto;

import java.util.ArrayList;
import java.util.List;



public class AutorDto {
    private String nome;
    private List<ReceitaDto> receitas = new ArrayList<>();
    private List<RefeicaoCompletaDto> refeicoesCompletas = new ArrayList<>();

    AutorDto(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "AutorDto [nome=" + nome + ", receitas=" + receitas.size() + ", refeicoesCompletas=" + refeicoesCompletas.size() + "]";
    }

    
}
