import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    private JRadioButton button1;
    private JRadioButton button2;
    private JRadioButton button3;
    private JRadioButton button4;

    // makes the quiz frame
    public Quiz() {
        this.setTitle("MajrFindr");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);

        JLabel title = new JLabel();
        title.setText("Welcome to MajrFindr - Your Virtual Academic Advisor");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.TOP);
        this.add(title);
    }

    public void askQuestion(String[] questions) {
        ButtonGroup group = new ButtonGroup();

        button1 = new JRadioButton(questions[0]);
        button2 = new JRadioButton(questions[1]);
        button3 = new JRadioButton(questions[2]);
        button4 = new JRadioButton(questions[3]);

        button1.setBounds(200, 160, 100, 30);
        button2.setBounds(200, 190, 100, 30);
        button3.setBounds(200, 220, 100, 30);
        button4.setBounds(200, 250, 100, 30);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            StdOut.println("button 1 was pressed!");
        }
        else if (e.getSource() == button2) {
            StdOut.println("button 2 was pressed!");
        }
        else if (e.getSource() == button3) {
            StdOut.println("button 3 was pressed!");
        }
        else if (e.getSource() == button4) {
            StdOut.println("button 4 was pressed!");
        }
    }

    public static void main(String[] args) {
        String[] q = { "question 1", "question 2", "question 3", "question 4" };
        Quiz quiz = new Quiz();
        quiz.askQuestion(q);
        // tests each method
    }
}
