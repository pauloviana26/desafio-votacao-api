package br.com.cooperativaviana.desafiovotacaoapi.helpers;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {
	
	private final MessageSource messageSource;

	public MessageHelper(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public String getMessage(String messageKey) {
		return messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale());
	}
	
	public String getMessage(String messageKey, Object... args) {
		return messageSource.getMessage(messageKey, args, LocaleContextHolder.getLocale());
	}
	
	public String getMessage(MessageSourceResolvable resolvable) {
		return messageSource.getMessage(resolvable, LocaleContextHolder.getLocale());
	}

}
