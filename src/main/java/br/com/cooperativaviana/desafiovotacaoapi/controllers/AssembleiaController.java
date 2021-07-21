package br.com.cooperativaviana.desafiovotacaoapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cooperativaviana.desafiovotacaoapi.controllers.dto.PautaDTO;
import br.com.cooperativaviana.desafiovotacaoapi.controllers.dto.SessaoInputDTO;
import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Pauta;
import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Sessao;
import br.com.cooperativaviana.desafiovotacaoapi.service.AssembleiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/assembleia")
@Tag(name = "Assembleia", description = "Cadastro de pautas, consultar, criar sessões de voto")
public class AssembleiaController {
	
	@Autowired
	private AssembleiaService assembleiaService;
	
	@PostMapping("/pauta/cadastrar")
	@Operation(summary = "Cadastro de pauta")
	public ResponseEntity<Void> salvar(@Valid @RequestBody PautaDTO pautaDTO) {
		assembleiaService.salvar(pautaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/pauta/listar")
	@Operation(summary = "Listagem de pautas")
	public ResponseEntity<List<Pauta>> buscarTodasPautas() {
		return ResponseEntity.ok(assembleiaService.buscarTodasPautas());
	}
	
	@PostMapping("/sessao/criarSessao")
	@Operation(summary = "Cria a sessão de votação em uma pauta")
	public ResponseEntity<Void> salvarSessao(@Valid @RequestBody SessaoInputDTO sessaoInputDTO) {
		assembleiaService.salvarSessao(sessaoInputDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/sessao/listar")
	@Operation(summary = "Listagem de sessões")
	public ResponseEntity<List<Sessao>> buscarTodasSessoes() {
		return ResponseEntity.ok(assembleiaService.buscarTodasSessoes());
	}
	
}
