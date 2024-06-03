package main.forumhub.forumhub.domain.topico;

import java.time.LocalDate;

public record DadosDetalhadamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDate dataCriacao
) {
    public DadosDetalhadamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao());
    }
}
