package br.com.allen.agropopshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/admin/listarProdutos")
	public ModelAndView listarProdutos() {
		List<Produto> lista = produtoRepo.findAll();
		ModelAndView ModelAndView = new ModelAndView("/admin/listarProdutos");
		ModelAndView.addObject("produtos", lista);
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
		return "redirect:/admin/listarProdutos";
	}
	
	@GetMapping("/removerProduto/{id}")
	public ModelAndView removerCliente(@PathVariable("id") long id){
		Produto aRemover = produtoRepo.findById(id)
		.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		
		produtoRepo.delete(aRemover);
		return new ModelAndView("redirect:/admin/listarProdutos");
	}
	
	@GetMapping("/editarProduto/{id}")
	public ModelAndView editarProduto (@PathVariable("id") long id) {
		Produto produto = produtoRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		
		ModelAndView ModelAndView = new ModelAndView("admin/editarProduto");
		ModelAndView.addObject(produto);
		return ModelAndView;
	}
	
	@PostMapping("/editarProduto/{id}")
	public ModelAndView editarProduto(@PathVariable("id")long id, Produto produto) {
		this.produtoRepo.save(produto);
		return new ModelAndView( "redirect:/admin/listarProdutos");
	}
}
