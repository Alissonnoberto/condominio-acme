package br.com.acme.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.acme.condominio.Condominio;
import br.com.acme.responsavel.Responsavel;
import br.com.acme.service.CondominioService;
import br.com.acme.service.ResponsavelService;
import br.com.acme.service.UnidadeService;
import br.com.acme.unidade.Unidade;

@RestController
@RequestMapping("/api")
public class UnidadeController {

	@Autowired
	private UnidadeService service;

	@Autowired
	private ResponsavelService serviceResponsavel;

	@Autowired
	private CondominioService serviceCondominio;

	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonIgnore
	@PostMapping("/unidades")
	public ResponseEntity<Unidade> save(@RequestParam("condominioId") Long condominioId,
			@RequestParam("responsavelId") Long responsavelId, @RequestBody Unidade unidade) {
		Optional<Condominio> condominioOptional = this.serviceCondominio.findById(condominioId);
		Optional<Responsavel> responsavelOptional = this.serviceResponsavel.findById(responsavelId);
		if (responsavelOptional.isPresent() && condominioOptional.isPresent()) {
			unidade.setResponsavelUnidade(responsavelOptional.get());
		}
		this.service.save(unidade);
		return ResponseEntity.ok(unidade);
	}

	@GetMapping("/unidades")
	public ResponseEntity<List<Unidade>> list() {
		return ResponseEntity.ok(this.service.list());
	}
}
