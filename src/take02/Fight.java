package take02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by Lanessear on 29.05.2017.
 */
public class Fight implements ActionListener {
    private Scanner sc = new Scanner(System.in);
    private Window w;
    private Player player;
    private Enemy enemy;
    private int damage;
    private int input;

    private boolean end = false;

    /**
     * Der Konstruktor für den Kampf.
     *
     * @param player initialisiert den Spieler, der für diese Klasse verwendet
     *               werden soll.
     * @param enemy  initialisiert das Monster, das für diese Klasse verwendet
     *               werden soll.
     */

    public Fight(Player player, Enemy enemy, Window window) {
        this.player = player;
        this.enemy = enemy;
        this.w = window;
        createActionListener();
    }

    /**
     * Die Methode move prüft, welchen Zug der Spieler wählt.
     *
     * @return move gibt zurück, welchen der beiden Züge der Spieler wählt.
     */

    public int move() {
        int move = 2;

        switch (input) {
            case 0:
                move = 0;
                break;
            case 1:
                move = 1;
                break;
        }
        return move;
    }

    /**
     * Die Methode turn prüft, ob das Spiel endet, indem es prüft, ob
     * die HP des Monsters oder des Spielers auf oder unter 0 gesunken sind.
     * Die Methode führt den Zug des Spielers aus und gibt die jeweiligen Nachrichten
     * aus.
     *
     * @return end gibt zurück, ob das Spiel beendet werden kann/soll.
     */

    public String turn() {
        String output = "";
        String extra = " ";
        if (move() != 2) {
            if (move() == 1) {
                if (player.usePotion()) {
                    output = "Player used potion and healed for 50 HP.";
                } else {
                    output = "No potions left.";
                }
            } else if (move() == 0) {
                int initialHpMonster = enemy.getHP();
                enemy.takeDamage(player.calculateAttackDamage());
                damage = initialHpMonster - enemy.getHP();
                if (enemy.getHP() <= 0) {
                    enemy.setHP(0);
                    output = "Monster took " + damage + " damage from Player and is defeated.\tPlayer wins!";
                    end = true;
                } else {
                    output = "Monster took " + damage + " damage from Player!";
                }
            }

            if (!end) {
                int initialHpMonster = enemy.getHP();
                int initialHpPlayer = player.getHP();
                player.takeDamage(enemy.calculateAttackDamage());
                damage = initialHpPlayer - player.getHP();
                if (player.getHP() <= 0) {
                    player.setHP(0);
                    output = output + "\tPlayer took " + damage + " damage from Enemy and is defeated.\tPlayer loses!";
                } else {
                    output = output + "\tPlayer took " + damage + " damage from Enemy!";
                    if (initialHpMonster < enemy.getHP()) {
                        extra = "Monster healed for " + damage + " HP.";
                    }
                }
            }
        }
        output = output + "\t" + player.getHealPotions();
        output = output + "\t" + player.getHP();
        output = output + "\t" + enemy.getHP();
        output = output + "\t" + extra;
        return output;
    }

    private void createActionListener() {
        for (int i = 0; i < w.getScreen().getButtonLength(); i++) {
            w.getScreen().getButton(i).addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        switch (w.getScreen().whichWindow) {
            case 0:
                if (ae.getSource() == w.getScreen().getButton(0)) {
                    System.out.println("Button 1");
                    if(player.getHP() == 0 || enemy.getHP() == 0) {
                        return;
                    }
                    input = 0;
                } else if (ae.getSource() == w.getScreen().getButton(1)) {
                    System.out.println("Button 2");
                    if(player.getHP() == 0 || enemy.getHP() == 0) {
                        return;
                    }
                    input = 1;
                } else if (ae.getSource() == w.getScreen().getButton(2)) {
                    System.out.println("Button 3");
                }
                w.setScreen(new DefaultScreen(w, turn()));
                break;
            case 1:
                if (ae.getSource() == w.getScreen().getButton(0)) {
                } else if (ae.getSource() == w.getScreen().getButton(1)) {
                } else if (ae.getSource() == w.getScreen().getButton(2)) {
                    w.setScreen(new DefaultScreen(w, turn()));
                    createActionListener();
                    return;
                }
                w.setScreen(new ItemScreen(w));
                break;
            default:
                return;
        }
        createActionListener();
    }

}
