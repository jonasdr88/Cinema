/**
 * Created by jonas on 30-3-2016.
 */
public class Reservatie {

    int aantalSt;
    int aantalBej;
    int aantalVolw;
    int[] plaatsen = new int[50];
    private String defilm;
    private String deversie;

    public Reservatie() {
    }

    public void AddFilm(String f) {
        defilm = f;
    }

    public void AddVersie(String v) {
        deversie = v;
    }

    public void AddStudent(int aantal) {
        aantalSt = aantal;
    }

    public void AddVolwassene(int aantal) {
        aantalVolw = aantal;
    }

    public void AddBejaarde(int aantal) {
        aantalBej = aantal;
    }

    public void Addplaatsen(int[] volzet) {
        int k = 0;
        for (int i = 0; i < 50; i++) {
            if (volzet[i] != 0) {
                plaatsen[k] = volzet[i];
                k++;
            }
        }
    }

    public String getFilm() {
        return defilm;
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
