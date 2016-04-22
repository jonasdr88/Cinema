/**
 * Created by jonas on 9-4-2016.
 */
public class Bejaarde extends Persoon {

    public Bejaarde() {
        super(8);
    }

    public int getPrijs() {
        System.out.println("getprijs student ok");
        return super.getPrijs();
    }
}

