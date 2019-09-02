package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.http.ResponseEntity;

public interface Crud<T>{
    //get
    public T get(Object body);

    //post
    public T post(Object body);

    //put
    public T put(Object body);

    //delete
    public T delete(Object body);

}
