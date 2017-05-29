package take02;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lanessear on 29.05.2017.
 */
public class DefaultScreen extends JPanel {
    protected JPanel[] p = new JPanel[5];
    protected JButton[] b = new JButton[3];
    protected int whichWindow;
    private String output1;
    private String output2;
    private String output3;
    private String playerHp;
    private String potions;
    private String enemyHp;

    public DefaultScreen(Window w, String input) {
        whichWindow = 0;
        w.setTitle("Fight");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for(int i = 0; i < p.length; i++) {
            p[i] = new JPanel();
            p[i].setLayout(new BoxLayout(p[i], BoxLayout.Y_AXIS));
            if(p[i] == p[p.length - 2]) {
                p[i].setLayout(new GridLayout(1, 2));
                b[0] = new JButton("Attack");
                p[i].add(b[0]);
                b[1] = new JButton("Use Potion");
                p[i].add(b[1]);
            } else if(p[i] == p[p.length - 1]) {
                p[i].setLayout(new GridLayout(1, 2));
                b[2] = new JButton("Start Over");
                p[i].add(b[2]);
            }
        }
        sortOutput(input);

        p[0].add(new JLabel("Player"));
        p[0].add(new JLabel("Potions left: " + potions));
        p[0].add(new JLabel("HP: " + playerHp));

        p[1].add(new JLabel("Enemy"));
        p[1].add(new JLabel("HP: " + enemyHp));

        p[2].add(new JLabel(output1));
        p[2].add(new JLabel(output2));
        p[2].add(new JLabel(output3));

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1, 2));
        top.add(p[0]);
        top.add(p[1]);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 1));
        center.add(p[2]);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(1, 2));
        bottom.add(p[p.length - 2]);
        bottom.add(p[p.length - 1]);

        add(top);
        add(center);
        add(bottom);

        w.add(this);
    }

    private void sortOutput(String input) {
        String[] output = input.split("\t");

        output1 = output[0];
        output2 = output[1];
        potions = output[2];
        playerHp = output[3];
        enemyHp = output[4];
        output3 = output[5];
    }

    public void redraw() {
        setVisible(false);
        remove(this);
    }

    public int getWindow() {
        return whichWindow;
    }

    public JButton getButton(int i) {
        return b[i];
    }

    public int getButtonLength() {
        return b.length;
    }

    public JPanel getPanel(int i) {
        return p[i];
    }
}
