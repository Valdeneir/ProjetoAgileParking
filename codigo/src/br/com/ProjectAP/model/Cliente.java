package br.com.ProjectAP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private String nome;
	private String dataNascimento;
	private int cpf;
	private int rg;
	private String veiculo;
	private String cor;
	private String email;
	private String login;
	private String senha;
	private String cSenha;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getcSenha() {
		return cSenha;
	}
	public void setcSenha(String cSenha) {
		this.cSenha = cSenha;
	}
	
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", cpf=" + cpf + ", rg=" + rg + ", veiculo=" + veiculo
				+ ", cor=" + cor + ", email=" + email + ", login=" + login
				+ ", senha=" + senha + ", cSenha=" + cSenha + "]";
	}
	
	
	
}
