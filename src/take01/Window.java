package take01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lanessear on 28.05.2017.
 */
public class Window implements ActionListener {
    private DefaultWindow screen;

    public Window() {
        String title = "My Game";
        int x = 800;
        int y = 550;
        screen = new DefaultWindow(title, x, y);
        createActionListener();
    }

    public void createActionListener() {
        for(int i = 0; i < screen.getButtonLength(); i++) {
            screen.getButton(i).addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        screen.redraw();
    }
}
