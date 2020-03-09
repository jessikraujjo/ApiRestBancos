package com.apirestbancos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestbancos.model.TipoConta;
import com.apirestbancos.repository.TipoContaRepository;


@RestController 
@RequestMapping(value = "/tipoconta")
public class TipoContaController {
	
	@Autowired 
	private TipoContaRepository tipocontarepository;
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity <List<TipoConta>>tipoconta() throws InterruptedException {
		List<TipoConta> list = (List<TipoConta>) tipocontarepository.findAll();
		
		return new ResponseEntity<List<TipoConta>>(list, HttpStatus.OK);

	}
	
	@PostMapping(value = "/cadastrar", produces = "application/json")
	public ResponseEntity<TipoConta>cadastrar(@RequestBody TipoConta tipoconta){
		TipoConta tipocontaSalva = tipocontarepository.save(tipoconta);
		return new ResponseEntity<TipoConta>(tipocontaSalva, HttpStatus.OK);
	}	
	
	
}

