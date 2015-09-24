package br.com.ProjectAP.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Estacionamento {

	@Id
	@GeneratedValue
	private String cnpj;
	private String nomeEstacionamento;
	private String cidade;
	private String rua;
	private int numero;
	private String complemento;
	private String telefone;
	private double valorDaVaga;
	
	
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeEstacionamento() {
		return nomeEstacionamento;
	}
	public void setNomeEstacionamento(String nomeEstacionamento) {
		this.nomeEstacionamento = nomeEstacionamento;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public double getValorDaVaga() {
		return valorDaVaga;
	}
	public void setValorDaVaga(double valorDaVaga) {
		this.valorDaVaga = valorDaVaga;
	}
	
	
}
