package app.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;

public record VeiculoDTO(
        String placa,
        @NotBlank(message = "marca do veículo é obrigatória")
        String marca,
        @NotBlank(message = "modelo do veículo é obrigatório")
        String modelo,
        LocalDate ano
) {
}
