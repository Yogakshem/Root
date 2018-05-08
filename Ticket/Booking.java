import java.awt.*;
import java.awt.event.*;
import java.sql.*;


//--------------------Main booking class--------------------------

	public class Booking extends Frame implements ActionListener
	{
		Panel p1;
		Button ecnoClass, bsnsClass, back;
		
		Booking()
		{
			p1 = new Panel();
			p1.setLayout(null);
			ecnoClass = new Button("TO BOOK AN ECONOMIC CLASS SEAT");
			bsnsClass = new Button("TO BOOK A BUSSINESS CLASS SEAT");
			back = new Button("Go Back to Main Menu");
			
			ecnoClass.setBounds(140, 150, 500, 200);
			bsnsClass.setBounds(740, 150, 500, 200);
			back.setBounds(425, 450, 500, 100);
			
			add(p1);
			p1.add(ecnoClass);
			p1.add(bsnsClass);
			p1.add(back);
			
			ecnoClass.addActionListener(this);
			bsnsClass.addActionListener(this);
			back.addActionListener(this);
			
			setSize(1380,740);
						
		}
		
		public void actionPerformed(ActionEvent book) 
		{

			String str1;
			str1 = book.getActionCommand();
			if (str1.equals("TO BOOK AN ECONOMIC CLASS SEAT")) 
			{
				EcnoClass ecs = new EcnoClass();
				ecs.setVisible(true);
			}
			if (str1.equals("TO BOOK A BUSSINESS CLASS SEAT")) 
			{
				BsnsClass bcs = new BsnsClass();
				bcs.setVisible(true);
			} 
			else if (str1.equals("Go Back to Main Menu")) 
			{
				setVisible(false);
			}

		}
		
	//--------------------Booking Economic Class Seat-------------------
		
		public class EcnoClass extends Frame implements ActionListener 
		{
			Panel p11;
			TextField t11, t12, t13, t14, t15, t16, t17;
			Label l10, l11, l12, l13, l14, l15, l16, l17;
			Button b11, b12;
			PreparedStatement ps;
			Connection c;
			
			EcnoClass()
			{
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					c = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false", "root", "");
					ps = c.prepareStatement("insert into economicclassseats values(?,?,?,?,?,?,?)");
							 
				} 
				catch (Exception e) 
				{
					System.out.println("Error In Booking Economic Class Seat");
				}
				
				p11 = new Panel();
				p11.setLayout(null);
				t11 = new TextField(20);
				t12 = new TextField(20);
				t13 = new TextField(20);
				t14 = new TextField(20);
				t15 = new TextField(20);
				t16 = new TextField(20);
				t17 = new TextField(20);
				l10 = new Label("BOOK AN ECONOMIC CLASS SEAT");
				l11 = new Label("SEAT NO. ::");
				l12 = new Label("OCCUPENT'S NAME ::");
				l13 = new Label("OCCUPENT'S PHONE NO. ::");
				l14 = new Label("OCCUPENT'S ADDRESS ::");
				l15 = new Label("SOURCE ::");
				l16 = new Label("DESTINATION ::");
				l17 = new Label("DATE yyyy-mm-dd ::"); 
				b11 = new Button("SAVE");
				b12 = new Button("BACK");
				
				t11.setBounds(600, 150, 500, 40);
				t12.setBounds(600, 200, 500, 40);
				t13.setBounds(600, 250, 500, 40);
				t14.setBounds(600, 300, 500, 40);
				t15.setBounds(600, 350, 500, 40);
				t16.setBounds(600, 400, 500, 40);
				t17.setBounds(600, 450, 500, 40);
				
				l10.setBounds(500, 50, 500, 60);
				
				l11.setBounds(350, 150, 150, 40);
				l12.setBounds(350, 200, 150, 40);
				l13.setBounds(350, 250, 150, 40);
				l14.setBounds(350, 300, 150, 40);
				l15.setBounds(350, 350, 150, 40);
				l16.setBounds(350, 400, 150, 40);
				l17.setBounds(350, 450, 150, 40);
				
				b11.setBounds(575, 575, 100, 60);
				b12.setBounds(725, 575, 100, 60);
				
				add(p11);
				p11.add(t11);
				p11.add(t12);
				p11.add(t13);
				p11.add(t14);
				p11.add(t15);
				p11.add(t16);
				p11.add(t17);
				p11.add(l10);
				p11.add(l11);
				p11.add(l12);
				p11.add(l13);
				p11.add(l14);
				p11.add(l15);
				p11.add(l16);
				p11.add(l17);
				p11.add(b11);
				p11.add(b12);
				
				b11.addActionListener(this);
				b12.addActionListener(this);
				setSize(1380,740);
			}
			
			public void actionPerformed(ActionEvent book1) 
			{
				String besstr = book1.getActionCommand();
				if (besstr.equals("BACK")) 
				{
					setVisible(false);
				}
				if (besstr.equals("SAVE")) 
				{

					try 
					{
						ps.setInt(1, Integer.parseInt(t11.getText()));
						ps.setString(2, t12.getText());
						ps.setString(3, t13.getText());
						ps.setString(4, t14.getText());
						ps.setString(5, t15.getText());
						ps.setString(6, t16.getText());
						ps.setDate(7, Date.valueOf(t17.getText()));

						ps.executeUpdate();
						
						t11.setText(null);
						t12.setText(null);
						t13.setText(null);
						t14.setText(null);
						t15.setText(null);
						t16.setText(null);
						t17.setText(null);
					} 
					catch (Exception a) 
					{
						System.out.println("error" + a);
					}
				}
			}
		}
		
		public class BsnsClass extends Frame implements ActionListener 
		{
			Panel p12;
			TextField t21, t22, t23, t24, t25, t26, t27;
			Label l20, l21, l22, l23, l24, l25, l26, l27;
			Button b21, b22;
			PreparedStatement ps;
			Connection c;

			BsnsClass() 
			{
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					c = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false", "root", "");
					ps = c.prepareStatement("insert into bussinessclassseats values(?,?,?,?,?,?,?)");
				} 
				catch (Exception e) 
				{
					System.out.println("Error In Booking Bussiness Class Seat");
				}

				p12 = new Panel();
				p12.setLayout(null);
				t21 = new TextField(20);
				t22 = new TextField(20);
				t23 = new TextField(20);
				t24 = new TextField(20);
				t25 = new TextField(20);
				t26 = new TextField(20);
				t27 = new TextField(20);
				l20 = new Label("BOOK AN BUSSINESS CLASS SEAT");
				l21 = new Label("SEAT NO. ::");
				l22 = new Label("OCCUPENT'S NAME ::");
				l23 = new Label("OCCUPENT'S PHONE NO. ::");
				l24 = new Label("OCCUPENT'S ADDRESS ::");
				l25 = new Label("SOURCE ::");
				l26 = new Label("DESTINATION ::");
				l27 = new Label("DATE yyyy-mm-dd ::"); 
				b21 = new Button("SAVE");
				b22 = new Button("BACK");
				
				t21.setBounds(600, 150, 500, 40);
				t22.setBounds(600, 200, 500, 40);
				t23.setBounds(600, 250, 500, 40);
				t24.setBounds(600, 300, 500, 40);
				t25.setBounds(600, 350, 500, 40);
				t26.setBounds(600, 400, 500, 40);
				t27.setBounds(600, 450, 500, 40);
				
				l20.setBounds(500, 50, 500, 60);
				
				l21.setBounds(350, 150, 150, 40);
				l22.setBounds(350, 200, 150, 40);
				l23.setBounds(350, 250, 150, 40);
				l24.setBounds(350, 300, 150, 40);
				l25.setBounds(350, 350, 150, 40);
				l26.setBounds(350, 400, 150, 40);
				l27.setBounds(350, 450, 150, 40);
				
				b21.setBounds(575, 575, 100, 60);
				b22.setBounds(725, 575, 100, 60);
				
				add(p12);
				p12.add(t21);
				p12.add(t22);
				p12.add(t23);
				p12.add(t24);
				p12.add(t25);
				p12.add(t26);
				p12.add(t27);
				p12.add(l20);
				p12.add(l21);
				p12.add(l22);
				p12.add(l23);
				p12.add(l24);
				p12.add(l25);
				p12.add(l26);
				p12.add(l27);
				p12.add(b21);
				p12.add(b22);
				
				b21.addActionListener(this);
				b22.addActionListener(this);
				setSize(1380,740);

			}

			public void actionPerformed(ActionEvent book2) 
			{
				String bbsstr = book2.getActionCommand();
				if (bbsstr.equals("BACK")) 
				{
					setVisible(false);
				} 
				else if (bbsstr.equals("SAVE")) 
				{
					try 
					{
						ps.setInt(1, Integer.parseInt(t21.getText()));
						ps.setString(2, t22.getText());
						ps.setString(3, t23.getText());
						ps.setString(4, t24.getText());
						ps.setString(5, t25.getText());
						ps.setString(6, t26.getText());
						ps.setDate(7, Date.valueOf(t27.getText()));

						ps.executeUpdate();
						
						t21.setText(null);
						t22.setText(null);
						t23.setText(null);
						t24.setText(null);
						t25.setText(null);
						t26.setText(null);
						t27.setText(null);
						
						
					} 
					catch (Exception a) 
					{
						System.out.println("error" + a);
					}
				}
			}
		}	

	}
