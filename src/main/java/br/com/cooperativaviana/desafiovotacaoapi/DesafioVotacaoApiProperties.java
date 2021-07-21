package br.com.cooperativaviana.desafiovotacaoapi;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("desafio-votacao-api")
public class DesafioVotacaoApiProperties {
	
	private String userInfoApiUrl;

	public String getUserInfoApiUrl() {
		return userInfoApiUrl;
	}

	public void setUserInfoApiUrl(String userInfoApiUrl) {
		this.userInfoApiUrl = userInfoApiUrl;
	}

}
