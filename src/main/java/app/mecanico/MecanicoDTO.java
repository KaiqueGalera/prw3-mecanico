package app.mecanico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MecanicoDTO(
        @NotBlank(message = "Nome do mecanico e obrigatorio")
        String nome,

        @NotNull(message = "Anos de experiencia e obrigatorio")
        @Positive(message = "Anos de experiencia deve ser um numero positivo")
        Integer anosDeExperiencia
) {}