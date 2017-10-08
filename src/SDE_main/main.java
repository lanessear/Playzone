package SDE_main;

public class main {

    public static void main(String[] meeps) {
        System.out.println("Checking input...");
        for(int i = 0; i < meeps.length; i++) {
            System.out.print(meeps[i] + " ");
            if(i == meeps.length-1) {
                System.out.println("\n");
            }
        }

        Board game = new Board(meeps);

        for(int i = 0; i < meeps.length; i++) {
            System.out.println(game.player[i].getName());
        }
    }
}
