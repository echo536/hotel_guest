package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

import presenter.system.Sys;
import swing.MyJButton;

public class MainFrame extends JFrame implements ActionListener, MouseListener, Runnable {
	Sys sys = null;
	
	// 工具栏
	JToolBar toolBar = null;
	// 工具栏按键
	private MyJButton bt1 = null, bt2 = null, 
			bt3 = null, bt4 = null, 
			bt5 = null, bt6 = null, 
			bt7 = null;
	
	//中间面板的左右组件
	JPanel leftPanel = null, rightPanel = null;

	//中间面板的分割线
	CenterPanel centerPanel = null;
	
	//底部状态栏
	JPanel bottom = null;
	JLabel lb1 = null, lb2 = null,
			lb3 = null, lb4 = null;
	// 底部状态栏实时显示当前所在模块
	String currentOption = "前 台 开 房    ";
	
	public MainFrame() { };
	
	public MainFrame(Sys sys, String userId, String userPower) {
		super("仲恺酒店管理系统");
		
		this.sys = sys;
		
		JPanel panelMain = new JPanel(new BorderLayout());
		
		buildToolBar();
		buildBottom(userId);
		centerPanel = new CenterPanel(sys);
		
		panelMain.add("North", toolBar);
		panelMain.add("Center", centerPanel);
		panelMain.add("South", bottom);
		
		//加事件监听
		addListener ();
		
		this.addWindowListener (new WindowAdapter () {
			public void windowClosing (WindowEvent we) {
				quit ();
			}//End windowClosing
		});
		
		this.setContentPane(panelMain);	
		this.setLocation(250, 100);
		this.setSize(1115, 700);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		// 设置不可改变大小
		this.setResizable(false);
		
		// 启动房间检查状态线程
		//(new Thread(this)).start();
	}
	
	/**
	 * 制作工具栏
	 * @return
	 */
	private void buildToolBar() {
		toolBar = new JToolBar();
		
		bt1 = new MyJButton("img\\receptionUp.png", "img\\receptionDown.png", "前台管理");
		bt2 = new MyJButton("img\\clientUp.png","img\\clientDown.png", "客户管理");
		bt3 = new MyJButton("img\\roomUp.png", "img\\roomDown.png", "房间管理");
		bt4 = new MyJButton("img\\queryUp.png", "img\\queryDown.png", "信息查询");
		bt5 = new MyJButton("img\\statisticsUp.png", "img\\statisticsDown.png", "报表统计");
		bt6 = new MyJButton("img\\userUp.png", "img\\userDown.png", "用户管理");
		bt7 = new MyJButton("img\\settingUp.png", "img\\settingDown.png", "系统设置");
		
		toolBar.add(bt1);
		toolBar.add(bt2);
		toolBar.add(bt3);
		toolBar.addSeparator();
		toolBar.add(bt4);
		toolBar.add(bt5);
		toolBar.addSeparator();
		toolBar.add(bt6);
		toolBar.addSeparator();
		toolBar.add(bt7);
		
		// 设置工具栏不可浮动
		toolBar.setFloatable(false);
	}

	/**
	 * 制作bottom栏
	 * @param us
	 * @return
	 */
	private void buildBottom(String userId) {
		bottom = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		
		lb1 = new JLabel("    仲 恺 酒 店 管 理 系 统    ");
		lb2 = new JLabel("    提 示 ： 本 系 统 有 前 台 管 理、客 户 管 理、房 间 管 理、信 息 查 询、报 表 统 计、用 户 管 理、报 表 统 计 等 功 能。    ");
		lb3 = new JLabel("    当 前： 前 台 开 房    ");
		lb4 = new JLabel("    当 前 操 作 员 ：   " + userId + "    ");
		
		lb1.setBorder(new LineBorder(new Color(20, 10 , 10)));
		lb2.setBorder(new LineBorder(new Color(10, 10 , 10)));
		lb3.setBorder(new LineBorder(new Color(10, 10 , 10)));
		lb4.setBorder(new LineBorder(new Color(10, 10 , 10)));
		
		bottom.add(lb1);
		bottom.add(lb2);
		bottom.add(lb3);
		bottom.add(lb4);
	}
	

	/**
	 * 退出系统
	 */
	private void quit() {
		int flag = 0;
		String msg = "您 现 在 要 关 闭 系 统 吗 ？";
		flag = JOptionPane.showConfirmDialog (null, msg, "提示", JOptionPane.YES_NO_OPTION);
		if(flag == JOptionPane.YES_OPTION) {
			this.setVisible (false);
			System.exit (0);
		}
		return;
	}
	
	private void addListener() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
		bt7.addActionListener(this);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		
		if(object == bt1) {
			bt1.setIcon(bt1.getDownIcon());
			bt2.setIcon(bt2.getUpIcon());
			bt3.setIcon(bt3.getUpIcon());
			bt4.setIcon(bt4.getUpIcon());
			bt5.setIcon(bt5.getUpIcon());
			bt6.setIcon(bt6.getUpIcon());
			bt7.setIcon(bt7.getUpIcon());
			centerPanel.displayReception();
			lb3.setText("    当 前： 前 台 开 房    ");
		} else if (object == bt2) {
			bt1.setIcon(bt1.getUpIcon());
			bt2.setIcon(bt2.getDownIcon());
			bt3.setIcon(bt3.getUpIcon());
			bt4.setIcon(bt4.getUpIcon());
			bt5.setIcon(bt5.getUpIcon());
			bt6.setIcon(bt6.getUpIcon());
			bt7.setIcon(bt7.getUpIcon());
			centerPanel.displayClient();
			lb3.setText("    当 前： 客 户 管 理    ");
		} else if (object == bt3) {
			bt1.setIcon(bt1.getUpIcon());
			bt2.setIcon(bt2.getUpIcon());
			bt3.setIcon(bt3.getDownIcon());
			bt4.setIcon(bt4.getUpIcon());
			bt5.setIcon(bt5.getUpIcon());
			bt6.setIcon(bt6.getUpIcon());
			bt7.setIcon(bt7.getUpIcon());
			centerPanel.displayRoom();
			lb3.setText("    当 前： 房 间 管 理    ");
		} else if (object == bt4) {
			bt1.setIcon(bt1.getUpIcon());
			bt2.setIcon(bt2.getUpIcon());
			bt3.setIcon(bt3.getUpIcon());
			bt4.setIcon(bt4.getDownIcon());
			bt5.setIcon(bt5.getUpIcon());
			bt6.setIcon(bt6.getUpIcon());
			bt7.setIcon(bt7.getUpIcon());
			centerPanel.displayQuery();
			lb3.setText("    当 前： 信 息 查 询    ");
		} else if (object == bt5) {
			bt1.setIcon(bt1.getUpIcon());
			bt2.setIcon(bt2.getUpIcon());
			bt3.setIcon(bt3.getUpIcon());
			bt4.setIcon(bt4.getUpIcon());
			bt5.setIcon(bt5.getDownIcon());
			bt6.setIcon(bt6.getUpIcon());
			bt7.setIcon(bt7.getUpIcon());
			centerPanel.displayStatistics();
			lb3.setText("    当 前： 报 表 统 计    ");
		} else if (object == bt6) {
			bt1.setIcon(bt1.getUpIcon());
			bt2.setIcon(bt2.getUpIcon());
			bt3.setIcon(bt3.getUpIcon());
			bt4.setIcon(bt4.getUpIcon());
			bt5.setIcon(bt5.getUpIcon());
			bt6.setIcon(bt6.getDownIcon());
			bt7.setIcon(bt7.getUpIcon());
			centerPanel.displayUser();
			lb3.setText("    当 前： 用 户 管 理    ");
		} else if (object == bt7) {
			bt1.setIcon(bt1.getUpIcon());
			bt2.setIcon(bt2.getUpIcon());
			bt3.setIcon(bt3.getUpIcon());
			bt4.setIcon(bt4.getUpIcon());
			bt5.setIcon(bt5.getUpIcon());
			bt6.setIcon(bt6.getUpIcon());
			bt7.setIcon(bt7.getDownIcon());
			//centerPanel.displaySetting();
			lb3.setText("    当 前： 系 统 设 置    ");
		}
	}
}
