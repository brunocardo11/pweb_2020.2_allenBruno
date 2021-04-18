package br.com.allen.agropopshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allen.agropopshop.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
