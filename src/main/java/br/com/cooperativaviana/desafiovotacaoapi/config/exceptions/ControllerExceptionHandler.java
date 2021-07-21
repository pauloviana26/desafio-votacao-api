package br.com.cooperativaviana.desafiovotacaoapi.config.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.cooperativaviana.desafiovotacaoapi.exceptions.NegocioException;
import br.com.cooperativaviana.desafiovotacaoapi.exceptions.ResourceNotFoundException;
import br.com.cooperativaviana.desafiovotacaoapi.helpers.MessageHelper;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	private final MessageHelper messageHelper;

    public ControllerExceptionHandler(MessageHelper messageHelper) {
		this.messageHelper = messageHelper;
	}

	@Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var body = buildBindingResultResponseError(status, ex.getBindingResult());
        return handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var body = buildBindingResultResponseError(status, ex.getBindingResult());
        return handleExceptionInternal(ex, body, headers, status, request);
    }

    public ResponseError buildBindingResultResponseError(HttpStatus status, BindingResult bindingResult) {
        var response = new ResponseError();
        response.setCode(status.value());
        response.setDescription(messageHelper.getMessage("erro.campos.invalidos"));
        bindingResult.getAllErrors().forEach(e -> {
            String fieldName = ((FieldError) e).getField();
            String errorMessage = messageHelper.getMessage(e);
            response.getFields().put(fieldName, errorMessage);
        });
        return response;
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> handleNegocioExpection(NegocioException ex, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;
        var body = new ResponseError();
        body.setCode(status.value());
        body.setDescription(ex.getMessage());
        return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleRecursoNaoEncontradoException(ResourceNotFoundException ex, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;
        var body = new ResponseError();
        body.setCode(status.value());
        body.setDescription(ex.getMessage());
        return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
    }
}
