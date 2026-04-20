package app.dto;

import app.entity.Mecanico;
import app.entity.Veiculo;

import java.time.LocalDate;

public record ConsertoDTO(
        Long id,
        LocalDate dataEntrada,
        LocalDate dataSaida,
        Mecanico mecanicoResposavel,
        Veiculo veiculo
) {
}
