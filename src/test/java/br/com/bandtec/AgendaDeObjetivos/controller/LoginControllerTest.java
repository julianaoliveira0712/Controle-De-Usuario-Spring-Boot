package br.com.bandtec.AgendaDeObjetivos.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginControllerTest {
	
	LoginController controller;		
	
	@Before
	public void setUp() {
		controller = new LoginController();		
	}
	
	@Test
	public void loginComSucesso() {		
		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("teste", "teste"));		
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals("Sucesso", resposta.getBody());
	}
	
	@Test
	public void loginComFalha() {
		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("login", "senha"));
		assertEquals(HttpStatus.UNAUTHORIZED, resposta.getStatusCode());
		assertEquals("Erro", resposta.getBody());
	}
	
}
