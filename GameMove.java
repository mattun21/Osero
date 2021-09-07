import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameMove extends JPanel implements MouseListener {
    public static final int MASU = 8;
    public static final int M_S = 60;
    public static final int BLACK = 1;
    public static final int WHITE = 2;
    private static final int WIDTH = M_S * MASU;
    private static final int HEIGHT= M_S * MASU;
    private boolean wb = true;

    private int[][] BOARD = new int[][] {{0,0,0,0,0,0,0,0},
                                                          {0,0,0,0,0,0,0,0},
                                                          {0,0,0,0,0,0,0,0},
                                                          {0,0,0,1,2,0,0,0},
                                                          {0,0,0,2,1,0,0,0},
                                                          {0,0,0,0,0,0,0,0},
                                                          {0,0,0,0,0,0,0,0},
                                                          {0,0,0,0,0,0,0,0}};

    private final int[][] dire = new int[][] {{ 1, 0},{ 1,-1},{ 0,-1},{-1,-1},
                                                            {-1, 0},{-1, 1},{ 0, 1},{ 1, 1}};
    private int[] BXY = new int[8];
    private int[][] XY = new int[8][2];

    public GameMove() {
        setSize(WIDTH, HEIGHT);
        addMouseListener(this);
    }
    public void paint(Graphics g) {
        g.setColor(new Color(34,139,34));
        g.fillRect(1,1,WIDTH-1, HEIGHT-1);
        for(int i = 0; i < MASU; i++) {
            for(int j = 0; j < MASU; j++) {
                g.setColor(Color.BLACK);
                g.drawRect((i*M_S),(j*M_S),M_S,M_S);
                switch (BOARD[i][j]){
                    case 1: g.setColor(Color.BLACK);      break;
                    case 2: g.setColor(Color.WHITE);      break;
                    case 0: continue;
                } 
                g.fillOval((j*M_S+3),(i*M_S+3),M_S-6,M_S-6);
            }
        }
    }
    public void putStone(int x, int y) {
        int stone, a, b;
        if(wb) {
            stone = BLACK;
        } else {
            stone = WHITE;
        }
        for(int i = 0; i < 8;i++) {
            a = x;    b = y;
            for(int j = 0;j < 8; j++) {
                a = a + dire[i][0];
                b = b + dire[i][1];
                if(a >=0 && a < 8 && b >=0 && b < 8) {
                    BXY[j] = BOARD[b][a];
                    XY[j][0] = a;    XY[j][1] = b;
                }
            }
            change(BXY,XY,stone,x,y);
            for(int j = 0; j<8; j++) {
                XY[j][0] = 0;    XY[j][1] = 0;
                BXY[j] = 0;
            }
        } 
        turn(); 
    }
    public void turn() {
        wb = !wb;
    }
    public void change(int bxy[],int xy[][], int stone,int x, int y) {
        int count= 0;
        for(int i = 0; i < 8; i++) {
            if(bxy[i]==stone) {
                count = i;
                break;
            } else if(bxy[i]==0) {
                count = 0;
                break;
            }
        }
        for(int i = 0; i < count; i++) {
            if(bxy[i]!=0 && bxy[i]!=stone) {
                BOARD[xy[i][1]][xy[i][0]] = stone;
                BOARD[y][x] = stone; 
            }
        }
    }
    public void mouseClicked(MouseEvent e) {
        int x = ((e.getX())/M_S);
        int y = ((e.getY())/M_S);
        putStone(x, y);
        repaint();
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}