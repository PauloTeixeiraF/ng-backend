package br.com.novamercado.contracts.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginDto {

	@Email(message = "{e-mail.not.valid}")
	@NotBlank(message = "{e-mail.not.blank}")
	private String email;
	
	@NotBlank(message = "{e-password.not.blank}")
	private String password;
	
	private boolean rememberMe;
	
}
