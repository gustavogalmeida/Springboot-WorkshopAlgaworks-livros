package com.algaworks.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{ 
	// Objeto classe Livro com tipo do ID long, essa interface DAO/Repository serve para acesso ao DB
}
