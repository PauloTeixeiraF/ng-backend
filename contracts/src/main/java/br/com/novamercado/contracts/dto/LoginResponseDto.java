package br.com.novamercado.contracts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LoginResponseDto {

	private Long id;
	private String name;
	private String role;
}
