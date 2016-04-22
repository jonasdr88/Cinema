/**
 * Created by jonas on 9-4-2016.
 */
public class Student extends Persoon {

    public Student() {
        super(7);
    }

    public int getPrijs() {
        System.out.println("getprijs student ok");
        return super.getPrijs();
    }
}
