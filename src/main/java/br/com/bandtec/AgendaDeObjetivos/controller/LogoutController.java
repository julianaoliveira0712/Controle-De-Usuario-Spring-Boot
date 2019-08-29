package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("token") String token){

        for (int i = 0; i < Token.tokens.size() ; i++) {
            Token token1 = Token.tokens.get(i);
            if(token1.getValor().equals(token)){
                Token.tokens.remove(token1);
            }
        }

        return ResponseEntity.ok("Usuário deslogado");

    }
}
