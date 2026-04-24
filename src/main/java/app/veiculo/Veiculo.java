package app.veiculo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String ano;
    private String cor;

    public Veiculo(VeiculoDTO dados) {
        this.placa = dados.placa();
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
        this.cor = dados.cor();
    }

    public void atualizarInformacoes(VeiculoDTO dados) {

        if (dados.placa() != null) {
            this.placa = dados.placa();
        }
        if (dados.marca() != null) {
            this.marca = dados.marca();
        }
        if (dados.modelo() != null) {
            this.modelo = dados.modelo();
        }
        if (dados.ano() != null) {
            this.ano = dados.ano();
        }
        if (dados.cor() != null) {
            this.cor = dados.cor();
        }
    }
}
