package app.mecanico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosMecanico(

        @NotBlank
        String nome,

        @NotNull
        @Positive
        Integer anosDeExperiencia
) {
}
