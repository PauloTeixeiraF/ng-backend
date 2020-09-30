package br.com.novamercado.contracts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.novamercado.contracts.model.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {

	public Optional<Register> findByName(String name);
	
	public Optional<Register> findByEmail(String email);

}
