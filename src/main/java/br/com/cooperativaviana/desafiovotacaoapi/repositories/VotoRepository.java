package br.com.cooperativaviana.desafiovotacaoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Voto;
import br.com.cooperativaviana.desafiovotacaoapi.model.enums.DescVoto;

public interface VotoRepository extends JpaRepository<Voto, Long>{
	
	Boolean existsVotoByAssociado_IdAssociadoAndSessao_Pauta_idPauta(Long idAssociado, Long idPauta);

    Integer countVotoBySessao_idSessaoAndVoto(Long idSessao, DescVoto voto);

}
