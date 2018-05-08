import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class Ticket extends Frame implements ActionListener
{

	Button booking, status, modify, delete, exit;
	Panel p;
	PreparedStatement ps;
	Connection c;
	
	Ticket()
	{
		p = new Panel();
		p.setLayout(null);
		
		booking = new Button("Booking");
		status = new Button("Status");
		modify = new Button("Modify");
		delete = new Button("Delete");
		exit = new Button("EXIT");
		
		booking.setBounds(350, 130, 550, 90);
		status.setBounds(350, 230, 550, 90);
		modify.setBounds(350, 330, 550, 90);
		delete.setBounds(350, 430, 550, 90);
		exit.setBounds(350, 530, 550, 90);

		add(p);
		p.add(booking);
		p.add(status);
		p.add(modify);
		p.add(delete);
		p.add(exit);

		booking.addActionListener(this);
		status.addActionListener(this);
		modify.addActionListener(this);
		delete.addActionListener(this);
		exit.addActionListener(this);

		setSize(1380, 740);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		String str;
		str = ae.getActionCommand();
		if (str.equals("Booking")) 
		{
			Booking bkg = new Booking();
			bkg.setVisible(true);
			
		} 
		else if (str.equals("Status")) 
		{
			Status sts = new Status();
			sts.setVisible(true);
		}
		/*else if (str.equals("Modify")) 
		{
			Modify mdf = new Modify();
			mdf.setVisible(true);
		}
		else if (str.equals("Delete")) 
		{
			Delete dlt = new Delete();
			dlt.setVisible(true);

		}*/
		else if (str.equals("EXIT")) 
		{
			setVisible(false);
		}
		
	}
	
	public static void main(String args[]) 
	{	
				
		Ticket t = new Ticket();
		t.setVisible(true);
		
	}
		
}
