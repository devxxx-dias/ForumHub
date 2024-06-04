package main.forumhub.forumhub.domain.topico;

import main.forumhub.forumhub.domain.curso.Curso;
import main.forumhub.forumhub.domain.resposta.Resposta;
import main.forumhub.forumhub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosListarTopicos(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime now,
        EstadoDoTopico estadoDoTopico
) {
    public DadosListarTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getEstadoDoTopico());
    }
}
