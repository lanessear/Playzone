package take02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by Lanessear on 29.05.2017.
 */
public class Main {
    private static Fight fight;
    public static void main(String[] meeps) {
        int playerHP = 0;
        int playerATK = 0;
        int playerHIT = 0;

        /**
         * Überprüfung auf fehlerhafte Eingabe
         */

        if (meeps.length > 3 || meeps.length < 3) {
            System.out.println("Wrong input. It should be: [HP] [DMG] [HIT]");
            return;
        } else {
            for (int i = 0; i < meeps.length; i++) {
                Scanner scanner = new Scanner(meeps[i]);
                if (!scanner.hasNextInt()) {
                    System.out.println(" The " + (i + 1) + " argument : "
                            + meeps[i] + " is not a number.");
                    return;
                }

                playerHP = Integer.parseInt(meeps[0]);
                playerATK = Integer.parseInt(meeps[1]);
                playerHIT = Integer.parseInt(meeps[2]);

                switch (i) {
                    case 0:
                        if (playerHP <= 0) {
                            System.out.println("The HP are too low.");
                            return;
                        }
                    case 1:
                    if (playerATK <= 0) {
                        System.out.println("The ATK is too low.");
                        return;
                    }
                    case 2:
                    if (playerHIT <= 0) {
                        System.out.println("The HIT is too low.");
                    }
                    if (playerHIT >= 100) {
                        System.out.println("The HIT is too high.");
                        return;
                    }
                }
            }
        }

        /**
         * Initialisierung des Spiels
         */

        boolean end = false;

        Player player = new Player(playerHP, playerATK, playerHIT);
        Enemy enemy = new Enemy(0, 0, 0);
        Window window = new Window(800, 550);

        System.out.print("You fight against the ");

        int ranNum = (int) (Math.random() * 3);

        if (ranNum == 0) {
            enemy = new Enemy(player.getHP() * 2,
                    player.getATK() / 2, 50);
            System.out.println("standard enemy.");
        }

        if (ranNum == 1) {
            enemy = new MonsterSp1(player.getHP() * 2,
                    player.getATK() / 2, 50,
                    player.getATK() / 5);
            System.out.println("shield enemy.");
        }

        if (ranNum == 2) {
            enemy = new MonsterSp2(player.getHP() * 2,
                    player.getATK() / 2, 50);
            System.out.println("healing enemy.");
        }

        fight = new Fight(player, enemy, window);
    }
}
