package com.apirestbancos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agencia implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String num_agencia;
	
	public Agencia() {
		
	}
	public Agencia(String num_agencia, Banco banco, Cliente cliente, List<Conta> contas) {
		super();
		this.num_agencia = num_agencia;
		this.banco = banco;
		this.contas = contas;
	}

	@JoinColumn(name="banco_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Banco banco; 
	
	@OneToMany(mappedBy = "agencia", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Conta> contas = new ArrayList<Conta>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNum_agencia() {
		return num_agencia;
	}

	public void setNum_agencia(String num_agencia) {
		this.num_agencia = num_agencia;
	}
	@JsonIgnore
	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	@JsonIgnore
	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	@Override
	public String toString() {
		return "Agencia [id=" + id + ", num_agencia=" + num_agencia + ", banco=" + banco 
				+ ", contas=" + contas + "]";
	}

}
