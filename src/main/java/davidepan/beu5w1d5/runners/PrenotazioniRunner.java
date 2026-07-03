package davidepan.beu5w1d5.runners;

import davidepan.beu5w1d5.entities.Edificio;
import davidepan.beu5w1d5.entities.Postazione;
import davidepan.beu5w1d5.entities.Utente;
import davidepan.beu5w1d5.enums.TipoPostazione;
import davidepan.beu5w1d5.services.EdificioService;
import davidepan.beu5w1d5.services.PostazioneService;
import davidepan.beu5w1d5.services.PrenotazioneService;
import davidepan.beu5w1d5.services.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PrenotazioniRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception{
        log.info("Salvataggio dei datin in db");

//        Edificio ed1 = new Edificio();
//        ed1.setCitta("Viterbo");
//        ed1.setNome("Poste italiane");
//        ed1.setIndirizzo("Via duomo 1");
//        ed1 = edificioService.salvaEdificio(ed1);

        //Creazione dei edifici
        Edificio ed1 = new Edificio( "Poste Italiane", "Via duomo 1", "Viterbo");
        ed1 = edificioService.salvaEdificio(ed1);

        Edificio ed2 = new Edificio( "Poste non italiane", "Via duomo 2", "Viterbo");
        ed2 = edificioService.salvaEdificio(ed2);

        Edificio ed3 = new Edificio( "Poste estere", "Via donna 1", "Roma");
        ed3 = edificioService.salvaEdificio(ed3);

        //Creazione delle postazioni
        Postazione pos1 = new Postazione("Senza climatizzatore", TipoPostazione.OPENSPACE, 100, ed1);
        pos1 = postazioneService.salvaPostazione(pos1);
        Postazione pos2 = new Postazione("Con climatizzatore", TipoPostazione.PRIVATO, 5, ed1);
        pos2 = postazioneService.salvaPostazione(pos2);
        Postazione pos3 = new Postazione("Con climatizzatore e sedie", TipoPostazione.SALA_RIUNIONI, 20, ed2);
        pos3 = postazioneService.salvaPostazione(pos3);
        Postazione pos4 = new Postazione("Con climatizzatore, sedie e tavolo", TipoPostazione.PRIVATO,  4, ed2);
        pos4 = postazioneService.salvaPostazione(pos4);
        Postazione pos5 = new Postazione("Con tutto e di più", TipoPostazione.OPENSPACE, 500, ed3);
        pos5 = postazioneService.salvaPostazione(pos5);

        //Creazione utenti
        Utente u1 = new Utente("gigio@gmail.com","Bonni","Gigio","Giggiobon");
        u1 = utenteService.salvaUtente(u1);
        Utente u2 = new Utente("belloci@gmail.com","Ciccio","Bello","CiccioBello");
        u2 = utenteService.salvaUtente(u2);
        Utente u3 = new Utente("Yogurtino@gmail.com","Yoyo","Yomino","YominoYougurtino");
        u3 = utenteService.salvaUtente(u3);
}}
