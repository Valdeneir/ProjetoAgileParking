package br.com.ProjectAP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reserva {

	@Id
	@GeneratedValue
	private int id;
	private String cidade;
	private String tipoReserva;
	private String nomeUsu;
	private String email;
	private String placa;
	private String data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getTipoReserva() {
		return tipoReserva;
	}
	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
	}
	public String getNomeUsu() {
		return nomeUsu;
	}
	public void setNomeUsu(String nomeUsu) {
		this.nomeUsu = nomeUsu;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", cidade=" + cidade + ", tipoReserva=" + tipoReserva + ", nomeUsu=" + nomeUsu
				+ ", email=" + email + ", placa=" + placa + ", data=" + data + "]";
	}
	
	
	
}
