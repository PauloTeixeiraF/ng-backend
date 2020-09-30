package br.com.novamercado.contracts.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.novamercado.contracts.enums.EstadoCiviEnum;
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
@Table(name = "cliente", catalog = "nova_mercado")
public class Cliente extends Auditable<String>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cliente_id")
	private Long id;
	
	@Column(name="NOME", length=100) 
	private String name;

	@Column(name="RG", length=10, unique=true)
	private String rg;
	
	@Column(name="UF_RG", length=6)
	private String ufRg;
	
	@Column(name="CPF", length=11, unique=true)
	private String cpf;
	
	@Column(name="DATA_NASCIMENTO")
	private Date dataNascimento;
	
	@Column(name="ESTADO_CIVIL")
	private EstadoCiviEnum estadoCivil;
	
	@ManyToOne
	@JoinColumn(name="telefone_id")
	private Telefone telefone;
	
	@ManyToOne
	@JoinColumn(name="profissao_id")
	private Profissao profissao;
	
	@ManyToOne
	@JoinColumn(name="email_id")
	private Email email;
	
	@ManyToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	@Column(name="NOME_CONJUGE", length=100) 
	private String nameConjuge;

	@Column(name="RG_CONJUGE", length=10, unique=true)
	private String rgConjuge;
	
	@Column(name="UF_RG_CONJUGE", length=6)
	private String ufRgConjuge;
	
	@Column(name="CPF_CONJUGE", length=11, unique=true)
	private String cpfConjuge;

	
}
