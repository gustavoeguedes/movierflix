package br.com.movierflix.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDTO(
        @NotBlank(message = "O campo nome é obrigatório")
        @Size(max=100, message = "O nome não pode ter mais de 100 carecteres")
        String name
) {}
