package app.conserto;

public record ConsertoResumoDTO(
        Long id,
        String dataEntrada,
        String dataSaida,
        String nomeMecanico,
        String marcaVeiculo,
        String modeloVeiculo
) {
}
