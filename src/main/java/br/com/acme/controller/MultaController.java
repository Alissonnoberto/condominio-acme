package br.com.acme.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.acme.multas.Multa;
import br.com.acme.service.MultaService;
import br.com.acme.service.UnidadeService;
import br.com.acme.unidade.Unidade;

@RestController
@RequestMapping("/api")
public class MultaController {
	
	@Autowired
	private MultaService service;
	
	@Autowired
	private UnidadeService serviceUnidade;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/unidade/{id}/multa")
	@JsonIgnore
	public ResponseEntity<Multa> save(@PathVariable("id") Long id, @RequestBody Multa multa) {
		Optional<Unidade> unidadeOptional = this.serviceUnidade.findById(id);
		if(unidadeOptional.isPresent()) {
			multa.setUnidadeMulta(unidadeOptional.get());
			this.service.save(multa);
		}
		return ResponseEntity.ok(multa);
	}
	@JsonIgnore
	@GetMapping("/unidade/{id}/aviso")
	public ResponseEntity<List<Multa>> list() {
		return ResponseEntity.ok(this.service.list());
	}

}
