package oldmana.general.md.client.gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import oldmana.general.md.client.Utils;

public class MenuGUI extends JLayeredPane
{
	private static final long serialVersionUID = -6084751482925840283L;
	
	private MDWindow window;
	
	private JButton connect;
	
	private JTextField ip;
	
	public MenuGUI(MDWindow window)
	{
		this.window = window;
		
		setSize(1500, 800);
		connect = new JButton("Connect");
		add(connect);
		Utils.setSizeOf(connect, 0.15, 0.05);
		Utils.setLocationOfCentered(connect, 0.5, 0.7);
		connect.setFont(Utils.getFont(Font.PLAIN, (int) (connect.getHeight() * 0.6)));
		connect.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent event)
			{
				MenuGUI.this.window.showTable();
			}
		});
		
		
		ip = new JTextField();
		add(ip);
		Utils.setSizeOf(ip, 0.15, 0.04);
		Utils.setLocationOfCentered(ip, 0.5, 0.65);
		ip.setFont(Utils.getFont(Font.PLAIN, (int) (ip.getHeight() * 0.6)));
		
		JButton local = new JButton("Host Local Server");
		add(local);
		Utils.setSizeOf(local, 0.15, 0.05);
		Utils.setLocationOfCentered(local, 0.5, 0.8);
		local.setFont(Utils.getFont(Font.PLAIN, (int) (local.getHeight() * 0.6)));
		local.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent event)
			{
				// TODO: Connect to server
			}
		});
	}
}
