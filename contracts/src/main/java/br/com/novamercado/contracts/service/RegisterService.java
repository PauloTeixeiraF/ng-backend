package br.com.novamercado.contracts.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.novamercado.contracts.dto.LoginDto;
import br.com.novamercado.contracts.dto.LoginResponseDto;
import br.com.novamercado.contracts.enums.StatusActiveEnum;
import br.com.novamercado.contracts.handler.DuplicateRegisterException;
import br.com.novamercado.contracts.handler.NotFoundException;
import br.com.novamercado.contracts.model.Register;
import br.com.novamercado.contracts.repository.RegisterRepository;

@Service
public class RegisterService {

private static final Logger logger = LoggerFactory.getLogger(RegisterService.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	public Register saveUser(Register register) throws DuplicateRegisterException, NotFoundException {
	    if (emailExist(register.getEmail())) {
	        throw new DuplicateRegisterException(
	          "Já existe uma conta de email: " + register.getEmail() + ", cadastrada em nosso banco de dados!");
	    } else {
			logger.info("Persistindo no Banco de Dados");
				register.setActive(StatusActiveEnum.YES);
				register.setCreatedBy(register.getName());
				register.setCreatedDate(new Date());
				register.setRole("ADMIN");
				register.setPassword(passwordEncoder.encode(register.getPassword()));
				registerRepository.save(register);
				logger.info("Usuário salvo com sucesso!");
	    }
		return register;
	}

	private boolean emailExist(String email) {

		logger.info("Pesquisando no Banco de Dados");

		Optional<Register> optRegister = registerRepository.findByEmail(email);
		if(optRegister.isPresent()) {
			logger.info("Usuário encontrado com sucesso!");
			return true;
		} 
		logger.error("Usuário não encontrado!");
		return false;
	}

	public Register getRegister(Long id) throws Exception{
		
		Register register;
		logger.info("Pesquisando no Banco de Dados");

		Optional<Register> optRegister = registerRepository.findById(id);
		register = optRegister.get();

		logger.info("Usuário encontrado com sucesso!");
		return register;
	}
	
	public LoginResponseDto authorize(LoginDto loginDto) throws AccessDeniedException {
		
		try {
			Optional<Register> optRegister = registerRepository.findByEmail(loginDto.getEmail());
			if(optRegister.isPresent()) {
				logger.info("Usuário encontrado com sucesso!");
				
				if(passwordEncoder.matches(loginDto.getPassword(),optRegister.get().getPassword())) {
					return LoginResponseDto.builder()
							.id(optRegister.get().getId())
							.name(optRegister.get().getName())
							.role(optRegister.get().getRole())
							.build();
				} else {
					logger.error("Credênciais (Usuário/Senha) inválidas!");
					throw new AccessDeniedException(
					          "Credênciais (Usuário/Senha) inválidas!");
				}
			}
		} catch (Exception e) {
			logger.error("Credênciais (Usuário/Senha) inválidas!");
			throw new AccessDeniedException(
			          "Credênciais (Usuário/Senha) inválidas!");
		}
		return null;
	}
		
		
}

