import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    public static int height1;
    public static int height2;
    public static int height3;
    public static String a;
    public static String b;
    public static String c;

    private JRadioButton button1;
    private JRadioButton button2;
    private JLabel title;
    private JLabel title2;
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
    private int options3;
    private int options4;
    private int options5;
    private int options6;


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
                options = 1;
            }
            else if (count == 1) {
                // selected analytical on q2
                this.askQuestion(ans3, que3);
                StdOut.println("analytical");
                options2 = 1;
            }
            else if (count == 2) {
                this.askQuestion(ans4, que4);
                StdOut.println("theoretical");
                options3 = 1;
            }
            else if (count == 3) {
                this.askQuestion(ans5, que5);
                StdOut.println("stargazing");
                options4 = 1;
            }
            else if (count == 4) {
                this.askQuestion(ans6, que6);
                StdOut.println("skiing");
                options5 = 1;
            }
            else if (count == 5) {
                // show recs
                StdOut.println("non-profit");
                options6 = 1;
                rec1();
                rec2();
                rec3();
                rec4();
                height1 = point.get(b) * 45;
                height2 = point.get(a) * 45;
                height3 = point.get(c) * 45;
                title2 = new JLabel();
                title2.setText("Your recommended major is " + a);
                title2.setHorizontalAlignment(JLabel.CENTER);
                title2.setVerticalAlignment(JLabel.TOP);
                ShowRecs recs = new ShowRecs();
                this.add(title2);
                this.setVisible(true);
                this.add(recs);

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
                options = 2;
            }
            else if (count == 1) {
                // selected creative on q2
                this.askQuestion(ans3, que3);
                StdOut.println("creative");
                options2 = 2;
            }
            else if (count == 2) {
                this.askQuestion(ans4, que4);
                StdOut.println("practical");
                options3 = 2;
            }
            else if (count == 3) {
                this.askQuestion(ans5, que5);
                StdOut.println("walk on the beach");
                options4 = 2;
            }
            else if (count == 4) {
                this.askQuestion(ans6, que6);
                StdOut.println("rome");
                options5 = 2;
            }
            else if (count == 5) {
                // show recs
                StdOut.println("goldman sachs");
                options6 = 2;
                rec1();
                rec2();
                rec3();
                rec4();
                height1 = point.get(b) * 45;
                height2 = point.get(a) * 45;
                height3 = point.get(c) * 45;
                title2 = new JLabel();
                title2.setText("Your recommended major is " + a);
                title2.setHorizontalAlignment(JLabel.CENTER);
                title2.setVerticalAlignment(JLabel.TOP);
                ShowRecs recs = new ShowRecs();
                this.add(title2);
                this.setVisible(true);
                this.add(recs);

            }
            count++;
        }
        else if (e.getSource() == startButton) {
            title.setVisible(false);
            startButton.setVisible(false);
            this.askQuestion(ans1, que1);
        }

    }

    public void rec1() {
        String astro = "Astrophysical Sciences";
        String cbe = "Chemical and Biological Engineering";
        String cos = "Computer Science";
        String econ = "Economics";
        String ece = "Electrical and Computer Engineering";
        String orfe = "Operations Research and Financial Engineering";
        String neuro = "Neuroscience";
        String phys = "Physics";
        String mae = "Mechanical and Aerospace Engineering";
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
            max();
        }

    }

    public void rec2() {
        String arch = "Architecture";
        String chem = "Chemistry";
        String cee = "Civil and Environmental Engineering";
        String eeb = "Environmental and Evolutionary Biology";
        String geo = "Geosciences";
        String math = "Mathematics";
        String mol = "Molecular Biology";
        String spia = "School of Public and International Affairs";
        String psy = "Psychology";
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
            max();
        }

    }

    public void rec3() {
        String aas = "African American Studies";
        String ant = "Anthropology";
        String soc = "Sociology";
        String poli = "Politics";
        String phi = "Philosophy";
        String nes = "Near Eastern Studies";
        String hist = "History";
        String eas = "East Asian Studies";
        String complit = "Comparative Literature";
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
            max();
        }

    }

    public void rec4() {
        String rel = "Religion";
        String sla = "Slavic Languages and Literature";
        String span = "Spanish and Portuguese";
        String mus = "Music";
        String germ = "German";
        String eng = "English";
        String fren = "French and Italian";
        String clas = "Classics";
        String art = "Art and Archaeology";
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
            max();
        }

    }

    public void max() {
        StdOut.println(a + " " + point.get(a));
        StdOut.println(b + " " + point.get(b));
        StdOut.println(c + " " + point.get(c));
    }

    public static void main(String[] args) {
        new Quiz();
    }
}
