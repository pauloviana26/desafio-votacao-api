package br.com.cooperativaviana.desafiovotacaoapi.controllers.dto;

import static br.com.cooperativaviana.desafiovotacaoapi.utils.UnMaskCpf.unMask;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Associado")
public class AssociadoDTO {
	
	private Long idAssociado;
	
	@NotBlank
	@CPF
	@Schema(required = true)
	private String cpf;
	
	public Long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = unMask(cpf);
	}
}
