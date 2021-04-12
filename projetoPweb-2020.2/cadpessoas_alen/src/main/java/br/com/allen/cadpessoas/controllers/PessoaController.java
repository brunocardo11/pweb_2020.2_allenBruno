package br.com.allen.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allen.cadpessoas.model.Pessoa;
import br.com.allen.cadpessoas.repositories.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepo;
	
	PessoaController(PessoaRepository pessoaRepo){
		this.pessoaRepo= pessoaRepo;
	}
	
	public String index() {
		return "index.html";
	}

	@GetMapping("/listarPessoas")
	public ModelAndView listarPessoas() {
		List<Pessoa> lista = pessoaRepo.findAll();
		ModelAndView ModelAndView = new ModelAndView("/listarPessoas");
		ModelAndView.addObject("pessoas", lista);
		return ModelAndView;
	}
	
	//Retorna Formulário
	@GetMapping("/adicionarPessoa")
	public ModelAndView formAdicionarPessoa() { 
		ModelAndView mav = new ModelAndView("adicionarPessoa");
		mav.addObject(new Pessoa());
		return mav;
	}
	
	//Adicionar pessoa
	@PostMapping("/adicionarPessoa")
	public String adicionarPessoa(Pessoa p) {
		this.pessoaRepo.save(p);
		return "redirect:/listarPessoas";
	}
	
	
	//Editar pessoa
	@GetMapping("/editar/{id}")
	public ModelAndView editarPessoa(@PathVariable("id") long id){
		Pessoa pessoa = pessoaRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		
		ModelAndView ModelAndView = new ModelAndView("editarPessoa");
		ModelAndView.addObject(pessoa);
		return ModelAndView;
	}
	
	@PostMapping("/editar/{id}")
	public ModelAndView editarPessoa(@PathVariable("id")long id, Pessoa pessoa) {
		this.pessoaRepo.save(pessoa);
		return new ModelAndView( "redirect:/listarPessoas");
	}
	
	//Remover pessoa
	@GetMapping("/remover/{id}")
	public ModelAndView removerPessoa(@PathVariable("id") long id){
		Pessoa aRemover = pessoaRepo.findById(id)
		.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		
		pessoaRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarPessoas");
	}
}
