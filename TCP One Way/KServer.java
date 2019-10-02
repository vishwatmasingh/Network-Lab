
import java.net.*;

import java.io.*;  

class KServer
{  

 public static void main(String args[])throws Exception
	{  

	ServerSocket ss=new ServerSocket(1234);  

	Socket s=ss.accept();  

	DataInputStream din=new DataInputStream(s.getInputStream());  

	DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
	
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  

	String str="";
 	
while(!str.equals("stop"))
		{  

		str=din.readUTF();  

		System.out.println("client says: "+str);  

		dout.flush();  

		}  

	din.close();  

	s.close();  

	ss.close();  

	}
}  

