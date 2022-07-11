package com.algaworks.socialbooks.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;

@RestController
@RequestMapping("/livros")
public class LivrosResources {
	
	@Autowired
	private LivrosRepository livrosRepository; // instanciando o Repository que faz acesso aos dados
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Livro> listar() {
		return livrosRepository.findAll(); // Utilizado do Repository/DAO instanciado para retornar tudo da Livros
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Livro livro) { //@RequestBody usado para pegar requisição e colocar no objeto
		livrosRepository.save(livro);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Livro> buscar(@PathVariable("id") Long id) {
		return livrosRepository.findById(id);
	}
}
