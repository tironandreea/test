package domain;

/**
 * Created by Tiron Andreea on 15/03/2017.
 */
public class Utilizator {
    private int id;
    private String nume;
    private String password;

    public Utilizator(int id, String nume,String password) {
        this.id = id;
        this.nume = nume;
        this.password=password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "" + id + " | " + nume + " | " + password;
    }
}