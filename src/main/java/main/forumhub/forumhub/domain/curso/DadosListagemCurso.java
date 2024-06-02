package main.forumhub.forumhub.domain.curso;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosListagemCurso(
        Long id,
        String nome,
        Categoria categoria

) {
public DadosListagemCurso(Curso curso){
    this(curso.getId(), curso.getNome(), curso.getCategoria());
}

}
