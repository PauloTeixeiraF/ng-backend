package br.com.novamercado.contracts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.novamercado.contracts.enums.TipoEnderecoEnum;
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
@Table(name = "endereco", catalog = "nova_mercado")
public class Endereco extends Auditable<String>{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "endereco_id")
	private Long id;
	
	@Column(name="TIPO_ENDERECO")
	private TipoEnderecoEnum tipoEndereco;
	
	@Column(name="LOGRADOURO", length=150)
	private String logradouro;

	@Column(name="NUMERO", length=10)
	private String numero;
	
	@Column(name="BAIRRO", length=100)
	private String bairro;
	
	@Column(name="CIDADE", length=100)
	private String cidade;
	
	@Column(name="UF", length=2)
	private String uf;
	
	@Column(name="CEP", length=8)
	private String cep;
	
	@Column(name="PRINCIPAL")
	private boolean principal;
}
