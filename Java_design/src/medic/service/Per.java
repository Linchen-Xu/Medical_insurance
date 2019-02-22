package medic.service;


import java.awt.*;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class Per extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel model;
	JScrollPane scrollPane;
	private JTextField aTextField;  
	private JTable table;
	String[] column = {"id","citicode","name","sex","birthday"};
	String[] data = {"a","b","c","d","e"};
	Integer size;
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public Per(int i) throws Exception {
		
		//System.out.println(1111);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Per data1 = new Per();
					data1.setTitle("个人基本信息维护");
					data1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the frame.
	 */
	public Per() {
		super();
		setBounds(100, 100, 700, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		model = new DefaultTableModel (null, column);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane,BorderLayout.CENTER);  
		//排序:  
        table.setRowSorter(new TableRowSorter<DefaultTableModel>(model));  
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选  
        table.addMouseListener(new MouseAdapter(){    //鼠标事件  
            public void mouseClicked(MouseEvent e){  
                int selectedRow = table.getSelectedRow(); //获得选中行索引  
                Object oa = model.getValueAt(selectedRow, 0);  
                aTextField.setText(oa.toString());  //给文本框赋值  
            }  
        });  
        scrollPane.setViewportView(table);  
        final JPanel panel = new JPanel();  
        getContentPane().add(panel,BorderLayout.SOUTH);  
        aTextField = new JTextField("",8);  
        panel.add(aTextField);  
        
        try {
			readper("D:\\eclipse files\\java-neon\\Java_design\\files\\person.txt");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        
        final JButton addButton = new JButton("添加");   //添加按钮  
        addButton.addActionListener(new ActionListener(){//添加事件  
            public void actionPerformed(ActionEvent e){  
                String []rowValues = {aTextField.getText()}; 
                if(rowValues[0].equals("")){
                	JOptionPane.showMessageDialog(null, "请输入id信息！", "添加失败", JOptionPane.ERROR_MESSAGE);
                	return;
                }
                Integer row = model.getRowCount()+1;
                model.addRow(rowValues);  //添加一行  
                aTextField.setText(row.toString());  
            }  
        });  
        panel.add(addButton);    
        
        final JButton searchButton1 = new JButton("查编号");   //添加按钮  
        searchButton1.addActionListener(new ActionListener(){//添加事件  
            public void actionPerformed(ActionEvent e){  
                String []rowValues = {aTextField.getText()};  
                findInTable(rowValues[0]);
            }  
        });  
        panel.add(searchButton1);    
        
        final JButton searchButton2 = new JButton("查名称");   //添加按钮  
        searchButton2.addActionListener(new ActionListener(){//添加事件  
        	public void actionPerformed(ActionEvent e){  
        		String []rowValues = {aTextField.getText()};  
        		findInTable(rowValues[0]);
        	}  
        });  
        panel.add(searchButton2);    
        
          
        final JButton delButton = new JButton("删除");  
        delButton.addActionListener(new ActionListener(){//添加事件  
            public void actionPerformed(ActionEvent e){  
                int selectedRow = table.getSelectedRow();//获得选中行的索引  
                if(selectedRow!=-1)  //存在选中行  
                {  
                    model.removeRow(selectedRow);  //删除行  
                }  
            }  
        });  
        panel.add(delButton);
        
        final JButton saveButton = new JButton("保存");  
        saveButton.addActionListener(new ActionListener(){//添加事件  
        	public void actionPerformed(ActionEvent e){  
        		try {
        			save("D:\\eclipse files\\java-neon\\Java_design\\files\\person.txt");
        			JOptionPane.showMessageDialog(null, "保存成功！", "保存成功", JOptionPane.INFORMATION_MESSAGE); 
        		} catch (Exception e1) {
        			e1.printStackTrace();
        		}
        	}  
        });  
        panel.add(saveButton);  
        
        final JButton exitButton = new JButton("关闭");  
        exitButton.addActionListener(new ActionListener(){//添加事件  
        	public void actionPerformed(ActionEvent e){  
        		dispose();
        	}  
        });  
        panel.add(exitButton);
    }  
	
	private void findInTable(String str){
		int rowCount = table.getRowCount();
		int columnCount = table.getColumnCount();
		for (int i = 0; i < rowCount; i++) {
			for (int k = 0; k < columnCount; k++) {
				Object value = table.getValueAt(i, k);
				if (str.equals(value)) {
					table.getSelectionModel().setSelectionInterval(i, i);
					Rectangle cellRect = table.getCellRect(i, k, true);
					table.scrollRectToVisible(cellRect);
					return;
				}
			}
		}
	}
	
	@SuppressWarnings("resource")
	public void readper(String filename) throws Exception{
		File file = new File(filename);
		BufferedReader reader = null;
		//System.out.println(1);
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			line = reader.readLine();
			if(null == line) return;
			size = Integer.parseInt(line);
			//System.out.println(size);
			for(int i=0;i<size;++i){
				line = reader.readLine();
				StringTokenizer a = new StringTokenizer(line,"_");
				data[0]=a.nextToken();
				data[1]=a.nextToken();
				data[2]=a.nextToken();
				data[3]=a.nextToken();
				data[4]=a.nextToken();
				model.addRow(data);
				//System.out.println(data[i][0]+","+data[i][1]+","+data[i][2]);
			}
			//System.out.println(111);
		reader.close();
	}
	
	
	public void save(String filename) throws Exception{
		FileWriter file = new FileWriter(filename);
		BufferedWriter writer = new BufferedWriter(file);
		String line = null;
		size = table.getRowCount();
		writer.write(size.toString());
		writer.newLine();
		writer.flush(); 
		for(int i=0;i<size;++i){
			line = model.getValueAt(i,0)+"_"+model.getValueAt(i,1)+"_"+model.getValueAt(i,2)+"_"+model.getValueAt(i,3)+"_"+model.getValueAt(i,4);
			writer.write(line);
			writer.newLine();
			writer.flush(); 
		}
		writer.close();
	}
	
}
