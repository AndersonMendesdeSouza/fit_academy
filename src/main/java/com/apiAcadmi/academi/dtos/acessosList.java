package com.apiAcadmi.academi.dtos;

import com.apiAcadmi.academi.acesso.Acesso;

public record acessosList(
		Long id,
		String nome,
		String senha
		
		) {

	
	
	  public acessosList(Acesso acesso) {
		 this(acesso.getId(), acesso.getNome(), acesso.getSenha());
	}
}
