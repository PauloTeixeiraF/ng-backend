package br.com.novamercado.contracts.handler;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Problem {
	
	private LocalDateTime dataHora;
	private String message;

}
