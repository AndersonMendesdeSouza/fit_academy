package com.apiAcadmi.academi.acesso;

import com.apiAcadmi.academi.dtos.dadosAtualizarAluno;
import com.apiAcadmi.academi.dtos.dadosAtualizarLogin;
import com.apiAcadmi.academi.dtos.dadosCadastroLogin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Acesso")
@Table(name = "acessos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Acesso {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nome;
 private String senha;
 
 
 
 public Acesso(dadosCadastroLogin dados) {
	 this.nome = dados.nome();
	 this.senha = dados.senha();
	}



public void atualizarLogin(dadosAtualizarLogin dados) {
	 if(dados.nome() != null) {
		 this.nome = dados.nome();
	 }
	 if(dados.senha()!= null) {
		 this.senha = dados.senha();
	 }
	
}

}
