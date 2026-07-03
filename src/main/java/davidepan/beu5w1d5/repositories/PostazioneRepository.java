package davidepan.beu5w1d5.repositories;

import davidepan.beu5w1d5.entities.Postazione;
import davidepan.beu5w1d5.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipoAndEdificioCitta(TipoPostazione tipo, String citta);
}
