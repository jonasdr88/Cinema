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
    }

}