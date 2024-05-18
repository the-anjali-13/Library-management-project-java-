import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


class Viewbook extends JFrame 
{
        Viewbook()
        {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JTable table = new JTable();
                JScrollPane sp = new JScrollPane(table);
                add(sp);
                setSize(500,500);
                setResizable(true);
                
                 try
                {
                        String url = "jdbc:mysql://localhost:3307/demo";
                        String user = "root";
                        String pass = "root1";

                        Connection con = DriverManager.getConnection(url,user,pass);
                        Statement st = con.createStatement();
                        String Query = "select * from addbook";
                        ResultSet rs = st.executeQuery(Query);
                        ResultSetMetaData rsmd = rs.getMetaData();
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        int cols= rsmd.getColumnCount();
                        String[] colName= new String[cols];

                        for(int i=0;i<cols;i++)
                                colName[i]=rsmd.getColumnName(i+1);
                        model.setColumnIdentifiers(colName);


                        while(rs.next())
                        {
                               // String id = String.valueOf(rs.getInt("id"));
                                String callno = rs.getString("callno");
                                String bookname = rs.getString("bookname");
                                String author = rs.getString("author");
                                String publisher = rs.getString("publisher");
                                String quantity = rs.getString("quantity");
                                //String contect = rs.getString("contect");

                                String tbdata[] ={callno,bookname,author,publisher,quantity};
                                model.addRow(tbdata);

                               // JOptionPane.showMessageDialog(this, "loading data from the database");
                        }
                }

                catch(SQLException x)
                {
                        x.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error loading data from the database");
                }
                
        }

                

}
