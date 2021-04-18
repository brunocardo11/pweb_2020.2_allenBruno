package br.com.allen.agropopshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allen.agropopshop.models.Cliente;
import br.com.allen.agropopshop.repositories.ClienteRepository;

@Controller
@RequestMapping("/")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepo;
	
	ClienteController(ClienteRepository clienteRepo){
		this.clienteRepo = clienteRepo;
		
	}
	
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/listarClientes")
	public ModelAndView listarclientes() {
		List<Cliente> lista = clienteRepo.findAll();
		ModelAndView ModelAndView = new ModelAndView("/listarClientes");
		ModelAndView.addObject("clientes", lista);
		return ModelAndView;
	}
	
	
	@GetMapping("/adicionarCliente")
	public ModelAndView formAdicionarPessoa() { 
		ModelAndView mav = new ModelAndView("adicionarCliente");
		mav.addObject(new Cliente());
		return mav;
	}

}
