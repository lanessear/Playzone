package take02;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lanessear on 29.05.2017.
 */
public class Window extends JFrame {
    private DefaultScreen s;

    public Window(int x, int y) {
        setSize(x, y);
        setResizable(false);
        setLayout(new GridLayout(1, 1));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        s = new DefaultScreen(this, " \t \tcalculating...\tcalculating...\tcalculating...\t ");
    }

    public DefaultScreen getScreen() {
        return s;
    }

    public void setScreen(DefaultScreen ds) {
        s.redraw();
        remove(s);
        s = ds;
    }
}
