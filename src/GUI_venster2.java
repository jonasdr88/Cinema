import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Thomas on 30/03/2016.
 */
public class GUI_venster2 extends JPanel {
    JSpinner spinnerStudent, spinnerVolwassen, spinnerGepensioneerd;
    int aantalStudenten = 0, aantalVolwassenen = 0, aantalGepensioneerden = 0;
    int aantalGereserveerdeStoelen = 0;
    int[] volzet = new int[50];
    private JLabel labelVolwassen, labelStudent, labelGepensioneerd, labelAantalTickets, labelPlaatsenKiezen;

    public GUI_venster2() {
        setVisible(true);
        setLayout(new BorderLayout());
        plaatsComponentenVenster2();
        addEventListeners();
        checkAantalGekozenPlaatsen();
        for (int i = 0; i < 50; i++)
            volzet[i] = 0;
    }

    /**
     * Maak componenten (knoppen, labels...) aan om via de GUI plaatsen te kiezen (venster 2).
     */
    public void plaatsComponentenVenster2() {
        labelAantalTickets = new JLabel("Aantal Tickets");
        labelAantalTickets.setFont(new Font("Calibri", Font.BOLD, 20));
        labelPlaatsenKiezen = new JLabel("Plaatsen kiezen");
        labelPlaatsenKiezen.setFont(new Font("Calibri", Font.BOLD, 20));
        labelVolwassen = new JLabel("Volwassen");
        labelVolwassen.setHorizontalAlignment(SwingConstants.CENTER);
        labelGepensioneerd = new JLabel("Gepensioneerd");
        labelGepensioneerd.setHorizontalAlignment(SwingConstants.CENTER);
        labelStudent = new JLabel("Student");
        labelStudent.setHorizontalAlignment(SwingConstants.CENTER);

        spinnerStudent = new JSpinner();
        spinnerVolwassen = new JSpinner();
        spinnerGepensioneerd = new JSpinner();

        maakPaneelVoorAantalTickets();
        maakPaneelVoorPlaatsen();
    }

    /**
     * Maak een genest paneel voor het aantal tickets (labels + spinners).
     */
    public void maakPaneelVoorAantalTickets() {
        JPanel aantalTicketsPaneel = new JPanel(new BorderLayout());
        aantalTicketsPaneel.add(labelAantalTickets, BorderLayout.NORTH);
        JPanel personenPaneel = new JPanel(new FlowLayout());
        personenPaneel.add(labelStudent);
        personenPaneel.add(spinnerStudent);
        personenPaneel.add(labelVolwassen);
        personenPaneel.add(spinnerVolwassen);
        personenPaneel.add(labelGepensioneerd);
        personenPaneel.add(spinnerGepensioneerd);
        aantalTicketsPaneel.add(personenPaneel, BorderLayout.SOUTH);
        add(aantalTicketsPaneel, BorderLayout.NORTH);
    }

    /**
     * Maak een genest paneel voor het weergeven van de 50 plaatsen van de cinemazaal.
     * Als op een zetel wordt gekllikt, moet de plaats onbeschikbaar worden en rood kleuren.
     */
    public void maakPaneelVoorPlaatsen() {
        JPanel plaatsenPaneel = new JPanel(new BorderLayout());
        plaatsenPaneel.add(labelPlaatsenKiezen, BorderLayout.NORTH);

        JPanel stoelenPaneel = new JPanel(new GridLayout(5, 10));
        int zetelnr = 0;
        for (int rij = 0; rij < 5; rij++) {
            for (int kolom = 0; kolom < 10; kolom++) {
                zetelnr++;
                CinemaLabel cinemaLabel = new CinemaLabel(zetelnr);
                cinemaLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        boolean gereserveerd = false;
                        if (!gereserveerd) {
                            if (cinemaLabel.getBackground() == Color.green) {
                                cinemaLabel.setBackground(Color.red);
                                cinemaLabel.setForeground(Color.orange);
                                volzet[cinemaLabel.labelnr] = cinemaLabel.labelnr;
                                aantalGereserveerdeStoelen++;

                            } else {
                                volzet[cinemaLabel.labelnr] = 0;
                                aantalGereserveerdeStoelen--;
                                cinemaLabel.setBackground(Color.green);
                                cinemaLabel.setForeground(Color.blue);
                            }
                        }

                    }
                });
                stoelenPaneel.add(cinemaLabel, BorderLayout.SOUTH);
            }
        }

        plaatsenPaneel.add(stoelenPaneel, BorderLayout.CENTER);
        add(plaatsenPaneel, BorderLayout.CENTER);
    }

    public void addEventListeners() {
        spinnerStudent.setModel(new SpinnerNumberModel(0, 0, 50, 1));      // tussen min=0 en max=50 tickets bestellen
        spinnerVolwassen.setModel(new SpinnerNumberModel(0, 0, 50, 1));
        spinnerGepensioneerd.setModel(new SpinnerNumberModel(0, 0, 50, 1));

        spinnerStudent.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                aantalStudenten = (Integer) spinnerStudent.getValue();
                System.out.println("Aantal student tickets: " + aantalStudenten);
            }
        });

        spinnerVolwassen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                aantalVolwassenen = (Integer) spinnerVolwassen.getValue();
                System.out.println("Aantal volwassen tickets: " + aantalVolwassenen);
            }
        });

        spinnerGepensioneerd.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                aantalGepensioneerden = (Integer) spinnerGepensioneerd.getValue();
                System.out.println("Aantal gepensioneerde tickets: " + aantalGepensioneerden);
            }
        });
    }

    public int getAantalStudenten() {
        return aantalStudenten;
    }

    public int getAantalVolwassenen() {
        return aantalVolwassenen;
    }

    public int getAantalGepensioneerden() {
        return aantalGepensioneerden;
    }

    public boolean checkAantalGekozenPlaatsen() {
        int som = getAantalStudenten() + getAantalVolwassenen() + getAantalGepensioneerden();
        // aantal tickets == aantal plaatsen die je rood hebt gemaakt in de zaalmatrix
        return som == aantalGereserveerdeStoelen;
    }

    public int getAantalGereserveerdeStoelen() {
        return aantalGereserveerdeStoelen;
    }

}

