package main.forumhub.forumhub.domain.resposta;

import jakarta.persistence.*;
import lombok.*;
import main.forumhub.forumhub.domain.topico.Topico;
import main.forumhub.forumhub.domain.usuario.Usuario;

import java.time.LocalDate;

@Entity(name = "Resposta")
@Table(name = "respostas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    @ManyToOne(fetch = FetchType.LAZY)
    private Topico topico;
    private LocalDate dataCriacao;
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario autor;
    private String solucao;




}

