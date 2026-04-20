package app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MecanicoDTO(
        @NotBlank(message = "nome do mecânico é obrigatório")
        String nome,
        @NotNull(message = "anos de experiência é obrigatório")
        int anosDeExperiencia
) {}
