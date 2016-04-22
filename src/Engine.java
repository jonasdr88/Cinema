/**
 * Created by jonas on 30-3-2016.
 */
public class Engine {
    public Reservatie reservatie;

    public Engine() {
        reservatie = new Reservatie();
        MaakZaal();

    }

    public void MaakZaal() {
        Zaal zaal = new Zaal();
        zaal.Maakzaal();
        //reserveertest
        zaal.ReserveerPlaats(5);
        zaal.ReserveerPlaats(6);
        zaal.ReserveerPlaats(7);
        zaal.ReserveerPlaats(23);
        zaal.ReserveerPlaats(50);
        zaal.ReserveerPlaats(1);
        zaal.getVrijePlaatsen();

    }

    public Reservatie getReservatie() {
        return r;
    }

    public void testStudent() {
        Student s = new Student();
        int pr = s.getPrijs();
        System.out.println("prijs: " + pr);
    }
}
