package GenesisGradeCalculator;
import javax.swing.*;

public class LoginPage {
    public static JTextField userText;
    public static JPasswordField passwordText;
    public static JTextField studentIDText;
    public static JTextField MKText;
    public static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame();
        frame.setSize(450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);


        JLabel userLabel = new JLabel("Email");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(150, 20, 165, 25);
        panel.add(userText);


        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(150, 50, 165, 25);
        panel.add(passwordText);


        JLabel studentIDLabel = new JLabel("Student ID");
        studentIDLabel.setBounds(10, 80, 80, 25);
        panel.add(studentIDLabel);

        studentIDText = new JTextField(20);
        studentIDText.setBounds(150, 80, 165, 25);
        panel.add(studentIDText);


        JLabel MKLabel = new JLabel("Marking Period #");
        MKLabel.setBounds(10, 110, 160, 25);
        panel.add(MKLabel);

        MKText = new JTextField(1);
        MKText.setBounds(150, 110, 165, 25);
        panel.add(MKText);


        JButton login = new JButton("Login");
        login.setBounds(10, 140, 80, 25);
        login.addActionListener(new GenesisScraper());
        panel.add(login);




        frame.setVisible(true);




    }

}
