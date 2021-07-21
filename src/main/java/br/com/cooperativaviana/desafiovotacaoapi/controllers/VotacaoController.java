package br.com.cooperativaviana.desafiovotacaoapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cooperativaviana.desafiovotacaoapi.controllers.dto.ResultadoVotacaoDTO;
import br.com.cooperativaviana.desafiovotacaoapi.controllers.dto.VotoDTO;
import br.com.cooperativaviana.desafiovotacaoapi.service.VotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/votacao")
@Tag(name = "Votação", description = "Cadastro de voto e mostrar resultado da votação")
public class VotacaoController {
	
	@Autowired
	private VotoService votoService;
	
	@PostMapping("/votar")
	@Operation(summary = "Registrar voto")
	public ResponseEntity<Void> salvar(@Valid @RequestBody VotoDTO votoDTO) {
		votoService.salvar(votoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/resultado/{idPauta}")
	@Operation(summary = "Resultado da votação de acordo com a pauta da sessão")
	public ResponseEntity<ResultadoVotacaoDTO> consulta(@PathVariable("idPauta") Long idPauta) {
		return ResponseEntity.ok(votoService.consultarResultadoVotacao(idPauta));
	}
}
