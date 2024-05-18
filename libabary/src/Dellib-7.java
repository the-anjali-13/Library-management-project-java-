import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Dellib extends JFrame implements ActionListener
{
    JLabel l; JTextField t; JButton b1,b2;

    Dellib()
    {
        l = new JLabel("Enter id:");
        l.setBounds(50,50,70,70);

        t = new JTextField();
        t.setBounds(100,75,140,20);

        b1 = new JButton("DELETE");
        b1.setBounds(100,130,90,30);

        b2 = new JButton("Back");
        b2.setBounds(200,200,70,20);

        b1.addActionListener(this);
        b2.addActionListener(this);

        add(l);add(t);add(b1);add(b2);
        setSize(300,300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            try
                {
                        String id = t.getText();
                        String url = "jdbc:mysql://localhost:3307/demo";                     
                        Connection con  = DriverManager.getConnection(url,"root","root1");
                        PreparedStatement pt = con.prepareStatement("delete from librariandata where id=?");
                        
                        pt.setString(1,id);
                        int row = pt.executeUpdate();
                        if(row>0)
                        {
                            JOptionPane.showMessageDialog(this, "librarian deleted successfully!");
                        }
                        else 
                        {
                            JOptionPane.showMessageDialog(this, "Error To Delete Librarian");
                            
                        }

                        t.setText("");
                }   
                 catch(Exception x)
                {
			        x.printStackTrace();
	            }
        }
        else if(e.getSource()==b2)
        {
            this.setVisible(false);
            Adminsection Adminsection = new Adminsection();
            Adminsection.setVisible(true);
        }
    }


}
