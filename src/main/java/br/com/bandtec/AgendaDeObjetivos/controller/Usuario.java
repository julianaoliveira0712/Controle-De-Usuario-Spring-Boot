package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nome;
	private String senha;
	private String login;

	public static List<Usuario> usuariosCadastrados = new ArrayList<>();

	public Usuario(String nome, String senha, String login) {
		this.nome = nome;
		this.senha = senha;
		this.login = login;
	}

	public Usuario() {

	}
		
	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getNome() {  return nome;  }
}
