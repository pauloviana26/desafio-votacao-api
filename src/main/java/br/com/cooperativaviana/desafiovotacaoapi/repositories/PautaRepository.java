package br.com.cooperativaviana.desafiovotacaoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Pauta;

public interface PautaRepository extends JpaRepository<Pauta, Long>{
	
	Boolean existsPautaByIdPauta(Long idPauta);
}
