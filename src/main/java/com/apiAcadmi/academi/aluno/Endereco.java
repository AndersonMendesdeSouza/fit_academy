package com.apiAcadmi.academi.aluno;

import jakarta.persistence.Embeddable;

@Embeddable
public record Endereco(String rua, int numero, String bairro) {

}
