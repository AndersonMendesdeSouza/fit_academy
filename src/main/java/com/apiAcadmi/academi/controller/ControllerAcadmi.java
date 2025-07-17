package com.apiAcadmi.academi.controller;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.apiAcadmi.academi.acesso.Acesso;
import com.apiAcadmi.academi.aluno.Aluno;
import com.apiAcadmi.academi.aluno.ListaDeAlunos;
import com.apiAcadmi.academi.dtos.acessosList;
import com.apiAcadmi.academi.dtos.dadosAtualizarAluno;
import com.apiAcadmi.academi.dtos.dadosAtualizarLogin;
import com.apiAcadmi.academi.dtos.dadosCadastroAluno;
import com.apiAcadmi.academi.dtos.dadosCadastroLogin;
import com.apiAcadmi.academi.dtos.dadosLogin;
import com.apiAcadmi.academi.repository.acessoRepository;
import com.apiAcadmi.academi.repository.alunoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/academia")
@CrossOrigin(origins = "*")
public class ControllerAcadmi {
	@Autowired
	private alunoRepository alunoRepository;

	@Autowired
	private acessoRepository acessoRepository;
	
//	Cadastrar Aluno
	@Transactional
	@PostMapping
	public ResponseEntity<ListaDeAlunos> cadastroAluno(@Valid @RequestBody dadosCadastroAluno dados, UriComponentsBuilder builder) {
		Aluno aluno = alunoRepository.save(new Aluno(dados));
		
		URI uri = builder.path("/academia/{id}").buildAndExpand(aluno.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ListaDeAlunos(aluno));
				}
	// Buscar Aluno
	@GetMapping
	public List<ListaDeAlunos> buscarAluno() {
		return alunoRepository.findAll().stream().map(ListaDeAlunos::new).toList();

	}
	@GetMapping("{id}")
	public List<ListaDeAlunos> buscarAlunoId(@PathVariable Long id){
		return alunoRepository.findById(id).stream().map(ListaDeAlunos::new).toList();	}

//Atualizar aluno
@Transactional
@PutMapping
public ResponseEntity<ListaDeAlunos> stualizarAluno(@Valid @RequestBody  dadosAtualizarAluno dados) {
	Aluno aluno = alunoRepository.getReferenceById(dados.id());
	aluno.atualizarAluno(dados);
 

	return ResponseEntity.ok(new ListaDeAlunos(aluno));
	}

//Deletar Aluno
@DeleteMapping("{id}")
public void deletar (@PathVariable Long id) {
	Aluno aluno = alunoRepository.getReferenceById(id);
	alunoRepository.deleteById(id);
}

//Cadastro Login
@PostMapping("/cadastroLogin")
public void cadastroLogin(@RequestBody dadosCadastroLogin dados) {
  acessoRepository.save(new Acesso(dados));
	
}

//Buscar Login
@GetMapping("/buscarLogin")
public List<acessosList> buscarAcesso(){
	return acessoRepository.findAll().stream().map(acessosList::new).toList();
}

//Atualizar Login
@Transactional
@PutMapping("/atualizarLogin")
public void atualizarLogin(@RequestBody dadosAtualizarLogin dados) {
	   Acesso acesso = acessoRepository.getReferenceById(dados.id());
	   acesso.atualizarLogin(dados);
	   
		
	}

//Deletar Login
@DeleteMapping("/deletarLogin/{id}")
public void deletarLogin(@PathVariable Long id) {

	 acessoRepository.deleteById(id);
	
}

//Fazer Login	
@PostMapping("/postAcessar")
public ResponseEntity<?> login(@RequestBody dadosLogin dados){
	Optional<Acesso> usuario = acessoRepository.findByNomeAndSenha(dados.nome(),dados.senha());
	
    if(usuario.isPresent()&& usuario.get().getSenha().equals(dados.senha())) {
    	return ResponseEntity.ok("Login autorizado");
    	
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inváidos");
}




}
