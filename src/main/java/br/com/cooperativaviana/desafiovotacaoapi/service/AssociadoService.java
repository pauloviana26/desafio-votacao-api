package br.com.cooperativaviana.desafiovotacaoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cooperativaviana.desafiovotacaoapi.controllers.dto.AssociadoDTO;
import br.com.cooperativaviana.desafiovotacaoapi.exceptions.NegocioException;
import br.com.cooperativaviana.desafiovotacaoapi.helpers.MessageHelper;
import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Associado;
import br.com.cooperativaviana.desafiovotacaoapi.repositories.AssociadoRepository;

@Service
public class AssociadoService {
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private MessageHelper messageHelper;
	
	public void salvar(AssociadoDTO associadoDTO) {
		if(verificaExisteAssociado(associadoDTO)) {
			throw new NegocioException(messageHelper.getMessage("registro.existente.associado"));
		}
		Associado associado = new Associado();
		associado.setCpf(associadoDTO.getCpf());
		associadoRepository.save(associado);
		
	}
	
	public List<Associado> buscarTodosAssociados() {
		return associadoRepository.findAll();
	}

	private boolean verificaExisteAssociado(AssociadoDTO associadoDTO) {
		return associadoRepository.existsAssociadoByCpf(associadoDTO.getCpf());
	}

}
