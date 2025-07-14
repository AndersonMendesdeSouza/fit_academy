package com.apiAcadmi.academi.aluno;

import java.time.LocalDate;

import com.apiAcadmi.academi.sexo.Sexo;

public record dadosCadastroAluno(
		String nome,
		String cpf,
		String email,
		String telefone,
		LocalDate datanascimento,
		Sexo sexo		
		) {

}
