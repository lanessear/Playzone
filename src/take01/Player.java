package take01;

/**
 * Created by Lanessear on 29.05.2017.
 */
public class Player extends Entity {
    private int potions = 0;
    public Player(String name, int hp, int att, int def, int hit) {
        super(name, hp, att, def, hit);
    }

    public int getPotions() {
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }
}
