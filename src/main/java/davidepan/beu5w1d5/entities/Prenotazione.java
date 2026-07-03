package davidepan.beu5w1d5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni",
uniqueConstraints = {
        @UniqueConstraint(columnNames = {"data", "postazione_id"}),
        @UniqueConstraint(columnNames = {"data", "utente_id"})
})
@Data
@NoArgsConstructor

public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "postazione_id", nullable = false)
    private Postazione postazione;

    public Prenotazione(Postazione postazione, Utente utente, LocalDate data) {
        this.postazione = postazione;
        this.utente = utente;
        this.data = data;
    }
}
