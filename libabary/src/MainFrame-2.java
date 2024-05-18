/* this is main and first  frame of library management project in which there
 are two button "admin login"  " librarian login " with a title label.
* */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainFrame extends JFrame implements ActionListener{

    JLabel l; JButton b1,b2;
     MainFrame() {


         l = new JLabel(" LIBRARY MANAGEMENT PORTAL");
         l.setBounds(100, 10, 600, 150);

         b1 = new JButton("Admin Login");
         b1.setBounds(100, 150, 200, 40);

         b2 = new JButton("Librarian Login");
         b2.setBounds(100, 200, 200, 40);

         b1.addActionListener(this);
         b2.addActionListener(this);

         add(l);
         add(b1);
         add(b2);
         setSize(500, 500);
         setLayout(null);
         setVisible(true);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b1)
            {
                Adminlogin Adminlogin = new Adminlogin();
                Adminlogin.setVisible(true);
                this.setVisible(false);
            }
            else if (e.getSource()==b2)
            {
                Liblogin Liblogin=new Liblogin();
                Liblogin.setVisible(true);
                this.setVisible(false);
            }
        }


 
}

