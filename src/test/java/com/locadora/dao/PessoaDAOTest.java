package com.locadora.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
	
	
}
