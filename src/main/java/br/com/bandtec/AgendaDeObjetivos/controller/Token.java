package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.ArrayList;
import java.util.List;

public class Token {
    private String valor;
    private Usuario usuario;

    public static List<Token> tokens = new ArrayList<>();

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}
