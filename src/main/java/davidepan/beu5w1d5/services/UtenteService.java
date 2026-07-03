package davidepan.beu5w1d5.services;

import davidepan.beu5w1d5.entities.Utente;
import davidepan.beu5w1d5.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente salvaUtente(Utente utente){
        return utenteRepository.save(utente);
    }
}
