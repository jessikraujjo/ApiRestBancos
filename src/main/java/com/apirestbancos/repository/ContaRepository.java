package com.apirestbancos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apirestbancos.model.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Long>{

}
