package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements Crud<ResponseEntity<String>> {

	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credenciais credenciais) {
		return post(credenciais);
	}

	@Override
	public ResponseEntity<String> get(Object body) {
		return null;
	}

	@Override
	public ResponseEntity<String> post(Object body) {
		Credenciais credenciais = (Credenciais)body;

		if(!Database.database.validarLogin(credenciais)){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
		}

		Usuario usuario = Database.database.selectUsuario(credenciais);

		Token token = new Token();
		token.setValor(Math.random() * 1000000 + usuario.getLogin());
		token.setUsuario(usuario);
		Token.tokens.add(token);
		return ResponseEntity.ok("Success " + token.getValor());
	}

	@Override
	public ResponseEntity<String> put(Object body) {
		return null;
	}

	@Override
	public ResponseEntity<String> delete(Object body) {
		return null;
	}
}
