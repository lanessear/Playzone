package take02;

/**
 * Created by Lanessear on 29.05.2017.
 */
public class Enemy extends Entity {
    /**
     * Der Konstruktor für das Monser, der die Werte der parent-Klasse übernimmt.
     * @param hp liest die vorgegebenen HP für das Monster ein.
     * @param atk liest die vorgegebenen Schadenspunkte für das Monster ein.
     * @param hit liest die vorgegebene Hitchance für das Monster ein.
     */

    protected Enemy(int hp, int atk, int hit) {
        super(hp, atk, hit);
    }
}
