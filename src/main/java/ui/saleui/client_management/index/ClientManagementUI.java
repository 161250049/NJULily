package ui.saleui.client_management.index;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.myui.MyComboBox;
import ui.myui.MyJButton;
import ui.myui.MyPanel;
import ui.myui.MyTable;
import ui.myui.MyTextField;
import ui.saleui.client_management.adding.ClientAddingUI;
import ui.saleui.client_management.detail_and_motifying.ClientDetailUI;

public class ClientManagementUI extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyJButton button_return, button_add, button_cam;
	
	public static JButton button_close;
	
	public ClientManagementUI(){
		
		JLabel infoBar = new JLabel("                     客户管理");
		infoBar.setBounds(0, 0, 1100, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(new Color(1, 1, 1, 0.55f));
		infoBar.setBackground(new Color(1, 1, 1, 0.05f));
		this.add(infoBar);
		
		//add a combo box (for choosing the selected way)
		String[] comboBoxStr = {"-------请选择一种搜索方式-------", "模糊查找"
				, "客户编号(ID)", "客户星级", "客户分类", "客户名称", "默认业务员"};
		MyComboBox comboBox = new MyComboBox(25, 15 + 20, 200, 25,comboBoxStr);
		this.add(comboBox);
		
		//add a text field (for typing the selected way)
		MyTextField textField = new MyTextField(235, 15 + 20, 200, 25);
		textField.setText("在此输入搜索关键字");
		this.add(textField);
		
		//add a button for starting the searching process
		MyJButton button_search = new MyJButton("搜索");
		button_search.setBounds(445, 15 + 20, 130, 25);
		button_search.addActionListener(this);
		this.add(button_search);		
		
		//add a button for showing all the client to the table
		MyJButton button_showAll = new MyJButton("显示全部客户");
		button_showAll.setBounds(944, 15 + 20, 130, 25);
		button_showAll.addActionListener(this);
		this.add(button_showAll);	
		
		//add a table for showing the information of the clients(the table is contained in a scroll pane)
		String[] headers = {"行号","客户编号","客户分类","客户星级"
				,"客户名称","默认业务员","应收付差额","应收","应付"};
		MyTable table = new MyTable(headers);
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(25, 50 + 20, 1050, 550);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		//add a button for adding a new client
		button_add = new MyJButton("新增一名客户");
		button_add.setBounds(25 + 420, 610 + 20, 130, 25);
		button_add.addActionListener(this);
		this.add(button_add);	
		
		//add a button for deleting a selected client
		MyJButton button_del = new MyJButton("删除所选客户");
		button_del.setBounds(165 + 420, 610 + 20, 130, 25);
		button_del.addActionListener(this);
		this.add(button_del);	
		
		//add a button for checking and modifying the information of a selected client
		button_cam = new MyJButton("修改或查看所选客户详细信息");
		button_cam.setBounds(305 + 420, 610 + 20, 210, 25);
		button_cam.addActionListener(this);
		this.add(button_cam);	
		
		//add a button for returning to the last UI
		button_return = new MyJButton("返回");
		button_return.setBounds(525 + 450, 610 + 20, 100, 25);
		button_return.addActionListener(this);
		this.add(button_return);	
		
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
					
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_return){
			ExitFunctionFrame eff = new ExitFunctionFrame("ClientManagementUI");
			eff.setVisible(true);
		}
		
		if(events.getSource() == button_add){
			ClientAddingUI window_add = new ClientAddingUI();
			window_add.setVisible(true);
		}
		
		if(events.getSource() == button_cam){
			ClientDetailUI window_detail = new ClientDetailUI();
			window_detail.setVisible(true);
		}
		
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
	}
}
