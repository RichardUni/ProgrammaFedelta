package model.ruolo;

import model.GestoreTessera;
import model.TesseraFedelta;

import java.util.Date;

public class DefaultCliente implements Cliente{

    private String nome;
    private String cognome;
    private Date dataNascita;
    private String CF;
    private int id_cliente;
    private String mail;
    private TesseraFedelta tesseraFedelta;
    private GestoreTessera gestoreTessere;
    private String numeroTelefono;

    /**
     * Permette di creare un nuovo utente <code>Cliente</code> nella piattaforma del ProgrammaFedelta
     */
    public DefaultCliente(String nome, String cognome, Date dataNascita, String CF, int id_cliente, String mail,
                          TesseraFedelta tesseraFedelta, String numeroTelefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.CF = CF;
        this.id_cliente = id_cliente;
        this.mail = mail;
        this.tesseraFedelta = tesseraFedelta;
        this.numeroTelefono = numeroTelefono;
        this.gestoreTessere = new GestoreTessera(this);
    }

    private GestoreTessera getGestoreTessere(){
    return this.gestoreTessere;
    }

    @Override
    public void creaTesseraFedelta() {

    }

    @Override
    public TesseraFedelta getTesseraFedelta() {
        return null;
    }

    @Override
    public String toString() {
        return "DefaultCliente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", CF='" + CF + '\'' +
                ", mail='" + mail + '\'' +
                ", tesseraFedelta=" + tesseraFedelta +
                ", gestoreTessere=" + gestoreTessere +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                '}';
    }
}
