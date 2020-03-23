package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NorthPanel {

	JPanel northPanel = new JPanel();
	
	public NorthPanel() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void init() {
		northPanel.setPreferredSize(new Dimension(980, 120));
		northPanel.setLayout(null);	
		/*
		reception.setBackground(Color.WHITE);
		
		
		northPanel.add(reception);
		northPanel.add(client);
		northPanel.add(room);
		northPanel.add(query);
		northPanel.add(statistics);
		northPanel.add(user);
		northPanel.add(setting);*/
	}

	public JPanel getNorthPanel() {
		init();
		return northPanel;
	}

	public void setNorthPanel(JPanel northPanel) {
		this.northPanel = northPanel;
	}
}
