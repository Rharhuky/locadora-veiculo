package com.locadora.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.locadora.model.Pessoa;

class PessoaDAOTest {

	static PessoaDAO pessoaDAO;
	static Pessoa pessoa;
	
	@BeforeAll
	static void setUp() {
		pessoaDAO = new PessoaDAO("");
		pessoa = new Pessoa("Damny", "144257");
		
	}
	
	
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	void inserirPessoa() {
		
		assertDoesNotThrow(() -> {
			pessoaDAO.inserirPessoa(pessoa);
			
		}, "Deveria salvar o objeto pessoa");
		
	}
	
	@Test
	void verPessoaPeloId() throws SQLException {
		
		assertEquals(pessoaDAO.verPessoaPeloId(1).getCpf(), "3352", "Deveriam ser iguais ....");
	}
	
	
}
