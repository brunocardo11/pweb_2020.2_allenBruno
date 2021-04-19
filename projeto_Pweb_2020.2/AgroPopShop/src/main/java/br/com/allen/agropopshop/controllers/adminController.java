package br.com.allen.agropopshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminController {
	
	@GetMapping("/admin")
	private String pageAdimin() {
		return "admin/admin";
	}
}
