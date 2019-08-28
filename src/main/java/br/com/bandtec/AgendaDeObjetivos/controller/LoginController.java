package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credenciais credenciais) {
		for (int i = 0; i <Usuario.usuariosCadastrados.size() ; i++) {
			Usuario usuario = Usuario.usuariosCadastrados.get(i);
			if(credenciais.getUsuario().equals(usuario.getLogin()) &&
				credenciais.getSenha().equals(usuario.getSenha())) {
				return ResponseEntity.ok("Success");
			}
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
	}
}
