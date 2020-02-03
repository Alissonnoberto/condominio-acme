package br.com.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.repository.ResponsavelRepository;
import br.com.acme.responsavel.Responsavel;

@Service
public class ResponsavelService {

	@Autowired
	private ResponsavelRepository repository;

	@Transactional
	public void save(Responsavel responsavel) {
		this.repository.save(responsavel);
	}

	@Transactional
	public List<Responsavel> list() {
		return this.repository.findAll();
	}

	@Transactional
	public Optional<Responsavel> findById(Long id) {
		return this.repository.findById(id);
	}

}
