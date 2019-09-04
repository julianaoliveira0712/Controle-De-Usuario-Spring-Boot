package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController implements Crud<ResponseEntity<String>>{

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("token") String token) {
        return delete(token);
    }



    @Override
    public ResponseEntity<String> get(Object body) {
        return null;
    }

    @Override
    public ResponseEntity<String> post(Object body) {
        return null;
    }

    @Override
    public ResponseEntity<String> put(Object body) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Object body) {
        String token = (String) body;
        for (int i = 0; i < Token.tokens.size() ; i++) {
            Token token1 = Token.tokens.get(i);
            if(token1.getValor().equals(token)){
                Token.tokens.remove(token1);
            }
        }

        return ResponseEntity.ok("Usuário deslogado");
    }
}
