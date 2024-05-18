import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Retbook extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l6;
    JTextField  t1,t2;
    JButton b1,b2;

    Retbook()
    {
        l1  = new JLabel("RETURN BOOK");
        l1.setBounds(200,60,150,80);

        l2  = new JLabel("BOOK CALL NO:");
        l2.setBounds(100,150,100,80);

        l3  = new JLabel("STUDENT ID:");
        l3.setBounds(100,200,100,80);

        t1 = new JTextField();
        t1.setBounds(200,180,200,20);

        t2 = new JTextField();
        t2.setBounds(200,230,200,20);

        b1 = new JButton("RETURN BOOK");
        b1.setBounds(200,480,140,40);

        b2 = new JButton("Back");
        b2.setBounds(400,580,80,30);

        l6  = new JLabel("NOTE : check student id carefully !!!!!");
        l6.setBounds(150,330,250,80);

        add(l1); add(l2); add(l3);add(t1);add(t2);add(b1);add(b2);add(l6);

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
            

            try
            {
                String url="jdbc:mysql://localhost:3307/demo";
                Connection con = DriverManager.getConnection(url,"root","root1");
                String Query ="delete from issuebook where callno=? and studentid=?";
                PreparedStatement pt = con.prepareStatement(Query);

                pt.setString(1,callno);
                pt.setString(2,studentid);
                
                int row = pt.executeUpdate();
                        if(row>0)
                        {
                            JOptionPane.showMessageDialog(this, "ISSUED BOOK RETURNED SUCCESSFULLY!!!");
                        }
                        else 
                        {
                            JOptionPane.showMessageDialog(this, "OOPS! ERROR TO RETURN BOOK\n    Check Callno/Id Again");
                            
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
        }
}

