package br.com.ProjectAP.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Estacionamento {

	@Id
	@GeneratedValue
	private int id;
	private String cnpj;
	private String nomeEstacionamento;
	private String cidade;
	private String rua;
	private int numero;
	private String complemento;
	private String telefone;
	private double valorVaga;
	private float latitude;
	private float longitude;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public double getValorVaga() {
		return valorVaga;
	}
	public void setValorVaga(double valorVaga) {
		this.valorVaga = valorVaga;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	
	
}
