package com.apirestbancos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.apirestbancos.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	@Query("select u from Cliente u where u.nome = ?1")
	Cliente findUserByNome(String nome);
}
