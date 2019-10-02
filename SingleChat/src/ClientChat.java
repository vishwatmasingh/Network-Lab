
import java.io.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
class ServerChat extends JFrame implements ActionListener
{
ServerSocket server;
Socket conn;
JPanel panel;
JTextField tf1;
JTextArea ta1;
JButton send;
DataInputStream dis;
DataOutputStream dos;
public ServerChat() throws UnknownHostException, IOException{
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
	server=new ServerSocket(2000);
	ta1.setText("Waiting for Client");
        conn=server.accept();
        ta1.setText(ta1.getText()+'\n'+"Client Found");
	while(true)
	{
		try{
			DataInputStream dis=new DataInputStream (conn.getInputStream());
			String string=dis.readUTF();
			ta1.setText(ta1.getText()+'\n'+"Client:"+string);
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
	ta1.setText(ta1.getText()+'\n'+"Me:"+tf1.getText());
	try{
		DataOutputStream dos=new DataOutputStream(conn.getOutputStream());
		dos.writeUTF(tf1.getText());	
	   }
	catch (Exception e2)
	   {
		
	    }
	    tf1.setText("");
	}
}
public static void main(String args[]) throws UnknownHostException,IOException{

ServerChat c=new ServerChat();
}
}
