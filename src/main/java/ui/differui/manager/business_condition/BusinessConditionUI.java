package ui.differui.manager.business_condition;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class BusinessConditionUI extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public BusinessConditionUI(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		JLabel infoBar = new JLabel("经营情况表");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
			
	}
	
	public void actionPerformed(ActionEvent events) {
		
	}
}
