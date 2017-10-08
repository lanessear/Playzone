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

    private void initBoard(String[] numOfPlayers) {
        this.players = numOfPlayers.length;
        this.wrath = numOfPlayers.length * 2 - 1;
        this.segments = players;
        this.spawn_points = segments;

        this.player = new Player[players];
        this.segment = new Segment[segments];
        this.spawn_point = new Spawn_Point[spawn_points];

        initPlayer(numOfPlayers);
    }

    private void initPlayer(String[] names) {
        for (int i = 0; i < player.length; i++) {
            player[i] = new Player(names[i]);
        }
    }
}
