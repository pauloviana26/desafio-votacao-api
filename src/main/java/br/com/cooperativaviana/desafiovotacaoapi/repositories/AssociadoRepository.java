package br.com.cooperativaviana.desafiovotacaoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Associado;

public interface AssociadoRepository extends JpaRepository<Associado, Long>{
	
	Boolean existsAssociadoByCpf(String cpf);

}
