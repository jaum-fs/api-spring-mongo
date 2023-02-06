package com.projeto.workshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projeto.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus stts = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(System.currentTimeMillis(), stts.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(stts).body(error);
	}
	
}
