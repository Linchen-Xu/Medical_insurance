package medic.service;

import java.awt.*;  
import javax.swing.*;
import java.awt.event.*;  


public class Fourth extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JButton button1,button2,button3;
	public Fourth(){
		init();
		this.setBounds(600,300,210,200);
		this.setVisible(true);
		this.setTitle("ҽ�ƴ�������");
	}
	private void init(){
		panel = new JPanel();
		button1 = new JButton("��Ա�����������");
		button2 = new JButton("   �ؼ���������   ");
		button3 = new JButton("         �ر�            ");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		setLayout(new GridLayout(1,5));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		this.add(panel);
	}
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == button1)
			try {
				new PersonofIns(1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if(e.getSource() == button2)
			try {
				new Specialmed(1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if(e.getSource() == button3) this.dispose(); 
	}

}
