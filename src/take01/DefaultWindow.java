package take01;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lanessear on 28.05.2017.
 */
public class DefaultWindow extends JFrame {
    private JPanel[] panel = new JPanel[6];
    private JButton[] button = new JButton[5];
    private int sizeX;
    private int sizeY;

    public DefaultWindow(String title, int sizeX, int sizeY) {
        super(title);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        setSize(sizeX, sizeY);
        setLayout(new GridLayout(3, 2));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        for(int i = 0; i < button.length; i++) {
            button[i] = new JButton();
        }

        for(int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel();
        }

        initWindow();
    }

    /**
     * exchangable variables depending on the window
     */
    protected void initWindow() {
        initPanels();

        setVisible(true);
    }

    private void initPanels() {
        initWest(panel[0]);
        initEast(panel[1]);
        initSouth(panel[4]);
        initSwitch(panel[5]);

        for(int  i = 0; i < panel.length; i++) {
            add(panel[i]);
        }
    }

    private void initWest(JPanel p) {
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        TextOutput text = new TextOutput();
        text.setLabel("Potions: ");
        text.nextLine();
        text.setLabel("HP: ");
        text.addLabel(p);
        printWest(p);
    }

    private void initEast(JPanel p) {
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        TextOutput text = new TextOutput();
        text.setLabel("Potions: ");
        text.nextLine();
        text.setLabel("HP: ");
        text.addLabel(p);
        printEast(p);
    }

    private void initSouth(JPanel p) {
        p.setLayout(new GridLayout(2, 2));
        printSouth(p);
    }

    private void initSwitch(JPanel p) {
        p.setLayout(new GridLayout());

        p.add(button[4]);
    }

    private void printWest(JPanel p) {
    }

    private void printEast(JPanel p) {
    }

    private void printSouth(JPanel p) {
        button[0].setText("Attack1");
        button[1].setText("Attack2");
        button[2].setText("Attack3");
        button[3].setText("Attack4");
        button[4].setText("Items");

        for(int i = 0; i < button.length - 1; i++) {
            p.add(button[i]);
        }
    }

    public void redraw() {
        for(int i = 0; i < panel.length; i++) {
            panel[i].setVisible(false);
            panel[i].removeAll();
            panel[i].setVisible(true);
        }
    }

    /**
     * Getter & Setter
     */

    public int getButtonLength() {
        return button.length;
    }

    public JButton getButton(int i) {
        return button[i];
    }
}