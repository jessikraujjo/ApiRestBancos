package com.apirestbancos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apirestbancos.model.Banco;


@Repository
public interface BancoRepository extends CrudRepository<Banco, Long>{

}
