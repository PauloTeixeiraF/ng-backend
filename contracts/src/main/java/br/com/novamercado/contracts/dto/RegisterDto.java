package br.com.novamercado.contracts.dto;

import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.novamercado.contracts.model.Register;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterDto {
	
		@NotBlank(message = "{name.not.blank}")
		private String name;
		
		@Email(message = "{e-mail.not.valid}")
		@NotBlank(message = "{e-mail.not.blank}")
		private String email;
		
		@NotBlank(message = "{e-password.not.blank}")
		private String password;
		
		@Transient
		@NotBlank(message = "{confirmed.not.blank]")
	    private String confirmPassword;

		@NotBlank(message = "{rule.not.blank}")
	    private String role;
	
		public Register transformeToObject(){
			return Register.builder()
					.name(this.getName()) 
					.email(this.getEmail()) 
					.password(this.getPassword()) 
					.role(this.getRole())
					.build();
	    }
}