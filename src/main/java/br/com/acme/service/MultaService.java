package br.com.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.multas.Multa;
import br.com.acme.repository.MultaRepository;

@Service
public class MultaService {

	@Autowired
	private MultaRepository repository;

	@Transactional
	public void save(Multa condominio) {
		this.repository.save(condominio);
	}

	@Transactional
	public List<Multa> list() {
		return this.repository.findAll();
	}

	@Transactional
	public Optional<Multa> findById(Long id) {
		return this.repository.findById(id);
	}
}
