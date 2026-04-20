package dto;

import entity.Mecanico;
import entity.Veiculo;

import java.time.LocalDate;

public record ConsertoDTO(
        Long id,
        LocalDate dataEntrada,
        LocalDate dataSaida,
        Mecanico mecanicoResposavel,
        Veiculo veiculo
) {
}
