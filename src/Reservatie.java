/**
 * Created by jonas on 30-3-2016.
 */
public class Reservatie {

    int aantalSt;
    int aantalBej;
    int aantalVolw;
    private String defilm;
    private String deversie;

    public Reservatie() {
    }

    public void AddFilm(String f) {
        defilm = f;
    }

    public String getFilm() {
        return defilm;
    }

    public void AddVersie(String v) {
        deversie = v;
    }

    public void AddStudent(int aantal) {
        aantalSt = aantal;
    }

    public void RemoveStudent() {
        aantalSt--;
    }

    public void AddVolwassene(int aantal) {
        aantalVolw = aantal;
    }

    public void RemoveVolwassene() {
        aantalVolw--;
    }

    public void addBejaarde(int aantal) {
        aantalBej = aantal;
    }

    public void removeBejaarde() {
        aantalBej--;
    }

    public String getVersie() {
        return deversie;
    }

    public int getAantalSt() {
        return aantalSt;
    }

    public int getAantalBej() {
        return aantalBej;
    }

    public int getAantalVolw() {
        return aantalVolw;
    }

    public int getPrijs() {
        int p;

        if (deversie.equals("3D (+ €3)"))
            p = 3;
        else if (deversie.equals("ULTRA - Laser (+ €4)"))
            p = 4;
        else
            p = 0;

        return p;
    }
}
