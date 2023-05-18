package model.ruoli;

import model.TesseraFedelta;

import java.sql.Date;

public class DefaultCliente implements Cliente{

    private String nome;
    private String cognome;
    private Date dataNascita;
    private String CF;
    private String mail;
    private TesseraFedelta tessera;
    private String numeroTelefonico;

}
