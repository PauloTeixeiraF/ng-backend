package br.com.novamercado.contracts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.novamercado.contracts.enums.TipoTelefoneEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "telefone", catalog = "nova_mercado")
public class Telefone extends Auditable<String>{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "telefone_id")
	private Long id;
	
	@Column(name="TIPO_TELEFONE")
	private TipoTelefoneEnum tiipoTelefone;
	
	@Column(name="DDD", length=2)
	private String ddd;
	
	@Column(name="NUMERO", length=9)
	private String numero;
	
	@Column(name="PRINCIPAL")
	private boolean principal;
	
}
