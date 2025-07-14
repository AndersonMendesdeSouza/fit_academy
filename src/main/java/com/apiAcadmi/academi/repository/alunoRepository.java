package com.apiAcadmi.academi.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiAcadmi.academi.aluno.Aluno;
import com.apiAcadmi.academi.aluno.ListaDeAlunos;

public interface alunoRepository extends JpaRepository<Aluno, Long>{

	 

}
