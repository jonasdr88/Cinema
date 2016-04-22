import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Thomas on 31/03/2016.
 */
public class CinemaLabel extends JLabel {
    int labelnr;
    boolean beschikbaar = true;

    public CinemaLabel(int labelnr) {
        this.labelnr = labelnr;
        setFont(new Font("Calibri", Font.BOLD, 20));
        setForeground(Color.orange);
        setText(Integer.toString(labelnr)); //zet nummer in label
        setOpaque(true); //labels zijn standaard transparant
        setHorizontalAlignment(CENTER);
        if (beschikbaar) {
            this.setBackground(Color.GREEN);
            this.setForeground(Color.blue);
        } else {
            this.setBackground(Color.red);
            this.setForeground(Color.orange);
        }
        LineBorder line = new LineBorder(Color.blue, 2, true); //fancy afgeronde hoekjes
        this.setBorder(line);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
