package it.unicam.cs.ids2223.programmafedelta.model.system;

import it.unicam.cs.ids2223.programmafedelta.model.Piattaforma;

public class MainApp {
    public static void main(String[] args) {
        Piattaforma p = Piattaforma.getInstance();
        p.init();
    }
}
