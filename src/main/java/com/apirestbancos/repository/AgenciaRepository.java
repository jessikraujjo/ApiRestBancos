package com.apirestbancos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apirestbancos.model.Agencia;


@Repository
public interface AgenciaRepository extends CrudRepository<Agencia, Long>{

}
