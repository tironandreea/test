package domain;

/**
 * Created by Tiron Andreea on 12/03/2017.
 */

import repository.HasId;

public class Artist implements HasId<Integer> {
    private int id;
    private String nume;

    public Artist(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer cod) {
        this.id = cod;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "" + id + " | " + nume;
    }
}