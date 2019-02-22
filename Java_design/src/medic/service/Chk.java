package medic.service;

import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Chk implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JLabel label;
	private String [][] list;

	/**
	 * Launch the application.
	 */
	public Chk(int i) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chk window = new Chk();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Chk() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(209, 68, 128, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		label = new JLabel("«Î ‰»Î±‡∫≈ªÚ–’√˚£∫");
		label.setBounds(60, 71, 135, 18);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("≤È—Ø±‡∫≈");
		button.setBounds(85, 143, 113, 27);
		button.addActionListener(this);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("≤È—Ø–’√˚");
		button_1.setBounds(224, 143, 113, 27);
		button_1.addActionListener(this);
		frame.getContentPane().add(button_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String path = "D:\\eclipse files\\java-neon\\Java_design\\files\\fee";
		File root = new File(path);
		File[] files = root.listFiles();
		Integer index = 0;
		list = new String[100][3];
		for(File a:files){
			String line = a.getAbsolutePath();
		}
	}
}

