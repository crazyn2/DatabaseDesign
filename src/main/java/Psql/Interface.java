package Psql;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame{
    JTextField textField;
    JTextField textField_1;
    JPanel contentPane = new JPanel();
    JLabel jLabel = new JLabel("请输入用户名和密码");
    JLabel lblNewLabel = new JLabel("用户名");
    JButton btnNewButton = new JButton("学生登陆");
    JButton btnNewButton_1 = new JButton("教师登陆");
    JButton btnNewButton_2 = new JButton("管理员登陆");

    public Interface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 524, 357);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        contentPane.add(lblNewLabel);

        textField = new JTextField();
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("密码");
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        contentPane.add(btnNewButton);

        contentPane.add(btnNewButton_1);
        contentPane.add(btnNewButton_2);
        contentPane.add(jLabel);
    }
}
