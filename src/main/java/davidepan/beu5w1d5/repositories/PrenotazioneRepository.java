package davidepan.beu5w1d5.repositories;

import davidepan.beu5w1d5.entities.Postazione;
import davidepan.beu5w1d5.entities.Prenotazione;
import davidepan.beu5w1d5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean prenotazioneDataPostazione(LocalDate data, Postazione postazione);
    boolean prenotazioneDataUtente(LocalDate data, Utente utente);
}
