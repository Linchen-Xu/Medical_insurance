package medic.ui;


import java.awt.*;  
import javax.swing.*;
import java.awt.event.*;  
import medic.service.*;


public class WindowInitial extends JFrame implements ActionListener  
{  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;  
	JFrame frame;
    JButton button1 , button2 , button3 , button4 , button5 , button6;
    WindowInitial(){  
        init();  
        //setSize(300,200);
        setBounds(600,300,210,250);  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
    }  
    public void init(){  
        button1 = new JButton("    公共业务管理    ");
        button2 = new JButton("医疗基本信息维护");
        button3 = new JButton("医疗中心报销管理");
        button5 = new JButton("    特检特治审批    ");
        button6 = new JButton("医疗人员费用查询");
        button4 = new JButton("              退出             ");
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        panel = new JPanel();  
        setLayout(new GridLayout(1,4));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button5);
        panel.add(button6);
        panel.add(button4);
        this.add(panel);
    }  
    public void actionPerformed(ActionEvent e){ 
    	if(e.getSource() == button1) new First();
    	if(e.getSource() == button2) new Second();
    	if(e.getSource() == button3) new Calc(1);
    	if(e.getSource() == button5) new Fourth();
    	if(e.getSource() == button6) new Chk(1);
        if(e.getSource() == button4){
        	dispose();
        	System.exit(0);
        }
        
    }  
}  