import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameMove extends Frame implements MouseListener, WindowListener{
    public static final int MASU = 8;
    private static final int M_S = 60;
    private static final int WIDTH = M_S * MASU;
    private static final int HEIGHT = WIDTH;
    private static final int BLACK = 1;
    private static final int WHITE = 2;
    private boolean wb = true;

    private int[][] BOARD = new int[][]
        {{0,0,0,0,0,0,0,0},
          {0,0,0,0,0,0,0,0},
          {0,0,0,0,0,0,0,0},
          {0,0,0,1,2,0,0,0},
          {0,0,0,2,1,0,0,0},
          {0,0,0,0,0,0,0,0},
          {0,0,0,0,0,0,0,0},
          {0,0,0,0,0,0,0,0}};
    private final int[][] dire = new int[][]
        {{ 1, 0},
          { 0, 1},
          {-1, 0},
          { 0,-1},
          { 1, 1},
          {-1,-1},
          { 1,-1},
          {-1,1}};
    private int[] BXY = new int[8];
    private int[][] XY = new int[8][2];

    public GameMove() {
        setSize(WIDTH+17, HEIGHT+40);
        addMouseListener(this);
        addWindowListener(this);
        setVisible(true);
    }
    public void paint(Graphics g) {
        g.setColor(new Color(34, 139,34));
        g.fillRect(0,0,600,600);
        for(int i = 0; i < MASU; i++) {
            for(int j = 0; j < MASU; j++) {
                g.setColor(Color.BLACK);
                g.drawRect((i*M_S)+8,(j*M_S)+31,M_S,M_S);
                if (BOARD[i][j] == 0) {
                    continue;
                } else if (BOARD[i][j] == BLACK) {
                    g.setColor(Color.BLACK);
                } else if (BOARD[i][j] == WHITE){
                    g.setColor(Color.WHITE);
                }
                g.fillOval((j*M_S+3)+8,(i*M_S+3)+31,M_S-6,M_S-6);
            }
        }
    }
    public void putStone(int x, int y) {
    }
    public void change() {
    }
    public void mouseClicked(MouseEvent e) {
        int x = ((e.getX()-8)/M_S);
        int y = ((e.getY()-31)/M_S);
        putStone(x, y);
        repaint();
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    public void windowClosing(WindowEvent e){
         System.exit(0);
    }
    public void windowOpened(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
}