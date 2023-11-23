package com.locadora.model;

import java.util.Objects;

public class Pessoa {

	private Integer pessoa_id;
	private String nome;
	private String cpf;
	
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	public Integer getPessoa_id() {
		return pessoa_id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, nome, pessoa_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(nome, other.nome)
				&& Objects.equals(pessoa_id, other.pessoa_id);
	}

	@Override
	public String toString() {
		return "Pessoa [pessoa_id=" + pessoa_id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
	 
	
	
}
