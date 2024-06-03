package main.forumhub.forumhub.controllers;

import jakarta.validation.Valid;
import main.forumhub.forumhub.domain.ValidacaoException;
import main.forumhub.forumhub.domain.curso.CursoRepository;
import main.forumhub.forumhub.domain.curso.DadosDetalhadamentoCurso;
import main.forumhub.forumhub.domain.topico.*;
import main.forumhub.forumhub.domain.usuario.Usuario;
import main.forumhub.forumhub.domain.usuario.UsuarioRepository;
import main.forumhub.forumhub.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestHeader("Authorization") String token, @RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var email = tokenService.getSubject(token.replace("Bearer ", ""));
        var autor = usuarioRepository.findByEmail(email);
        var curso = cursoRepository.localizarCurso(dados.nomeCurso());
        if (curso == null) {
            throw new ValidacaoException(" O Curso nao consta na nossa lista de cursos cadastrado ");
        }

        var topico = new Topico(null, dados.titulo(), dados.mensagem(), LocalDate.now(), EstadoDoTopico.AGUARDANDO,
                (Usuario) autor, curso, null);
        topicoRepository.save(topico);
        var uri = uriBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadamentoTopico(topico));


    }


}
