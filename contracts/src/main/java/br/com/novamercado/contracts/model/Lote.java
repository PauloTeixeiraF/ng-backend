package br.com.novamercado.contracts.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.novamercado.contracts.enums.StatusLoteEnum;
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
@Table(name = "lote", catalog = "nova_mercado")
public class Lote extends Auditable<String>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "lote_id")
	private Long id;
	
	@Column(name="STATUS_LOTE") 
	private StatusLoteEnum statusLoteEnum;
	
	@Column(name="DATA") 
	private Date data;
	
}
