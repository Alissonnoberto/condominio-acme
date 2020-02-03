package br.com.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.repository.UnidadeRepository;
import br.com.acme.unidade.Unidade;

@Service
public class UnidadeService {

	@Autowired
	private UnidadeRepository repository;

	@Transactional
	public void save(Unidade unidade) {
		this.repository.save(unidade);
	}

	@Transactional
	public List<Unidade> list() {
		return this.repository.findAll();
	}

	@Transactional
	public Optional<Unidade> findById(Long id) {
		return this.repository.findById(id);
	}
}
