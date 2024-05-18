import javax.swing.*;
import java.awt.event.*;

class sellib extends JFrame implements ActionListener
{
    JLabel l ; JButton b1,b2,b3,b4,b5,b6;

    sellib() {
        l = new JLabel("Librarian Selection");
        l.setBounds(160, 30, 140, 40);

        b1 = new JButton("Add Books");
        b1.setBounds(150, 100, 140, 40);

        b2 = new JButton("View Books");
        b2.setBounds(150, 150, 140, 40);

        b3 = new JButton("Issue Book");
        b3.setBounds(150, 200, 140, 40);

        b4 = new JButton("View Issued Books");
        b4.setBounds(150, 250, 140, 40);

        b5 = new JButton("Returned Books");
        b5.setBounds(150, 300, 140, 40);

        b6 = new JButton("Log Out");
        b6.setBounds(150, 350, 140, 40);

        add(l);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        setSize(500, 500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b1)
            {
                Addbook Addbook =new Addbook();
                Addbook.setVisible(true);
                this.setVisible(false);
                
            }

            else if(e.getSource()==b2)
            {
                Viewbook Viewbook = new Viewbook();
                Viewbook.setVisible(true);   
                //this.setVisible(false);
            }

            else if(e.getSource()==b3)
            {
                Issuebook Issuebook=new Issuebook();
                Issuebook.setVisible(true);
                this.setVisible(false);
                
            }

            else if(e.getSource()==b4)
            {
                Viewissue Viewissue = new Viewissue();
                Viewissue.setVisible(true);
                //this.setVisible(false);
            }
            else if(e.getSource()==b5)
            {
                Retbook Retbook= new Retbook();
                Retbook.setVisible(true);
                this.setVisible(false);
            }
            else if(e.getSource()==b6)
            {
                this.setVisible(false);
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        }

}