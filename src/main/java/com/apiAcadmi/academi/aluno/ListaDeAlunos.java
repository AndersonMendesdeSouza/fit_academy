package com.apiAcadmi.academi.aluno;

import java.time.LocalDate;

import com.apiAcadmi.academi.sexo.Sexo;

public record ListaDeAlunos(Long id, String nome, String cpf, String email, String telefone, LocalDate datanascimento,
		Sexo sexo, LocalDate datamatricula) {

	public ListaDeAlunos(Aluno aluno) {
 this(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getEmail(), aluno.getTelefone(), aluno.getDatanascimento(), aluno.getSexo(), aluno.getDatamatricula());
	}

}
