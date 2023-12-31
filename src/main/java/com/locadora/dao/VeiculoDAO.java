package com.locadora.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.locadora.enums.Tipo;
import com.locadora.model.Veiculo;

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

	public Veiculo consultarVeiculoPlaca(String placa) {
		String queryPlaca = "select * from veiculos where placa = ?";
		Veiculo veiculo = null;

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(queryPlaca);
			preparedStatement.setString(1,  placa);
			ResultSet resultado = preparedStatement.executeQuery();
			veiculo = mapToVeiculo(resultado);

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return veiculo;

	}

	public Veiculo consultarVeiculoId(Integer veiculoId) {

		String queryPlaca = "SELECT * FROM veiculos WHERE veiculo_id = ?";
		Veiculo veiculo = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryPlaca);
			preparedStatement.setInt(1, veiculoId);
			ResultSet resultSet = preparedStatement.executeQuery();
			veiculo = mapToVeiculo(resultSet);
		}
		catch(SQLException e) {

		}
		return veiculo;

	}

	public void consultarTodosVeiculos(){
		List<Veiculo> veiculos = new ArrayList<>(); // pq com set dá errado
		//		Set<Veiculo> veiculos = new TreeSet<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM veiculos");
			ResultSet resultSet = preparedStatement.executeQuery();
			//			resultSet.getBlob("nome");
			while(resultSet.next()) {

				Veiculo v = new Veiculo();

				v.setModelo(resultSet.getString("modelo"));
				v.setNome			(resultSet.getString("nome"));
				v.setNumeroPortas	(resultSet.getInt("numero_portas"));
				v.setPlaca			(resultSet.getString("placa"));
				v.setTipoVeiculo(Tipo.valueOf(resultSet.getString("tipo_veiculo")));

				veiculos.add(v);
			}
			veiculos.forEach(System.out::println);
		} 

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualizarVeiculoPelaPlaca(String placa, Veiculo veiculo) {

		Veiculo veiculoParaAtualizar = this.consultarVeiculoPlaca(placa);
		atualizarCamposVeiculo(veiculoParaAtualizar, veiculo);
		
		String updateQuery = "UPDATE veiculos SET modelo = ? WHERE placa = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, veiculoParaAtualizar.getModelo());
			preparedStatement.setString(2, placa);
			preparedStatement.execute();
			connection.commit();
			System.out.println("Update with Sucess");
			
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}


	}
	
	public void deletarVeiculoByPelaPlaca(String placa) {
		
		Veiculo veiculo = consultarVeiculoPlaca(placa);
		PreparedStatement preparedStatement;
		try {
			String deleteQuery = "DELETE FROM veiculos WHERE placa = ?";
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setString(1, placa);
			preparedStatement.executeUpdate(); // ?
			connection.commit();
			
		}
		catch(SQLException exception) {
			exception.printStackTrace();
		}
		
		
	}





	private Veiculo mapToVeiculo(ResultSet resultSet) throws SQLException {
		Veiculo v = null;
		if(resultSet.next()) {
			v = new Veiculo();
			v.setModelo(resultSet.getString("modelo"));
			v.setNome			(resultSet.getString("nome"));
			v.setNumeroPortas	(resultSet.getInt("numero_portas"));
			v.setPlaca			(resultSet.getString("placa"));
			v.setTipoVeiculo(Tipo.valueOf(resultSet.getString("tipo_veiculo")));
		}
		return v;
	}
	
	/**
	 * Ainda requer implementacao
	 * @param veiculoParaAtualizar
	 * @param veiculoNovosDados
	 */
	private void atualizarCamposVeiculo(Veiculo veiculoParaAtualizar, Veiculo veiculoNovosDados) {
		
		if( ! Objects.isNull(veiculoNovosDados) ) {
			
			veiculoParaAtualizar.setModelo(veiculoNovosDados.getModelo());
			
		}
		
		
	}


}
