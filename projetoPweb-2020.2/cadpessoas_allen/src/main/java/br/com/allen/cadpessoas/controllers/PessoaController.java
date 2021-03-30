package br.com.allen.cadpessoas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.allen.cadpessoas.model.Pessoa;
import br.com.allen.cadpessoas.repositories.PessoaRepository;

@Controller
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepo;

	@GetMapping("/listarPessoas")
	public ModelAndView listarPessoas() {
		Iterable<Pessoa> lista = pessoaRepo.findAll();
		ModelAndView mav = new ModelAndView("/listarPessoas");
		mav.addObject("pessoas", lista);
		return mav;
	}
	
	@RequestMapping(value="/adicionarPessoa", method=RequestMethod.GET)
	public String cad() {
		return"/adicionarPessoa.html";
	}
	
	@RequestMapping(value="/adicionarPessoa", method=RequestMethod.POST)
	public String cad(Pessoa pessoa) {
		pessoaRepo.save(pessoa);
		return"/adicionarPessoa.html";
	}
	
}
