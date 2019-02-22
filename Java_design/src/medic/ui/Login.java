package medic.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//定义一个登录界面
public class Login extends JFrame implements ActionListener{
  
//入口主函数
   
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
		//设置窗体的标题属性
		jf.setTitle("登录");
		//设置窗体的大小属性
		jf.setSize(300,200);
		//设置窗体的位置属性
		jf.setLocation(800,400);
		//设置窗体关闭时退出程序
		jf.setDefaultCloseOperation(3);
		//设置禁止调整窗体的大小
		jf.setResizable(false);
		//实例化一个布局类的对象
		FlowLayout fl = new FlowLayout();
		//设置窗体的布局方式为流式布局
		jf.setLayout(fl);
		//实例化一个JLabel标签类的对象
		JLabel jlaName = new JLabel("                                          ");
		//将jlaName对象添加到容器JFrame对象上
		jf.add(jlaName);
		//实例化一个JTextField对象
		jteName = new JTextField("admin",20);
		//将jteName对象添加到容器JFrame对象上
		jf.add(jteName);
		//实例化一个JPasswordField对象
		jpaName = new JPasswordField("123456",20);
		//将jpaName对象添加到容器JFrame对象上
		jf.add(jpaName);
		//实例化一个JCheckBox对象
		JButton jbuName = new JButton("           登   录          ");
		//将jButton对象添加到容器JFrame对象上
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