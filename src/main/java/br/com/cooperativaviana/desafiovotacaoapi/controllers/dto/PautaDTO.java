package br.com.cooperativaviana.desafiovotacaoapi.controllers.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Pauta")
public class PautaDTO {
	
	private Long id;
	
	@NotBlank
	@Schema(required = true)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
