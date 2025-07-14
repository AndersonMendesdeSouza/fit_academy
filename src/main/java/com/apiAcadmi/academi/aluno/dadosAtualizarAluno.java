package com.apiAcadmi.academi.aluno;

import java.time.LocalDate;

import com.apiAcadmi.academi.sexo.Sexo;

import jakarta.validation.constraints.NotNull;

public record dadosAtualizarAluno(
		@NotNull
		Long id,

		String nome,
		String cpf,
		String email,
		String telefone,
		Sexo sexo,
		LocalDate datanascimento

) {

}
