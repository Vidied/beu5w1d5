package davidepan.beu5w1d5.runners;

import davidepan.beu5w1d5.entities.Edificio;
import davidepan.beu5w1d5.entities.Postazione;
import davidepan.beu5w1d5.entities.Prenotazione;
import davidepan.beu5w1d5.entities.Utente;
import davidepan.beu5w1d5.enums.TipoPostazione;
import davidepan.beu5w1d5.repositories.PrenotazioneRepository;
import davidepan.beu5w1d5.services.EdificioService;
import davidepan.beu5w1d5.services.PostazioneService;
import davidepan.beu5w1d5.services.PrenotazioneService;
import davidepan.beu5w1d5.services.UtenteService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

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
        Edificio ed1 = new Edificio( "Viterbo", "Via duomo 1","Poste Italiane" );
        ed1 = edificioService.salvaEdificio(ed1);

        Edificio ed2 = new Edificio( "Viterbo", "Via duomo 2", "Poste non italiane");
        ed2 = edificioService.salvaEdificio(ed2);

        Edificio ed3 = new Edificio( "Roma", "Via donna 1", "Poste estere");
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

        log.info("Fine creazione oggetti per DB");

        //Creazione delle prenotazioni
        log.info("Creazione delle prenotazioni");

        try {
            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setData(LocalDate.now().plusDays(2));
            prenotazione.setUtente(u1);
            prenotazione.setPostazione(pos1);

            Prenotazione prenotazioneSalvata = prenotazioneService.prenotaPostazione(prenotazione);
            log.info("Prenotazione registrata con successo! ID: " + prenotazioneSalvata.getId());

            //Verifica forzando una prenotazione nello stesso giorno e stesso utente
            Prenotazione prenotazione2 = new Prenotazione();
            prenotazione2.setData(LocalDate.now().plusDays(2));
            prenotazione2.setUtente(u1);
            prenotazione2.setPostazione(pos1);

            Prenotazione prenotazioneSalvata2 = prenotazioneService.prenotaPostazione(prenotazione2);
            log.info("Prenotazione registrata con successo! ID: " + prenotazioneSalvata2.getId());
        } catch (RuntimeException e){
            log.error("Errore: {}", e.getMessage());
        }

        //Test ricerca postazioni
        List<Postazione> postazioniTrovate = postazioneService.cercaPostazione(TipoPostazione.PRIVATO, "Viterbo");

        log.info("Postazioni trovate a Viterbo di tipo PRIVATO: " + postazioniTrovate.size());
        for (Postazione p : postazioniTrovate) {
            log.info("ID: " + p.getId() + " Descrizione: " + p.getDescrizione());
        }
}}
