import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradeCalculator extends JFrame implements ActionListener {

    JLabel title, sub1, sub2, sub3, sub4, sub5, totalLbl, avgLbl, gradeLbl;
    JTextField tsub1, tsub2, tsub3, tsub4, tsub5, totalField, avgField, gradeField;
    JButton calcBtn, clearBtn;

    public GradeCalculator() {
        //frame
        setTitle("Student Grade Calculator");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));

        //title
        title = new JLabel("Student Grade Calculator");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setBounds(50, 20, 300, 30);
        add(title);

        //subject labels and text fields
        sub1 = new JLabel("Subject 1:");
        sub2 = new JLabel("Subject 2:");
        sub3 = new JLabel("Subject 3:");
        sub4 = new JLabel("Subject 4:");
        sub5 = new JLabel("Subject 5:");
        JLabel[] labels = {sub1, sub2, sub3, sub4, sub5};

        int y = 70;
        for (JLabel l : labels) {
            l.setBounds(50, y, 100, 25);
            add(l);
            y += 40;
        }

        tsub1 = new JTextField();
        tsub2 = new JTextField();
        tsub3 = new JTextField();
        tsub4 = new JTextField();
        tsub5 = new JTextField();
        JTextField[] fields = {tsub1, tsub2, tsub3, tsub4, tsub5};

        y = 70;
        for (JTextField f : fields) {
            f.setBounds(150, y, 180, 25);
            add(f);
            y += 40;
        }

        //buttons
        calcBtn = new JButton("Calculate");
        clearBtn = new JButton("Clear");
        calcBtn.setBounds(80, 280, 100, 30);
        clearBtn.setBounds(200, 280, 100, 30);
        add(calcBtn);
        add(clearBtn);

        //result labels and fields
        totalLbl = new JLabel("Total:");
        avgLbl = new JLabel("Average:");
        gradeLbl = new JLabel("Grade:");
        totalLbl.setBounds(50, 330, 100, 25);
        avgLbl.setBounds(50, 360, 100, 25);
        gradeLbl.setBounds(50, 390, 100, 25);
        add(totalLbl);
        add(avgLbl);
        add(gradeLbl);

        totalField = new JTextField();
        avgField = new JTextField();
        gradeField = new JTextField();
        totalField.setEditable(false);
        avgField.setEditable(false);
        gradeField.setEditable(false);
        totalField.setBackground(Color.WHITE);
        avgField.setBackground(Color.WHITE);
        gradeField.setBackground(Color.WHITE);

        totalField.setBounds(150, 330, 180, 25);
        avgField.setBounds(150, 360, 180, 25);
        gradeField.setBounds(150, 390, 180, 25);
        add(totalField);
        add(avgField);
        add(gradeField);

        //Listeners
        calcBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcBtn) {
            try {
                int[] marks = new int[5];
                marks[0] = Integer.parseInt(tsub1.getText());
                marks[1] = Integer.parseInt(tsub2.getText());
                marks[2] = Integer.parseInt(tsub3.getText());
                marks[3] = Integer.parseInt(tsub4.getText());
                marks[4] = Integer.parseInt(tsub5.getText());

                int total = 0;
                for (int m : marks) total += m;

                double average = total / 5.0;
                String grade;

                if (average >= 90)
                    grade = "A+";
                else if (average >= 80)
                    grade = "A";
                else if (average >= 70)
                    grade = "B";
                else if (average >= 60)
                    grade = "C";
                else if (average >= 50)
                    grade = "D";
                else
                    grade = "F";

                totalField.setText(String.valueOf(total));
                avgField.setText(String.format("%.2f", average));
                gradeField.setText(grade);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid marks (numbers only).",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearBtn) {
            tsub1.setText("");
            tsub2.setText("");
            tsub3.setText("");
            tsub4.setText("");
            tsub5.setText("");
            totalField.setText("");
            avgField.setText("");
            gradeField.setText("");
        }
    }

    public static void main(String[] args) {
        new GradeCalculator();
    }
}