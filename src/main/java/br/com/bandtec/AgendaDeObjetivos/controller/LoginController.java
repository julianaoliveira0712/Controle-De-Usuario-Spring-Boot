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

		for (int i = 0; i < Usuario.usuariosCadastrados.size() ; i++) {
			Usuario usuario = Usuario.usuariosCadastrados.get(i);
			if(credenciais.getUsuario().equals(usuario.getLogin()) &&
					credenciais.getSenha().equals(usuario.getSenha())) {
				Token token = new Token();
				token.setValor(Math.random() * 1000000 + usuario.getLogin());
				token.setUsuario(usuario);
				Token.tokens.add(token);
				return ResponseEntity.ok("Success " + token.getValor());
			}
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
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
