package br.com.novamercado.contracts.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.novamercado.contracts.dto.RegisterDto;
import br.com.novamercado.contracts.dto.RegisterResponseDto;
import br.com.novamercado.contracts.model.Register;
import br.com.novamercado.contracts.service.RegisterService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/register")
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private RegisterService registerService;
	
	@ApiOperation(value = "Criar um novo usuário")
	@PostMapping
	public ResponseEntity<RegisterResponseDto> saveUser(@RequestBody @Valid RegisterDto registerDto) throws Exception{	
		logger.info("Salvando novo usuário");
		Register register = registerService.saveUser(registerDto.transformeToObject());
		return new ResponseEntity<>(register.transformeToDto(), HttpStatus.CREATED);
	}
	
//	@GetMapping("/{id}")
//    public RegisterResponseDto getRegister(@PathVariable Long id) throws NotFoundException {
//		try {
//			RegisterResponseDto registerDto = registerService.getRegister(id).transformeToDto();
//			 if(registerDto != null)
//					return registerDto;
//				else
//					throw new NotFoundException("Customer not found with id " + id);
//		} catch (Exception e) {
//			logger.error("Falha ao pesquisar usuário -> ".concat(e.getMessage()));
//			throw new NotFoundException("Customer not found with id " + id);
//		}
//    }
	
	
	
}
