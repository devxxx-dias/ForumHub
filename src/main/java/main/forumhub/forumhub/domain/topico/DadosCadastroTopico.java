package main.forumhub.forumhub.domain.topico;

import jakarta.persistence.*;
import main.forumhub.forumhub.domain.curso.Curso;
import main.forumhub.forumhub.domain.resposta.Resposta;
import main.forumhub.forumhub.domain.usuario.Usuario;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastroTopico(
        String titulo,
        String mensagem,
        String nomeCurso
) {
}
