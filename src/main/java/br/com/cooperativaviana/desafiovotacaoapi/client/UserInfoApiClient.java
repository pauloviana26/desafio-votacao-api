package br.com.cooperativaviana.desafiovotacaoapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userInfoApiClient", url = "${desafio-votacao-api.user-info-api-url}")
public interface UserInfoApiClient {
	
	@GetMapping("/users/{cpf}")
	String consultarStatusAssociado(@PathVariable(value = "cpf") String cpf);
}
