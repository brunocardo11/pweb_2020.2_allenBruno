package br.com.allen.agropopshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allen.agropopshop.models.Produto;
import br.com.allen.agropopshop.repositories.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	ProdutoController (ProdutoRepository produtoRepo){
		this.produtoRepo = produtoRepo;
	}
	
	@GetMapping("/listarProdutos")
	public ModelAndView listarclientes() {
		List<Produto> lista = produtoRepo.findAll();
		ModelAndView ModelAndView = new ModelAndView("/admin/listarProdutos");
		ModelAndView.addObject("clientes", lista);
		return ModelAndView;
	}
	
	@GetMapping("/admin/adicionarProduto")
	public ModelAndView adicionarProduto() {
		ModelAndView mav = new ModelAndView("admin/adicionarProduto");
		mav.addObject(new Produto());
		return mav;
	}
	
	@PostMapping("/admin/adicionarProduto")
	public String adicionarProduto(Produto p) {
		this.produtoRepo.save(p);
		return "redirect:/";
	}
}
