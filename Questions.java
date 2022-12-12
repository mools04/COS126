public class Questions {

    private ST<String, Integer> point = new ST<String, Integer>();
    private int numMajors = 9;
    private int options;
    private int options2;
    private String[] majors;

    public Questions() {
        majors = q2(1);
    }

    public void q1(int choice) {
        if (choice == 1) {
            options = 1;
        }
        if (choice == 2) {
            options = 2;
        }
    }

    public String[] q2(int choice) {
        String[] maj = new String[numMajors];
        if (choice == 1 && options == 1) {
            maj[0] = "Astrophysical Sciences";
            maj[1] = "Chemical and Biological Engineering";
            maj[2] = "Computer Science";
            maj[3] = "Economics";
            maj[4] = "Electrical and Computer Engineering";
            maj[5] = "Operations Research and Financial Engineering";
            maj[6] = "Neuroscience";
            maj[7] = "Physics";
            maj[8] = "Mechanical and Aerospace Engineering";
            options2 = 1;
        }
        if (choice == 1 && options == 2) {
            maj[0] = "Architecture";
            maj[1] = "Chemistry";
            maj[2] = "Civil and Environmental Engineering";
            maj[3] = "Ecology and Evolutionary Biology";
            maj[4] = "Geosciences";
            maj[5] = "Mathematics";
            maj[6] = "Molecular Biology";
            maj[7] = "School of Public and International Affairs";
            maj[8] = "Psychology";
            options2 = 2;
        }
        if (choice == 2 && options == 1) {
            maj[0] = "African American Studies";
            maj[1] = "Anthropology";
            maj[2] = "Sociology";
            maj[3] = "Politics";
            maj[4] = "Philosophy";
            maj[5] = "Near Eastern Studies";
            maj[6] = "History";
            maj[7] = "East Asian Studies";
            maj[8] = "Comparative Literature";
            options2 = 3;
        }
        if (choice == 2 && options == 2) {
            maj[0] = "Religion";
            maj[1] = "Slavic Language and Literature";
            maj[2] = "Spanish and Portuguese";
            maj[3] = "Music";
            maj[4] = "German";
            maj[5] = "English";
            maj[6] = "French and Italian";
            maj[7] = "Classics";
            maj[8] = "Art and Archaeology";
            options2 = 4;
        }
        return maj;
    }

    public void q3(int choice) {
        if (choice == 1 && options2 == 1) {
            point.put(majors[0], 3);
            point.put(majors[2], 2);
            point.put(majors[3], 2);
            point.put(majors[6], 2);
            point.put(majors[7], 3);

        }
        if (choice == 1 && options2 == 2) {
            point.put(majors[1], 3);
            point.put(majors[4], 1);
            point.put(majors[5], 3);
            point.put(majors[6], 2);
            point.put(majors[8], 3);
        }
        if (choice == 1 && options2 == 3) {
            point.put(majors[4], 3);
            point.put(majors[5], 1);
            point.put(majors[7], 1);
            point.put(majors[8], 1);
        }
        if (choice == 1 && options2 == 4) {
            point.put(majors[0], 3);
            point.put(majors[7], 2);
            point.put(majors[8], 1);
        }


        if (choice == 2 && options2 == 1) {
            point.put(majors[1], 2);
            point.put(majors[4], 3);
            point.put(majors[5], 1);
            point.put(majors[8], 3);
        }
        if (choice == 2 && options2 == 2) {
            point.put(majors[0], 3);
            point.put(majors[2], 3);
            point.put(majors[3], 2);
            point.put(majors[7], 2);
        }
        if (choice == 2 && options2 == 3) {
            point.put(majors[0], 2);
            point.put(majors[1], 3);
            point.put(majors[2], 3);
            point.put(majors[3], 2);
            point.put(majors[6], 2);
        }
        if (choice == 2 && options2 == 4) {
            point.put(majors[1], 1);
            point.put(majors[2], 3);
            point.put(majors[3], 2);
            point.put(majors[4], 1);
            point.put(majors[5], 2);
            point.put(majors[6], 2);
        }


    }

    public void q4(int choice) {
        if (choice == 1 && options2 == 1) {

        }
        if (choice == 1 && options2 == 2) {

        }
        if (choice == 1 && options2 == 3) {

        }
        if (choice == 1 && options2 == 4) {

        }


        if (choice == 2 && options2 == 1) {

        }
        if (choice == 2 && options2 == 2) {

        }
        if (choice == 2 && options2 == 3) {

        }
        if (choice == 2 && options2 == 4) {

        }
    }

    public void q5(int choice) {
        if (choice == 1 && options2 == 1) {

        }
        if (choice == 1 && options2 == 2) {

        }
        if (choice == 1 && options2 == 3) {

        }
        if (choice == 1 && options2 == 4) {

        }


        if (choice == 2 && options2 == 1) {

        }
        if (choice == 2 && options2 == 2) {

        }
        if (choice == 2 && options2 == 3) {

        }
        if (choice == 2 && options2 == 4) {

        }
    }

    public static void main(String[] args) {

    }
}
