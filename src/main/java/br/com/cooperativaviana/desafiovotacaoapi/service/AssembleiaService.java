package br.com.cooperativaviana.desafiovotacaoapi.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cooperativaviana.desafiovotacaoapi.controllers.dto.PautaDTO;
import br.com.cooperativaviana.desafiovotacaoapi.controllers.dto.SessaoInputDTO;
import br.com.cooperativaviana.desafiovotacaoapi.exceptions.NegocioException;
import br.com.cooperativaviana.desafiovotacaoapi.helpers.MessageHelper;
import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Pauta;
import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Sessao;
import br.com.cooperativaviana.desafiovotacaoapi.repositories.PautaRepository;
import br.com.cooperativaviana.desafiovotacaoapi.repositories.SessaoRepository;

@Service
public class AssembleiaService {
	
	private static final int DEFAULT_TIME = 1;
	
	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Autowired
	private MessageHelper messageHelper;
	
	public void salvar(PautaDTO pautaDTO) {
		
		Pauta pauta = new Pauta();
		pauta.setDescricao(pautaDTO.getDescricao());
		
		pautaRepository.save(pauta);
	}
	
	public List<Pauta> buscarTodasPautas() {
		var pautas = pautaRepository.findAll();
		return pautas;
	}
	
	public void salvarSessao(SessaoInputDTO inputDTO) {
		validarPauta(inputDTO);
		
		var pauta = pautaRepository.findById(inputDTO.getIdPauta());
		
		Sessao sessao = new Sessao();
		sessao.setPauta(pauta.get());
		sessao.setDataInicio(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		
		if(inputDTO.getDuracao() == null || inputDTO.getDuracao() < 1) {
			sessao.setDataFim(sessao.getDataInicio().plusMinutes(DEFAULT_TIME));
		} else {
			sessao.setDataFim(sessao.getDataInicio().plusMinutes(inputDTO.getDuracao()));
		}
		
		sessaoRepository.save(sessao);
	}
	
	public List<Sessao> buscarTodasSessoes() {
		var sessoes = sessaoRepository.findAll();
		return sessoes;
	}

	private void validarPauta(SessaoInputDTO valor) {
		if(!pautaRepository.existsPautaByIdPauta(valor.getIdPauta())) {
			throw new NegocioException(messageHelper.getMessage("registro.inexistente.pauta"));
		}
		
		if(sessaoRepository.existsSessaoByPauta_idPauta(valor.getIdPauta())) {
			throw new NegocioException(messageHelper.getMessage("registro.existente.sessao"));
		}
	}
}
