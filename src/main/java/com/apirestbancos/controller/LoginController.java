package com.apirestbancos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/entrar")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String entrar() {
		return "entrar";
	}
	@RequestMapping(method = RequestMethod.GET, path = "/inicio")
	public String inicio() {
		return "inicio";
	}
}
