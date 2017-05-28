package take01;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lanessear on 28.05.2017.
 */
public class DefaultWindow extends JFrame {
    private JPanel[] panel = new JPanel[4];
    private JButton[] button = new JButton[6];
    private int sizeX;
    private int sizeY;

    public DefaultWindow(String title, int sizeX, int sizeY) {
        super(title);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        setSize(sizeX, sizeY);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        for(int i = 0; i < button.length - 1; i++) {
            button[i] = new JButton();
        }

        for(int i = 0; i < panel.length - 1; i++) {
            panel[i] = new JPanel();
        }

        initWindow();
    }

    /**
     * exchangable variables depending on the window
     */
    protected void initWindow() {
        initPanels();
    }

    private void initPanels() {
        initWest(panel[0]);
        initEast(panel[1]);
        initSouth(panel[2]);

        for(int  i = 0; i < panel.length; i++) {
            panel[i].setVisible(true);
            add(panel[i]);
        }
    }

    private void initWest(JPanel p) {
        p.setSize((this.sizeX / 2), (this.sizeY / 2 + this.sizeY / 5));
        p.add(new JLabel("yusss"));
        printWest(p);
    }

    private void initEast(JPanel p) {
        p.setSize((this.sizeX / 2), (this.sizeY / 2 + this.sizeY / 5));
        printEast(p);
    }

    private void initSouth(JPanel p) {
        p.setSize(this.sizeX, (this.sizeY - (this.sizeY / 2 + this.sizeY / 5)));
        p.setLayout(new GridLayout(3, 2));
        printSouth(p);
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
        for(int i = 0; i < panel.length - 1; i++) {
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
