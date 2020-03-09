package com.apirestbancos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestbancos.model.Banco;
import com.apirestbancos.repository.BancoRepository;


@RestController 
@RequestMapping(value = "/banco")
public class BancoController {
	
	@Autowired 
	private BancoRepository bancorepository;
	
	
	@GetMapping(value = "/", produces = "application/json")
	@CachePut("cachebancos")
	public ResponseEntity <List<Banco>>cliente() throws InterruptedException {
		List<Banco> list = (List<Banco>) bancorepository.findAll();
		
		return new ResponseEntity<List<Banco>>(list, HttpStatus.OK);

	}
	
		
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Banco>cadastrar(@RequestBody Banco banco){
		for(int pos = 0 ; pos < banco.getAgencias().size(); pos++) {
			banco.getAgencias().get(pos).setBanco(banco);
		}
		Banco bancoSalvo = bancorepository.save(banco);
		return new ResponseEntity<Banco>(bancoSalvo, HttpStatus.OK);
	}
	
}

