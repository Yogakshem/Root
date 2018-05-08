import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//----------------------------STATUS of SEATS--------------------------------

public class Status extends Frame implements ActionListener

{
	Panel p2;
	Button sts1, sts2;
	Button back2;

	Status() 
	{
		p2 = new Panel();
		p2.setLayout(null);
		sts1 = new Button("DISPLAY BOTH SEAT STATUS IN SEQUENCE");
		sts2 = new Button("DISPLAY BOTH SEAT STATUS SIDE BY SIDE");
		back2 = new Button("BACK TO THE MAIN MENU");

		sts1.setBounds(140, 150, 500, 200);
		sts2.setBounds(740, 150, 500, 200);
		back2.setBounds(425, 450, 500, 100);

		add(p2);
		p2.add(sts1);
		p2.add(sts2);
		p2.add(back2);

		sts1.addActionListener(this);
		sts2.addActionListener(this);
		back2.addActionListener(this);

		setSize(1380,740);
	}

	public void actionPerformed(ActionEvent ae2) 
	{
		String str2;
		str2 = ae2.getActionCommand();
		if (str2.equals("DISPLAY BOTH SEAT STATUS IN SEQUENCE")) 
		{
			Sequence seq = new Sequence();
			seq.setVisible(true);
		}
		else if (str2.equals("DISPLAY BOTH SEAT STATUS SIDE BY SIDE")) 
		{
			//SideBySide sbs = new SideBySide();
			//sbs.setVisible(true);
		}

		else if (str2.equals("BACK TO THE MAIN MENU")) 
		{
			setVisible(false);
		}
	}

//-----------------------------Sequential Display-------------------------------
	
	public class Sequence extends Frame implements ActionListener 
	{
		Panel p21;
		Label sdl1, sdl2;
		Button sdb1, sdb2;
		TextField sdt1;

		Sequence() 
		{
			p21 = new Panel();
			p21.setLayout(null);
			sdl1 = new Label("ENTER THE SEAT NUMBER::");
			sdl2 = new Label("SEQUENTIAL DISPLAY OF SEAT");
			sdb1 = new Button("OK");
			sdb2 = new Button("BACK");
			sdt1 = new TextField(20);

			sdl1.setBounds(400, 250, 150, 40);
			sdl2.setBounds(550, 100, 500, 60);
			sdt1.setBounds(600, 250, 150, 40);
			sdb1.setBounds(400, 400, 150, 100);
			sdb2.setBounds(750, 400, 150, 100);

			add(p21);
			p21.add(sdl1);
			p21.add(sdl2);
			p21.add(sdt1);
			p21.add(sdb1);
			p21.add(sdb2);

			sdb1.addActionListener(this);
			sdb2.addActionListener(this);

			setSize(1380,740);
		}

		public void actionPerformed(ActionEvent sdae) 
		{
			String sdstr;
			sdstr = sdae.getActionCommand();
			if (sdstr.equals("BACK")) 
			{
				setVisible(false);
			} 
			else if (sdstr.equals("OK")) 
			{
				SequenceData sd = new SequenceData(Integer.parseInt(sdt1.getText()));
				sd.setVisible(true);
			}
		}
	}

//--------------SequenceData  display data in sequence---------------------
	//------------------for ECONOMIC CLASS ---------------------------
	
	public class SequenceData extends Frame implements ActionListener 
	{
		Panel p22;
		Button next, back;
		Label sdl01, sdl1, sdl2, sdl3, sdl4, sdl5, sdl6, sdl7;
		TextField sdt1, sdt2, sdt3, sdt4, sdt5, sdt6, sdt7;
		Statement st;
		ResultSet rs;
		int j;

		SequenceData(int i) 
		{
			try 
			{
				Connection c;
				Class.forName("com.mysql.cj.jdbc.Driver");
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false", "root", "");
				st = c.createStatement();
				p22 = new Panel();
				p22.setLayout(null);
				next = new Button("CLICK TO SEE FOR BUSSINESS CLASS (same seat no)");
				back = new Button("BACK");

				sdt1 = new TextField();
				sdt2 = new TextField();
				sdt3 = new TextField();
				sdt4 = new TextField();
				sdt5 = new TextField();
				sdt6 = new TextField();
				sdt7 = new TextField();

				sdl01 = new Label("SEQUENTIAL DISPLAY FOR ECONOMIC CLASS SEAT");
				sdl1 = new Label("SEAT NO. ::");
				sdl2 = new Label("OCCUPENT'S NAME ::");
				sdl3 = new Label("OCCUPENT'S PHONE NO. ::");
				sdl4 = new Label("OCCUPENT'S ADDRESS ::");
				sdl5 = new Label("SOURCE ::");
				sdl6 = new Label("DESTINATION ::");
				sdl7 = new Label("DATE yyyy-mm-dd ::");
				

				sdt1.setBounds(600, 150, 500, 40);
				sdt2.setBounds(600, 200, 500, 40);
				sdt3.setBounds(600, 250, 500, 40);
				sdt4.setBounds(600, 300, 500, 40);
				sdt5.setBounds(600, 350, 500, 40);
				sdt6.setBounds(600, 400, 500, 40);
				sdt7.setBounds(600, 450, 500, 40);
				sdl01.setBounds(500, 50, 500, 60);
				sdl1.setBounds(350, 150, 150, 40);
				sdl2.setBounds(350, 200, 150, 40);
				sdl3.setBounds(350, 250, 150, 40);
				sdl4.setBounds(350, 300, 150, 40);
				sdl5.setBounds(350, 350, 150, 40);
				sdl6.setBounds(350, 400, 150, 40);
				sdl7.setBounds(350, 450, 150, 40);

				next.setBounds(320, 550, 400, 60);
				back.setBounds(850, 550, 100, 60);
				

				add(p22);
				p22.add(sdt1);
				p22.add(sdt2);
				p22.add(sdt3);
				p22.add(sdt4);
				p22.add(sdt5);
				p22.add(sdt6);
				p22.add(sdt7);
				p22.add(sdl01);
				p22.add(sdl1);
				p22.add(sdl2);
				p22.add(sdl3);
				p22.add(sdl4);
				p22.add(sdl5);
				p22.add(sdl6);
				p22.add(sdl7);
				p22.add(next);
				p22.add(back);
				

				next.addActionListener(this);
				back.addActionListener(this);
				setSize(1380, 740);
			}
			catch (Exception e2) 
			{
				System.out.println("error" + e2);
			}
			j = i;
			try 
			{
				rs = st.executeQuery("select * from economicclassseats where SeatNo=" + i);
				rs.next();
				sdt1.setText(rs.getString(1));
				sdt2.setText(rs.getString(2));
				sdt3.setText(rs.getString(3));
				sdt4.setText(rs.getString(4));
				sdt5.setText(rs.getString(5));
				sdt6.setText(rs.getString(6));
				sdt7.setText(rs.getString(7));
			} 
			catch (Exception e3) 
			{
				System.out.println("error" + e3);
			}

		}

		public void actionPerformed(ActionEvent sdae1) 
		{
			String sdstr1;
			sdstr1 = sdae1.getActionCommand();
			if (sdstr1.equals("CLICK TO SEE FOR BUSSINESS CLASS (same seat no)")) 
			{
				SequenceData2 sd2 = new SequenceData2(j);
				sd2.setVisible(true);
			}
			else if (sdstr1.equals("BACK")) 
			{
				setVisible(false);
			}
		}
	}
	
//--------------SequenceData  display data in sequence---------------------
	//----------------for BUSSINESS CLASS---------------------------
	
	public class SequenceData2 extends Frame implements ActionListener 
	{
		Panel p23;
		Button back4;
		Label sdl02, sdl8, sdl9, sdl10, sdl11, sdl12, sdl13, sdl14;
		TextField sdt8, sdt9, sdt10, sdt11, sdt12, sdt13, sdt14;
		Statement st;
		ResultSet rs;

		SequenceData2(int k) 
		{
			try 
			{

				Connection c;
				Class.forName("com.mysql.cj.jdbc.Driver");
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false", "root", "");
				st = c.createStatement();

				p23 = new Panel();
				p23.setLayout(null);
				back4 = new Button("BACK");

				sdt8 = new TextField(20);
				sdt9 = new TextField(20);
				sdt10 = new TextField(20);
				sdt11 = new TextField(20);
				sdt12 = new TextField(20);
				sdt13 = new TextField(20);
				sdt14 = new TextField(20);
				
				sdl02 = new Label("SEQUENTIAL DISPLAY FOR BUSSINESS CLASS SEAT");
				sdl8 = new Label("SEAT NO. ::");
				sdl9 = new Label("OCCUPENT'S NAME ::");
				sdl10 = new Label("OCCUPENT'S PHONE NO. ::");
				sdl11 = new Label("OCCUPENT'S ADDRESS ::");
				sdl12 = new Label("SOURCE ::");
				sdl13 = new Label("DESTINATIO ::");
				sdl14 = new Label("DATE ::");
				
				sdt8.setBounds(600, 150, 500, 40);
				sdt9.setBounds(600, 200, 500, 40);
				sdt10.setBounds(600, 250, 500, 40);
				sdt11.setBounds(600, 300, 500, 40);
				sdt12.setBounds(600, 350, 500, 40);
				sdt13.setBounds(600, 400, 500, 40);
				sdt14.setBounds(600, 450, 500, 40);

				sdl02.setBounds(500, 50, 500, 60);
				sdl8.setBounds(350, 150, 150, 40);
				sdl9.setBounds(350, 200, 150, 40);
				sdl10.setBounds(350, 250, 150, 40);
				sdl11.setBounds(350, 300, 150, 40);
				sdl12.setBounds(350, 350, 150, 40);
				sdl13.setBounds(350, 400, 150, 40);
				sdl14.setBounds(350, 450, 150, 40);

				back4.setBounds(400, 550, 250, 60);
				

				add(p23);
				p23.add(sdt8);
				p23.add(sdt9);
				p23.add(sdt10);
				p23.add(sdt11);
				p23.add(sdt12);
				p23.add(sdt13);
				p23.add(sdt14);
				p23.add(sdl02);
				p23.add(sdl8);
				p23.add(sdl9);
				p23.add(sdl10);
				p23.add(sdl11);
				p23.add(sdl12);
				p23.add(sdl13);
				p23.add(sdl14);
				p23.add(back4);


				back4.addActionListener(this);
				setSize(1380, 740);
			} 
			catch (Exception e2) 
			{
				System.out.println("error" + e2);
			}
			try 
			{
				rs = st.executeQuery("select * from bussinessclassseats where SeatNo=" + k);
				rs.next();
				sdt8.setText(rs.getString(1));
				sdt9.setText(rs.getString(2));
				sdt10.setText(rs.getString(3));
				sdt11.setText(rs.getString(4));
				sdt12.setText(rs.getString(5));
				sdt13.setText(rs.getString(6));
				sdt14.setText(rs.getString(7));

			} 
			catch (Exception e3) 
			{
				System.out.println("error" + e3);
			}

		}

		public void actionPerformed(ActionEvent sdae2) 
		{
			String sdstr2;
			sdstr2 = sdae2.getActionCommand();
			if (sdstr2.equals("BACK")) 
			{
				setVisible(false);
			}
		}
	}
}
