package br.com.novamercado.contracts.handler;

import java.util.List;

import org.springframework.validation.ObjectError;

public class DuplicateRegisterException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2305976766596925019L;
	List<ObjectError> errors;


    public DuplicateRegisterException(String message) {
        super(message);
    }

    public DuplicateRegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateRegisterException(Throwable cause) {
        super(cause);
    }
}