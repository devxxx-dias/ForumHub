//package main.forumhub.forumhub.domain.perfil;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import main.forumhub.forumhub.domain.usuario.Usuario;
//
//import java.util.List;
//
//@Entity(name = "Perfil")
//@Table(name = "perfis")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
//public class Perfil {
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String nome;
//
//    @ManyToOne(fetch = FetchType.LAZY) // Assuming Usuario has a 'perfil' field
//    private List<Usuario> usuarios; // List of associated Usuarios
//}
