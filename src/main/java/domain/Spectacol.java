package domain;

/**
 * Created by Tiron Andreea on 12/03/2017.
 */
import repository.HasId;

public class Spectacol implements HasId<Integer> {
    private int id;
    private String denumire;
    private int id_artist;
    private int locuri_disponibile;
    private int locuri_vandute;
    private String ora_incepere;
    private String data;

    public Spectacol(int id, String denumire, int id_artist, int locuri_disponibile, int locuri_vandute, String ora_incepere, String data) {
        this.id = id;
        this.denumire = denumire;
        this.id_artist = id_artist;
        this.locuri_disponibile = locuri_disponibile;
        this.locuri_vandute = locuri_vandute;
        this.ora_incepere = ora_incepere;
        this.data = data;
    }


    public int getId_artist() {
        return id_artist;
    }

    public void setId_artist(int id_artist) {
        this.id_artist = id_artist;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getLocuri_vandute() {
        return locuri_vandute;
    }

    public void setLocuri_vandute(int locuri_vandute) {
        this.locuri_vandute = locuri_vandute;
    }


    public int getLocuri_disponibile() {
        return locuri_disponibile;
    }

    public void setLocuri_disponibile(int locuri_disponibile) {
        this.locuri_disponibile = locuri_disponibile;
    }

    public String getOra_incepere() {
        return ora_incepere;
    }

    public void setOra_incepere(String ora_incepere) {
        this.ora_incepere = ora_incepere;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer cod) {
        this.id = cod;
    }

    @Override
    public String toString() {
        return "" + id + " | " + denumire + " | " + data + " | " + ora_incepere;
    }
}