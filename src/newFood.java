import java.awt.*;

public class newFood extends Food{
    public newFood(Color color, int x, int y, int width, int height, Board board){
        super(color, x, y, width, height, board);
    }

    public void paint(Graphics g){
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }

}
