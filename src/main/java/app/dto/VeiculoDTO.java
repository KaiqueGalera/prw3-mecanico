package app.dto;

import java.time.LocalDate;

public record VeiculoDTO(
        String placa,
        String marca,
        String modelo,
        LocalDate ano
) {
}
