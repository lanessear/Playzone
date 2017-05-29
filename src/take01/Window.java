package take01;

/**
 * Created by Lanessear on 28.05.2017.
 */
public class Window {
    private DefaultWindow screen;
    private Player player;
    private Enemy enemy;
    private String title;
    private int x;
    private int y;

    public Window(Player player, Enemy enemy) {
        title = "My Game";
        x = 800;
        y = 550;
        this.player = player;
        this.enemy = enemy;
        screen = new DefaultWindow(title, x, y, player.getPotions(), player.getHp(), enemy.getHp());
    }

    public DefaultWindow getScreen() {
        return screen;
    }

    public void defaultWindow() {
        screen.dispose();
        screen = new DefaultWindow(title, x, y, player.getPotions(), player.getHp(), enemy.getHp());
    }

    public void itemWindow() {
        screen.dispose();
        screen = new ItemWindow(title, x, y);
    }

    public String getTitle() {
        return title;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
