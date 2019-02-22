package medic.service;

import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

public class Calc implements ActionListener, ItemListener{

	private JFrame frame , newframe;
	private JTextField textField , textField1 , textField_1 , textField_2 , textField_3 , textField_4 , textField_5 , textField_6 , textField_7;
	private JLabel addlabel1 , addlabel2 , addlabel3 , addlabel4 , addlabel5 , addlabel6 , textPane11;
	private JButton button , newbutton , newbutton_1 , button1_1 , closebutton;
	JLabel label11 , label12 , label13 , label14 , label15 , label16 , label17 , label18 , label19;
	private DefaultListModel<String> model;
	private JList<String> list;
	private String[][] catadata;
	private Double[][] cataprice , limit;
	private JComboBox<String> comboBox , comboBox_1;
	private Double totalcost = 0.0;
	private String filename = null;
	/**
	 * Launch the application.
	 */
	public Calc(int i) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
					window.frame.setTitle("中心报销");
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
	public Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	//初始化报销窗口
		try {
			init();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 783, 526);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(94, 40, 140, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		label11 = new JLabel("姓名");
		label11.setBounds(44,40,36,24);
		frame.getContentPane().add(label11);
		
		label12 = new JLabel("人员ID");
		label12.setBounds(261, 40, 52, 24);
		frame.getContentPane().add(label12);
		
		textField_1 = new JTextField();
		textField_1.setBounds(327, 40, 140, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		label13 = new JLabel("医疗机构编码");
		label13.setBounds(14, 143, 96, 24);
		frame.getContentPane().add(label13);
		
		textField_2 = new JTextField();
		textField_2.setBounds(127, 143, 220, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		label14 = new JLabel("医疗机构名称");
		label14.setBounds(371, 143, 96, 24);
		frame.getContentPane().add(label14);
		
		textField_3 = new JTextField();
		textField_3.setBounds(494, 143, 220, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		label15 = new JLabel("申报原因");
		label15.setBounds(494, 40, 66, 24);
		frame.getContentPane().add(label15);
		
		textField_4 = new JTextField();
		textField_4.setBounds(574, 40, 140, 24);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		
		label16 = new JLabel("病种名称");
		label16.setBounds(14, 91, 66, 24);
		frame.getContentPane().add(label16);
		
		textField_5 = new JTextField();
		textField_5.setBounds(94, 91, 140, 24);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		label17 = new JLabel("病种编码");
		label17.setBounds(247, 91, 66, 24);
		frame.getContentPane().add(label17);
		
		textField_6 = new JTextField();
		textField_6.setBounds(327, 91, 140, 24);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		label18 = new JLabel("住院次数");
		label18.setBounds(494, 91, 66, 24);
		frame.getContentPane().add(label18);
		
		textField_7 = new JTextField();
		textField_7.setBounds(574, 91, 140, 24);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		label19 = new JLabel("结算明细");
		label19.setBounds(14, 186, 66, 24);
		frame.getContentPane().add(label19);
		
		button = new JButton("添加");
		button.setBounds(14, 223, 66, 27);
		button.addActionListener(this);
		frame.getContentPane().add(button);
		
		newbutton = new JButton("保存");
		newbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	//保存后给出提示消息
					save();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		newbutton.setBounds(196, 399, 70, 30);
		frame.getContentPane().add(newbutton);
		
		closebutton = new JButton("取消");
		closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	//取消报销，同时删除本次已保存的文件
					if(filename == null) return;
					//System.out.println(filename);
					File newfile = new File(filename);
					if(newfile.exists()) newfile.delete();
					JOptionPane.showMessageDialog(null, "成功取消本次报销！", "取消成功", JOptionPane.INFORMATION_MESSAGE); 
					frame.dispose();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		closebutton.setBounds(327, 399, 70 , 30);
		frame.getContentPane().add(closebutton);
		
		newbutton_1 = new JButton("关闭");
		newbutton_1.setBounds(458, 399, 70, 30);
		newbutton_1.addActionListener(this);
		frame.getContentPane().add(newbutton_1);
		
		model = new DefaultListModel<>();
		list = new JList<>(model);
		list.setSize(620, 200);
		list.setLocation(94, 186);
		frame.getContentPane().add(list);
	}
	
	/**
	 * 点击事件处理
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newbutton_1) frame.dispose();
		if(e.getSource() == button) additem();
		if(e.getSource() == button1_1){	//计算报销总金额
			String s = "";
			s = addlabel5.getText();
			String stringlist =  comboBox.getSelectedItem()+","+comboBox_1.getSelectedItem()+","+addlabel2.getText()
				  					+","+s+","+textField1.getText();
			//System.out.println(s);
			if( !s.equals("") ){
				Double middata = Double.parseDouble(s);
				int midindex1 = comboBox.getSelectedIndex()+1 , midindex2 = comboBox_1.getSelectedIndex()+1;;
				switch(comboBox.getSelectedIndex()){
					case 2:
						totalcost += middata;
						break;
					case 1:
						if(middata > limit[midindex1][midindex2]) totalcost += limit[midindex1][midindex2] * 0.5 + (middata - limit[midindex1][midindex2]);
						else totalcost += middata * 0.5;
						break;
					default:break;
				}
				model.addElement(stringlist);
			}else JOptionPane.showMessageDialog(null, "未输入信息！", "添加失败", JOptionPane.ERROR_MESSAGE); 
			newframe.dispose();
		}
	}
	
	/**
	 * 下拉框状态处理
	 * @param e
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void itemStateChanged(final ItemEvent e) {
		int index = comboBox.getSelectedIndex();
		textField1.setText("");
		if(e.getSource() == comboBox){
	        int i;
	        addlabel2.setText("");
	        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {}));
	        switch(index){
	        case 0:
	       	 i = Integer.parseInt(catadata[1][0]);
	       	 for(int j=1;j<=i;++j)
	       		comboBox_1.insertItemAt(catadata[1][j], j-1);
	       	 break;
	        case 1:
	        	i = Integer.parseInt(catadata[2][0]);
	          	for(int j=1;j<=i;++j)
	          		comboBox_1.insertItemAt(catadata[2][j], j-1);
	       	 break;
	        case 2:
	        	i = Integer.parseInt(catadata[3][0]);
	        	for(int j=1;j<=i;++j)
	          		comboBox_1.insertItemAt(catadata[3][j], j-1);
	       	 break;
	        }
		}
		if(e.getSource() == comboBox_1){
			//System.out.println(1);
			int index1 = comboBox_1.getSelectedIndex();
			//System.out.println(index);
			//System.out.println(index1);
			addlabel2.setText(cataprice[index+1][index1+1].toString());
			
			//System.out.println(cataprice[index+1][index+1]);
		}
      }
	
	/**
	 * 保存文件，同时获得本次的文件名
	 * @throws Exception
	 */
	
	private void save() throws Exception{
		String line1 = textField_1.getText();
		if(line1.equals("")){
			JOptionPane.showMessageDialog(null, "未输入人员id！", "保存失败", JOptionPane.ERROR_MESSAGE); 
			return;
		}
		Integer index = 1;
		filename = "D:\\eclipse files\\java-neon\\Java_design\\files\\"+line1+"_"+index.toString()+".txt";
		for(;(new File(filename)).exists();){
			++index;
			filename = "D:\\eclipse files\\java-neon\\Java_design\\files\\"+line1+"_"+index.toString()+".txt";
		}
		new File(filename).createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		writer.write(textField.getText()+"_"+textField_1.getText()+"_"+textField_2.getText()+"_"+textField_3.getText()+
					 "_"+textField_4.getText()+"_"+textField_5.getText()+"_"+textField_6.getText()+"_"+textField_7.getText());
		writer.newLine();
		writer.flush();
		int size = model.size();
		for(int i=0;i<size;++i){
			writer.write(model.getElementAt(i));
			writer.newLine();
			writer.flush();
		}
		writer.write(totalcost.toString());
		writer.newLine();
		writer.flush();
		writer.close();
		JOptionPane.showMessageDialog(null, "保存成功！本次总自费金额为 "+totalcost.toString()+" 元.", "保存成功", JOptionPane.INFORMATION_MESSAGE); 
	}
	
	/**
	 * 添加处方
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void additem(){
		newframe = new JFrame();
		newframe.setTitle("添加处方");
		newframe.setBounds(100, 100, 442, 378);
		newframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newframe.getContentPane().setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"甲", "乙", "丙"}));
		comboBox.setBounds(201, 30, 89, 24);
		comboBox.addItemListener(this);
		newframe.getContentPane().add(comboBox);
		
		textPane11 = new JLabel();
		textPane11.setText("收费项目等级");
		textPane11.setBounds(91, 30, 96, 24);
		newframe.getContentPane().add(textPane11);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {}));
		
      	for(int j=1 , i = Integer.parseInt(catadata[1][0]);j<=i;++j)
      		comboBox_1.insertItemAt(catadata[1][j], j-1);
      	
		comboBox_1.setBounds(201, 67, 89, 24);
		comboBox_1.addItemListener(this);
		newframe.getContentPane().add(comboBox_1);
		
		addlabel1 = new JLabel();
		addlabel1.setText("项目名称");
		addlabel1.setBounds(121, 67, 66, 24);
		newframe.getContentPane().add(addlabel1);
		
		addlabel2 = new JLabel();
		addlabel2.setBounds(201, 104, 89, 24);
		newframe.getContentPane().add(addlabel2);
		
		addlabel3 = new JLabel();
		addlabel3.setText("单价");
		addlabel3.setBounds(151, 104, 36, 24);
		newframe.getContentPane().add(addlabel3);
		
		addlabel4 = new JLabel();
		addlabel4.setText("数量");
		addlabel4.setBounds(151, 145, 36, 24);
		newframe.getContentPane().add(addlabel4);
		
		textField1 = new JTextField();
		textField1.setBounds(201, 145, 89, 24);
		textField1.getDocument().addDocumentListener(new DocumentListener() 
		{
			public void insertUpdate(DocumentEvent event){
				if(textField1.getText().equals("")){
					addlabel5.setText("");
					return;
				}
				Double number = Double.parseDouble(textField1.getText()) * Double.parseDouble(addlabel2.getText());
				addlabel5.setText(number.toString());
			}
			public void removeUpdate(DocumentEvent event){
				if(textField1.getText().equals("")){
					addlabel5.setText("");
					return;
				}
				Double number = Double.parseDouble(textField1.getText()) * Double.parseDouble(addlabel2.getText());
				addlabel5.setText(number.toString());
			}         	
			public void changedUpdate(DocumentEvent event){
				if(textField1.getText().equals("")){
					addlabel5.setText("");
					return;
				}
				Double number = Double.parseDouble(textField1.getText()) * Double.parseDouble(addlabel2.getText());
				addlabel5.setText(number.toString());
			} 
		});
		newframe.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		addlabel5 = new JLabel();
		addlabel5.setBounds(201, 182, 89, 24);
		newframe.getContentPane().add(addlabel5);
		
		addlabel6 = new JLabel();
		addlabel6.setText("金额");
		addlabel6.setBounds(151, 182, 36, 24);
		newframe.getContentPane().add(addlabel6);
		
		button1_1 = new JButton("添加");
		button1_1.setBounds(151, 250, 113, 27);
		button1_1.addActionListener(this);
		newframe.getContentPane().add(button1_1);
		
		newframe.setVisible(true);
	}
	
	/**
	 * 初始化，获得操作中需要的数据
	 * @throws IOException
	 */
	
	private void init() throws IOException{
		catadata = new String [4][100];
		cataprice = new Double [4][100];
		limit = new Double [4][100];
		filename = "D:\\eclipse files\\java-neon\\Java_design\\files\\catadata\\";
		BufferedReader reader = null;
		String line = null;
		for(Integer i=1;i<=3;++i){
			reader = new BufferedReader(new FileReader(filename+i.toString()+".txt"));
			line = reader.readLine();
			if(line.equals("")||null == line) continue;
			Integer index = Integer.parseInt(line);
			catadata[i][0]=index.toString();
			for(int j=1;j<=index;++j){
				StringTokenizer a = new StringTokenizer(reader.readLine(),"_");
				catadata[i][j] = a.nextToken();
				cataprice[i][j] = Double.parseDouble(a.nextToken());
				limit[i][j] = Double.parseDouble(a.nextToken());
			}
		}
		reader.close();
	}

}
