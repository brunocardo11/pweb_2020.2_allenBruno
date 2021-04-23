package br.com.allen.agropopshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allen.agropopshop.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
