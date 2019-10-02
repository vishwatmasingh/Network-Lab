import java.io.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
class ClientChat extends JFrame implements ActionListener
{
Socket conn;
JPanel panel;
JTextField tf1;
JTextArea ta1;
JButton send;
public ClientChat() throws UnknownHostException, IOException{
	panel=new JPanel();
	tf1=new JTextField();
	ta1=new JTextArea();
	send=new JButton("Send");
	this.setSize(500,500);
	this.setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	panel.setLayout(null);
	this.add(panel);
	ta1.setBounds(20,20,450,360);
	panel.add(ta1);
	tf1.setBounds(20,400,340,30);
	panel.add(tf1);
	send.setBounds(375,400,95,30);
	panel.add(send);
	this.setTitle("Server");
	send.addActionListener(this);
	conn=new Socket("localhost",2000);
	ta1.setText("Connected to Server");
	this.setTitle("Client");
	while(true)
	{
		try{
			DataInputStream dis=new DataInputStream (conn.getInputStream());
			String string=dis.readUTF();
			ta1.setText(ta1.getText()+'\n'+"Server:"+string);
		  }
		catch(Exception e)
		{
		}
		
          }
}
public void actionPerformed(ActionEvent e)
{
if((e.getSource()==send)&&(tf1.getText()!=""))
   {
	try{
	ta1.setText(ta1.getText()+'\n'+"Me:"+tf1.getText());
	DataOutputStream dos=new DataOutputStream(conn.getOutputStream());
	dos.writeUTF(tf1.getText());	
           }
	catch(Exception e2)
		{
		}
	tf1.setText("");
	}
}
public static void main(String args[]) throws UnknownHostException,IOException{

ClientChat c=new ClientChat();
}
}
