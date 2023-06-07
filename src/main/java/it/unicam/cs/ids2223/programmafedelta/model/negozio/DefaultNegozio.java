package it.unicam.cs.ids2223.programmafedelta.model.negozio;

import java.util.Objects;

public class DefaultNegozio implements Negozio{

    private int idNegozio;
    private int idProprietario;
    private String nome;

    public DefaultNegozio(int idNegozio, int idProprietario, String nome) {
        this.idNegozio = idNegozio;
        this.idProprietario = idProprietario;
        this.nome = nome;
    }

    public int getIdNegozio() {
        return idNegozio;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getIdPropietario() {
        return 0;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultNegozio that = (DefaultNegozio) o;
        return idNegozio == that.idNegozio && idProprietario == that.idProprietario && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNegozio, idProprietario, nome);
    }

    @Override
    public String toString() {
        return "DefaultNegozio{" +
                "idNegozio=" + idNegozio +
                ", idProprietario=" + idProprietario +
                ", nome='" + nome + '\'' +
                '}';
    }
}
