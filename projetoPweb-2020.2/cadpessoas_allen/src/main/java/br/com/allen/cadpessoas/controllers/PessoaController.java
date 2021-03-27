package br.com.allen.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allen.cadpessoas.model.Pessoa;
import br.com.allen.cadpessoas.repositories.PessoaRepository;

@Controller
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepo;

	@GetMapping("/listarPessoas.html")
	public ModelAndView listarPessoas() {
		List<Pessoa> lista = pessoaRepo.findAll();
		ModelAndView mav = new ModelAndView("/listarPessoas");
		mav.addObject("pessoas", lista);
		return mav;
	}
}
