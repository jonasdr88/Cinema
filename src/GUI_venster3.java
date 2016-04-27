import javax.swing.*;
import java.awt.*;

/**
 * Created by Thomas on 30/03/2016.
 */
public class GUI_venster3 extends JPanel {
    ButtonGroup betaalmethodes;
    private JLabel labelOverzicht, labelGekozenFilm, labelGekozenVersie, labelGekozenTickets, labelGekozenPlaatsen, labelBetaalmethodeKiezen, labelTotaalbedrag, labelBedrag, labelEmail;
    private JLabel labelLeeg1, labelLeeg2, labelLeeg3, labelLeeg4, labelLeeg5;
    private JTextField email;
    private JRadioButton betaalmethode1, betaalmethode2, betaalmethode3;

    public GUI_venster3() {
        setVisible(true);
        setLayout(new GridLayout(10, 1));
        plaatsComponentenVenster3();
    }

    /**
     * Maak componenten (knoppen, labels...) aan om via de GUI een overzicht te krijgen en te betalen (venster 3).
     */
    public void plaatsComponentenVenster3() {
        labelOverzicht = new JLabel("Overzicht reservatie");
        labelOverzicht.setFont(new Font("Calibri", Font.BOLD, 20));
        labelGekozenFilm = new JLabel("Film: The Revenant"); //labelGekozenFilm = new JLabel(engine.getReservatie().getFilmnaam());
        labelGekozenVersie = new JLabel("Versie: 3D");
        labelGekozenTickets = new JLabel("2 Student ticket(s)");
        labelGekozenPlaatsen = new JLabel("Zaal 4 stoel 37 en 38");
        labelBetaalmethodeKiezen = new JLabel("Betaalmethode kiezen");
        labelBetaalmethodeKiezen.setFont(new Font("Calibri", Font.BOLD, 20));
        labelTotaalbedrag = new JLabel("Totaalbedrag: ");
        labelBedrag = new JLabel("€17.50");
        labelEmail = new JLabel("E-mailadres ter verificatie: ");
        labelLeeg1 = new JLabel("");
        labelLeeg2 = new JLabel("");
        labelLeeg3 = new JLabel("");
        labelLeeg4 = new JLabel("");
        labelLeeg5 = new JLabel("");

        betaalmethode1 = new JRadioButton("Bancontact - Mister Cash");
        betaalmethode2 = new JRadioButton("VISA");
        betaalmethode3 = new JRadioButton("Fysieke tickets");
        betaalmethode3.setToolTipText("Duid deze optie aan indien u reeds over cinematickets beschikt.");
        betaalmethodes = new ButtonGroup();
        betaalmethodes.add(betaalmethode1);
        betaalmethodes.add(betaalmethode2);
        betaalmethodes.add(betaalmethode3);

        email = new JTextField("");

        add(labelOverzicht);
        add(labelLeeg1);
        add(labelGekozenFilm);
        add(labelGekozenVersie);
        add(labelGekozenTickets);
        add(labelGekozenPlaatsen);
        add(labelBetaalmethodeKiezen);
        add(labelLeeg2);
        add(betaalmethode1);
        add(labelLeeg3);
        add(betaalmethode2);
        add(labelLeeg4);
        add(betaalmethode3);
        add(labelLeeg5);
        add(labelTotaalbedrag);
        add(labelBedrag);
        add(labelEmail);
        add(email);
    }

    /**
     * Methode die checkt of er een betaalmethode gekozen werd en een geldig e-mailadres werd ingegeven.
     */
    public boolean checkOfAllesIngevuldIs() {
        return (betaalmethodes.getSelection() != null) && !(email.getText().equals("")) && (email.getText().contains("@"));
    }
}
