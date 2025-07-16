package com.apiAcadmi.academi.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;

import com.apiAcadmi.academi.sexo.Sexo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record dadosAtualizarAluno(
		@NotNull
		Long id,

		String nome,
		@NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", message = "CPF deve estar no formato XXX.XXX.XXX-XX")
		String cpf,
	 @Email
		String email,
	      @NotBlank @Pattern(regexp = "\\d{2}\\ \\d{5}\\-\\d{4}")
		String telefone,
		Sexo sexo,
		LocalDate datanascimento

) {

}
