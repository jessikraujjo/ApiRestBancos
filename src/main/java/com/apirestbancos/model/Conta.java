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
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String num_conta;

	@JsonIgnore
	@JoinColumn(name="agencia_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Agencia agencia;

	@OneToMany(mappedBy = "conta", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<TipoConta> tipoconta = new ArrayList<TipoConta>();
	
	@JoinColumn(name="banco_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	private Double saldo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNum_conta() {
		return num_conta;
	}

	public void setNum_conta(String num_conta) {
		this.num_conta = num_conta;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	@JsonIgnore
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public List<TipoConta> getTipoconta() {
		return tipoconta;
	}

	public void setTipoconta(List<TipoConta> tipoconta) {
		this.tipoconta = tipoconta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	
	public void saca(double quantidade) {
		if (this.saldo < quantidade) {
			System.out.println("Saldo insuficiente");
		} else {
			this.saldo = this.saldo - quantidade;

			System.out.println("Saque realizado com sucesso!");
		}

	}

	public void deposita(double quantidade) {
		this.saldo += quantidade;
	}

	public void transfere(Conta destino, double valor) {
		if (this.saldo < valor) {
			System.out.println("Saldo insuficiente");
		}else {
			 
		     this.saldo = this.saldo - valor;
		     destino.saldo = destino.saldo + valor;
		     System.out.println("Tranferência realizada com sucesso!");
		}
	}
	
	public String recuperaDadosParaImpressao() {
        String dados = "Titular: " + cliente.getNome();
        dados += "\nNúmero: " + this.num_conta;
        // imprimir aqui os outros atributos...
        // também pode imprimir this.calculaRendimento()
        return dados;
    }

}
