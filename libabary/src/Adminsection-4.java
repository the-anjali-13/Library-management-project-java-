import javax.swing.*;
import java.awt.event.*;

class Adminsection extends JFrame implements ActionListener
{
    JButton a,b,c,d; JLabel l;

    Adminsection()
    {
        l = new JLabel("ADMIN SECTION");
        l.setBounds(130,60,150,80);

        a = new JButton("Add Librarian");
        a.setBounds(100,150,150,40);

        b = new JButton("View Librarian");
        b.setBounds(100,200,150,40);

        c = new JButton("Delete Librarian");
        c.setBounds(100,250,150,40);

        d = new JButton("Log out");
        d.setBounds(100,300,150,40);

        add(l);add(a);add(b);add(c);add(d);

        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);

        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == a) 
        {
            Addlib addlib=new Addlib();
            addlib.setVisible(true);
            this.setVisible(false);
        } 
        else if (e.getSource() == b)
        {
            Viewlib viewlib=new Viewlib();
           viewlib.setVisible(true);
          // this.setVisible(false);
        }
         else if (e.getSource() == c)
        {
            Dellib dellib=new Dellib();
            dellib.setVisible(true);
            this.setVisible(false);
        }
         else if (e.getSource() == d)
        {
            this.setVisible(false);
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        }
    }

 

}
