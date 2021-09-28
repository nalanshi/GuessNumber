package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.*;

public class View extends JFrame {
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JLabel log_show = new JLabel();
	private JPanel contentPane;
	private JLabel lblNewLabel = new JLabel("Guess Number");
	private model.Number number = new model.Number( 5);
	private JTextField textField = new JTextField();
	/**
	 * Launch the application.
	 *

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField.setBounds(60, 121, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Button");
		btnNewButton.addActionListener(new Controller(number,this));
		btnNewButton.setBounds(60, 173, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton1 = new JButton("Log");
		btnNewButton1.addActionListener(new Controller(number,this));
		btnNewButton1.setBounds(250, 50, 89, 23);
		contentPane.add(btnNewButton1);



		textArea = new JTextArea();
		textArea.setTabSize(7);
		textArea.setEnabled(false);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(200, 90, 210, 130);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);


		lblNewLabel.setBounds(60, 34, 241, 75);
		contentPane.add(lblNewLabel);

	}

	public JTextField getTextField() {
		// TODO Auto-generated method stub
		return textField;
	}

	public void refreshLog(String text){
		System.out.println(text);
		textArea.setText(text);
		scrollPane.updateUI();
	}

	public JLabel getJlabel() {
		return lblNewLabel;
	}
}
