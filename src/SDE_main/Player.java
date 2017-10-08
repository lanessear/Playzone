package SDE_main;

public class Player {
    private String name;
    private int hp;

    public void setHero(String name) {
        switch (name) {
            case "A":
                this.name = "Princess";
                this.hp = 5;
            case "B":
                this.name = "Knight";
                this.hp = 5;
            case "C":
                this.name = "King";
                this.hp = 5;
            case "D":
                this.name = "Queen";
                this.hp = 5;
        }
    }

    public String getName() {
        return name;
    }
}
