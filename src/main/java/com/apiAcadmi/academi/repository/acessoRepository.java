package com.apiAcadmi.academi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiAcadmi.academi.acesso.Acesso;

public interface acessoRepository extends JpaRepository<Acesso, Long>{

	Optional<Acesso> findByNomeAndSenha(String nome, String senha);

}
