package br.com.allen.agropopshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allen.agropopshop.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
