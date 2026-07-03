package davidepan.beu5w1d5.entities;

import davidepan.beu5w1d5.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postazioni")
@Data
@NoArgsConstructor
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descrizione;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    @Column(nullable = false, name = "max_partecipanti")
    private Integer maxPartecipanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;
}
