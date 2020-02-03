/**
 * 
 */
package br.com.acme.unidade;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.acme.aviso.Aviso;
import br.com.acme.condominio.Condominio;
import br.com.acme.multas.Multa;
import br.com.acme.responsavel.Responsavel;
//import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author carlosfilho
 *
 */
@Entity
@Getter
@Setter
//@Builder
@EqualsAndHashCode
@Table(name = "tb_responsavel")
public class Unidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne()
	@JoinColumn(name = "id_condominio")
	private Condominio condominioUnidade;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_responsavel")
	private Responsavel responsavelUnidade;

	private String numeroUnidade;

	private String blocoUnidade;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeMulta")
	private Set<Multa> multasUnidade;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeAviso")
	private Set<Aviso> AvisoUnidade;

}
