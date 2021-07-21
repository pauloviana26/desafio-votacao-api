package br.com.cooperativaviana.desafiovotacaoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cooperativaviana.desafiovotacaoapi.client.UserInfoApiClient;
import br.com.cooperativaviana.desafiovotacaoapi.exceptions.NegocioException;
import br.com.cooperativaviana.desafiovotacaoapi.exceptions.NotFoundException;
import br.com.cooperativaviana.desafiovotacaoapi.helpers.MessageHelper;
import feign.FeignException;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoApiClient apiClient;
	
	@Autowired
	private MessageHelper messageHelper;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public String consultarStatusAssociado(String cpf) {
		try {
			var response = apiClient.consultarStatusAssociado(cpf);
			return objectMapper.readTree(response).requiredAt("/status").asText();
		} catch (FeignException.FeignClientException.NotFound e) {
			throw new NotFoundException(messageHelper.getMessage(e.getMessage()));
		} catch (JsonProcessingException e) {
			throw new NegocioException(messageHelper.getMessage("erro.processar.requisicao", e.getMessage()));
		}
	}
}
