package br.com.ProjectAP.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Estacionamento {

	@Id
	@GeneratedValue
	private String cnpj;
	private String nomeEstacionamento;
	private String local;
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
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
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
