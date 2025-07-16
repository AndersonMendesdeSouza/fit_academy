package com.apiAcadmi.academi.dtos;

import jakarta.validation.constraints.NotBlank;

public record dadosCadastroLogin(
		@NotBlank
		String nome,
		@NotBlank
		String senha
		
		
		) {

}
