import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Liblogin extends JFrame implements ActionListener
{
    JLabel l1,l2,l3; JButton b; JTextField t; JPasswordField p;

    Liblogin()
    {
        l1 = new JLabel("Librarian Login Form");
        l1.setBounds(170, 60,200,100);

        l2 = new JLabel("Enter name ");
        l2.setBounds(90,140,70,80);

        l3 = new JLabel("password");
        l3.setBounds(100,200,70,80);

        t = new JTextField();
        t.setBounds(160,170,150,20);

        p = new JPasswordField();
        p.setBounds(160,235,150,20);

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

    public void performLogin()
    {
        String username = t.getText();
        String password = new String(p.getPassword());

        if (authenticate(username, password))
        {
            JOptionPane.showMessageDialog(this, "Login Successful");
            sellib sellib= new sellib();
            sellib.setVisible(true);
            this.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Invalid Username/Password");
        }
    }

    private boolean authenticate(String username, String password) {
        // Connect to the database and check credentials
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/demo", "root", "root1");
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM Librariandata WHERE name=? AND password=?");
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