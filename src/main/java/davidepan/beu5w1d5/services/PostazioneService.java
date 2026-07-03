package davidepan.beu5w1d5.services;

import davidepan.beu5w1d5.entities.Postazione;
import davidepan.beu5w1d5.enums.TipoPostazione;
import davidepan.beu5w1d5.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public Postazione salvaPostazione(Postazione postazione){
        return postazioneRepository.save(postazione);
    }

    public List<Postazione> ricercaPostazione (TipoPostazione tipo, String citta){
        return postazioneRepository.findByTipoAndCitta(tipo, citta);
    }
}
