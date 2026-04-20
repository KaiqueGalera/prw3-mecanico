package app.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(
        String placa,
        @NotBlank(message = "marca do veículo é obrigatória")
        String marca,
        @NotBlank(message = "modelo do veículo é obrigatório")
        String modelo,
        @Pattern(regexp = "\\d{4}")
        String ano,
        String cor
) {
}
