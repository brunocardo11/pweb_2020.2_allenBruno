package br.com.allen.agropopshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.allen.agropopshop.repositories.ClienteRepository;
import br.com.allen.agropopshop.repositories.PedidoProdutoRepository;
import br.com.allen.agropopshop.repositories.PedidoRepository;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepo;
	
	@Autowired
	private PedidoProdutoRepository pedidoProdutoRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	
}
