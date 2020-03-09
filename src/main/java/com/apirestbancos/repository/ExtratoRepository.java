package com.apirestbancos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.apirestbancos.model.Conta;
import com.apirestbancos.model.Extrato;

public interface ExtratoRepository extends CrudRepository<Extrato, Long>{
	
	@Query("select u from Extrato u where u.contaorigem = ?1")
	Extrato findExtratoByConta(Conta contaorigem);
}
