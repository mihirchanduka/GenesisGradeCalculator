package GenesisGradeCalculator;
import javax.swing.*;


public class Gradebook {
    String[] Co;
    String[] Gr;
    String[] LG;

    public Gradebook(String[] Courses ,String[] Grade, String[] LetterGrade){
        Co = Courses;
        Gr = Grade;
        LG = LetterGrade;
        String[][] c = new String[Courses.length][3];
        for(int i = 0; i < Courses.length; i++){
            c[i][0] = Courses[i];
            c[i][1] = Grade[i];
            c[i][2] = LetterGrade[i];
        }


        String[] head = {"COURSE", "GRADE", "LETTER"};

        JFrame frame = new JFrame();
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);



        JTable grades = new JTable(c,head);
        JScrollPane scrollPane = new JScrollPane(grades);
        grades.setBounds(0 , 0, 300, 150);
        grades.setBounds(0,0,300,150);
        panel.add(scrollPane);
        panel.add(grades.getTableHeader());
        panel.add(grades);



        JLabel unweightedgpa = new JLabel("Unweighted GPA " + GPACalc.getUnWeightedGPA(LG));
        unweightedgpa.setBounds(70,150, 2500, 25);
        panel.add(unweightedgpa);


        JLabel weightedgpa = new JLabel("Weighted GPA " + GPACalc.getWeightedGPA(Co,LG));
        weightedgpa.setBounds(70,175, 200, 25);
        panel.add(weightedgpa);

        frame.setVisible(true);
    }


}
