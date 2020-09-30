package br.com.novamercado.contracts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.novamercado.contracts.enums.TipoEmailEnum;
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
@Table(name = "email", catalog = "nova_mercado")
public class Email extends Auditable<String>{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "email_id")
	private Long id;
	
	@Column(name="TIPO_EMAIL")
	private TipoEmailEnum tipoEmail;
	
	@Column(name="Email", length=50)
	private String email;
	
	@Column(name="PRINCIPAL")
	private boolean principal;
}