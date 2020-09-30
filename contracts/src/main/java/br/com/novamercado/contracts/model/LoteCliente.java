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
@Table(name = "lote_cliente", catalog = "nova_mercado")
public class LoteCliente extends Auditable<String>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "lote_cliente_id")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;
	
	@ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
	
	@Column(name="QUADRA", length=20) 
	private String quadra;
	

}
