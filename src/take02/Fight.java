package take02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by Lanessear on 29.05.2017.
 */
public class Fight implements ActionListener{
    private Scanner sc = new Scanner(System.in);
    private Window w;
    private Player player;
    private Enemy enemy;
    private int damage;
    private int input;

    private boolean end = false;

    /**
     * Der Konstruktor für den Kampf.
     * @param player initialisiert den Spieler, der für diese Klasse verwendet
     * werden soll.
     * @param enemy initialisiert das Monster, das für diese Klasse verwendet
     * werden soll.
     */

    public Fight(Player player, Enemy enemy, Window window) {
        this.player = player;
        this.enemy = enemy;
        this.w = window;
        createActionListener();
    }

    /**
     * Die Methode move prüft, welchen Zug der Spieler wählt. Außerdem prüft sie,
     * ob eine valide Eingabe getätigt wurde und fragt erneut ab, wenn dies nicht
     * geschehen ist.
     * @return move gibt zurück, welchen der beiden Züge der Spieler wählt.
     */

    public boolean move() {
        boolean wrongInput = false;
        boolean move = true;

        do {
            wrongInput = false;
            if (!this.end) {
                System.out.println("Use:\n(0) Potion\n(1) Attack");
            }

            System.out.print("You enter: ");

            switch (input) {
                case 0:
                    move = false;
                    break;
                case 1:
                    move = true;
                    break;
                default:
                    wrongInput = true;
                    System.out.println("Invalid input!");
                    System.out.println("--------------");
            }
        } while (wrongInput);
        System.out.println("--------------");
        return move;
    }

    /**
     * Die Methode turn prüft, ob das Spiel endet, indem es prüft, ob
     * die HP des Monsters oder des Spielers auf oder unter 0 gesunken sind.
     * Die Methode führt den Zug des Spielers aus und gibt die jeweiligen Nachrichten
     * aus.
     * @return end gibt zurück, ob das Spiel beendet werden kann/soll.
     */

    public boolean turn() {
        boolean end = false;
        if (!this.move()) {
            if (player.usePotion()) {
                w.getScreen().getPanel(3).add(new JLabel("Player used potion and healed for 50 HP."));
            } else {
                w.getScreen().getPanel(3).add(new JLabel("No potions left."));
            }
        } else {
            int initialHpMonster = enemy.getHP();
            enemy.takeDamage(player.calculateAttackDamage());
            damage = initialHpMonster - enemy.getHP();
            if (enemy.getHP() <= 0) {
                w.getScreen().getPanel(3).add(new JLabel("Monster took " + damage + " damage from "
                        + "Player and is defeated." + "\nPlayer wins!"));
                end = true;
            } else {
                w.getScreen().getPanel(1).add(new JLabel("Monster took " + damage + " damage from Player!"));
            }
        }

        if (!end) {
            int initialHpMonster = enemy.getHP();
            int initialHpPlayer = player.getHP();
            player.takeDamage(enemy.calculateAttackDamage());
            damage = initialHpPlayer - player.getHP();
            if (player.getHP() <= 0) {
                w.getScreen().getPanel(3).add(new JLabel("Player took " + damage + " damage from "
                        + "Enemy and is defeated." + "\nPlayer loses!"));
                end = true;
            } else {
                w.getScreen().getPanel(1).add(new JLabel("Player took " + damage + " damage from Enemy!"));
                if (initialHpMonster < enemy.getHP()) {
                    w.getScreen().getPanel(1).add(new JLabel("Monster healed for " + damage + " HP."));
                }
            }
        }

        return end;
    }

    private void createActionListener() {
        for(int i = 0; i < w.getScreen().getButtonLength(); i++) {
            w.getScreen().getButton(i).addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        w.getScreen().redraw();
        switch(w.getScreen().whichWindow) {
            case 0:
                if(ae.getSource() == w.getScreen().getButton(0)) {
                    input = 1;
                    w.setScreen(new DefaultScreen(w));
                } else if(ae.getSource() == w.getScreen().getButton(1)) {
                    input = 0;
                    w.setScreen(new DefaultScreen(w));
                } else if(ae.getSource() == w.getScreen().getButton(2)) {
                    input = 5;
                    w.setScreen(new ItemScreen(w));
                }
                break;
            case 1:
                if(ae.getSource() == w.getScreen().getButton(0)) {
                    w.setScreen(new ItemScreen(w));
                } else if(ae.getSource() == w.getScreen().getButton(1)) {
                    w.setScreen(new ItemScreen(w));
                } else if(ae.getSource() == w.getScreen().getButton(2)) {
                    input = 5;
                    w.setScreen(new DefaultScreen(w));
                }
                break;
            default: return;
        }
        createActionListener();
    }
}
