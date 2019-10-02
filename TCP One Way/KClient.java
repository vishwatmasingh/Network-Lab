
import java.net.*; 

import java.io.*; 

class KClient
{ 
 
public static void main(String args[])throws Exception
	{ 
 
	Socket s=new Socket("localhost",1234);
        
DataInputStream din=new DataInputStream(s.getInputStream());
        
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      
  
String str="";
        
while(!str.equals("stop"))
		{  
		
str=br.readLine();
		dout.writeUTF(str);
		dout.flush();  

		}
  

	dout.close();
        
s.close();  

	}
}  
