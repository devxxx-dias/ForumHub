package main.forumhub.forumhub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import main.forumhub.forumhub.domain.curso.Curso;
import main.forumhub.forumhub.domain.resposta.Resposta;
import main.forumhub.forumhub.domain.usuario.Usuario;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDate dataCriacao;
    @Enumerated(EnumType.STRING)
    private EstadoDoTopico estadoDoTopico;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarios_id")
    private Usuario autor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Resposta> resposta;

    public void setResposta(List<Resposta> resposta) {
        resposta.forEach(r -> r.setTopico(this));
        this.resposta = resposta;
    }


}

