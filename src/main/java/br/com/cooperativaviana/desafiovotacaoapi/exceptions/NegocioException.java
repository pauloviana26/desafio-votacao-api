package br.com.cooperativaviana.desafiovotacaoapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NegocioException extends RuntimeException {
	
	private static final long serialVersionUID = 872321034737434715L;
	
	public NegocioException(String message) {
		super(message);
	}
	
	public NegocioException(String message, Throwable cause) {
		super(message, cause);
	}

}
