package it.unicam.cs.ids2223.programmafedelta.model.controllerRuoli;

import it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.GestoreTessere;
import it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.InfoTessera;
import it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.TesseraFedelta;
import it.unicam.cs.ids2223.programmafedelta.model.utenti.GestoreUtente;
import it.unicam.cs.ids2223.programmafedelta.model.utenti.TipoUtente;
import it.unicam.cs.ids2223.programmafedelta.model.utenti.Utente;
import it.unicam.cs.ids2223.programmafedelta.ruoli.Cassiere;
import it.unicam.cs.ids2223.programmafedelta.view.IView;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ControllerCassiere extends ControllerUtenteAutenticato implements ControllerUtente{

    private Cassiere cassiere;

    public ControllerCassiere(IView<String> view, Cassiere cassiere) {
        super(view, cassiere);
        this.cassiere = cassiere;
        impostaMenu();
    }

    protected boolean switchMenu(int scelta) {
        boolean loop = true;
        switch (scelta) {
            case 1:
                creaTesseraFedelta();
                break;
            case 2:
                convalidaAcquisto();
                break;
            case 3:
                inserisciCliente();
            default:
                loop = super.switchMenu(scelta);
        }
        return loop;
    }

    private void creaTesseraFedelta() {
        int punti = 0;
        int stato = 1;

        GestoreTessere gestoreTessere = GestoreTessere.getInstance(cassiere);
        Set<TesseraFedelta> gruppoTessere = gestoreTessere.getTessereFedelta();
        int idTessera = gruppoTessere.size();
        if(idTessera!=0) idTessera++;

        LocalDateTime dI, dF;
        view.message("Inserisci la data d'inizio validità della tessera fedeltà");
        dI = view.fetchDate();
        view.message("Inserisci la data di scadenza della tessera fedeltà");
        dF = view.fetchDate();

        Optional<Integer> idClienteScelto;
        GestoreUtente gestoreUtente = GestoreUtente.getInstance();
        Set<Utente> insiemeClienti = gestoreUtente.getUtenti(c -> c.getTipo().equals(TipoUtente.CLIENTE));
        Set<String> viewSet = insiemeClienti.stream().map(Utente::getUsername).collect(Collectors.toSet());
        if(insiemeClienti.isEmpty()){
            view.message("Non sono presenti clienti all'interno della piattaforma.");
            return;
        }
        while(true){
            view.message("Scegli il cliente a cui associare la tessera fedeltà:");
            String cliente = view.fetchSingleChoice(viewSet);
            Optional<Utente> clienteScelto = insiemeClienti.stream().filter(c -> c.getUsername().equals(cliente)).findFirst();
            idClienteScelto = clienteScelto.map(c -> c.getId());
            break;
            }

        view.message("Vuoi confermare la creazione della tessera fedeltà? [Y/n]:");
        boolean accetta = view.fetchBool();

        if (accetta) {
            gestoreTessere.add(new InfoTessera(idTessera, idClienteScelto, idNegozio, punti, dI, dF, stato));
            view.message("La tessera fedeltà è stata creata con successo");
        } else {
            view.message("La creazione della tessera fedeltà è stata annullata");
        }
    }



    private void impostaMenu() {
        menuItems.add("1) Crea Tessera Fedeltà");
        menuItems.add("2) Convalida Acquisto");
        menuItems.add("3) Inserisci Cliente");
    }
}
