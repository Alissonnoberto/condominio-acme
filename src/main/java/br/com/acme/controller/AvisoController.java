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

import br.com.acme.aviso.Aviso;
import br.com.acme.service.AvisoService;
import br.com.acme.service.UnidadeService;
import br.com.acme.unidade.Unidade;

@RestController
@RequestMapping("/api")
public class AvisoController {
	
	@Autowired
	private AvisoService service;
	
	@Autowired
	private UnidadeService serviceUnidade;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/unidade/{id}/avisos")
	public ResponseEntity<Aviso> save(@PathVariable("id") Long id, @RequestBody Aviso aviso) {
		Optional<Unidade> unidadeOptional = this.serviceUnidade.findById(id);
		if(unidadeOptional.isPresent()) {
			aviso.setUnidadeAviso(unidadeOptional.get());
			this.service.save(aviso);
		}
		return ResponseEntity.ok(aviso);
	}
	
	@GetMapping("/unidade/{id}/aviso")
	public ResponseEntity<List<Aviso>> list() {
		return ResponseEntity.ok(this.service.list());
	}

}
