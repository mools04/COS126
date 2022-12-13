// to do:
// - get symbol tables organized
// - recommendation at the end w/ graphics
// - add flashy background/font

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    private JRadioButton button1;
    private JRadioButton button2;
    private JLabel title;
    private JLabel question;
    private JButton startButton;
    private String[] ans1;
    private String que1;
    private String[] ans2;
    private String que2;
    private String[] ans3;
    private String que3;
    private String[] ans4;
    private String que4;
    private String[] ans5;
    private String que5;
    private String[] ans6;
    private String que6;
    private int count;

    // symbol table point stuff
    private ST<String, Integer> point = new ST<String, Integer>();
    private int options;
    private int options2;
    private String[] majors;

    // makes the quiz frame
    public Quiz() {
        title = new JLabel();
        title.setText("Welcome to MajrFindr - Your Virtual Academic Advisor!");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);

        startButton = new JButton();
        startButton.setBounds(200, 160, 100, 100);
        startButton.addActionListener(this);
        startButton.setText("START");

        this.setTitle("MajrFindr");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setVisible(true);
        this.add(startButton);
        this.add(title);

        que1 = "Are you more innovative or reflective?";
        ans1 = new String[2];
        ans1[0] = "Innovative";
        ans1[1] = "Reflective";

        que2 = "Are you more analytical or creative?";
        ans2 = new String[2];
        ans2[0] = "Analytical";
        ans2[1] = "Creative";

        que3 = "Are you more theoretical or practical?";
        ans3 = new String[2];
        ans3[0] = "Theoretical";
        ans3[1] = "Practical";

        que4 = "Which is the better first date: stargazing at an observatory "
                + "or a long walk on the beach?";
        ans4 = new String[2];
        ans4[0] = "Stargazing";
        ans4[1] = "Walk on the beach";

        que5 = "Which is a better vacation: skiing at a mountain or touring "
                + "rome?";
        ans5 = new String[2];
        ans5[0] = "Skiing";
        ans5[1] = "Rome";

        que6 = "Two fully-funded internship opportunities arise. One is with "
                + "a public health non-profit in Africa. The other is with "
                + "Goldman Sachs, an investment banking firm in New York. "
                + "They will both equally benefit your career. What is your "
                + "choice?";
        ans6 = new String[2];
        ans6[0] = "Non-profit";
        ans6[1] = "Goldman Sachs";
    }

    public void askQuestion(String[] ans, String q) {
        question = new JLabel();
        question.setText("<html><center>" + q + "</center></html>");
        question.setHorizontalAlignment(JLabel.CENTER);
        question.setVerticalAlignment(JLabel.TOP);
        question.setBounds(JLabel.CENTER, JLabel.TOP, 500, 100);

        ButtonGroup group = new ButtonGroup();

        button1 = new JRadioButton(ans[0]);
        button2 = new JRadioButton(ans[1]);

        button1.setBounds(200, 160, 200, 30);
        button2.setBounds(200, 190, 200, 30);

        button1.addActionListener(this);
        button2.addActionListener(this);

        group.add(button1);
        group.add(button2);

        this.add(button1);
        this.add(button2);
        this.add(question);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            question.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
            if (count == 0) {
                // selected innovative on q1
                this.askQuestion(ans2, que2);
                StdOut.println("innovative");
            }
            else if (count == 1) {
                // selected analytical on q2
                this.askQuestion(ans3, que3);
                StdOut.println("analytical");
            }
            else if (count == 2) {
                this.askQuestion(ans4, que4);
                StdOut.println("theoretical");
            }
            else if (count == 3) {
                this.askQuestion(ans5, que5);
                StdOut.println("stargazing");
            }
            else if (count == 4) {
                this.askQuestion(ans6, que6);
                StdOut.println("skiing");
            }
            else if (count == 5) {
                // show recs
                StdOut.println("non-profit");
            }
            count++;
        }
        else if (e.getSource() == button2) {
            question.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
            if (count == 0) {
                // selected reflective on q1
                this.askQuestion(ans2, que2);
                StdOut.println("reflective");
            }
            else if (count == 1) {
                // selected creative on q2
                this.askQuestion(ans3, que3);
                StdOut.println("creative");
            }
            else if (count == 2) {
                this.askQuestion(ans4, que4);
                StdOut.println("practical");
            }
            else if (count == 3) {
                this.askQuestion(ans5, que5);
                StdOut.println("walk on the beach");
            }
            else if (count == 4) {
                this.askQuestion(ans6, que6);
                StdOut.println("rome");
            }
            else if (count == 5) {
                // show recs
                StdOut.println("goldman sachs");
            }
            count++;
        }
        else if (e.getSource() == startButton) {
            title.setVisible(false);
            startButton.setVisible(false);
            this.askQuestion(ans1, que1);
        }
    }

    public static void main(String[] args) {
        new Quiz();
    }
}
