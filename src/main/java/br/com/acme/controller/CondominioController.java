package br.com.acme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.condominio.Condominio;
import br.com.acme.service.CondominioService;
import br.com.acme.unidade.Unidade;

@RestController
@RequestMapping("/api")
public class CondominioController {
	
	@Autowired
	private CondominioService service;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/condominios")
	public ResponseEntity<Condominio> save(@RequestBody Condominio condominio) {
		this.service.save(condominio);
		return ResponseEntity.ok(condominio);
	}
	
	@GetMapping("/condominios")
	public ResponseEntity<List<Condominio>> list() {
		return ResponseEntity.ok(this.service.list());
	}
}
