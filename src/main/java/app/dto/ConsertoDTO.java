package app.dto;

import app.entity.Mecanico;
import app.entity.Veiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record ConsertoDTO(
        Long id,
        @Pattern(
                regexp = "\\d{2}/\\d{2}/\\d{4}",
                message = "data de entrada deve estar no formato xx/xx/xxxx")
        String dataEntrada,
        @Pattern(
                regexp = "\\d{2}/\\d{2}/\\d{4}",
                message = "data de saída deve estar no formato xx/xx/xxxx")
        String dataSaida,
        @Valid
        MecanicoDTO mecanicoResponsavel,
        @Valid
        VeiculoDTO veiculo
) {
}
