package SDE_main;

public class Player {
    private String name;
    private int hp;
    private int str;
    private int def;
    private int will;
    private int dex;

    public Player(String name) {
        setHero(name);
    }

    private void setHero(String name) {
        switch (name) {
            case "A":
                this.name = "Princess";
                this.hp = 5;
                break;
            case "B":
                this.name = "Knight";
                this.hp = 5;
                break;
            case "C":
                this.name = "King";
                this.hp = 5;
                break;
            case "D":
                this.name = "Queen";
                this.hp = 5;
                break;
        }
    }

    public String getName() {
        return name;
    }
}
