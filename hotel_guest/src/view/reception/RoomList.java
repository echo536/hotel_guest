package view.reception;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import swing.CircularButton;

public class RoomList extends JPanel implements ActionListener{
	private Hashtable roomList = new Hashtable();
	
	private JPanel panelMain = null;
	
	private int column = 5;
	private int row = 3;
	
	// 按键总数
	private int buttonTotal = 15;
	
	// 按键计数器
	private int buttonCount = 0;
	
	public RoomList() {
	}
	
	public RoomList(int roomQuantity) {
		super(new BorderLayout());
		this.setPreferredSize(new Dimension(854, 403));
		
		// 定义滚动面板
		JScrollPane spMain;
		
		int authenticRow = roomQuantity / column;
		if(authenticRow > row) {
			if(roomQuantity % column == 0) {
				row = authenticRow;
			} else {
				row = authenticRow + 1;
			}
			buttonTotal = roomQuantity;
		}
		
		// 建立按键面板
		panelMain = new JPanel(new GridLayout(row, column, 59, 50));
		panelMain.setBorder(new EmptyBorder(40, 50, 20, 50));
		

		//panelMain.setBackground(new Color(248, 242, 230));
		spMain = new JScrollPane(panelMain);

		// 加入主面板
		this.add("Center", spMain);	
	}

	public JButton addButton(int roomNum) {
		CircularButton circularButton = new CircularButton(String.valueOf(roomNum));
		circularButton.setBorderPainted(false);				//设置按键无边框
		circularButton.setPreferredSize(new Dimension(100, 100));
		circularButton.setBackground(new Color(78, 163, 255));
		panelMain.add(circularButton);		  				//将按键加入按键面板
		roomList.put(roomNum, circularButton);					//将按键存入哈希表
		buttonCount++;								//按键记数器+1
		return circularButton;
	}
	
	public JButton getButton(int roomNum) {
		return (JButton)roomList.get(roomNum);
	}
	
	public void supplementButton() {
		if(buttonCount < buttonTotal) {
			for (int i = 0; i < buttonTotal - buttonCount; i++) {
				JLabel lb = new JLabel("　");
				panelMain.add(lb);				//补空位
		    }
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
	}
	
	
}
