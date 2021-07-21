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

import br.com.cooperativaviana.desafiovotacaoapi.controllers.dto.AssociadoDTO;
import br.com.cooperativaviana.desafiovotacaoapi.model.entity.Associado;
import br.com.cooperativaviana.desafiovotacaoapi.service.AssociadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/associados")
@Tag(name = "Associados", description = "Listar e cadastrar associados")
public class AssociadoController {
	
	@Autowired
	private AssociadoService associadoService;
	
	@GetMapping("/listar")
	@Operation(summary = "Listagem dos associados")
	public ResponseEntity<List<Associado>> buscarTodosAssociados() {
		return ResponseEntity.ok(associadoService.buscarTodosAssociados());
	}
	
	@PostMapping("/cadastrar")
	@Operation(summary = "Cadastrar associados")
	public ResponseEntity<Void> salvar(@Valid @RequestBody AssociadoDTO associadoDTO) {
		associadoService.salvar(associadoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
