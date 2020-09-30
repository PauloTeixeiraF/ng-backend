package br.com.novamercado.contracts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RegisterResponseDto {

	private Long id;
	private String name;
	private String email;
	private String password;
    private String confirmPassword;
    private String role;
    
}
