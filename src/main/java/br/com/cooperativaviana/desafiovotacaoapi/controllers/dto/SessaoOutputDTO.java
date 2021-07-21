package br.com.cooperativaviana.desafiovotacaoapi.controllers.dto;

import java.time.LocalDateTime;

import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Pauta;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "SessaoOutput")
public class SessaoOutputDTO {
	
	private Pauta pauta;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraFim;

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public LocalDateTime getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(LocalDateTime dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}
}
