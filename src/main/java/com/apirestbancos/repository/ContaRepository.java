package com.apirestbancos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apirestbancos.model.Banco;
import com.apirestbancos.model.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Long>{
	@Query("select u from Conta u where u.num_conta = ?1")
	Conta findUserByConta(String conta);
	
	@Query("select u from Conta u where u.saldo = ?1")
	Conta findSaldo(Double saldo);
}
