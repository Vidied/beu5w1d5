package davidepan.beu5w1d5.services;

import davidepan.beu5w1d5.entities.Edificio;
import davidepan.beu5w1d5.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public Edificio salvaEdificio(Edificio edificio){
        return edificioRepository.save(edificio);
    }
}
