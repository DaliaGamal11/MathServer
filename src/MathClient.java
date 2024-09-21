// MathClient.java: A test client program to access MathServer.
import java.io.*;
import java.net.Socket;

public class MathClient {
	
 public static void main(String [] args){
	 
//	 MathClient client = new MathClient();
//	 client.runMultipleRequests(5);
	 
	 //run one request
	 String hostname = "localhost";
	 int port = 6666;
	 	 
	 try {
		 // create a socket
		 Socket socket = new Socket(hostname, port);
		 
		 // perform a simple math operation "12+21"
		 BufferedWriter writer = new BufferedWriter(
		 new OutputStreamWriter(socket.getOutputStream()));
		 writer.write("*:5:10");
		 writer.newLine();
		 writer.flush();
		 
		 // get the result from the server
		 BufferedReader reader = new BufferedReader(
		 new InputStreamReader(socket.getInputStream()));
		 System.out.println("The result sent from the server : " + reader.readLine());
		 reader.close();
		 writer.close();
		 socket.close();
	 }
	 catch (Exception e) {
		 e.printStackTrace();
	 }
 	}
 
 	public void runMultipleRequests(int numOfClients){
 		 String hostname = "localhost";
 		 int port = 6666;
 		 
 		 for(int i = 0; i< numOfClients; i++){
 		 try {
 			 // create a socket
 			 Socket socket = new Socket(hostname, port);
 			 
 			 // perform a simple math operation "12+21"
 			 BufferedWriter writer = new BufferedWriter(
 			 new OutputStreamWriter(socket.getOutputStream()));
 			 writer.write("+:12:21");
 			 writer.newLine();
 			 writer.flush();
 			 
 			 // get the result from the server
 			 BufferedReader reader = new BufferedReader(
 			 new InputStreamReader(socket.getInputStream()));
 			 System.out.println(reader.readLine());
 			 reader.close();
 			 writer.close();
 			 socket.close();
 		 }
 		 catch (Exception e) {
 			 e.printStackTrace();
 		 }
 		 }
 	}
 
}