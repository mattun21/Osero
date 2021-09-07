import javax.swing.*;
public class Osero extends JFrame {
    private final int MASU = 8;
    private final int M_S = 60;
    private final int WIDTH = M_S * MASU;
    private final int HEIGHT = WIDTH;

    public static void main(String[] args) {
        Osero frame = new Osero("Othello");
    }
    public Osero(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH+17, HEIGHT+40);
        setTitle("Othello");
        setVisible(true);
        GameMove gm = new GameMove();
        super.add(gm);
    }
}