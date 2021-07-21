package br.com.cooperativaviana.desafiovotacaoapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long>{
	
	Boolean existsSessaoByPauta_idPauta(Long idPauta);

    Optional<Sessao> findByPauta_idPauta(Long idPauta);

}
