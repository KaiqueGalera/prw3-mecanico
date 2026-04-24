package app.conserto;

import app.mecanico.MecanicoDTO;
import app.veiculo.VeiculoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public record ConsertoDTO(
        Long id,

        @Pattern(
                regexp = "\\d{2}/\\d{2}/\\d{4}",
                message = "Data de entrada deve estar no formato xx/xx/xxxx")
        String dataEntrada,

        @Pattern(
                regexp = "\\d{2}/\\d{2}/\\d{4}",
                message = "Data de saida deve estar no formato xx/xx/xxxx")
        String dataSaida,

        @Valid
        MecanicoDTO mecanicoResponsavel,

        @Valid
        VeiculoDTO veiculo,

        Boolean ativo
) {
}
