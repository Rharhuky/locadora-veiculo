package com.locadora.dao;

public class Main {

	public static void main(String[] args) {
		
		VeiculoDAO dao = new VeiculoDAO("");
		dao.consultarTodosVeiculos();
		
		dao.deletarVeiculoByPelaPlaca("101010");
		dao.consultarTodosVeiculos();
		
		
	}
	
}
