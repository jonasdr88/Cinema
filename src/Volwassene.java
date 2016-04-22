/**
 * Created by jonas on 9-4-2016.
 */
public class Volwassene extends Persoon {

    public Volwassene() {
        super(10);
    }

    public int getPrijs() {
        System.out.println("getprijs student ok");
        return super.getPrijs();
    }
}

