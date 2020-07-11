package Psql;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Design extends JFrame {

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
	protected JButton btnNewButton = new JButton("count-by-year");
	protected JButton btnNewButton_1 = new JButton("order-by-score");
	protected JButton btnNewButton_2 = new JButton("count-by-avg");
	protected JButton btnNewButton_4 = new JButton("count-by-courses");
	protected JButton btnNewButton_3 = new JButton("query students");
	protected JLabel lblNewLabel = new JLabel("student number");
	protected JButton btnNewButton_5 = new JButton("query students");
	protected JLabel lblNewLabel_1 = new JLabel("teacher number");
	protected JLabel lblNewLabel_2 = new JLabel("class number");
	protected JButton btnNewButton_7 = new JButton("courses of class query");
	protected JScrollPane scrollPane = new JScrollPane();
	protected JTextArea textArea = new JTextArea();
	/**
	 * Create the frame.
	 */
	public Design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 503);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		panel.setPreferredSize(new Dimension(0, 150));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		panel.add(btnNewButton);
		
		panel.add(btnNewButton_1);
		
		panel.add(btnNewButton_2);
		
		panel.add(btnNewButton_3);
		
		panel.add(lblNewLabel);
		
		panel.add(textField);
		textField.setColumns(10);
		
		panel.add(btnNewButton_5);
		
		panel.add(lblNewLabel_1);
		
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		panel.add(btnNewButton_4);
		
		panel.add(lblNewLabel_2);
		
		textField_2.setText("");
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		panel.add(btnNewButton_7);
		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(textArea);
	}

}
