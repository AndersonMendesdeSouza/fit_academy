package com.apiAcadmi.academi.dtos;

import java.time.LocalDate;

import com.apiAcadmi.academi.sexo.Sexo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record dadosCadastroAluno(
		@NotBlank
		String nome,
		@NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", message = "CPF deve estar no formato XXX.XXX.XXX-XX")
		String cpf,
		@NotBlank
        @Email
        String email,
        @NotBlank @Pattern(regexp = "\\d{2}\\ \\d{5}\\-\\d{4}")
		String telefone,
	 @NotNull
		LocalDate datanascimento,
		 @NotNull
		Sexo sexo		
		) {

}
