
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Adminlogin extends JFrame implements ActionListener
{
    JLabel l1,l2,l3; JButton b; JTextField t; JPasswordField p;

    Adminlogin()
    {
        l1 = new JLabel("Admin Login Form");
        l1.setBounds(170, 60,200,100);

        l2 = new JLabel("username");
        l2.setBounds(100,140,70,80);

        l3 = new JLabel("password");
        l3.setBounds(100,200,70,80);

        t = new JTextField();
        t.setBounds(160,170,150,30);

        p = new JPasswordField();
        p.setBounds(160,225,150,30);

        b = new JButton("login");
        b.setBounds(180,300,70,30);


        b.addActionListener(this);

        add(l1);add(l2); add(l3); add(t); add(p);add(b);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
 


    public void actionPerformed(ActionEvent e)
    {
        performLogin();
        this.setVisible(false);
    }

    private void performLogin() {
        String username = t.getText();
        String password = new String(p.getPassword());

        if (authenticate(username, password)) {
            JOptionPane.showMessageDialog(this, "Login Successful");
            Adminsection Adminsection= new Adminsection();
            Adminsection.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username/Password");
        }
    }

    private boolean authenticate(String username, String password) {
        // Connect to the database and check credentials
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/demo", "root", "root1");
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM userdata WHERE name=? AND password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

 
}