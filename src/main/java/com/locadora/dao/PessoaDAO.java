package com.locadora.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public Pessoa verPessoaPeloId(Integer pessoa_id) throws SQLException {
		
		String readQuery = "SELECT * FROM pessoas WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(readQuery);
		preparedStatement.setInt(1, pessoa_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		return mapearParaPessoa(resultSet);
	}
	
	private Pessoa mapearParaPessoa(ResultSet resultSet) throws SQLException {
		Pessoa pessoa = null;
		while(resultSet.next()) {
			pessoa = new Pessoa(
					resultSet.getInt("id"), 
					resultSet.getString("nome"), 
					resultSet.getString("cpf")
					);
		}
		return pessoa;
		
	}
	
}
