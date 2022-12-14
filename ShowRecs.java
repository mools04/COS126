import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class ShowRecs extends JPanel {

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawRect(85, 500 - Quiz.height1, 100, Quiz.height1);
        g.fillRect(85, 500 - Quiz.height1, 100, Quiz.height1);
        g.setColor(Color.YELLOW);
        g.drawRect(185, 500 - Quiz.height2, 100, Quiz.height2);
        g.fillRect(185, 500 - Quiz.height2, 100, Quiz.height2);
        g.setColor(Color.GREEN);
        g.drawRect(285, 500 - Quiz.height3, 100, Quiz.height3);
        g.fillRect(285, 500 - Quiz.height3, 100, Quiz.height3);
        g.setColor(Color.BLACK);
        g.drawString(Quiz.a, 185, 500 - Quiz.height2);
        g.drawString(Quiz.b, 85, 500 - Quiz.height1);
        g.drawString(Quiz.c, 285, 500 - Quiz.height3);
    }

    public static void main(String[] args) {

    }
}
