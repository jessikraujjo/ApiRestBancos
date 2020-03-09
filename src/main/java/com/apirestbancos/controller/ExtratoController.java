package com.apirestbancos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestbancos.model.Conta;
import com.apirestbancos.model.Extrato;
import com.apirestbancos.repository.ContaRepository;
import com.apirestbancos.repository.ExtratoRepository;

@RestController
@RequestMapping(value = "/extrato")
public class ExtratoController {

	@Autowired
	private ExtratoRepository extratorepository;
	@Autowired
	private ContaRepository contarepository;

	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Extrato>> extrato() throws InterruptedException {
		List<Extrato> list = (List<Extrato>) extratorepository.findAll();

		return new ResponseEntity<List<Extrato>>(list, HttpStatus.OK);

	}

	@GetMapping(value = "/{num_conta}", produces = "application/json")
	public ResponseEntity<List<Extrato>> init(@PathVariable(value = "num_conta") String num_conta) {

		Conta conta = contarepository.findUserByConta(num_conta);
		// Extrato extrato = extratorepository.findExtratoByConta(conta);
		List<Extrato> list = (List<Extrato>) extratorepository.findAll();
		List<Extrato> listConta = new ArrayList<Extrato>();

		int i = 0;
		for (Extrato contas : list) {

			if (contas.getContaorigem() == null) {
				listConta.remove(contas);
				
			}else {
				if (contas.getContaorigem().getNum_conta().equals(conta.getNum_conta())) {
					listConta.add(contas);
				}
			}
		}

		return new ResponseEntity<List<Extrato>>(listConta, HttpStatus.OK);

	}

}
