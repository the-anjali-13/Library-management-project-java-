import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


class Addlib extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField  t1,t2,t3,t4,t5;
    JPasswordField p;
    JButton b1,b2;

    Addlib()
    {
        l1  = new JLabel("ADD LIBRARIAN FORM");
        l1.setBounds(200,60,150,80);

        l2  = new JLabel("NAME :");
        l2.setBounds(100,150,100,80);

        l3  = new JLabel("PASSWORD :");
        l3.setBounds(100,200,100,80);

        l4  = new JLabel("E-MAIL:");
        l4.setBounds(100,250,100,80);

        l5  = new JLabel("ADDRESS :");
        l5.setBounds(100,300,100,80);

        l6  = new JLabel("CITY :");
        l6.setBounds(100,350,100,80);

        l7  = new JLabel("CONTECT NO. :");
        l7.setBounds(100,400,100,80);

        t1 = new JTextField();
        t1.setBounds(200,180,200,20);

        t2 = new JTextField();
        t2.setBounds(200,430,200,20);

        t3 = new JTextField();
        t3.setBounds(200,280,200,20);

        t4 = new JTextField();
        t4.setBounds(200,330,200,20);

        t5 = new JTextField();
        t5.setBounds(200,380,200,20);

        p = new JPasswordField();
        p.setBounds(200,230,200,20);

        b1 = new JButton("confirm");
        b1.setBounds(200,480,100,40);

        b2 = new JButton("back");
        b2.setBounds(400,580,80,30);

        add(l1); add(l2); add(l3); add(l4); add(l5); add(l6);add(l7);add(t1);add(t2);add(t3);add(t4);add(t5);add(b1);add(b2);add(p);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(600,700);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

     public void actionPerformed(ActionEvent e)
    {

         if (e.getSource() == b1)
        {
                // Get data from text fields
                String name = t1.getText();
                String email =t2.getText();
                String address = t3.getText();
                String city = t4.getText();
                String contact = t5.getText();
                char[] passwordChars = p.getPassword();
                String password = new String(passwordChars);

                try
                {
                        String url = "jdbc:mysql://localhost:3307/demo";
                                               
                        Connection con  = DriverManager.getConnection(url,"root","root1");
                        PreparedStatement pt = con.prepareStatement("insert into librariandata(name,password,email,address,city,contect)values(?,?,?,?,?,?)");
                        
                        pt.setString(1,name);
                        pt.setString(2,password);
                        pt.setString(3,email);
                        pt.setString(4,address);
                        pt.setString(5,city);
                        pt.setString(6,contact);
                        
                        int row = pt.executeUpdate();
                        if(row>0)
                        {
                            JOptionPane.showMessageDialog(this, "Registration Successful!");
                        }
                        else 
                        {
                            JOptionPane.showMessageDialog(this, "ERROR!!!!");
                            
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
            this.dispose();
            Adminsection Adminsection = new Adminsection();
            Adminsection.setVisible(true);
        }
    }    
        public void clearFields()
        {
       
         t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        p.setText("");
         }
                      

}