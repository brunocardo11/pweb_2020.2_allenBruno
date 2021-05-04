package br.com.allen.agropopshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allen.agropopshop.models.Dependente;
import br.com.allen.agropopshop.repositories.DependenteRepository;

@Controller
public class DependenteController {
	
	@Autowired
	private DependenteRepository dependenteRepo;
	
	DependenteController(DependenteRepository dependenteRepo){
		this.dependenteRepo = dependenteRepo;
		
	}
	
	/*@GetMapping("/admin/infoCliente/1")
	public ModelAndView listarDependentes() {
		List<Dependente> lista = dependenteRepo.findAll();
		ModelAndView mav = new ModelAndView("admin/listarDependentes");
		mav.addObject("dependentes", lista);
	return mav;
	
}*/
	/*
	@GetMapping("/admin/infoCliente")
	public ModelAndView listarDependentes() {
		List<Dependente> lista = dependenteRepo.findAll();
		ModelAndView mav1 = new ModelAndView("admin/infoCliente");
		mav1.addObject("dependente", lista);
		return mav1;
	}*/

}
