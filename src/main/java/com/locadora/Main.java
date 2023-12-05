package com.locadora;

import java.sql.SQLException;

import com.locadora.dao.PessoaDAO;
import com.locadora.dao.VeiculoDAO;

public class Main {

	public static void main(String[] args) {
		
//		VeiculoDAO dao = new VeiculoDAO("");
//		dao.consultarTodosVeiculos();
//		
//		dao.deletarVeiculoByPelaPlaca("101010");
//		dao.consultarTodosVeiculos();
		PessoaDAO e = new PessoaDAO("");
		
		try {
			e.verPessoaPeloId(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}
