package com.locadora.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.locadora.model.Veiculo;
class VeiculoDAOTest {

	static VeiculoDAO veiculoDAO;
	
	@BeforeAll
	static void setUp() {
		
		veiculoDAO = new VeiculoDAO("");
		
	}
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	void consultarVeiculoPlacaTest() {
		
		Integer idTest = 1;
		Veiculo v = veiculoDAO.consultarVeiculoPlaca("101010");
		Assertions.assertNotEquals(v.getVeiculo_id(), 1, "O id deveria ser nulo" );
		
	}
	
}
