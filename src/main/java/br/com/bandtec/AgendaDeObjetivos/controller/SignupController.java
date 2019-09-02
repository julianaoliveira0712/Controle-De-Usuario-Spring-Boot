package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController implements Crud<ResponseEntity<String>>{

    @PostMapping("/signup")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario novoUsuario){
        return post(novoUsuario);
    }


    @Override
    public ResponseEntity<String> get(Object body) {
        return null;
    }

    @Override
    public ResponseEntity<String> post(Object body) {
        Usuario novoUsuario = (Usuario) body;

        for (int i = 0; i < Usuario.usuariosCadastrados.size() ; i++) {
            Usuario usuario = Usuario.usuariosCadastrados.get(i);
            if (novoUsuario.getLogin().equals(usuario.getLogin())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário já existe");
            }
        }

        Usuario.usuariosCadastrados.add(novoUsuario);
        Token token = new Token();
        token.setValor(Math.random() * 1000000 + novoUsuario.getLogin());
        token.setUsuario(novoUsuario);
        Token.tokens.add(token);

        return ResponseEntity.ok("Usuário Cadastrado " + token.getValor());
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
