package dto;

import java.time.LocalDate;

public record VeiculoDTO(
        Long id,
        String placa,
        String marca,
        String modelo,
        LocalDate ano
) {
}
