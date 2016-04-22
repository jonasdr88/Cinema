/**
 * Created by jonas on 30-3-2016.
 */
public class Zaal {

    public boolean[] plaatsen = new boolean[51];

    public Zaal() {
    }

    public void Maakzaal() {
        for (int i = 0; i < 50; i++) {
            plaatsen[i] = false;
        }
    }

    public void ReserveerPlaats(int k) {
        plaatsen[k] = true;
    }

    public int[] getVrijePlaatsen() {
        int j = 0, c = 0;
        for (int a = 0; a < 50; a++) {
            if (plaatsen[a] == false)
                j++;
        }
        int[] vrijeplaatsen = new int[j];
        for (int b = 0; b < 50; b++) {
            if (plaatsen[b] == false) {
                vrijeplaatsen[c] = b;
                c++;
            }
        }

//        for(int y=0;y<j;y++){
//            System.out.println(vrijeplaatsen[y]);
//        }
        return vrijeplaatsen;
    }

}
