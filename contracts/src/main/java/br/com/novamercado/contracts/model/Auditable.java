package br.com.novamercado.contracts.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.novamercado.contracts.enums.StatusActiveEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

	@Enumerated(EnumType.STRING)
	@Column(name="ATIVO") 
	private StatusActiveEnum active;
	
	@CreatedBy
    @Column(name = "CRIADO_POR")
    private String createdBy;

    @CreatedDate
    @Column(name = "DATA_CRIACAO")
    private Date createdDate;
    
    @LastModifiedBy
    @Column(name = "ULTIMA_MODIFICACAO_POR")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "DATA_ULTIMA_MODIFICACAO")
    private Date lastModifiedDate;
       
}
