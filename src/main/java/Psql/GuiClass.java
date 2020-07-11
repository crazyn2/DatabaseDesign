package Psql;

import javax.swing.*;
import java.awt.*;

public class GuiClass extends JFrame {
    public JTextArea jTextArea = new JTextArea();
    private JScrollPane jScrollPane = new JScrollPane(jTextArea);
    private JTextField jTextField = new JTextField();
    private  JButton button = new JButton("Query");
    private  JPanel pan = new JPanel();
    public GuiClass(String sTitle){
        super(sTitle);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        Container container = getContentPane();
        container.add(new JLabel("Students number:"));
        container.setLayout(new FlowLayout());
//        container.add(jTextField);
        jTextArea.setLineWrap(true);
//        jTextArea.setSelectedTextColor(Color.blue);
//        jTextArea.setBackground(Color.BLACK);
//        jTextArea.setForeground(Color.GREEN);
//        jTextArea.setCaretColor(Color.WHITE);
        jTextArea.setEditable(false);
        Font font = new Font("MySelf", Font.BOLD, 15);
        jTextArea.setFont(font);
//        container.add(button);
        container.add(jScrollPane);
        button.setSize(30,30);
        button.setHorizontalTextPosition(SwingConstants.LEFT);
        container.add(button);
        this.setContentPane(container);
        setBounds(10,10,400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
