import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Issuebook extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    JTextField  t1,t2,t3,t4;
    JButton b1,b2;

    Issuebook()
    {
        l1  = new JLabel("ISSUE BOOK");
        l1.setBounds(200,60,150,80);

        l2  = new JLabel("BOOK CALL NO:");
        l2.setBounds(100,150,100,80);

        l3  = new JLabel("STUDENT ID:");
        l3.setBounds(100,200,100,80);

        l4  = new JLabel("STUDENT NAME:");
        l4.setBounds(100,250,100,80);

        l5  = new JLabel("STUDENT CONTECT:");
        l5.setBounds(100,300,100,80);

        t1 = new JTextField();
        t1.setBounds(200,180,200,20);

        t2 = new JTextField();
        t2.setBounds(200,230,200,20);

        t3 = new JTextField();
        t3.setBounds(200,280,200,20);

        t4 = new JTextField();
        t4.setBounds(200,330,200,20);

        b1 = new JButton("ISSUE CONFIRM");
        b1.setBounds(200,480,140,40);

        b2 = new JButton("Back");
        b2.setBounds(400,580,80,30);

        add(l1); add(l2); add(l3); add(l4); add(l5);add(t1);add(t2);add(t3);add(t4);add(b1);add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(600,700);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            String callno = t1.getText();
            String studentid = t2.getText();
            String studentname = t3.getText();
            String studentcontect = t4.getText();

            try
            {
                String url="jdbc:mysql://localhost:3307/demo";
                Connection con = DriverManager.getConnection(url,"root","root1");
                String Query ="insert into issuebook(callno,studentid,studentname,studentcontect)values(?,?,?,?)";
                PreparedStatement pt = con.prepareStatement(Query);

                pt.setString(1,callno);
                pt.setString(2,studentid);
                pt.setString(3,studentname);
                pt.setString(4,studentcontect);
                
                int row = pt.executeUpdate();
                        if(row>0)
                        {
                            JOptionPane.showMessageDialog(this, "BOOK ISSUED SUCCESSFULLY!!!");
                        }
                        else 
                        {
                            JOptionPane.showMessageDialog(this, "OOPS! ERROR TO ISSUE BOOK");
                            
                        }
            }   
            catch(Exception x)
            {
			        x.printStackTrace();
	        }
			    //clearing textfields
                clearFields();
         }
        else if(e.getSource() == b2)
        {
            this.setVisible(false);
             sellib sellib=new sellib();
            sellib.setVisible(true);
        }
        
    }
    public void clearFields()
        {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        }
}


