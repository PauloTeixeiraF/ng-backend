package br.com.novamercado.contracts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.novamercado.contracts.dto.RegisterResponseDto;
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
@Table(name = "registro", catalog = "nova_mercado")
public class Register extends Auditable<String>{

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "register_id")
		private Long id;
		
		@Column(name="NOME", length=150) 
		private String name;
		
		@Column(name="EMAIL", length=255, unique=true)
		private String email;
		
		@Column(name="SENHA", length=255, unique=true)
		private String password;
		
		@Column(name="REGRA", length=5)
	    private String role;
		
		public RegisterResponseDto transformeToDto(){
			return new RegisterResponseDto(id, name, email, password, password, role);
	    }

}
