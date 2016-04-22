import javax.swing.*;
import java.awt.*;

/**
 * Created by Jonas en Thomas on 17/03/2016.
 */
public class Main {
    public static void main(String[] args) {
        // GUI aanmaken en weergeven
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        GUI_control gui = new GUI_control();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(550, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        gui.setLocation(dim.width / 2 - gui.getSize().width / 2, dim.height / 2 - gui.getSize().height / 2); // zet frame in het midden van het scherm
        gui.setVisible(true);
        gui.setTitle("Cinematickets reserveren");

        // DOMEIN CODE

        GUI_venster1 vens1 = gui.getVenster1();
        saveFilm(vens1, e);
        String s = e.r.getFilm();
        System.out.println(s);
    }

    public static void saveFilm(GUI_venster1 g1, Engine e) {
        e.r.AddFilm(g1.getGekozenFilm());
    }

    public static void saveVersie(GUI_venster1 gui1, Engine e) {
        e.r.AddVersie(gui1.getGekozenVersie());
    }

}