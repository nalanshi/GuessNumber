package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.Controller;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel = new JLabel("Guess Number");
	private model.Number number = new model.Number(10, 5);
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
		
		textField.setBounds(147, 121, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Button");
		btnNewButton.addActionListener(new Controller(number,this));
		btnNewButton.setBounds(144, 173, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel.setBounds(78, 34, 241, 75);
		contentPane.add(lblNewLabel);
	}

	public JTextField getTextField() {
		// TODO Auto-generated method stub
		return textField;
	}
	public JLabel getJlabel() {
		return lblNewLabel;
	}
}
