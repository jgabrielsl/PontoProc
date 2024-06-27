package br.com.PontoBack.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@Email @NotBlank(message = "O e-mail não pode estar vazio") String email,
                       @NotBlank(message = "A senha não pode estar vazia") String senha) {
}
