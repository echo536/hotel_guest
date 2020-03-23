package view.reception;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import model.room.Room;
import presenter.system.Sys;

public class ReceptionPanel extends JPanel implements ActionListener{	
	private JTabbedPane rightPanel = null;
	private ReceptionLeftPanel leftPanel= null;
	private JButton[] buttons = null;
	
	private Room[] roomTypeOne = null;  
	private Room[] roomTypeTwo = null;  
	private Room[] roomTypeThree = null;
	private Room[] roomTypeFour = null; 
	private Room[] roomTypeFive = null; 
	
	private JPanel roomTypeOneButton = null;
	private JPanel roomTypeTwoButton = null;
	private JPanel roomTypeThreeButton = null;
	private JPanel roomTypeFourButton = null;
	private JPanel roomTypeFiveButton = null;
	
	Hashtable ht = new Hashtable();
	Sys sys = null;
	
	public ReceptionPanel(Sys sys) {
		super();
		this.sys = sys;
		leftPanel = new ReceptionLeftPanel();
		//buildLeft();
		buildRight();
		this.setLayout(new BorderLayout());
		this.add("West", leftPanel);
		this.add("East", rightPanel);
		this.setBorder(new EmptyBorder(5, 3, 5, 0));
	}
	
	public void buildLeft() {
		leftPanel = new ReceptionLeftPanel();
		leftPanel.setBorder(new EmptyBorder(40, 20, 40, 20));
		leftPanel.setPreferredSize(new Dimension(220, 120));
		leftPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		//leftPanel.setBorder(BorderFactory.createLineBorder(new Color(78, 163, 255), 1));
	}
	
	public void buildRight() {
		rightPanel = new JTabbedPane();
		
		roomTypeOne = sys.getRoomTypeOne();
		roomTypeTwo = sys.getRoomTypeTwo();
		roomTypeThree = sys.getRoomTypeThree();
		roomTypeFour =sys.getRoomTypeFour();
		roomTypeFive =sys.getRoomTypeFive();
		
		roomTypeOneButton = buildRoomList(roomTypeOne);
		roomTypeTwoButton = buildRoomList(roomTypeTwo);
		roomTypeThreeButton = buildRoomList(roomTypeThree);
		roomTypeFourButton = buildRoomList(roomTypeFour);
		roomTypeFiveButton = buildRoomList(roomTypeFive);
		
	    //制作ViewList面板并加入rightPanel
	    //rightPanel.addTab("全 部 房 间", buildRoomList(room));
	    rightPanel.addTab("豪 华 双 人 间", roomTypeOneButton);
	    rightPanel.addTab("豪 华 单 人 间", roomTypeTwoButton);
	    rightPanel.addTab("标 准", roomTypeThreeButton);
	    rightPanel.addTab("双 人 间", roomTypeFourButton);
	    rightPanel.addTab("单 人 间", roomTypeFiveButton);
	    
	    
	    //将当前房间类型(ViewList控件)存入哈希表
	    //ht.put("全部房间", all);
	    
	    //TODO 后续加入单个类型房间的标签页
	}
	
	public JPanel buildRoomList(Room[] rooms) {
		RoomList roomList = null;
		// 获取房间总数
		int roomQuantity = rooms.length;
		
		roomList = new RoomList(roomQuantity);
		buttons = new JButton[roomQuantity];
		int i = 0;
		for(Room room: rooms) {
			buttons[i] = roomList.addButton(room.getRoom_num());
			buttons[i++].addActionListener(this);
		}
		// 如果房间数不能占满整个面板，自动补充空白房间
		roomList.supplementButton();
		return roomList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		Room[] room = null;
		
		if(object == roomTypeOneButton) {
			room = roomTypeOne;
		} else if(object == roomTypeTwoButton) {
			room = roomTypeTwo;
		} else if(object == roomTypeThreeButton) {
			room = roomTypeThree;
		} else if(object == roomTypeFourButton) {
			room = roomTypeFour;
		} else if(object == roomTypeFiveButton) {
			room = roomTypeFive;
		}
		
		boolean flag = false;
		for(int i = 0; i < buttons.length; i++) {
			if(object == buttons[i]) {
				leftPanel.setLabel(room[i]);
				break;
			}
		}
	}
}
