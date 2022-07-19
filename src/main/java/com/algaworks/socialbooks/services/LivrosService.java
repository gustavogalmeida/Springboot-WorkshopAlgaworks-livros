package com.algaworks.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Comentario;
import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.AutoresRepository;
import com.algaworks.socialbooks.repository.ComentariosRepository;
import com.algaworks.socialbooks.repository.LivrosRepository;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	public List<Livro> listar (){
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Livro livro = livrosRepository.findById(id).orElseThrow(()->new LivroNaoEncontradoException("Livro não encontrado"));
		
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro não foi encontrado!");
		}
	}
	
	public void atualizar (Livro livro) {
		verificaLivroExiste(livro);
		livrosRepository.save(livro);
	}
	public void verificaLivroExiste (Livro livro) {
		buscar(livro.getId());
	}
	public Comentario salvarComentario (Long livroid, Comentario comentario) {
		Livro livro = buscar(livroid);
		
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentariosRepository.save(comentario);
	}
	public List<Comentario> listarComentarios (Long livroId) {
		Livro livro = buscar(livroId);
		
		return livro.getComentarios();
	}
}
