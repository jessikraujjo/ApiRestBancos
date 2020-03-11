package com.apirestbancos.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestbancos.model.Agencia;
import com.apirestbancos.model.Cliente;
import com.apirestbancos.model.Conta;
import com.apirestbancos.model.Extrato;
import com.apirestbancos.model.TipoConta;
import com.apirestbancos.repository.ClienteRepository;
import com.apirestbancos.repository.ContaRepository;
import com.google.gson.Gson;

@RestController 
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired 
	private ClienteRepository clienterepository;
	@Autowired 
	private ContaRepository contarepository;
	
	@GetMapping(value = "/", produces = "application/json")
	@CachePut("cacheclientes")
	public ResponseEntity <List<Cliente>>cliente() throws InterruptedException {
		
		List<Cliente> list = (List<Cliente>) clienterepository.findAll();
		return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cadastrar", produces = "application/json")
	public ResponseEntity<Cliente>cadastrar(@RequestBody String jsonConta){
		
		JSONObject obj = new JSONObject(jsonConta);
		Agencia agencia = new Agencia();
		agencia.setId(Long.parseLong(obj.getString("agencia_id")));
		Gson convert = new Gson();
		Cliente cliente = convert.fromJson(jsonConta, Cliente.class);
		System.out.println("cliente "+ cliente.getCpf());
		
		for(int pos = 0 ; pos < cliente.getTelefones().size(); pos++) {
			cliente.getTelefones().get(pos).setCliente(cliente);
		}
		for(int pos = 0 ; pos < cliente.getContas().size(); pos++) {
			cliente.getContas().get(pos).setCliente(cliente);
			cliente.getContas().get(pos).setAgencia(agencia);
			cliente.getContas().get(pos).setSaldo(0.0);
		}
		cliente.setAgencia(agencia);
		Cliente clienteSalvo = clienterepository.save(cliente);
		
		return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.OK);
	}	
	
	
}

