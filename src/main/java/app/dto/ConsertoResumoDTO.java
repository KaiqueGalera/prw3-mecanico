package app.dto;

public record ConsertoResumoDTO(
        String dataEntrada,
        String dataSaida,
        String nomeMecanico,
        String marcaVeiculo,
        String modeloVeiculo
) {
}
