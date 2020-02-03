package br.com.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.condominio.Condominio;
import br.com.acme.repository.CondominioRepository;

@Service
public class CondominioService {

	@Autowired
	private CondominioRepository repository;

	@Transactional
	public void save(Condominio condominio) {
		this.repository.save(condominio);
	}

	@Transactional
	public List<Condominio> list() {
		return this.repository.findAll();
	}

	@Transactional
	public Optional<Condominio> findById(Long id) {
		return this.repository.findById(id);
	}
}
