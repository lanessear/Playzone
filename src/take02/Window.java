package take02;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lanessear on 29.05.2017.
 */
public class Window extends JFrame {
    private DefaultScreen s;

    public Window(int x, int y) {
        super();
        s = new DefaultScreen(this);
        setSize(x, y);
        setLayout(new GridLayout(3, 2));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public DefaultScreen getScreen() {
        return s;
    }

    public void setScreen(DefaultScreen ds) {
        s = ds;
    }
}
