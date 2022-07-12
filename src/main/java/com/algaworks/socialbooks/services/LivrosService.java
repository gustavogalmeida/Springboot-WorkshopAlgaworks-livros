package com.algaworks.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;


public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	public List<Livro> listar (){
		return livrosRepository.findAll();
	}
	public Optional<Livro> buscar(Long id) {
		Optional<Livro> livro = livrosRepository.findById(id);
		
		if (livro == null) {
			//throw new LivroNaoEncontradoException("O livro não pode ser encontrado!");
		}
		return livro;
	}
}
