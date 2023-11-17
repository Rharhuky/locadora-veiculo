package com.locadora;

import java.util.Objects;

import com.locadora.enums.Tipo;


public class Veiculo {

	private String nome;
	private String modelo;
	private int numeroPortas;
	private Tipo tipoVeiculo;
	private String placa;
	
	public Veiculo() {}
	
	public Veiculo(String nome, String modelo, int numeroPortas, Tipo tipoVeiculo, String placa) {
		super();
		this.nome = nome;
		this.modelo = modelo;
		this.numeroPortas = numeroPortas;
		this.tipoVeiculo = tipoVeiculo;
		this.placa = placa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getNumeroPortas() {
		return numeroPortas;
	}
	public void setNumeroPortas(int numeroPortas) {
		this.numeroPortas = numeroPortas;
	}
	public Tipo getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(Tipo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Veiculo [nome=" + nome + ", modelo=" + modelo + ", numeroPortas=" + numeroPortas + ", tipoVeiculo="
				+ tipoVeiculo + ", placa=" + placa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(modelo, nome, numeroPortas, placa, tipoVeiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(modelo, other.modelo) && Objects.equals(nome, other.nome)
				&& numeroPortas == other.numeroPortas && Objects.equals(placa, other.placa)
				&& tipoVeiculo == other.tipoVeiculo;
	}

	
	
	
	
}
