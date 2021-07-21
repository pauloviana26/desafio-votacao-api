package br.com.cooperativaviana.desafiovotacaoapi.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cooperativaviana.desafiovotacaoapi.controllers.dto.ResultadoVotacaoDTO;
import br.com.cooperativaviana.desafiovotacaoapi.controllers.dto.VotoDTO;
import br.com.cooperativaviana.desafiovotacaoapi.exceptions.NegocioException;
import br.com.cooperativaviana.desafiovotacaoapi.exceptions.ResourceNotFoundException;
import br.com.cooperativaviana.desafiovotacaoapi.helpers.MessageHelper;
import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Associado;
import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Sessao;
import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Voto;
import br.com.cooperativaviana.desafiovotacaoapi.model.enums.DescVoto;
import br.com.cooperativaviana.desafiovotacaoapi.repositories.AssociadoRepository;
import br.com.cooperativaviana.desafiovotacaoapi.repositories.SessaoRepository;
import br.com.cooperativaviana.desafiovotacaoapi.repositories.VotoRepository;

@Service
public class VotoService {
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private MessageHelper messageHelper;
	
	
	public void salvar(VotoDTO votoDTO) {
		var sessao = sessaoRepository.findByPauta_idPauta(votoDTO.getIdPauta());
		var associado = associadoRepository.findById(votoDTO.getIdAssociado());
		
		validarVoto(votoDTO, sessao, associado);
		
		Voto voto = new Voto();
		voto.setVoto(votoDTO.getVoto());
		voto.setAssociado(associado.get());
		voto.setSessao(sessao.get());
		
		votoRepository.save(voto);
	}
	
	public ResultadoVotacaoDTO consultarResultadoVotacao(Long idPauta) {
        var sessao = sessaoRepository.findByPauta_idPauta(idPauta);

        if (sessao.isPresent()) {
            if (isSessaoVotacaoEncerrada(sessao)) {
                ResultadoVotacaoDTO resultado = new ResultadoVotacaoDTO();
                resultado.setSessao(sessao.get());
                resultado.setTotalSim(votoRepository.countVotoBySessao_idSessaoAndVoto(sessao.get().getIdSessao(), DescVoto.SIM));
                resultado.setTotalNao(votoRepository.countVotoBySessao_idSessaoAndVoto(sessao.get().getIdSessao(), DescVoto.NAO));
                return resultado;
            } else {
                throw new NegocioException(messageHelper.getMessage("sessao.votacao.aberta"));
            }
        }
        throw new ResourceNotFoundException(messageHelper.getMessage("registro.inexistente.sessao.pauta"));
    }


	private void validarVoto(VotoDTO votoDTO, Optional<Sessao> sessao, Optional<Associado> associado) {
		
		if(!sessao.isPresent()) {
			throw new NegocioException(messageHelper.getMessage("registro.inexistente.sessao.pauta"));
		}
		
		if(!associado.isPresent()) {
			throw new NegocioException(messageHelper.getMessage("registro.inexistente.associado"));
		}
		
		if(isSessaoVotacaoEncerrada(sessao)) {
			throw new NegocioException(messageHelper.getMessage("sessao.votacao.encerrada"));
		}
		
		if(votoRepository.existsVotoByAssociado_IdAssociadoAndSessao_Pauta_idPauta(votoDTO.getIdAssociado(), votoDTO.getIdPauta())) {
			throw new NegocioException(messageHelper.getMessage("voto.existente.associado"));
		}
		
		var statusUserInfo = userInfoService.consultarStatusAssociado(associado.get().getCpf());
		
		if(statusUserInfo.equals("UNABLE_TO_VOTE")) {
			throw new NegocioException(messageHelper.getMessage("voto.nao.autorizado"));
		}
	}
	
	private boolean isSessaoVotacaoEncerrada(Optional<Sessao> sessao) {
		return LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).isAfter(sessao.get().getDataFim());
	}
}
