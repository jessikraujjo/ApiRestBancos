package com.apirestbancos.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Extrato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String data;
	private String transacao;
	private Double valor;
	
	private Conta contaorigem;
	private Conta contadestino;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTransacao() {
		return transacao;
	}
	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
		
	public Conta getContaorigem() {
		return contaorigem;
	}
	public void setContaorigem(Conta contaorigem) {
		this.contaorigem = contaorigem;
	}
	public Conta getContadestino() {
		return contadestino;
	}
	public void setContadestino(Conta contadestino) {
		this.contadestino = contadestino;
	}
	
	public String dataModificada() {
		Calendar cal = Calendar.getInstance();
		DateFormat data = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dataMod = data.format(cal.getTime());
		return dataMod;
	}

}
