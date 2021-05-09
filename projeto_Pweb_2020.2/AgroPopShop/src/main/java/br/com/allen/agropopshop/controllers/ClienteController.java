package br.com.allen.agropopshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allen.agropopshop.models.Cliente;
import br.com.allen.agropopshop.models.Dependente;
import br.com.allen.agropopshop.repositories.ClienteRepository;
import br.com.allen.agropopshop.repositories.DependenteRepository;

@Controller
@RequestMapping("/")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private DependenteRepository dependenteRepo;
	
	ClienteController(ClienteRepository clienteRepo){
		this.clienteRepo = clienteRepo;
		
	}
	
	public String index() {
		return "index.html";
	}
	
	//Retorna a lista de clientes
	@GetMapping("/listarClientes")
	public ModelAndView listarclientes() {
		List<Cliente> lista = clienteRepo.findAll();
		ModelAndView ModelAndView = new ModelAndView("/admin/listarClientes");
		ModelAndView.addObject("clientes", lista);
		return ModelAndView;
	}
	
	//Retorna o formulário de cadastro de clientes
	@GetMapping("/adicionarCliente")
	public ModelAndView formAdicionarCliente() {
		ModelAndView mav = new ModelAndView("user/adicionarCliente");
		mav.addObject(new Cliente());
		return mav;
	}
	
	//Adiciona pessoa
	@PostMapping("/adicionarCliente")
	public String adicionarCliente(Cliente c) {
		this.clienteRepo.save(c);
		return "redirect:/listarClientes";
	}
	
	
	//Remover cliente
	@GetMapping("/remover/{id}")
	public ModelAndView removerCliente(@PathVariable("id") long id){
		Cliente aRemover = clienteRepo.findById(id)
		.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		
		clienteRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarClientes");
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editarCliente (@PathVariable("id") long id) {
		Cliente cliente = clienteRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		
		ModelAndView ModelAndView = new ModelAndView("admin/editarCliente");
		ModelAndView.addObject(cliente);
		return ModelAndView;
	}
	
	@PostMapping("/editar/{id}")
	public ModelAndView editarPessoa(@PathVariable("id")long id, Cliente cliente) {
		this.clienteRepo.save(cliente);
		return new ModelAndView( "redirect:/admin/infoCliente/{id}");
	}
	
	@GetMapping("/admin/infoCliente/{id}")
		public ModelAndView infoCLiente(@PathVariable("id") long id) {
		List<Dependente> lista1 = dependenteRepo.findByIdPrincipal(id);
		Cliente cliente = clienteRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		ModelAndView mav = new ModelAndView("admin/infoCliente");
		mav.addObject("dependentes", lista1);
		mav.addObject(cliente);
		return mav;
	}

	public DependenteRepository getDependenteRepo() {
		return dependenteRepo;
	}

	public void setDependenteRepo(DependenteRepository dependenteRepo) {
		this.dependenteRepo = dependenteRepo;
	}
	
	@GetMapping("/adicionarDependente/{id}")
	public ModelAndView cadastrarDependente (@PathVariable("id") long id) {
		Cliente cliente = clienteRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		ModelAndView mav = new ModelAndView("admin/adicionarDependente");
		mav.addObject(new Dependente());
		mav.addObject(cliente);
		return mav;
	}

}
