package it.unicam.cs.ids2223.programmafedelta.model.controllerRuoli;

import it.unicam.cs.ids2223.programmafedelta.model.bonus.Bonus;
import it.unicam.cs.ids2223.programmafedelta.model.bonus.GestoreBonus;
import it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.GestoreTessere;
import it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.InfoTessera;
import it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.TesseraFedelta;
import it.unicam.cs.ids2223.programmafedelta.model.utenti.GestoreUtente;
import it.unicam.cs.ids2223.programmafedelta.model.utenti.TipoUtente;
import it.unicam.cs.ids2223.programmafedelta.model.utenti.Utente;
import it.unicam.cs.ids2223.programmafedelta.ruoli.Cassiere;
import it.unicam.cs.ids2223.programmafedelta.ruoli.Cliente;
import it.unicam.cs.ids2223.programmafedelta.view.IView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ControllerCliente extends ControllerUtenteAutenticato implements ControllerUtente {

    private Cliente cliente;
    private Cassiere cassiere;

    public ControllerCliente(IView<String> view, Cliente cliente) {
        super(view, cliente);
        impostaMenu();
    }

    protected boolean switchMenu(int scelta) {
        boolean loop = true;
        switch (scelta) {
            case 1:
                creaTesseraFedelta();
                break;
            case 2:
                effettuaAcquisto();
                break;
            case 3:
                visitaProfilo();
            case 4:
                modificaProfilo();
            case 5:
                riscattaBonus();
            case 6:
                scriviRecensione();
            case 7:
                portaUnAmico();
            default:
                loop = super.switchMenu(scelta);
        }
        return loop;
    }

    private void creaTesseraFedelta() {

        int punti = 0;
        int stato = 1;

        GestoreTessere gestoreTessere = GestoreTessere.getInstance(cliente);

        Set<TesseraFedelta> gruppoTessere = gestoreTessere.getTessereFedelta();
        int idTessera = gruppoTessere.size();
        if(idTessera!=0) idTessera++;

        LocalDateTime dI, dF;
        dI = LocalDateTime.now();
        dF = LocalDateTime.now();

        Optional<Integer> idClienteScelto;
        GestoreUtente gestoreUtente = GestoreUtente.getInstance();
        Set<Utente> insiemeClienti = gestoreUtente.getUtenti(c -> c.getTipo().equals(TipoUtente.CLIENTE));
        String usernameCorrente = view.ask("Inserire il proprio username");
        Optional<Integer> idCliente = insiemeClienti.stream()
                .filter(c -> c.getUsername().equals(usernameCorrente))
                .map(Utente::getId)
                .findFirst();
        if(!idCliente.isPresent()){
            view.message("Utente non trovato");
            return;
        }

        view.message("Vuoi confermare la creazione della tessera fedeltà? [Y/n]:");
        boolean accetta = view.fetchBool();

        if (accetta) {
            gestoreTessere.add(new InfoTessera(idTessera, idCliente, idNegozio, punti, dI, dF, stato));
            view.message("La tessera fedeltà è stata creata con successo");
        } else {
            view.message("La creazione della tessera fedeltà è stata annullata");
        }
    }

    private void riscattaBonus() {

        GestoreBonus gestoreBonus = GestoreBonus.getInstance(cassiere);
        GestoreTessere gestoreTessere = GestoreTessere.getInstance(cassiere);

        view.message("Inserire id tessera fedeltà");
        Set<TesseraFedelta> insiemeTessere = gestoreTessere.getTessereFedelta();
        int idTesseraFedelta = view.fetchInt();
        Optional<Integer> tesseraSelezionata = insiemeTessere.stream()
                .filter(t -> t.getIdTessera()==idTesseraFedelta)
                .map(TesseraFedelta::getSaldo)
                .findFirst();
        int saldoTessera = tesseraSelezionata.orElse(-1);
        if(saldoTessera<0){
            view.message("Nessuna tessera presente nella piattaforma con l'id inserito");
            return;
        }

        Set<Bonus> gruppoBonus = gestoreBonus.getGruppoBonus();
        Set<String> bonusAttivi = gruppoBonus.stream()
                .filter(b -> b.getStato() == 1)
                .map(Bonus::getNome)
                .collect(Collectors.toSet());
        view.message("Scegliere un bonus tra i presenti nella lista", bonusAttivi);
        String bonusScelto = view.fetchSingleChoice(bonusAttivi);
        Optional<Integer> bonusPunti = gruppoBonus.stream()
                .filter(b -> b.getNome().equals(bonusScelto))
                .map(Bonus::getPunti)
                .findFirst();
        int prezzoBonus = bonusPunti.orElse(0);

        view.message("Il bonus" + bonusScelto + " necessita di " + prezzoBonus);

        if(saldoTessera<prezzoBonus){
            view.message("Punteggio presente nella tessera fedeltà non sufficiente");
            return;
        }else{
            view.message("Il bonus è disponibile per il riscatto");
            int saldoAggiornato = saldoTessera - prezzoBonus;
            gestoreTessere.aggiornaSaldo(new InfoTessera(saldoAggiornato, idTesseraFedelta));
        }
    }

    private void portaUnAmico() {

    }

    private void scriviRecensione() {

    }

    private void modificaProfilo() {

    }

    private void visitaProfilo() {

    }

    private void effettuaAcquisto() {

    }

    private void impostaMenu() {
        menuItems.add("1) Crea Tessera Fedelta");
        menuItems.add("2) Effettua Acquista");
        menuItems.add("3) Visita Profilo");
        menuItems.add("4) Modifica Profilo");
        menuItems.add("5) Riscatta Bonus");
        menuItems.add("6) Scrivi Recensione");
        menuItems.add("7) Porta un Amico");
    }
}
