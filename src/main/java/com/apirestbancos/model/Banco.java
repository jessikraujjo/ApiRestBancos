package com.apirestbancos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banco implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;

	@OneToMany(mappedBy = "banco", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Agencia> agencias = new ArrayList<Agencia>();
	
	public List<Agencia> getAgencias() {
		return agencias == null ? null: new ArrayList<Agencia>(this.agencias);
	}

	public void setAgencias(List<Agencia> agencias) {
		
		if (agencias == null) {
			this.agencias = null;
		} else {
			this.agencias = Collections.unmodifiableList(agencias);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
