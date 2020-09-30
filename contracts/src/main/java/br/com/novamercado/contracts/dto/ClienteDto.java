package br.com.novamercado.contracts.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.novamercado.contracts.enums.EstadoCiviEnum;
import br.com.novamercado.contracts.model.Email;
import br.com.novamercado.contracts.model.Endereco;
import br.com.novamercado.contracts.model.Profissao;
import br.com.novamercado.contracts.model.Telefone;

public class ClienteDto {

	@NotBlank(message = "{name.not.blank}")
	private String name;

	@NotBlank(message = "{rg.not.blank}")
	private String rg;
	
	@NotBlank(message = "{rguf.not.blank}")
	private String ufRg;
	
	@CPF(message = "{cpf.not.valid}")
	@NotBlank(message = "{cpf.not.blank}")
	private String cpf;
	
	@NotBlank(message = "{dtnasc.not.blank}")
	private Date dataNascimento;
	
	@NotBlank(message = "{estcivil.not.blank}")
	private EstadoCiviEnum estadoCivil;
	
	@NotNull(message = "{telefone.not.null}")
	@ManyToOne
	@JoinColumn(name="telefone_id")
	private Telefone telefone;
	
	@ManyToOne
	@JoinColumn(name="profissao_id")
	private Profissao profissao;
	
	@NotNull(message = "{email.not.null}")
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
