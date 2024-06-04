package main.forumhub.forumhub.domain.resposta;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDateTime;

public record DadosListarRespostas(
        Long id,
        String nome,
        @JsonAlias("Autor_Id")
        Long usuarioId,
        Long idTopico,
        LocalDateTime dataCriacao,
        @JsonAlias("Sugestao")
        String mensagem,
        StatusResposta status
) {

    public DadosListarRespostas(Resposta resposta) {
        this(resposta.getId(), resposta.getNome(),
                resposta.getAutor().getId(), resposta.getTopico().getId(),
                resposta.getDataCriacao(), resposta.getMensagem(), resposta.getStatus());
    }
}
