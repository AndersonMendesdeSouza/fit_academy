package com.apiAcadmi.academi.controller;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.apiAcadmi.academi.aluno.Aluno;
import com.apiAcadmi.academi.aluno.ListaDeAlunos;
import com.apiAcadmi.academi.aluno.dadosAtualizarAluno;
import com.apiAcadmi.academi.aluno.dadosCadastroAluno;
import com.apiAcadmi.academi.repository.alunoRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/academia")
@CrossOrigin(origins = "*")
public class ControllerAcadmi {
	@Autowired
	private alunoRepository alunoRepository;

	@Transactional
	@PostMapping
	public ResponseEntity<ListaDeAlunos> cadastroAluno(@RequestBody dadosCadastroAluno dados, UriComponentsBuilder builder) {
		Aluno aluno = alunoRepository.save(new Aluno(dados));
		
		URI uri = builder.path("/academia/{id}").buildAndExpand(aluno.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ListaDeAlunos(aluno));
				}
	
	@GetMapping
	public List<ListaDeAlunos> buscarAluno() {
		return alunoRepository.findAll().stream().map(ListaDeAlunos::new).toList();

	}
	@GetMapping("{id}")
	public List<ListaDeAlunos> buscarAlunoId(@PathVariable Long id){
		return alunoRepository.findById(id).stream().map(ListaDeAlunos::new).toList();	}


@Transactional
@PutMapping
public ResponseEntity<ListaDeAlunos> stualizarAluno(@RequestBody  dadosAtualizarAluno dados) {
	Aluno aluno = alunoRepository.getReferenceById(dados.id());
	aluno.atualizarAluno(dados);
 

	return ResponseEntity.ok(new ListaDeAlunos(aluno));
	}


@DeleteMapping("{id}")
public void deletar (@PathVariable Long id) {
	Aluno aluno = alunoRepository.getReferenceById(id);
	alunoRepository.deleteById(id);
}

}
