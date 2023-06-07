package it.unicam.cs.ids2223.programmafedelta.model.controllerRuoli;

import it.unicam.cs.ids2223.programmafedelta.model.prodotto.GestoreProdotto;
import it.unicam.cs.ids2223.programmafedelta.model.prodotto.Prodotto;
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
        int idCliente = 0;

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
            view.message("Scegli il cliente a cui associare la tessera fedeltà:", viewSet);
            String cliente = view.fetchSingleChoice(viewSet);
            Optional<Utente> clienteScelto = insiemeClienti.stream().filter(c -> c.getUsername().equals(cliente)).findFirst();
            idClienteScelto = clienteScelto.map(c -> c.getId());
            idCliente = idClienteScelto.orElse(-1);
            break;
        }

        view.message("Vuoi confermare la creazione della tessera fedeltà? [Y/n]:");
        boolean accetta = view.fetchBool();

        if (accetta) {
            gestoreTessere.add(new InfoTessera(idTessera, idCliente, punti, dI, dF, stato));
            view.message("La tessera fedeltà è stata creata con successo");
        } else {
            view.message("La creazione della tessera fedeltà è stata annullata");
        }
    }


    private void convalidaAcquisto() {

        GestoreProdotto gestoreProdotto = GestoreProdotto.getInstance(cassiere);
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

        Set<Prodotto> gruppoProdotti = gestoreProdotto.getGruppoProdotti();
        Set<String> prodotti = gruppoProdotti.stream()
                .map(Prodotto::getNome)
                .collect(Collectors.toSet());
        view.message("Scegliere il prodotto da convalidare", prodotti);
        String prodottoScelto = view.fetchSingleChoice(prodotti);
        Optional<Integer> puntiDaAssegnare = gruppoProdotti.stream()
                .filter(p -> p.getNome().equals(prodottoScelto))
                .map(Prodotto::getPunti)
                .findFirst();
        int puntiProdotto = puntiDaAssegnare.orElse(0);

        int saldoAggiornato = saldoTessera + puntiProdotto;
        gestoreTessere.aggiornaSaldo(new InfoTessera(saldoAggiornato, idTesseraFedelta));

        view.message("Convalidazione del prodotto effettuata con successo");


    }

    private void inserisciCliente() {
    }

    private void impostaMenu() {
        menuItems.add("1) Crea Tessera Fedeltà");
        menuItems.add("2) Convalida Acquisto");
        menuItems.add("3) Inserisci Cliente");
    }
}
