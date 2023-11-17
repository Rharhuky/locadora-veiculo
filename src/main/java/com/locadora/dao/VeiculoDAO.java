package com.locadora.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.locadora.Veiculo;

public class VeiculoDAO extends DAO{

	public VeiculoDAO(String u) {
		super("veiculo");
	}

	protected void salvarVeiculo(Veiculo veiculo) {

		PreparedStatement preparedStatement;

		try {
			String insertSQL = "insert into veiculos (nome, modelo, numero_portas, tipo_veiculo, placa) values (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString (1, veiculo.getNome());
			preparedStatement.setString (2, veiculo.getModelo());
			preparedStatement.setInt	(3, veiculo.getNumeroPortas());
			preparedStatement.setObject(4, veiculo.getTipoVeiculo(), java.sql.Types.OTHER);
			preparedStatement.setString (5, veiculo.getPlaca());

			super.salvar(preparedStatement);

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}


}
