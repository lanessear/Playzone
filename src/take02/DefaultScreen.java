package take02;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lanessear on 29.05.2017.
 */
public class DefaultScreen extends JPanel {
    protected JPanel[] p = new JPanel[6];
    protected JButton[] b = new JButton[3];
    protected int whichWindow;

    public DefaultScreen(Window w) {
        whichWindow = 0;
        w.setTitle("My Game");

        for(int i = 0; i < p.length; i++) {
            p[i] = new JPanel();
            p[i].setLayout(new BoxLayout(p[i], BoxLayout.Y_AXIS));
            if(p[i] == p[4]) {
                p[i].setLayout(new GridLayout(1, 2));
                b[0] = new JButton("Attack");
                p[i].add(b[0]);
                b[1] = new JButton("Use Potion");
                p[i].add(b[1]);
            } else if(p[i] == p[5]) {
                p[i].setLayout(new GridLayout(1, 2));
                b[2] = new JButton("Items");
                p[i].add(b[2]);
            }
            w.add(p[i]);
        }
    }

    public void redraw() {
        setVisible(false);
        removeAll();
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
