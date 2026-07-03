package davidepan.beu5w1d5.services;

import davidepan.beu5w1d5.entities.Prenotazione;
import davidepan.beu5w1d5.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione prenotaPostazione(Prenotazione prenotazione){
        if (prenotazioneRepository.prenotazioneDataPostazione(prenotazione.getData(), prenotazione.getPostazione())){
            throw new RuntimeException("Errore: Postazione occupata per quella data");
        }

        if(prenotazioneRepository.prenotazioneDataUtente(prenotazione.getData(), prenotazione.getUtente())){
            throw new RuntimeException("Errore: L'utente ha già una prenotazione per quella data");
        }
        return prenotazioneRepository.save((prenotazione));
    }
}
