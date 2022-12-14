import javax.swing.JPanel;
import java.awt.Graphics;

public class ShowRecs extends JPanel {

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(180, 500 - Quiz.height1, 50, Quiz.height1);
        g.drawRect(230, 500 - Quiz.height2, 50, Quiz.height2);
        g.drawRect(280, 500 - Quiz.height3, 50, Quiz.height3);
    }

    public static void main(String[] args) {

    }
}
