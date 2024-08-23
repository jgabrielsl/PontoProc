package br.com.PontoBack.dto;

import jakarta.validation.constraints.NotBlank;

public record RegisterDepRequestDTO(
        @NotBlank(message = "O nome não pode estar vazio") String nome) {
}
