package take01;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lanessear on 28.05.2017.
 */
public class DefaultWindow extends JFrame {
    private JPanel[] panel = new JPanel[6];
    private JButton[] button = new JButton[5];
    private JLabel label = new JLabel("XXX");
    private int potions;
    private int playerHP;
    private int enemyHP;
    private int sizeX;
    private int sizeY;

    public DefaultWindow(String title, int sizeX, int sizeY, int potions, int playerHP, int enemyHP) {
        super(title);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.potions = potions;
        this.playerHP = playerHP;
        this.enemyHP = enemyHP;
        setSize(sizeX, sizeY);
        setLayout(new GridLayout(3, 2));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initWindow();
    }

    /**
     * exchangable variables depending on the window
     */
    protected void initWindow() {
        for(int i = 0; i < button.length; i++) {
            button[i] = new JButton();
        }

        for(int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel();
        }

        initPanels();
    }

    protected void initPanels() {
        initWestTop(panel[0], potions, playerHP);
        initWestBottom(panel[2], enemyHP);
        initEast(panel[1]);
        initSouth(panel[4]);
        initSwitch(panel[5]);

        for(JPanel aPanel : panel) {
            add(aPanel);

            setVisible(true);
        }
    }

    private void initWestTop(JPanel p, int potions, int hp) {
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        TextOutput text = new TextOutput();
        text.setLabel("Potions: " + potions);
        text.nextLine();
        text.setLabel("HP: " + hp);
        text.addLabel(p);
    }

    private void initWestBottom(JPanel p, int hp) {
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        TextOutput text = new TextOutput();
        text.nextLine();
        text.nextLine();
        text.setLabel("HP: " + hp);
        text.addLabel(p);
    }

    private void initEast(JPanel p) {
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(label);
    }

    private void initSouth(JPanel p) {
        p.setLayout(new GridLayout(2, 2));
        printSouth(p);
    }

    private void initSwitch(JPanel p) {
        p.setLayout(new GridLayout());

        p.add(button[4]);
    }

    public void printEast(String output) {
        label.setText(output);
        System.out.println(output);
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
        for (JPanel aPanel : panel) {
            aPanel.setVisible(false);
            aPanel.removeAll();
            aPanel.setVisible(true);
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

    public int getPotions(){
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public int getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(int hp) {
        this.playerHP = hp;
    }

    public int getEnemyHP() {
        return enemyHP;
    }

    public void setEnemyHP(int hp) {
        this.enemyHP = hp;
    }
}
