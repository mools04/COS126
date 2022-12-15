import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;


// ShowRecs.java draws a bar graph representing the three majors with the
// highest point totals on the final slide, with the top major in the middle,
// second-highest major on the left, and the third-highest major on the right
// using Graphics2D
public class ShowRecs extends JPanel {

    public void paint(Graphics g) {
        // initialize/declare constants for height, width, scale factor
        // and positions of bars for bar graph
        int size = 500;
        int x1 = 85;
        int x2 = 185;
        int x3 = 285;
        int w = 100;
        int scale = 15;
        int scale2 = 10;
        int height1 = Quiz.height1 + scale2;
        int height2 = Quiz.height2 + scale2;
        int height3 = Quiz.height3 + scale2;
        // Split top three majors into single words, so they fit on the bars
        String[] top = Quiz.a.split(" ");
        String[] second = Quiz.b.split(" ");
        String[] third = Quiz.c.split(" ");
        // find number of words in each string array
        int len1 = top.length;
        int len2 = second.length;
        int len3 = third.length;
        super.paint(g);
        // draw red rectangle for second-highest major
        g.setColor(Color.RED);
        g.drawRect(x1, size - height1, w, height1);
        g.fillRect(x1, size - height1, w, height1);
        // draw yellow rectangle for top major
        g.setColor(Color.YELLOW);
        g.drawRect(x2, size - height2, w, height2);
        g.fillRect(x2, size - height2, w, height2);
        // draw green rectangle for third-highest major
        g.setColor(Color.GREEN);
        g.drawRect(x3, size - height3, w, height3);
        g.fillRect(x3, size - height3, w, height3);
        g.setColor(Color.BLACK);
        // Put major names on respective bars (one word on each line)
        for (int i = 0; i < len1 - 1; i++) {
            g.drawString(top[i], x2, size - (height2) + (i * scale));
        }
        // last word will have the ranking number after it
        g.drawString(top[len1 - 1] + ": " + Quiz.point.get(Quiz.a), x2, size -
                (height2) + ((len1 - 1) * scale));
        for (int i = 0; i < len2 - 1; i++) {
            g.drawString(second[i], x1, size - (height1) + (i * scale));
        }
        // last word will have the ranking number after it
        g.drawString(second[len2 - 1] + ": " + Quiz.point.get(Quiz.b), x1, size -
                (height1) + ((len2 - 1) * scale));
        for (int i = 0; i < len3 - 1; i++) {
            g.drawString(third[i], x3, size - (height3) + (i * scale));
        }
        // last word will have the ranking number after it
        g.drawString(third[len3 - 1] + ": " + Quiz.point.get(Quiz.c), x3, size -
                (height3) + ((len3 - 1) * scale));

    }

    public static void main(String[] args) {
        
    }
}
