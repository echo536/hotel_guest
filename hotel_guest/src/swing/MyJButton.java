package swing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import view.NorthPanel;

public class MyJButton extends JButton implements MouseListener {
	private Icon upIcon = null;
	private Icon downIcon = null;

	public MyJButton(String upUrl, String downUrl, String tip) {
		buildButton(upUrl, downUrl, tip);
	}
	
	private void buildButton(String upUrl, String downUrl, String tip) {
		URL upURL = NorthPanel.class.getResource(upUrl);
        upIcon = new ImageIcon(upURL);
		URL downURL = NorthPanel.class.getResource(downUrl);
        downIcon = new ImageIcon(downURL);
        
        this.setIcon(upIcon);
        this.setToolTipText(tip);
	}

	public Icon getUpIcon() {
		return upIcon;
	}

	public Icon getDownIcon() {
		return downIcon;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
	
}
