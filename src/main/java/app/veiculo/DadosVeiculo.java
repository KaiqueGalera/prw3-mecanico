package app.veiculo;

import jakarta.validation.constraints.NotBlank;

public record DadosVeiculo(

        @NotBlank
        String placa,

        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        @NotBlank
        String ano,

        @NotBlank
        String cor
) {
}
