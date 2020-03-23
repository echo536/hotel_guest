package view;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import presenter.system.Sys;
import view.client.ClientPanel;
import view.query.QueryPanel;
import view.reception.ReceptionPanel;
import view.room.RoomPanel;
import view.statistics.StatisticsPanel;
import view.user.UserPanel;
import view.setting.SettingPanel;

public class CenterPanel extends JPanel{
	ReceptionPanel reception = null;
	ClientPanel client = null;
	RoomPanel room = null;
	QueryPanel query = null;
	StatisticsPanel statistics = null;
	UserPanel user = null;
	SettingPanel setting = null;
	
	Sys sys = null;
	
	public CenterPanel(Sys sys) {
		super();
		this.sys = sys;
		this.setLayout(new CardLayout());
		setPanel();
		displayReception();
	}
	
	private void setPanel() {
		reception = new ReceptionPanel(sys);
		client = new ClientPanel();
		room = new RoomPanel();
		query = new QueryPanel();
		statistics = new StatisticsPanel();
		setting = new SettingPanel();
		user = new UserPanel();
		
		// 添加面板
		this.add(reception);
		this.add(client);
		this.add(room);
		this.add(query);
		this.add(statistics);
		this.add(setting);
		this.add(user);
	}
	
	public void displayReception() {
		reception.setVisible(true);
		client.setVisible(false);
		room.setVisible(false);
		query.setVisible(false);
		statistics.setVisible(false);
		setting.setVisible(false);
		user.setVisible(false);
	}

	public void displayClient() {
		reception.setVisible(false);
		client.setVisible(true);
		room.setVisible(false);
		query.setVisible(false);
		statistics.setVisible(false);
		setting.setVisible(false);
		user.setVisible(false);
	}
	public void displayRoom() {
		reception.setVisible(false);
		client.setVisible(false);
		room.setVisible(true);
		query.setVisible(false);
		statistics.setVisible(false);
		setting.setVisible(false);
		user.setVisible(false);
	}
	public void displayQuery() {
		reception.setVisible(false);
		client.setVisible(false);
		room.setVisible(false);
		query.setVisible(true);
		statistics.setVisible(false);
		setting.setVisible(false);
		user.setVisible(false);
	}
	public void displayStatistics() {
		reception.setVisible(false);
		client.setVisible(false);
		room.setVisible(false);
		query.setVisible(false);
		statistics.setVisible(true);
		setting.setVisible(false);
		user.setVisible(false);
	}
	public void displayUser() {
		reception.setVisible(false);
		client.setVisible(false);
		room.setVisible(false);
		query.setVisible(false);
		statistics.setVisible(false);
		setting.setVisible(true);
		user.setVisible(false);
	}
	public void displaySetting() {
		reception.setVisible(false);
		client.setVisible(false);
		room.setVisible(false);
		query.setVisible(false);
		statistics.setVisible(false);
		setting.setVisible(false);
		user.setVisible(true);
	}
	
}
