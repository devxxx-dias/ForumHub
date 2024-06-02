package main.forumhub.forumhub.domain.curso;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record DadosDetalhadamentoCurso(
        Long id,
        String nome,
        Categoria categoria
) {
    public DadosDetalhadamentoCurso(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
