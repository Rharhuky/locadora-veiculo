package com.locadora.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.locadora.Veiculo;
import com.locadora.enums.Tipo;

public class VeiculoDAO extends DAO{

	public VeiculoDAO(String u) {
		super("veiculo");
	}

	public void salvarVeiculo(Veiculo veiculo) {

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
	
	public void consultarVeiculoPlaca(String placa) {
		String queryPlaca = "select * from veiculos where placa = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryPlaca);
			preparedStatement.setString(1,  placa);
			ResultSet resultado = preparedStatement.executeQuery();
			System.out.println(mapToVeiculo(resultado));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void consultarVeiculoId() {
		
	}
	
	private Veiculo mapToVeiculo(ResultSet resultSet) throws SQLException {
		Veiculo v = new Veiculo();
		if(resultSet.next()) {
		
		v.setModelo(resultSet.getString("modelo"));
		v.setNome			(resultSet.getString("nome"));
		v.setNumeroPortas	(resultSet.getInt("numero_portas"));
		v.setPlaca			(resultSet.getString("placa"));
		v.setTipoVeiculo(Tipo.valueOf(resultSet.getString("tipo_veiculo")));
		}
		return v;
	}


}
