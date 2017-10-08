package SDE_main;

public class Board {
    private int players;
    private int wrath;
    private int segments;
    private int spawn_points;

    public Player player[];
    private Segment segment[];
    private Spawn_Point spawn_point[];

    public Board(String[] players) {
        initBoard(players);
    }

    private void initBoard(String[] x) {
        this.players = x.length;
        this.wrath = x.length * 2 - 1;
        this.segments = players;
        this.spawn_points = segments;

        this.player = new Player[players];
        this.segment = new Segment[segments];
        this.spawn_point = new Spawn_Point[spawn_points];

        choosePlayer(x);
    }

    private void choosePlayer(String[] names) {
        for (int i = 0; i < player.length; i++) {
            player[i].setHero(names[i]);
        }
    }
}
