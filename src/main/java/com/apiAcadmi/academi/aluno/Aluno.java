package com.apiAcadmi.academi.aluno;

import java.time.LocalDate;

import com.apiAcadmi.academi.dtos.dadosAtualizarAluno;
import com.apiAcadmi.academi.dtos.dadosCadastroAluno;
import com.apiAcadmi.academi.sexo.Sexo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Aluno")
@Table(name = "alunos")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;

	private LocalDate datanascimento;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private LocalDate datamatricula;

	public Aluno(dadosCadastroAluno dados) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.datanascimento = dados.datanascimento();
		this.sexo = dados.sexo();
		this.datamatricula = LocalDate.now();

	}


	public void atualizarAluno(dadosAtualizarAluno dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.cpf() != null) {
			this.cpf = dados.cpf();
		}
		if (dados.email() != null) {
			this.email = dados.email();
		}
		if (dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
		if (dados.sexo() != null) {
			this.sexo = dados.sexo();
		}

		if (dados.datanascimento() != null) {
			this.datanascimento = dados.datanascimento();
		}

	}

}
