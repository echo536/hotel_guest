package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.room.Room;

public class RightPanel extends JPanel{

	JPanel centerPanel = new JPanel();
	
	public RightPanel() { }
	
	public RightPanel(JPanel left, JPanel right) {
		
	}
	
	public void init() {
		
	}
	
	public void displayRoom(Room[] room) {
		int lenght = room.length;
		
		for(int i = 0; i < lenght; i++) {
			JButton button = new JButton(String.valueOf(room[i].getRoom_num()));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

}
