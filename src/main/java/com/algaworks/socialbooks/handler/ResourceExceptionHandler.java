package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.DetalhesErro;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlerLivroNaoEncontradoException(LivroNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(404l);
		erro.setTitulo("O livro não pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://erro.socialbooks.com/404");
		erro.setTimestamps(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
