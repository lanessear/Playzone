package take01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lanessear on 28.05.2017.
 */
public class Game implements ActionListener{
    private Window screen;
    private Player player;
    private Enemy enemy;

    public Game() {
        player = new Player("Player", 100, 20, 0, 100);
        enemy = new Enemy("Enemy", 100, 20, 0, 55);
        screen = new Window(player, enemy);
        updateScreen();

        player.setPotions(2);
    }

    public void createActionListener() {
        for(int i = 0; i < screen.getScreen().getButtonLength(); i++) {
            screen.getScreen().getButton(i).addActionListener(this);
        }
    }

    private void updateScreen() {
        createActionListener();
        screen.getScreen().setPlayerHP(player.getHp());
        screen.getScreen().setEnemyHP(enemy.getHp());
    }

    public void actionPerformed(ActionEvent ae) {
        //screen.getScreen().redraw();
        if(ae.getSource() == screen.getScreen().getButton(4)) {
            screen.itemWindow();
            updateScreen();
            return;
        } else if(ae.getSource() == screen.getScreen().getButton(0)) {
            screen.getScreen().printEast(player.attack(enemy));
        } else if(ae.getSource() == screen.getScreen().getButton(1)) {

        } else if(ae.getSource() == screen.getScreen().getButton(2)) {

        } else if(ae.getSource() == screen.getScreen().getButton(3)) {

        }
        screen.defaultWindow();
        updateScreen();
    }
}
