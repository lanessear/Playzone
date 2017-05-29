package take01;

/**
 * Created by Lanessear on 29.05.2017.
 */
public class Entity {
    private String name;
    private int hp;
    private int att;
    private int def;
    private int hit;

    public Entity(String name, int hp, int att, int def, int hit) {
        this.name = name;
        this.hp = hp;
        this.att = att;
        this.def = def;
        this.hit = hit;
    }

    public String attack(Entity victim) {
        String x;
        if(victim.getHp() == 0) {
            victim.setHp(100);
            x = "----------NEW ROUND!---------";
        } else {
            int random = (int) (Math.random() * 100);
            if (this.hit > random) {
                victim.hp = victim.hp - this.att;
                x = this.name + " hit " + victim.name + "!";
            } else {
                x = this.name + " missed " + victim.name + "!";
            }
            if (victim.getHp() <= 0 + 1) {
                x = victim.name + " is defeated.";
                victim.setHp(0);
            }
        }
        return x;
    }

    //Getter & Setter

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }
}
