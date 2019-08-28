package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @PostMapping("/signup")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario novoUsuario){

        for (int i = 0; i < Usuario.usuariosCadastrados.size() ; i++) {
            Usuario usuario = Usuario.usuariosCadastrados.get(i);
            if (novoUsuario.getLogin().equals(usuario.getLogin())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário já existe");
            }
        }

        Usuario.usuariosCadastrados.add(novoUsuario);
        return ResponseEntity.ok("Usuário Cadastrado " + Usuario.usuariosCadastrados.size());
    }

}
