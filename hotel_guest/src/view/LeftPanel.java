package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class LeftPanel extends JPanel{

	JPanel westPanel = new JPanel();
	
	public LeftPanel() {
		this.setSize(new Dimension(200, 500));
	}
	
	public void init() {
		westPanel.setBackground(Color.GREEN);
		westPanel.setPreferredSize(new Dimension(220, 580));
		//westPanel.setLayout(mgr);
	}

	public JPanel getWestPanel() {
		init();
		return westPanel;
	}

	public void setWestPanel(JPanel westPanel) {
		this.westPanel = westPanel;
	}

}
