package Psql;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Design extends JFrame {//图形界面

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	final Frame frame = new Frame();
	protected JTextField textField = new JTextField();
	protected JTextField textField_1 = new JTextField();
	protected JTextField textField_2 = new JTextField();
	protected JPanel panel = new JPanel();
	protected JButton btnNewButton = new JButton("学生成绩按每学年成绩统计");//("count-by-year");
	protected JButton btnNewButton_1 = new JButton("学生成绩名次排定");
	protected JButton btnNewButton_2 = new JButton("每门课程平均成绩统计");
	protected JButton btnNewButton_3 = new JButton("学生所学课程及学分统计");
	protected JButton btnNewButton_4 = new JButton("学生成绩查询");
	protected JLabel lblNewLabel = new JLabel("查询的学号:");
	protected JButton btnNewButton_5 = new JButton("教师任课查询");
	protected JLabel lblNewLabel_1 = new JLabel("查询的教师号:");
	protected JLabel lblNewLabel_2 = new JLabel("查询的班级号:");
	protected JButton btnNewButton_7 = new JButton("班级课程开设查询");
	protected JScrollPane scrollPane = new JScrollPane();
	protected JTextArea textArea = new JTextArea();
	/**
	 * Create the frame.
	 */
	public Design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 503);
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.green);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		panel.setPreferredSize(new Dimension(0, 120));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		panel.add(btnNewButton);
		
		panel.add(btnNewButton_1);
		
		panel.add(btnNewButton_2);

		panel.add(btnNewButton_3);

		
		panel.add(lblNewLabel);
		
		panel.add(textField);
		textField.setColumns(10);

		panel.add(btnNewButton_4);
		
		panel.add(lblNewLabel_1);
		panel.add(textField_1);
		textField_1.setColumns(10);
		panel.add(btnNewButton_5);

		panel.add(lblNewLabel_2);
		
		textField_2.setText("");
		panel.add(textField_2);
		textField_2.setColumns(10);
		panel.add(btnNewButton_7);

		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(textArea);
	}

}
