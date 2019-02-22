package medic.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//����һ����¼����
public class Login extends JFrame implements ActionListener{
  
//���������
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String account;
	private String password;
	private JTextField jteName;
	private JPasswordField jpaName;
	private JFrame jf;

	public static void main(String[] args) {
		Login loginui = new Login();
		loginui.initGUI();
	}

	public void initGUI(){
		jf = new JFrame();
		//���ô���ı�������
		jf.setTitle("��¼");
		//���ô���Ĵ�С����
		jf.setSize(300,200);
		//���ô����λ������
		jf.setLocation(800,400);
		//���ô���ر�ʱ�˳�����
		jf.setDefaultCloseOperation(3);
		//���ý�ֹ��������Ĵ�С
		jf.setResizable(false);
		//ʵ����һ��������Ķ���
		FlowLayout fl = new FlowLayout();
		//���ô���Ĳ��ַ�ʽΪ��ʽ����
		jf.setLayout(fl);
		//ʵ����һ��JLabel��ǩ��Ķ���
		JLabel jlaName = new JLabel("                                          ");
		//��jlaName������ӵ�����JFrame������
		jf.add(jlaName);
		//ʵ����һ��JTextField����
		jteName = new JTextField("admin",20);
		//��jteName������ӵ�����JFrame������
		jf.add(jteName);
		//ʵ����һ��JPasswordField����
		jpaName = new JPasswordField("123456",20);
		//��jpaName������ӵ�����JFrame������
		jf.add(jpaName);
		//ʵ����һ��JCheckBox����
		JButton jbuName = new JButton("           ��   ¼          ");
		//��jButton������ӵ�����JFrame������
		jbuName.addActionListener(this);
		jf.add(jbuName);
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		account = jteName.getText();
		password = new String(jpaName.getPassword());
		if(account.equals("admin")&&password.equals("123456")){
			jf.dispose();
			new Main();
		}
	}
	  
}