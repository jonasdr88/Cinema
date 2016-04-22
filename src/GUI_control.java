import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Beheer de GUI voor het cinema-project.
 */
public class GUI_control extends JFrame {
    JPanel v1;
    JPanel v2;
    JPanel v3;
    Engine e;
    JMenuBar menubar;
    JMenu programma, help;
    JMenuItem sluiten, contact;
    JButton btnVorige, btnVolgende;
    JPanel currentPanel, panelVoortgang;
    JLabel labelVoortgang1, labelVoortgang2, labelVoortgang3;


    /**
     * Constructor: Maak het frame en het menu aan en plaats de componenten in de vensters.
     */
    public GUI_control() {

        v1 = new GUI_venster1();
        v2 = new GUI_venster2();
        v3 = new GUI_venster3();
        e = new Engine();

        maakMenu();
        this.setLayout(new BorderLayout());
        this.currentPanel = v1;
        this.add(maakVoortgangPanel(), BorderLayout.NORTH);
        this.add(v1, BorderLayout.CENTER);
        this.add(maakKnoppenPanel(), BorderLayout.SOUTH);
        addEventListeners();
    }

    /**
     * Maak een menubar met submenu's en items in.
     */

    public void maakMenu() {
        menubar = new JMenuBar();
        setJMenuBar(menubar);

        programma = new JMenu("Programma");
        menubar.add(programma);

        sluiten = new JMenuItem("Sluiten");
        programma.add(sluiten);

        EventSluiten eventSluiten = new EventSluiten();
        sluiten.addActionListener(eventSluiten);

        help = new JMenu("Help");
        menubar.add(help);

        contact = new JMenuItem("Contact");
        help.add(contact);

        EventHelp eventHelp = new EventHelp();
        contact.addActionListener(eventHelp);
    }

    /**
     * Maak een paneel voor de knoppen 'Vorige' en 'Volgende', die onderaan op het frame staan.
     */
    public JPanel maakKnoppenPanel() {
        JPanel knoppenPanel = new JPanel();
        btnVorige = new JButton("Vorige");
        btnVorige.setFont(new Font("Calibri", Font.BOLD, 17));
        btnVolgende = new JButton("Volgende");
        btnVolgende.setFont(new Font("Calibri", Font.BOLD, 17));
        knoppenPanel.setLayout(new FlowLayout());
        knoppenPanel.add(btnVorige);
        knoppenPanel.add(btnVolgende);
        return knoppenPanel;
    }

    /**
     * Maak een paneel om bovenaan de GUI te laten zien in welke van de 3 stappen de gebruiker zich bevindt.
     */
    public JPanel maakVoortgangPanel() {
        panelVoortgang = new JPanel(new GridLayout());      //Opmaak van de labels in de voortgangsbalk:
        labelVoortgang1 = new JLabel("1. Film kiezen");
        labelVoortgang1.setFont(new Font("Calibri", Font.BOLD, 20));
        labelVoortgang1.setHorizontalAlignment(SwingConstants.CENTER);
        labelVoortgang1.setForeground(Color.red);
        labelVoortgang1.setOpaque(true);
        labelVoortgang1.setBackground(Color.yellow);
        labelVoortgang2 = new JLabel("2. Plaatsen kiezen");
        labelVoortgang2.setFont(new Font("Calibri", Font.BOLD, 20));
        labelVoortgang2.setHorizontalAlignment(SwingConstants.CENTER);
        labelVoortgang3 = new JLabel("3. Betalen");
        labelVoortgang3.setFont(new Font("Calibri", Font.BOLD, 20));
        labelVoortgang3.setHorizontalAlignment(SwingConstants.CENTER);

        panelVoortgang.add(labelVoortgang1, BorderLayout.WEST);
        panelVoortgang.add(labelVoortgang2, BorderLayout.CENTER);
        panelVoortgang.add(labelVoortgang3, BorderLayout.EAST);
        panelVoortgang.setBorder(BorderFactory.createLineBorder(Color.black));
        //panelVoortgang.setBackground(Color.yellow);
        return panelVoortgang;
    }

    public JPanel getCurrentPanel() {
        return currentPanel;
    }

    /**
     * Deze methode geeft aan welk inhoudspaneel weergegeven moet worden.
     */
    public void setCurrentPanel(JPanel currentPanel) {
        this.currentPanel = currentPanel;
    }

    /**
     * Logica die uitgevoerd wordt wanneer in het programma op 'Volgende' of 'Vorige' wordt geklikt.
     * Switch tussen de 3 panels. De voortgangsbalk wordt steeds upgedatet.
     */
    public void addEventListeners() {
        btnVorige.addActionListener(e ->
        {
            if (currentPanel instanceof GUI_venster1) {
                //onnodige button/methode in dit geval
                labelVoortgang1.setForeground(Color.red);
                labelVoortgang1.setOpaque(true);
                labelVoortgang1.setBackground(Color.yellow);
                return;
            }

            if (currentPanel instanceof GUI_venster2) {
                this.remove(currentPanel);
                setCurrentPanel(v1);
                this.add(currentPanel);
                this.validate();
                this.repaint();
                this.requestFocus();
                btnVolgende.setText("Volgende");
                labelVoortgang2.setForeground(Color.black);
                labelVoortgang2.setOpaque(false);
                labelVoortgang1.setForeground(Color.red);
                labelVoortgang1.setOpaque(true);
                labelVoortgang1.setBackground(Color.yellow);
                return;
            }

            if (currentPanel instanceof GUI_venster3) {
                this.remove(currentPanel);
                setCurrentPanel(v2);
                this.add(currentPanel);
                this.validate();
                this.repaint();
                this.requestFocus();
                btnVolgende.setText("Volgende");
                labelVoortgang3.setForeground(Color.black);
                labelVoortgang3.setOpaque(false);
                labelVoortgang2.setOpaque(true);
                labelVoortgang2.setForeground(Color.red);
                labelVoortgang2.setBackground(Color.yellow);
            }
        });

        btnVolgende.addActionListener(e ->
        {
            if (currentPanel instanceof GUI_venster1) {
                if (!((GUI_venster1) currentPanel).checkOfFilmEnVersieGeselecteerdIs())
                    JOptionPane.showMessageDialog(null, "Selecteer een film en versie a.u.b.");
                else {
                    this.remove(currentPanel);
                    setCurrentPanel(v2);
                    this.add(currentPanel);
                    this.validate();
                    this.repaint();
                    this.requestFocus();
                    labelVoortgang1.setForeground(Color.black);
                    labelVoortgang1.setOpaque(false);
                    labelVoortgang2.setForeground(Color.red);
                    labelVoortgang2.setOpaque(true);
                    labelVoortgang2.setBackground(Color.yellow);
                }
                return;
            }

            if (currentPanel instanceof GUI_venster2) {
                if (!((GUI_venster2) currentPanel).checkAantalGekozenPlaatsen())
                    JOptionPane.showMessageDialog(null, "Het aantal tickets moet overeenkomen met het aantal plaatsen in de zaal.");
                else {
                    btnVolgende.setText("Betalen");
                    this.remove(currentPanel);
                    setCurrentPanel(v3);
                    this.add(currentPanel);
                    this.validate();
                    this.repaint();
                    this.requestFocus();

                    labelVoortgang2.setForeground(Color.black);
                    labelVoortgang2.setOpaque(false);
                    labelVoortgang3.setOpaque(true);
                    labelVoortgang3.setForeground(Color.red);
                    labelVoortgang3.setBackground(Color.yellow);
                    return;
                }
            }

            if (currentPanel instanceof GUI_venster3) {
                if (!((GUI_venster3) currentPanel).checkOfAllesIngevuldIs())
                    JOptionPane.showMessageDialog(null, "Gelieve uw betaalmethode aan te duiden en een geldig e-mailadres op te geven.");
                else {
                    int input = JOptionPane.showConfirmDialog(null, "De tickets worden gereserveerd en het programma wordt afgesloten.", "Reservatie bevestigen", JOptionPane.OK_CANCEL_OPTION);
                    if (input == JOptionPane.OK_OPTION)
                        System.exit(0);
                    return;
                }
            }
        });
    }

    public GUI_venster1 getVenster1() {
        return (GUI_venster1) v1;
    }

    public GUI_venster2 getVenster2() {
        return (GUI_venster2) v2;
    }

    public GUI_venster3 getVenster3() {
        return (GUI_venster3) v3;
    }

    /**
     * Subklasse voor het event om in de menubalk het programma af te sluiten.
     */
    public class EventSluiten implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    /**
     * Subklasse voor event om een e-mailadres te laten zien indien op Help wordt gedrukt in het menu.
     */
    public class EventHelp implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showConfirmDialog(null, "Hulp nodig? Mail ons via thomas.jonas@student.uantwerpen.be", "Help", JOptionPane.DEFAULT_OPTION);
        }
    }


}
