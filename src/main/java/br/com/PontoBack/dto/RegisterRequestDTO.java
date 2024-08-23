package br.com.PontoBack.dto;

import br.com.PontoBack.model.Departamento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequestDTO(

        @NotBlank(message = "O nome não pode estar vazio") String nome,
        @Email @NotBlank(message = "O e-mail não pode estar vazio") String email,
        @NotBlank(message = "A senha não pode estar vazia") String senha,
        @NotBlank(message = "O cpf não pode estar vazio") @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos") String cpf,
        @NotBlank(message = "Departamento não pode estar vazio") Departamento departamento) {
}
