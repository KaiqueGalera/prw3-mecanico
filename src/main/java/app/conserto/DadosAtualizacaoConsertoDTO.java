package app.conserto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConsertoDTO(
        @NotNull
        Long id,

        String dataSaida,

        String nomeMecanico,

        Integer anosDeExperiencia
) {
}
