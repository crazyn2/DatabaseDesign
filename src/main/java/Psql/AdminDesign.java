package Psql;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminDesign extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    final Frame frame = new Frame();
    JTextField textField = new JTextField();
    JTextField textField_1 = new JTextField();
    JTextField textField_2 = new JTextField();
    JPanel panel = new JPanel();
    JButton btnNewButton = new JButton("学生成绩按每学年成绩统计");
    JButton btnNewButton_1 = new JButton("学生成绩名次排定");
    JButton btnNewButton_2 = new JButton("每门课程平均成绩统计");
    JButton btnNewButton_4 = new JButton("学生成绩查询");
    JButton btnNewButton_3 = new JButton("学生所学课程及学分统计");
    JLabel lblNewLabel = new JLabel("学号");
    JButton btnNewButton_5 = new JButton("教师任课查询");
    JLabel lblNewLabel_1 = new JLabel("教师号");
    JLabel lblNewLabel_2 = new JLabel("班级号");
    JButton btnNewButton_7 = new JButton("班级课程开设查询");
    JScrollPane scrollPane = new JScrollPane();
    JTextArea textArea = new JTextArea();

    public AdminDesign() {
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 910, 503);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.setContentPane(this.contentPane);
        this.panel.setPreferredSize(new Dimension(0, 150));
        this.contentPane.add(this.panel, "North");
        this.panel.setLayout(new FlowLayout(0, 5, 5));
        this.panel.add(this.btnNewButton);
        this.panel.add(this.btnNewButton_1);
        this.panel.add(this.btnNewButton_2);
        this.panel.add(this.btnNewButton_3);
        this.panel.add(this.lblNewLabel);
        this.panel.add(this.textField);
        this.textField.setColumns(10);
        this.panel.add(this.btnNewButton_4);
        this.panel.add(this.lblNewLabel_1);
        this.panel.add(this.textField_1);
        this.textField_1.setColumns(10);
        this.panel.add(this.btnNewButton_5);
        this.panel.add(this.lblNewLabel_2);
        this.textField_2.setText("");
        this.panel.add(this.textField_2);
        this.textField_2.setColumns(10);
        this.panel.add(this.btnNewButton_7);
        this.contentPane.add(this.scrollPane, "Center");
        this.scrollPane.setViewportView(this.textArea);
    }
}
