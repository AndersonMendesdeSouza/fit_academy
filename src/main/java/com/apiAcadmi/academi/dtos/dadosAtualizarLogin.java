package com.apiAcadmi.academi.dtos;

import jakarta.validation.constraints.NotNull;

public record dadosAtualizarLogin(
		@NotNull
		Long id,
		
		String nome,
		String senha
		
		) {

}
