package davidepan.beu5w1d5.repositories;

import davidepan.beu5w1d5.entities.Postazione;
import davidepan.beu5w1d5.entities.Prenotazione;
import davidepan.beu5w1d5.entities.Utente;
import davidepan.beu5w1d5.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean existsByDataAndPostazione(LocalDate data, Postazione postazione);
    boolean existsByDataAndUtente(LocalDate data, Utente utente);
    List<Prenotazione> findByDataAndUtente(LocalDate data, Utente utente);

}
