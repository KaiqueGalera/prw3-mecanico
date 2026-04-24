package app.mecanico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record DadosMecanico(

        @NotBlank
        String nome,

        @NotBlank
        @Positive
        Integer anosDeExperiencia
) {
}
