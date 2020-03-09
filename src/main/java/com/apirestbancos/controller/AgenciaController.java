package com.apirestbancos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestbancos.model.Agencia;
import com.apirestbancos.model.Banco;
import com.apirestbancos.repository.AgenciaRepository;
import com.apirestbancos.repository.BancoRepository;


import org.json.JSONObject;



@RestController 
@RequestMapping(value = "/agencia")
public class AgenciaController {
	
	@Autowired 
	private AgenciaRepository agenciarepository;
	
	private BancoRepository bancorepository;
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity <List<Agencia>>agencia() throws InterruptedException {
		List<Agencia> list = (List<Agencia>) agenciarepository.findAll();
		
		return new ResponseEntity<List<Agencia>>(list, HttpStatus.OK);

	}
	
	@PostMapping(value = "/cadastrar", produces = "application/json")
	public ResponseEntity<Agencia>cadastrar(@Valid @RequestBody String jsonAgencia, Agencia agencia){
		Banco banco = new Banco();
		JSONObject obj = new JSONObject(jsonAgencia);
		
		banco.setId(Long.parseLong(obj.getString("banco_id")));
		agencia.setBanco(banco);
		agencia.setNum_agencia(obj.getString("num_agencia"));
		
		Agencia agenciaSalva = agenciarepository.save(agencia);
		
		return new ResponseEntity<Agencia>(agenciaSalva, HttpStatus.OK);

	}
	
	
}

