package br.com.cooperativaviana.desafiovotacaoapi.controllers.dto;

import javax.validation.constraints.NotNull;

import br.com.cooperativaviana.desafiovotacaoapi.model.enums.DescVoto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Voto")
public class VotoDTO {

	@NotNull
	private Long idAssociado;

	@NotNull
	private Long idPauta;

	@NotNull
	@Schema(description = "Sim ou Não")
	private DescVoto voto;

	public Long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public Long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Long idPauta) {
		this.idPauta = idPauta;
	}

	public DescVoto getVoto() {
		return voto;
	}

	public void setVoto(DescVoto voto) {
		this.voto = voto;
	}
}
