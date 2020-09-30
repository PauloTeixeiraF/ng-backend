package br.com.novamercado.contracts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.novamercado.contracts.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
