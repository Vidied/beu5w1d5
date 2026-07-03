package davidepan.beu5w1d5.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.metamodel.mapping.NonAggregatedIdentifierMapping;
import org.yaml.snakeyaml.events.Event;

import javax.naming.Name;

@Entity
@Table(name = "utenti")
@Data
@NoArgsConstructor
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(nullable = false, unique = true)
    private String email;
}
