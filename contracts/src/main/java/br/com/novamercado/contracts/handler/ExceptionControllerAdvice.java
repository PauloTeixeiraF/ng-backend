package br.com.novamercado.contracts.handler;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.NotFoundException;


@ControllerAdvice
@RestController
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<?> handleAccessDeniedException(
    		AccessDeniedException ex) {
    	Problem problem = Problem.builder()
    			.dataHora(LocalDateTime.now())
    			.message(ex.getMessage())
    			.build();
    	ErrorResponse error = ErrorResponse.builder()
    			.error(problem)
    			.build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
    
    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<?> handleNotFoundException(
    		NotFoundException ex) {
    	Problem problem = Problem.builder()
    			.dataHora(LocalDateTime.now())
    			.message(ex.getMessage())
    			.build();
    	ErrorResponse error = ErrorResponse.builder()
    			.error(problem)
    			.build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    @ExceptionHandler({ DuplicateRegisterException.class })
    public ResponseEntity<?> handleDuplicateRegisterException(
    		DuplicateRegisterException ex) {
    	Problem problem = Problem.builder()
    			.dataHora(LocalDateTime.now())
    			.message(ex.getMessage())
    			.build();
    	ErrorResponse error = ErrorResponse.builder()
    			.error(problem)
    			.build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
    
    
    
    @ExceptionHandler({ SQLException.class })
    public ResponseEntity<Object> handleSQLException(
      Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
      "Erro no SQL.", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler({ SQLSyntaxErrorException.class })
    public ResponseEntity<Object> handleSQLSysntexErrorException(
      Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
          "Erro na sintaxe do SQL.", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}