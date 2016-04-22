import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Thomas on 30/03/2016.
 */
public class GUI_venster1 extends JPanel {
    ButtonGroup groepFilms, groepVersies;
    String gekozenVersie, gekozenFilm;
    private JLabel labelFilmKiezen, labelVersieKiezen, labelLeeg1, labelLeeg2, labelLeeg3;
    private JRadioButton radioButtonFilm1, radioButtonFilm2, radioButtonFilm3, radioButtonFilm4, radioButtonFilm5;
    private JRadioButton radioButtonVersieNormaal, radioButtonVersie3D, radioButtonVersieUltraLaser;

    public GUI_venster1() {
        setVisible(true);
        setLayout(new GridLayout(9, 2));
        plaatsComponentenVenster1();
        addEventListeners();
    }

    /**
     * Maak componenten (knoppen, labels...) aan om via de GUI film en versie te kiezen (venster 1)
     */
    public void plaatsComponentenVenster1() {
        labelFilmKiezen = new JLabel("Film kiezen");
        labelFilmKiezen.setFont(new Font("Calibri", Font.BOLD, 20));
        radioButtonFilm1 = new JRadioButton("The Revenant");
        radioButtonFilm2 = new JRadioButton("Star Wars episode VII");
        radioButtonFilm3 = new JRadioButton("Deadpool");
        radioButtonFilm4 = new JRadioButton("Safety First");
        radioButtonFilm5 = new JRadioButton("The Boy in the striped pyjamas");

        groepFilms = new ButtonGroup();
        groepFilms.add(radioButtonFilm1);
        groepFilms.add(radioButtonFilm2);
        groepFilms.add(radioButtonFilm3);
        groepFilms.add(radioButtonFilm4);
        groepFilms.add(radioButtonFilm5);

        labelVersieKiezen = new JLabel("Versie kiezen");
        labelVersieKiezen.setFont(new Font("Calibri", Font.BOLD, 20));
        radioButtonVersieNormaal = new JRadioButton("Normaal");
        radioButtonVersie3D = new JRadioButton("3D (+ €3)");
        radioButtonVersieUltraLaser = new JRadioButton("ULTRA - Laser (+ €4)");

        groepVersies = new ButtonGroup();
        groepVersies.add(radioButtonVersieNormaal);
        groepVersies.add(radioButtonVersie3D);
        groepVersies.add(radioButtonVersieUltraLaser);

        labelLeeg1 = new JLabel("");
        labelLeeg2 = new JLabel("");
        labelLeeg3 = new JLabel("");

        add(labelFilmKiezen);
        add(labelVersieKiezen);
        add(radioButtonFilm1);
        add(radioButtonVersieNormaal);
        add(radioButtonFilm2);
        add(radioButtonVersie3D);
        add(radioButtonFilm3);
        add(radioButtonVersieUltraLaser);
        add(radioButtonFilm4);
        add(labelLeeg2);
        add(radioButtonFilm5);
        add(labelLeeg3);
    }

    public void addEventListeners() {
        // Check welke film geselecteerd werd
        radioButtonFilm1.setActionCommand(radioButtonFilm1.getText());
        radioButtonFilm2.setActionCommand(radioButtonFilm2.getText());
        radioButtonFilm3.setActionCommand(radioButtonFilm3.getText());
        radioButtonFilm4.setActionCommand(radioButtonFilm4.getText());
        radioButtonFilm5.setActionCommand(radioButtonFilm5.getText());

        class FilmActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                gekozenFilm = groepFilms.getSelection().getActionCommand();
                System.out.println("Gekozen film: " + gekozenFilm);
            }
        }

        ActionListener filmActionListener = new FilmActionListener();
        radioButtonFilm1.addActionListener(filmActionListener);
        radioButtonFilm2.addActionListener(filmActionListener);
        radioButtonFilm3.addActionListener(filmActionListener);
        radioButtonFilm4.addActionListener(filmActionListener);
        radioButtonFilm5.addActionListener(filmActionListener);


        //Check welke versie geselecteerd werd
        radioButtonVersieNormaal.setActionCommand(radioButtonVersieNormaal.getText());
        radioButtonVersie3D.setActionCommand(radioButtonVersie3D.getText());
        radioButtonVersieUltraLaser.setActionCommand(radioButtonVersieUltraLaser.getText());

        class VersieActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                gekozenVersie = groepVersies.getSelection().getActionCommand();
                System.out.println("Gekozen versie: " + gekozenVersie);
            }
        }

        ActionListener versieActionListener = new VersieActionListener();
        radioButtonVersieNormaal.addActionListener(versieActionListener);
        radioButtonVersie3D.addActionListener(versieActionListener);
        radioButtonVersieUltraLaser.addActionListener(versieActionListener);


    }

    public boolean checkOfFilmEnVersieGeselecteerdIs() {
        return (groepFilms.getSelection() != null) && (groepVersies.getSelection() != null);
    }

    public String getGekozenFilm() {
        return gekozenFilm;
    }

    public String getGekozenVersie() {
        return gekozenVersie;
    }

    public void jonastest() {
        System.out.println("venster 1 check");
    }


}
