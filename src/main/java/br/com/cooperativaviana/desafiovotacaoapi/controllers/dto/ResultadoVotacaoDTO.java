package br.com.cooperativaviana.desafiovotacaoapi.controllers.dto;

import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Sessao;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ResultadoVotacao")
public class ResultadoVotacaoDTO {
	
	private Sessao sessao;

    private Integer totalSim;

    private Integer totalNao;

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Integer getTotalSim() {
		return totalSim;
	}

	public void setTotalSim(Integer totalSim) {
		this.totalSim = totalSim;
	}

	public Integer getTotalNao() {
		return totalNao;
	}

	public void setTotalNao(Integer totalNao) {
		this.totalNao = totalNao;
	}
}
