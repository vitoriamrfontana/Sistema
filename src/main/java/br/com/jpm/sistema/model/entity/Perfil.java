package br.com.jpm.sistema.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bio;

    @Column(nullable = false)
    private String foto;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Perfil(String bio, String foto) {
        this.bio = bio;
        this.foto = foto;
    }
    @Override
    public String toString(){
        return "Perfil{" +
                "id=" + id +
                ", bio=" + bio + '\'' +
                ", foto=" + foto + '\'' +
                '}';
    }
}
