package take02;

/**
 * Created by Lanessear on 29.05.2017.
 */
public class ItemScreen extends DefaultScreen {
    public ItemScreen(Window w) {
        super(w, " ");
        whichWindow = 1;
        w.setTitle("Items");

        b[0].setText("Up");
        b[1].setText("Down");
        b[2].setText("Back");
    }
}
