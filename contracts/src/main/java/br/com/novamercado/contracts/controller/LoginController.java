package br.com.novamercado.contracts.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.novamercado.contracts.dto.LoginDto;
import br.com.novamercado.contracts.dto.LoginResponseDto;
import br.com.novamercado.contracts.service.RegisterService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private RegisterService registerService;
	
	@ApiOperation(value = "Efetua login de usuário")
	@CrossOrigin
	@GetMapping
	public ResponseEntity<LoginResponseDto> loginUser(@RequestBody @Valid LoginDto loginDto) throws Exception{	
		logger.info("Efetuando login");
		LoginResponseDto login = registerService.authorize(loginDto);
		
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
}
