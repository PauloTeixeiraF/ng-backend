package br.com.novamercado.contracts.handler;

import java.util.List;

import org.springframework.validation.ObjectError;

public class AccessDeniedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5050886862432687015L;
	
	List<ObjectError> errors;

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }
}

