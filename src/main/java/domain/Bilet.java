package domain;

/**
 * Created by Tiron Andreea on 12/03/2017.
 */
import repository.HasId;

public class Bilet implements HasId<Integer> {
    private int id;
    private int id_spectacol;
    private String cumparator;
    private int locuri;

    public Bilet(int id, int id_spectacol, String cumparator, int locuri) {
        this.id = id;
        this.id_spectacol = id_spectacol;
        this.cumparator = cumparator;
        this.locuri = locuri;
    }

    public int getId_spectacol() {
        return id_spectacol;
    }

    public void setId_spectacol(int id_spectacol) {
        this.id_spectacol = id_spectacol;
    }

    public String getCumparator() {
        return cumparator;
    }

    public void setCumparator(String cumparator) {
        this.cumparator = cumparator;
    }

    public int getLocuri() {
        return locuri;
    }

    public void setLocuri(int locuri) {
        this.locuri = locuri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer cod) {
        this.id = cod;
    }

    @Override
    public String toString() {
        return "" + id + " | " +  cumparator + " | " + locuri;
    }
}