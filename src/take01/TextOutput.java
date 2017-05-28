package take01;

import javax.swing.*;

/**
 * Created by Lanessear on 28.05.2017.
 */
public class TextOutput {
    private JLabel[] l = new JLabel[11];
    private int currentLine = 0;

    public TextOutput() {
        for (int i = 0; i < l.length; i++) {
            l[i] = new JLabel();
        }
    }

    public void nextLine() {
        l[currentLine++].setText(" ");
    }

    public void addLabel(JPanel p) {
        for (int i = 0; i < l.length; i++) {
            p.add(l[i]);
        }
    }

    public JLabel getLabel(int i) {
        return this.l[i];
    }

    public void setLabel(String output) {
        int lineLength = 20;
        if (output.length() > lineLength * l.length + 1) {
            System.out.println("Invalid Input");
            return;
        }
        if (output.length() <= lineLength) {
            l[currentLine++].setText(output);
        } else {
            char[] x = new char[output.length()];
            int y = 0;
            while(currentLine < l.length) {
                String out = "";
                for (int i = 0; i < lineLength; i++) {
                    x[i] = output.charAt(y);
                    out = out + x[i];
                    y++;
                    System.out.println(y);
                    if(y + 1 > output.length()) {
                        l[currentLine++].setText(out);
                        return;
                    }
                }
                l[currentLine++].setText(out);
            }

        }
    }

    public int getCurrentLine() {
        return currentLine;
    }
}
