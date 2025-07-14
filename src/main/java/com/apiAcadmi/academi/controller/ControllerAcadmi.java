package com.apiAcadmi.academi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiAcadmi.academi.aluno.Aluno;
import com.apiAcadmi.academi.aluno.ListaDeAlunos;
import com.apiAcadmi.academi.aluno.dadosCadastroAluno;
import com.apiAcadmi.academi.repository.alunoRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/academia")

public class ControllerAcadmi {
	@Autowired
	private alunoRepository alunoRepository;

	@Transactional
	@PostMapping
	public void cadastroAluno(@RequestBody dadosCadastroAluno dados) {
		alunoRepository.save(new Aluno(dados));
	}

	@GetMapping
	public List<ListaDeAlunos> buscarAluno() {
		return alunoRepository.findAll().stream().map(ListaDeAlunos::new).toList();

	}

}