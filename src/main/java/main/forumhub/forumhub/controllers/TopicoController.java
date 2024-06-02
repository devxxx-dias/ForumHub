package main.forumhub.forumhub.controllers;

import jakarta.validation.Valid;
import main.forumhub.forumhub.domain.topico.DadosCadastroTopico;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dados){
        return ResponseEntity.ok().build();
    }

}
