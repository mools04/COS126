import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Quiz.java uses Java Swing to create a GUI college major quiz with six
// questions. Depending on the user's choices, the quiz will display a
// recommended major and the top 3 majors overall in a bar graph at the end of
// the quiz. The quiz calculates the top 3 majors based on consensus/stereotypes
// surrounding each major (for example, engineering is more practical while
// mathematics is more theoretical). Points are awarded to those that fit
// the chosen category.
public class Quiz extends JFrame implements ActionListener {

    public static int height1; // height of second-highest major bar on bar graph
    public static int height2; // height of top major bar on bar graph
    public static int height3; // height of third-highest major bar on bar graph
    public static String a; // top major string
    public static String b; // second-highest major string
    public static String c; // third-highest major string
    // symbol table to hold top 3 majors and point values
    public static ST<String, Integer> point = new ST<String, Integer>();

    private JRadioButton button1; // button for answer 1
    private JRadioButton button2; // button for answer 2
    private JLabel title; // title for welcome slide
    private JLabel title2; // title for slide with bar graph
    private JLabel question; // question label
    private JButton startButton; // button on welcome slide to start quiz
    private String[] ans1; // first set of answers
    private String que1; // first question
    private String[] ans2; // second set of answers
    private String que2; // second question
    private String[] ans3; // third set of answers
    private String que3; // third question
    private String[] ans4; // fourth set of answers
    private String que4; // fourth question
    private String[] ans5; // fifth set of answers
    private String que5; // fifth question
    private String[] ans6; // sixth set of answers
    private String que6; // sixth question
    private int count; // counter to know what question the quiz is on


    private int options; // choice for first question
    private int options2; // choice for second question
    private int options3; // choice for third question
    private int options4; // choice for fourth question
    private int options5; // choice for fifth question
    private int options6; // choice for sixth question


    // makes the quiz frame
    public Quiz() {
        // create title
        title = new JLabel();
        title.setText("Welcome to MajrFindr - Your Virtual Academic Advisor!");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        // create start button
        startButton = new JButton();
        startButton.setBounds(200, 160, 100, 100);
        startButton.addActionListener(this);
        startButton.setText("START");
        // set title and size, add start button and title to first slide
        this.setTitle("MajrFindr");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setVisible(true);
        this.add(startButton);
        this.add(title);
        // create question 1 with answers
        que1 = "Are you more innovative or reflective?";
        ans1 = new String[2];
        ans1[0] = "Innovative";
        ans1[1] = "Reflective";
        // create question 2 with answers
        que2 = "Are you more analytical or creative?";
        ans2 = new String[2];
        ans2[0] = "Analytical";
        ans2[1] = "Creative";
        // create question 3 with answers
        que3 = "Are you more theoretical or practical?";
        ans3 = new String[2];
        ans3[0] = "Theoretical";
        ans3[1] = "Practical";
        // create question 4 with answers
        que4 = "Which is the better first date: stargazing at an observatory "
                + "or a long walk on the beach?";
        ans4 = new String[2];
        ans4[0] = "Stargazing";
        ans4[1] = "Walk on the beach";
        // create question 5 with answers
        que5 = "Which is a better vacation: skiing at a mountain or touring "
                + "rome?";
        ans5 = new String[2];
        ans5[0] = "Skiing";
        ans5[1] = "Rome";
        // create question 6 with answers
        que6 = "Two fully-funded internship opportunities arise. One is with "
                + "a public health non-profit in Africa. The other is with "
                + "Goldman Sachs, an investment banking firm in New York. "
                + "They will both equally benefit your career. What is your "
                + "choice?";
        ans6 = new String[2];
        ans6[0] = "Non-profit";
        ans6[1] = "Goldman Sachs";
    }

    // sets up the question slides given the question and answers
    public void askQuestion(String[] ans, String q) {
        // create a new question label and place it in correct spot
        question = new JLabel();
        question.setText("<html><center>" + q + "</center></html>");
        question.setHorizontalAlignment(JLabel.CENTER);
        question.setVerticalAlignment(JLabel.TOP);
        question.setBounds(JLabel.CENTER, JLabel.TOP, 500, 100);

        ButtonGroup group = new ButtonGroup();
        // create two buttons for the two answers
        button1 = new JRadioButton(ans[0]);
        button2 = new JRadioButton(ans[1]);

        button1.setBounds(200, 160, 200, 30);
        button2.setBounds(200, 190, 200, 30);

        button1.addActionListener(this);
        button2.addActionListener(this);
        // add question and answers to the slide
        group.add(button1);
        group.add(button2);
        this.add(button1);
        this.add(button2);
        this.add(question);
    }


    public void actionPerformed(ActionEvent e) {
        // initialize/declare variables for bar graph slide
        int scale = 45;
        String recommend = "Your recommended major is ";
        // if answer 1 is selected
        if (e.getSource() == button1) {
            // clear the screen
            question.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
            if (count == 0) {
                // ask question 2
                this.askQuestion(ans2, que2);
                // selected innovative on q1
                options = 1;
                // test: print out innovative if pressed
                StdOut.println("innovative");
            }
            else if (count == 1) {
                // ask question 3
                this.askQuestion(ans3, que3);
                // selected analytical on q2
                options2 = 1;
                // test: print out analytical if pressed
                StdOut.println("analytical");
            }
            else if (count == 2) {
                // ask question 4
                this.askQuestion(ans4, que4);
                // selected theoretical on q3
                options3 = 1;
                // test: print out theoretical if pressed
                StdOut.println("theoretical");
            }
            else if (count == 3) {
                // ask question 5
                this.askQuestion(ans5, que5);
                // selected stargazing on q4
                options4 = 1;
                // test: print out stargazing if pressed
                StdOut.println("stargazing");
            }
            else if (count == 4) {
                // ask question 6
                this.askQuestion(ans6, que6);
                // selected skiing on q5
                options5 = 1;
                // test: print out skiing if pressed
                StdOut.println("skiing");
            }
            else if (count == 5) {
                // selected non-profit on q6
                options6 = 1;
                // test: print out non-profit if pressed
                StdOut.println("non=profit");
                // call recommend functions to populate symbol table
                rec1();
                rec2();
                rec3();
                rec4();
                // make heights of bars proportional to point values
                height1 = point.get(b) * scale;
                height2 = point.get(a) * scale;
                height3 = point.get(c) * scale;
                // make title for bar graph
                title2 = new JLabel();
                title2.setText(recommend + a);
                title2.setHorizontalAlignment(JLabel.CENTER);
                title2.setVerticalAlignment(JLabel.TOP);
                // show recommendations
                ShowRecs recs = new ShowRecs();
                this.add(title2);
                this.setVisible(true);
                this.add(recs);
                // test heights
                testheight();

            }
            count++;
        }
        else if (e.getSource() == button2) {
            // clear the screen
            question.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
            if (count == 0) {
                // ask second question
                this.askQuestion(ans2, que2);
                // selected reflective on q1
                options = 2;
                // test: print out reflective if pressed
                StdOut.println("reflective");
            }
            else if (count == 1) {
                // ask question 3
                this.askQuestion(ans3, que3);
                // selected creative on q2
                options2 = 2;
                // test: print out creative if pressed
                StdOut.println("creative");
            }
            else if (count == 2) {
                // ask question 4
                this.askQuestion(ans4, que4);
                // selected practical on q3
                options3 = 2;
                // test: print out practical if pressed
                StdOut.println("practical");
            }
            else if (count == 3) {
                // ask question 5
                this.askQuestion(ans5, que5);
                // selected walk on the beach for q4
                options4 = 2;
                // test: print out walk on the beach if pressed
                StdOut.println("walk on the beach");
            }
            else if (count == 4) {
                // ask question 6
                this.askQuestion(ans6, que6);
                // selected rome on q5
                options5 = 2;
                // test: print out rome if pressed
                StdOut.println("rome");
            }
            else if (count == 5) {
                // selected goldman sachs on q6
                options6 = 2;
                // test: print out goldman sachs if pressed
                StdOut.println("goldman sachs");
                // call recommend functions to populate symbol table
                rec1();
                rec2();
                rec3();
                rec4();
                // make heights of bar graph proportional to point values
                height1 = point.get(b) * scale;
                height2 = point.get(a) * scale;
                height3 = point.get(c) * scale;
                // make title for graph slide
                title2 = new JLabel();
                title2.setText(recommend + a);
                title2.setHorizontalAlignment(JLabel.CENTER);
                title2.setVerticalAlignment(JLabel.TOP);
                // show recommendations
                ShowRecs recs = new ShowRecs();
                this.add(title2);
                this.setVisible(true);
                this.add(recs);
                // print heights of bars
                testheight();


            }
            count++;
        }
        // ask question 1 after start is pressed
        else if (e.getSource() == startButton) {
            // test: print out start if started is pressed
            StdOut.println("START");
            title.setVisible(false);
            startButton.setVisible(false);
            this.askQuestion(ans1, que1);
        }

    }

    // recommendations for people who answered innovative and then analytical
    // adds point values to top 3 majors of the 9 possible depending on
    // their next 4 answers
    public void rec1() {
        // create strings for each of 9 possible majors
        String astro = "Astrophysical Sciences";
        String cbe = "Chemical and Biological Engineering";
        String cos = "Computer Science";
        String econ = "Economics";
        String ece = "Electrical and Computer Engineering";
        String orfe = "Operations Research and Financial Engineering";
        String neuro = "Neuroscience";
        String phys = "Physics";
        String mae = "Mechanical and Aerospace Engineering";
        // given innovative and analytical for first two questions, will iterate
        // through all possible options of the next four questions
        // (16 combinations) and input the major and associated point value
        // into symbol table
        if (options2 == 1 && options == 1) {
            if (options3 == 1 && options4 == 1 && options5 == 1 && options6 == 1) {
                a = astro;
                b = phys;
                c = neuro;
                point.put(a, 8);
                point.put(b, 7);
                point.put(c, 6);
            }
            if (options3 == 2 && options4 == 1 && options5 == 1 && options6 == 1) {
                a = astro;
                b = cbe;
                c = neuro;
                point.put(a, 5);
                point.put(b, 5);
                point.put(c, 4);
            }
            if (options3 == 1 && options4 == 2 && options5 == 1 && options6 == 1) {
                a = econ;
                b = orfe;
                c = ece;
                point.put(a, 7);
                point.put(b, 5);
                point.put(c, 5);
            }
            if (options3 == 1 && options4 == 1 && options5 == 2 && options6 == 1) {
                a = neuro;
                b = astro;
                c = cos;
                point.put(a, 8);
                point.put(b, 7);
                point.put(c, 6);
            }
            if (options3 == 1 && options4 == 1 && options5 == 1 && options6 == 2) {
                a = phys;
                b = astro;
                c = cos;
                point.put(a, 8);
                point.put(b, 7);
                point.put(c, 7);
            }
            if (options3 == 2 && options4 == 2 && options5 == 1 && options6 == 1) {
                a = cbe;
                b = orfe;
                c = mae;
                point.put(a, 7);
                point.put(b, 6);
                point.put(c, 5);
            }
            if (options3 == 2 && options4 == 1 && options5 == 2 && options6 == 1) {
                a = phys;
                b = cbe;
                c = astro;
                point.put(a, 5);
                point.put(b, 5);
                point.put(c, 4);
            }
            if (options3 == 2 && options4 == 1 && options5 == 1 && options6 == 2) {
                a = orfe;
                b = phys;
                c = econ;
                point.put(a, 6);
                point.put(b, 5);
                point.put(c, 5);
            }
            if (options3 == 1 && options4 == 2 && options5 == 1 && options6 == 2) {
                a = econ;
                b = orfe;
                c = ece;
                point.put(a, 10);
                point.put(b, 8);
                point.put(c, 7);
            }
            if (options3 == 1 && options4 == 2 && options5 == 2 && options6 == 1) {
                a = ece;
                b = cbe;
                c = econ;
                point.put(a, 7);
                point.put(b, 6);
                point.put(c, 5);
            }
            if (options3 == 1 && options4 == 1 && options5 == 2 && options6 == 2) {
                a = cos;
                b = ece;
                c = neuro;
                point.put(a, 9);
                point.put(b, 7);
                point.put(c, 7);
            }
            if (options3 == 2 && options4 == 2 && options5 == 2 && options6 == 1) {
                a = cbe;
                b = mae;
                c = orfe;
                point.put(a, 8);
                point.put(b, 6);
                point.put(c, 4);
            }
            if (options3 == 2 && options4 == 2 && options5 == 1 && options6 == 2) {
                a = orfe;
                b = econ;
                c = mae;
                point.put(a, 9);
                point.put(b, 7);
                point.put(c, 5);
            }
            if (options3 == 2 && options4 == 1 && options5 == 2 && options6 == 2) {
                a = cos;
                b = cbe;
                c = mae;
                point.put(a, 7);
                point.put(b, 6);
                point.put(c, 6);
            }
            if (options3 == 1 && options4 == 2 && options5 == 2 && options6 == 2) {
                a = ece;
                b = econ;
                c = cos;
                point.put(a, 9);
                point.put(b, 8);
                point.put(c, 7);
            }
            if (options3 == 2 && options4 == 2 && options5 == 2 && options6 == 2) {
                a = mae;
                b = orfe;
                c = econ;
                point.put(a, 8);
                point.put(b, 7);
                point.put(c, 6);
            }
            // print out majors and ratings
            test();
        }

    }

    // recommendations for people who answered innovative and then creative
    // adds point values to top 3 majors of the 9 possible depending on
    // their next 4 answers
    public void rec2() {
        // create strings for each of 9 possible majors
        String arch = "Architecture";
        String chem = "Chemistry";
        String cee = "Civil and Environmental Engineering";
        String eeb = "Environmental and Evolutionary Biology";
        String geo = "Geosciences";
        String math = "Mathematics";
        String mol = "Molecular Biology";
        String spia = "School of Public and International Affairs";
        String psy = "Psychology";
        // given innovative and creative for first two questions, will iterate
        // through all possible options of the next four questions
        // (16 combinations) and input the major and associated point value
        // into symbol table
        if (options2 == 2 && options == 1) {
            if (options3 == 1 && options4 == 1 && options5 == 1 && options6 == 1) {
                a = psy;
                b = math;
                c = eeb;
                point.put(a, 9);
                point.put(b, 6);
                point.put(c, 6);
            }
            if (options3 == 2 && options4 == 1 && options5 == 1 && options6 == 1) {
                a = cee;
                b = eeb;
                c = psy;
                point.put(a, 9);
                point.put(b, 7);
                point.put(c, 6);
            }
            if (options3 == 1 && options4 == 2 && options5 == 1 && options6 == 1) {
                a = geo;
                b = psy;
                c = eeb;
                point.put(a, 7);
                point.put(b, 7);
                point.put(c, 5);
            }
            if (options3 == 1 && options4 == 1 && options5 == 2 && options6 == 1) {
                a = chem;
                b = math;
                c = psy;
                point.put(a, 9);
                point.put(b, 8);
                point.put(c, 7);
            }
            if (options3 == 1 && options4 == 1 && options5 == 1 && options6 == 2) {
                a = math;
                b = psy;
                c = chem;
                point.put(a, 9);
                point.put(b, 7);
                point.put(c, 5);
            }
            if (options3 == 2 && options4 == 2 && options5 == 1 && options6 == 1) {
                a = eeb;
                b = cee;
                c = arch;
                point.put(a, 10);
                point.put(b, 7);
                point.put(c, 6);
            }
            if (options3 == 2 && options4 == 1 && options5 == 2 && options6 == 1) {
                a = arch;
                b = cee;
                c = math;
                point.put(a, 10);
                point.put(b, 7);
                point.put(c, 6);
            }
            if (options3 == 2 && options4 == 1 && options5 == 1 && options6 == 2) {
                a = cee;
                b = arch;
                c = math;
                point.put(a, 7);
                point.put(b, 6);
                point.put(c, 6);
            }
            if (options3 == 1 && options4 == 2 && options5 == 1 && options6 == 2) {
                a = mol;
                b = math;
                c = eeb;
                point.put(a, 6);
                point.put(b, 6);
                point.put(c, 6);
            }
            if (options3 == 1 && options4 == 2 && options5 == 2 && options6 == 1) {
                a = geo;
                b = mol;
                c = arch;
                point.put(a, 9);
                point.put(b, 7);
                point.put(c, 6);
            }
            if (options3 == 1 && options4 == 1 && options5 == 2 && options6 == 2) {
                a = math;
                b = mol;
                c = chem;
                point.put(a, 11);
                point.put(b, 7);
                point.put(c, 7);
            }
            if (options3 == 2 && options4 == 2 && options5 == 2 && options6 == 1) {
                a = arch;
                b = geo;
                c = spia;
                point.put(a, 9);
                point.put(b, 8);
                point.put(c, 7);
            }
            if (options3 == 2 && options4 == 2 && options5 == 1 && options6 == 2) {
                a = eeb;
                b = spia;
                c = cee;
                point.put(a, 8);
                point.put(b, 7);
                point.put(c, 5);
            }
            if (options3 == 2 && options4 == 1 && options5 == 2 && options6 == 2) {
                a = math;
                b = spia;
                c = arch;
                point.put(a, 8);
                point.put(b, 6);
                point.put(c, 6);
            }
            if (options3 == 1 && options4 == 2 && options5 == 2 && options6 == 2) {
                a = mol;
                b = math;
                c = spia;
                point.put(a, 9);
                point.put(b, 8);
                point.put(c, 7);
            }
            if (options3 == 2 && options4 == 2 && options5 == 2 && options6 == 2) {
                a = spia;
                b = mol;
                c = arch;
                point.put(a, 9);
                point.put(b, 7);
                point.put(c, 6);
            }
            // print out majors and ratings
            test();
        }
    }

    // recommendations for people who answered reflective and then analytical
    // adds point values to top 3 majors of the 9 possible depending on
    // their next 4 answers
    public void rec3() {
        // create strings for each of 9 possible majors
        String aas = "African American Studies";
        String ant = "Anthropology";
        String soc = "Sociology";
        String poli = "Politics";
        String phi = "Philosophy";
        String nes = "Near Eastern Studies";
        String hist = "History";
        String eas = "East Asian Studies";
        String complit = "Comparative Literature";
        // given reflective and analytical for first two questions, will iterate
        // through all possible options of the next four questions
        // (16 combinations) and input the major and associated point value
        // into symbol table
        if (options2 == 1 && options == 2) {
            if (options3 == 1 && options4 == 1 && options5 == 1 && options6 == 1) {
                a = aas;
                b = phi;
                c = soc;
                point.put(a, 6);
                point.put(b, 6);
                point.put(c, 4);
            }
            if (options3 == 2 && options4 == 1 && options5 == 1 && options6 == 1) {
                a = aas;
                b = soc;
                c = ant;
                point.put(a, 8);
                point.put(b, 7);
                point.put(c, 5);
            }
            if (options3 == 1 && options4 == 2 && options5 == 1 && options6 == 1) {
                a = nes;
                b = ant;
                c = phi;
                point.put(a, 6);
                point.put(b, 4);
                point.put(c, 4);
            }
            if (options3 == 1 && options4 == 1 && options5 == 2 && options6 == 1) {
                a = phi;
                b = soc;
                c = hist;
                point.put(a, 8);
                point.put(b, 6);
                point.put(c, 5);
            }
            if (options3 == 1 && options4 == 1 && options5 == 1 && options6 == 2) {
                a = nes;
                b = phi;
                c = hist;
                point.put(a, 5);
                point.put(b, 5);
                point.put(c, 4);
            }
            if (options3 == 2 && options4 == 2 && options5 == 1 && options6 == 1) {
                a = ant;
                b = aas;
                c = nes;
                point.put(a, 7);
                point.put(b, 6);
                point.put(c, 5);
            }
            if (options3 == 2 && options4 == 1 && options5 == 2 && options6 == 1) {
                a = soc;
                b = ant;
                c = hist;
                point.put(a, 9);
                point.put(b, 7);
                point.put(c, 7);
            }
            if (options3 == 2 && options4 == 1 && options5 == 1 && options6 == 2) {
                a = hist;
                b = aas;
                c = soc;
                point.put(a, 6);
                point.put(b, 6);
                point.put(c, 5);
            }
            if (options3 == 1 && options4 == 2 && options5 == 1 && options6 == 2) {
                a = nes;
                b = eas;
                c = poli;
                point.put(a, 8);
                point.put(b, 5);
                point.put(c, 4);
            }
            if (options3 == 1 && options4 == 2 && options5 == 2 && options6 == 1) {
                a = complit;
                b = eas;
                c = ant;
                point.put(a, 8);
                point.put(b, 6);
                point.put(c, 6);
            }
            if (options3 == 1 && options4 == 1 && options5 == 2 && options6 == 2) {
                a = hist;
                b = phi;
                c = eas;
                point.put(a, 7);
                point.put(b, 7);
                point.put(c, 6);
            }
            if (options3 == 2 && options4 == 2 && options5 == 2 && options6 == 1) {
                a = ant;
                b = soc;
                c = complit;
                point.put(a, 9);
                point.put(b, 7);
                point.put(c, 7);
            }
            if (options3 == 2 && options4 == 2 && options5 == 1 && options6 == 2) {
                a = nes;
                b = poli;
                c = soc;
                point.put(a, 7);
                point.put(b, 6);
                point.put(c, 5);
            }
            if (options3 == 2 && options4 == 1 && options5 == 2 && options6 == 2) {
                a = hist;
                b = poli;
                c = soc;
                point.put(a, 9);
                point.put(b, 7);
                point.put(c, 7);
            }
            if (options3 == 1 && options4 == 2 && options5 == 2 && options6 == 2) {
                a = eas;
                b = complit;
                c = nes;
                point.put(a, 8);
                point.put(b, 6);
                point.put(c, 6);
            }
            if (options3 == 2 && options4 == 2 && options5 == 2 && options6 == 2) {
                a = poli;
                b = ant;
                c = eas;
                point.put(a, 9);
                point.put(b, 7);
                point.put(c, 7);
            }
            // print out majors and ratings
            test();
        }
    }

    // recommendations for people who answered reflective and then creative
    // adds point values to top 3 majors of the 9 possible depending on
    // their next 4 answers
    public void rec4() {
        // create strings for each of 9 possible majors
        String rel = "Religion";
        String sla = "Slavic Languages and Literature";
        String span = "Spanish and Portuguese";
        String mus = "Music";
        String germ = "German";
        String eng = "English";
        String fren = "French and Italian";
        String clas = "Classics";
        String art = "Art and Archaeology";
        // given reflective and creative for first two questions, will iterate
        // through all possible options of the next four questions
        // (16 combinations) and input the major and associated point value
        // into symbol table
        if (options2 == 2 && options == 2) {
            if (options3 == 1 && options4 == 1 && options5 == 1 && options6 == 1) {
                a = germ;
                b = rel;
                c = eng;
                point.put(a, 8);
                point.put(b, 6);
                point.put(c, 5);
            }
            if (options3 == 2 && options4 == 1 && options5 == 1 && options6 == 1) {
                a = eng;
                b = germ;
                c = fren;
                point.put(a, 7);
                point.put(b, 7);
                point.put(c, 5);
            }
            if (options3 == 1 && options4 == 2 && options5 == 1 && options6 == 1) {
                a = clas;
                b = germ;
                c = rel;
                point.put(a, 6);
                point.put(b, 6);
                point.put(c, 5);
            }
            if (options3 == 1 && options4 == 1 && options5 == 2 && options6 == 1) {
                a = rel;
                b = clas;
                c = art;
                point.put(a, 8);
                point.put(b, 7);
                point.put(c, 6);
            }
            if (options3 == 1 && options4 == 1 && options5 == 1 && options6 == 2) {
                a = fren;
                b = germ;
                c = art;
                point.put(a, 7);
                point.put(b, 6);
                point.put(c, 5);
            }
            if (options3 == 2 && options4 == 2 && options5 == 1 && options6 == 1) {
                a = sla;
                b = span;
                c = eng;
                point.put(a, 5);
                point.put(b, 5);
                point.put(c, 5);
            }
            if (options3 == 2 && options4 == 1 && options5 == 2 && options6 == 1) {
                a = fren;
                b = mus;
                c = rel;
                point.put(a, 8);
                point.put(b, 6);
                point.put(c, 5);
            }
            if (options3 == 2 && options4 == 1 && options5 == 1 && options6 == 2) {
                a = eng;
                b = mus;
                c = germ;
                point.put(a, 9);
                point.put(b, 6);
                point.put(c, 5);
            }
            if (options3 == 1 && options4 == 2 && options5 == 1 && options6 == 2) {
                a = eng;
                b = clas;
                c = germ;
                point.put(a, 5);
                point.put(b, 4);
                point.put(c, 4);
            }
            if (options3 == 1 && options4 == 2 && options5 == 2 && options6 == 1) {
                a = clas;
                b = sla;
                c = rel;
                point.put(a, 9);
                point.put(b, 7);
                point.put(c, 7);
            }
            if (options3 == 1 && options4 == 1 && options5 == 2 && options6 == 2) {
                a = art;
                b = rel;
                c = mus;
                point.put(a, 8);
                point.put(b, 6);
                point.put(c, 6);
            }
            if (options3 == 2 && options4 == 2 && options5 == 2 && options6 == 1) {
                a = sla;
                b = span;
                c = clas;
                point.put(a, 8);
                point.put(b, 7);
                point.put(c, 7);
            }
            if (options3 == 2 && options4 == 2 && options5 == 1 && options6 == 2) {
                a = eng;
                b = span;
                c = mus;
                point.put(a, 7);
                point.put(b, 6);
                point.put(c, 4);
            }
            if (options3 == 2 && options4 == 1 && options5 == 2 && options6 == 2) {
                a = mus;
                b = art;
                c = fren;
                point.put(a, 8);
                point.put(b, 7);
                point.put(c, 7);
            }
            if (options3 == 1 && options4 == 2 && options5 == 2 && options6 == 2) {
                a = clas;
                b = art;
                c = span;
                point.put(a, 7);
                point.put(b, 6);
                point.put(c, 5);
            }
            if (options3 == 2 && options4 == 2 && options5 == 2 && options6 == 2) {
                a = span;
                b = sla;
                c = mus;
                point.put(a, 8);
                point.put(b, 6);
                point.put(c, 6);
            }
            // print out majors and ratings
            test();
        }
    }

    // Method to make sure that the top majors and ratings are the same as the
    // ones displayed on the GUI and the graph
    public void test() {
        String rate = " with a rating of ";
        StdOut.println("Your top major is " + a + rate + point.get(a));
        StdOut.println("Your second major is " + b + rate + point.get(b));
        StdOut.println("Your third major is " + c + rate + point.get(c));
    }

    // Method to test the heights of the bars and print them out
    public void testheight() {
        StdOut.println("height1 = " + height1);
        StdOut.println("height2 = " + height2);
        StdOut.println("height3 = " + height3);
    }

    // Creates a new quiz so that the GUI pops up when the program is ran
    public static void main(String[] args) {
        new Quiz();
    }
}
