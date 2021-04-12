package br.com.allen.cadpessoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allen.cadpessoas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
