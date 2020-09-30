package br.com.novamercado.contracts.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "lote_financeiro", catalog = "nova_mercado")
public class LoteFinanceiro extends Auditable<String>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "lote_financeiro_id")
	private Long id;
	
	@OneToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;
	
	@Column(name="DESCRICAO", length=80) 
	private String descricao;

	@Column(name="VALOR_LOTE") 
	private BigDecimal valorLote;
	
	@Column(name="VALOR_ENTRADA") 
	private BigDecimal valorEntrada;
	
	@Column(name="CONDICOES",length=255) 
	private String condicoes;
	
	@Column(name="SALDO_RESTANTE") 
	private BigDecimal saldoRestante;
	
	@Column(name="QTDE_PARCELAS") 
	private Integer qtdeParcelas;
	
	@Column(name="VALOR_PARCELA") 
	private BigDecimal valorParcela;
	
	@Column(name="DATA") 
	private Date data;
	
}
