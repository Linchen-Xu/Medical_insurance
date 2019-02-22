package medic.service;

import java.awt.*;  
import javax.swing.*;
import java.awt.event.*;  


public class Second extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JButton button1,button2,button3,button4,button5,button6;
	public Second(){
		init();
		this.setBounds(600,300,210,280);
		this.setVisible(true);
		this.setTitle("医疗基本信息维护");
	}
	private void init(){
		button1 = new JButton("   药品信息维护     ");
		button2 = new JButton("诊疗项目信息维护");
		button3 = new JButton("服务设施项目维护");
		button4 = new JButton("定点医疗机构信息");
		button5 = new JButton("医疗待遇计算参数");
		button6 = new JButton("             关闭              ");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		panel = new JPanel();
		setLayout(new GridLayout(1,5));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		this.add(panel);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1 )
			try {
				new Med(1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		if(e.getSource() == button2 ) 
			try {
				new Pro(1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		if(e.getSource() == button3 )
			try {
				new Fac(1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		if(e.getSource() == button4 ) 
			try {
				new Ins(1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		if(e.getSource() == button5 ) 
			try {
				new MedTreat(1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		if(e.getSource() == button6 ) this.dispose();
	}

}
