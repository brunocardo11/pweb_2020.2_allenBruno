package br.com.allen.agropopshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
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
	
	@GetMapping("/pedido")
	public ModelAndView cadastrarPedido(){
		ModelAndView mav = new ModelAndView("/");
		return mav;
	}
	
	public PedidoRepository getPedidoRepo() {
		return pedidoRepo;
	}

	public void setPedidoRepo(PedidoRepository pedidoRepo) {
		this.pedidoRepo = pedidoRepo;
	}

	public PedidoProdutoRepository getPedidoProdutoRepo() {
		return pedidoProdutoRepo;
	}

	public void setPedidoProdutoRepo(PedidoProdutoRepository pedidoProdutoRepo) {
		this.pedidoProdutoRepo = pedidoProdutoRepo;
	}

	public ClienteRepository getClienteRepo() {
		return clienteRepo;
	}

	public void setClienteRepo(ClienteRepository clienteRepo) {
		this.clienteRepo = clienteRepo;
	}

}
