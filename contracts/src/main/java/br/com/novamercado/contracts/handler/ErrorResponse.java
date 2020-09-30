package br.com.novamercado.contracts.handler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
	private Problem error;
}
