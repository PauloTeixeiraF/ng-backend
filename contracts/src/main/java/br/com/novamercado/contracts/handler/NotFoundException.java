package br.com.novamercado.contracts.handler;

import java.util.List;

import org.springframework.validation.ObjectError;

public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5050886862432687015L;
	
	List<ObjectError> errors;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}

