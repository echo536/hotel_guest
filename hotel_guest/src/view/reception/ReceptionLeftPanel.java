package view.reception;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import model.room.Room;

public class ReceptionLeftPanel extends JTabbedPane {
	JLabel num = null;
	JLabel type = null;
	JLabel price = null;
	JLabel guarantee = null;
	JLabel status = null;
	
	public ReceptionLeftPanel(){
		super();
		Room room = new Room(1,"",1.1F,1.1F,"  ");
		buildLabel(room);
	}
	
	public void buildLabel(Room room) {
		num = new JLabel("房间号码：" + String.valueOf(room.getRoom_num()));
		type = new JLabel("房间类型：" + room.getType());
		price = new JLabel("房间价格：" + room.getPrice());
		guarantee = new JLabel("房间押金：" + room.getGuarantee_deposit());
		status = new JLabel("房间状态：" + room.getStatus());
		
		JPanel information = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 20));
		information.setBorder(new EmptyBorder(50, 5, 10, 10));
		information.setPreferredSize(new Dimension(230, 0));
		
		information.add(num);
		information.add(type);
		information.add(price);
		information.add(guarantee);
		information.add(status);
		this.add("房 间 信 息", information);
	}
	
	public void setLabel(Room room) {
		num.setText("房间号码：" + String.valueOf(room.getRoom_num()));
		type.setText("房间类型：" + room.getType());
		price.setText("房间价格：" + room.getPrice());
		guarantee.setText("房间押金：" + room.getGuarantee_deposit());
		status.setText("房间状态：" + room.getStatus());
	}
}
