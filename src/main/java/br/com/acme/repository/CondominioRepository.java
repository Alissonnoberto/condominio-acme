package br.com.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acme.condominio.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long>  {

}
