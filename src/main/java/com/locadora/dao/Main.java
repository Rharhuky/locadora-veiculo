package com.locadora.dao;

import com.locadora.Veiculo;
import com.locadora.enums.Tipo;

public class Main {

	public static void main(String[] args) {
		
//		Veiculo v = new Veiculo();
//		v.setModelo("Jeta");
//		v.setNome("Jeta");
//		v.setPlaca("101010");
//		v.setTipoVeiculo(Tipo.HATCH);
//		
		VeiculoDAO dao = new VeiculoDAO("");
//		dao.salvarVeiculo(v);
		Veiculo e =dao.consultarVeiculoPlaca("101010");
		Veiculo a = dao.consultarVeiculoId(5);
		System.out.println(e + " ###\n" + a);
		dao.consultarTodosVeiculos();
		
	}
	
}
