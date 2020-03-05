import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {

    Timer timer;
    ArrayList<Sprite> actors;
    int paddingNum = 25;
    Game game;
    long nextMoment;


    public Board(Game game){
        setPreferredSize(new Dimension(600, 800));
        setBackground(Color.BLACK);
        this.game = game;
    }

    public void setUp(){
        actors = new ArrayList<>();
        STATS.updateLevel();
        actors.add(new Player(Color.GREEN, getWidth()/2, getHeight()/2, 25, 25, this, game));
        for (int i = 0; i < STATS.getNumFood(); i++){
            actors.add(new Food(Color.YELLOW, (int)(Math.random()*(getWidth()-paddingNum)+paddingNum), (int)(Math.random()*(getHeight()-paddingNum)+paddingNum), 20, 20, this));
        }
        for(int i = 0; i < STATS.getNumEnemies(); i++){
            actors.add(new Enemy(Color.RED, (int)(Math.random()*(getWidth()-paddingNum)+paddingNum), (int)(Math.random()*(getHeight()-paddingNum)+paddingNum), 50, 50, this));
         }

        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void checkCollisions(){
        for(int i = 1; i < actors.size(); i++){
            if(actors.get(0).collidesWith(actors.get(i))){
                if(actors.get(i) instanceof Enemy){
                    game.notClicked();
                    STATS.setLife(STATS.getLife() - 1);
                    setUp();
                }
                if(actors.get(i) instanceof Food){
                    actors.get(i).setRemove();
                }
            }
        }

        for(int i = actors.size() - 1; i >= 0; i--){
            if(actors.get(i).isRemove()){
                actors.remove(i);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nextMoment = System.currentTimeMillis();
        if (STATS.isPLAY() && STATS.getLife() != 0) {
            if ((nextMoment - game.getMoment()) >= 2000) {
                checkCollisions();
            }
            if (actors.size() <= STATS.getNumEnemies() + 1) {
                System.out.println("Killed em all");
                STATS.setLevel(STATS.getLevel() + 1);
                setUp();
                game.notClicked();
                if(STATS.getLevel()==4)
                    STATS.setEND(true);
            }

        }
        if(game.getIsClicked()){
            STATS.setPLAY(true);
            STATS.setMENU(false);
            STATS.setEND(false);
            for (Sprite thisGuy : actors) {
                thisGuy.move();
            }
        }

        if(STATS.getLife() == 0 && game.getIsClicked()){
            STATS.setLife(3);
            STATS.setPLAY(false);
            STATS.setMENU(true);
        }
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(STATS.isMENU()){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 70));
            printSimpleString("Shapey Shapes", getWidth(), 0, 150, g);
            g.setFont(new Font("Arial", Font.BOLD, 35));
            printSimpleString("Left Click to play", getWidth(), 0, 300, g);
        }

        if(STATS.getLife() == 0){
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 65));
            printSimpleString("YOU DIED!", getWidth(), 0, 150, g);
            g.setFont(new Font("Arial", Font.BOLD, 35));
            printSimpleString("Left Click to retry", getWidth(), 0, 300, g);
        }

        if(STATS.isPLAY() && STATS.getLife() != 0){
            for (Sprite thisGuy : actors) {
                thisGuy.paint(g);
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("seriff", Font.BOLD, 20));
            printSimpleString(" Lives:" + Integer.toString(STATS.getLife()), 50, 5,  20, g);
        }

        if(STATS.isEND()){
            STATS.setPLAY(false);
            g.setColor(Color.WHITE);
            g.setFont(new Font("seriff", Font.BOLD, 20));
            printSimpleString(" You Won", getWidth(), 0, 150, g);
            g.setFont(new Font("Arial", Font.BOLD, 35));
            printSimpleString("Left Click to retry", getWidth(), 0, 300, g);
        }
    }

    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g){
        int stringLen = (int)g.getFontMetrics().getStringBounds(s, g).getWidth();
        int start = width/2 -stringLen/2;
        g.drawString(s, start + XPos, YPos);
    }

}
