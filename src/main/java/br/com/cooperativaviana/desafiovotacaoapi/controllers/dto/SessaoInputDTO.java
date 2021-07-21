package br.com.cooperativaviana.desafiovotacaoapi.controllers.dto;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "SessaoInput")
public class SessaoInputDTO {
	
	@NotNull
    @Schema(required = true)
    private Long idPauta;

    @Schema(description = "Digite o tempo em minutos que a sessão deverá ficar disponível")
    private Integer duracao;

	public Long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Long idPauta) {
		this.idPauta = idPauta;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
}
