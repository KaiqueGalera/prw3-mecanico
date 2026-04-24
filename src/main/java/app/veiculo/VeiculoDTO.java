package app.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(
        @NotBlank
        String placa,

        @NotBlank(message = "Marca do veiculo e obrigatoria")
        String marca,

        @NotBlank(message = "Modelo do veiculo e obrigatorio")
        String modelo,

        @Pattern(regexp = "\\d{4}", message = "Ano deve ter 4 digitos")
        String ano,

        String cor
) {}