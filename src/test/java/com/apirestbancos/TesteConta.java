package com.apirestbancos;

import com.apirestbancos.model.Cliente;
import com.apirestbancos.model.Conta;

public class TesteConta {

	public static void main(String[] args) {
		/*Conta conta = new Conta();
		conta.setSaldo(Double.parseDouble("1000"));
		
		conta.saca(200);
		
		conta.deposita(500);
		
		conta.saca(2000);*/
		
		Conta c1 = new Conta();
		Cliente cliente = new Cliente();
		cliente.setNome("jeeh");
		c1.setCliente(cliente );
		c1.setNum_conta("26299-6");
        System.out.println(c1.recuperaDadosParaImpressao());

        /*Conta c2 = c1;  // linha importante!
        c2.deposita(200);*/

        //System.out.println("conta 1 :" +c1.getSaldo());
        // System.out.println("conta 2 :" +c2.getSaldo());
		//ystem.out.println(conta.getSaldo());
	}

}
