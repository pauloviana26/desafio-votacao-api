package br.com.cooperativaviana.desafiovotacaoapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 872321034737434715L;
	
	public NotFoundException(String message) {
		super(message);
	}

}
