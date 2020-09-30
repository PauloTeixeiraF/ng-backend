package br.com.novamercado.contracts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "empreendimento", catalog = "nova_mercado")
public class Empreendimento extends Auditable<String>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "empreendimento_id")
	private Long id;
	
	@Column(name="EMPREENDIMENTO", length=100, unique=true) 
	private String empreendimento;
	
	@ManyToOne
	@JoinColumn(name="lote_id")
	private Lote lote;
	
	@Column(name="PROPRIETARIO", length=100) 
	private String proprietario;
	
	@ManyToOne
	@JoinColumn(name="telefone_id")
	private Telefone telefone;

}
