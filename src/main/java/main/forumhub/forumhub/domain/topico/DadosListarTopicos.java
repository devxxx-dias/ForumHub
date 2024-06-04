package main.forumhub.forumhub.domain.topico;

import main.forumhub.forumhub.domain.curso.Curso;
import main.forumhub.forumhub.domain.resposta.DadosAtualizacaoResposta;
import main.forumhub.forumhub.domain.resposta.DadosListarRespostas;
import main.forumhub.forumhub.domain.resposta.Resposta;
import main.forumhub.forumhub.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record DadosListarTopicos(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime now,
        EstadoDoTopico estadoDoTopico,
       List<DadosListarRespostas> respostas
) {
    public DadosListarTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getEstadoDoTopico(),topico.getResposta().stream().map(DadosListarRespostas::new).collect(Collectors.toUnmodifiableList()));
    }
}
