package medic.service;

import java.awt.*;  
import javax.swing.*;
import java.awt.event.*;  


public class First extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JButton button1,button2,button3;
	public First(){
		init();
		this.setBounds(600,300,210,200);
		this.setVisible(true);
		this.setTitle("����ҵ��");
	}
	public void init(){
		button1 = new JButton("��λ������Ϣά��");
        button2 = new JButton("���˻�����Ϣά��");
        button3 = new JButton("             �ر�             ");
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        panel = new JPanel();  
        setLayout(new GridLayout(1,3));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        this.add(panel);
	}
	public void actionPerformed(ActionEvent e){ 
    	if(e.getSource() == button1)
			try {
				new Comp(1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	if(e.getSource() == button2)
			try {
				new Per(1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        if(e.getSource() == button3) this.dispose();
    }  

}
