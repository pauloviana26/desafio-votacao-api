package br.com.cooperativaviana.desafiovotacaoapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.cooperativaviana.desafiovotacaoapi.model.enums.DescVoto;

@Entity
@Table(name = "voto", schema = "votacao")
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voto")
	private Long idVoto;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "voto", length = 3)
	private DescVoto voto;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_associado")
	private Associado associado;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_sessao")
	private Sessao sessao;

	public Voto() {}

	public Long getIdVoto() {
		return idVoto;
	}

	public void setIdVoto(Long idVoto) {
		this.idVoto = idVoto;
	}

	public DescVoto getVoto() {
		return voto;
	}

	public void setVoto(DescVoto voto) {
		this.voto = voto;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
}
