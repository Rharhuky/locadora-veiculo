package com.locadora.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.locadora.model.Pessoa;

public class PessoaDAO extends DAO{

	public PessoaDAO(String u) {
		super("");
	}

	
	public void inserirPessoa(Pessoa pessoa) throws SQLException {
		
		String insertQuery = "INSERT INTO pessoas(nome, cpf) VALUES(?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1,  pessoa.getNome());
		preparedStatement.setString(2, pessoa.getCpf());
		preparedStatement.execute();
		connection.commit();
		
	}
	
	
}
