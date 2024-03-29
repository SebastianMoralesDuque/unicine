package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudad")
    private List<Teatro> teatros;

    public Ciudad(String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.teatros = teatros;
    }
}
