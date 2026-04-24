package app.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private int anosDeExperiencia;

    public Mecanico(DadosMecanico dados) {
        this.nome = dados.nome();
        this.anosDeExperiencia = dados.anosDeExperiencia();
    }

    public void atualizarInformacoes(DadosMecanico dados) {

        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.anosDeExperiencia() != null) {
            this.anosDeExperiencia = dados.anosDeExperiencia();
        }
    }
}