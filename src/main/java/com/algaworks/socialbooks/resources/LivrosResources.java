package com.algaworks.socialbooks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;

@RestController
public class LivrosResources {
	
	@Autowired
	private LivrosRepository livrosRepository; // instanciando o Repository que faz acesso aos dados
	
	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public List<Livro> listar() {
		return livrosRepository.findAll(); // Utilizado do Repository/DAO instanciado para retornar tudo da Livros
	}
}
