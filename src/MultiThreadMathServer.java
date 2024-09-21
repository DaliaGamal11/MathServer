/* MultiThreadMathServer.java: A program extending MathServer which
allows concurrent client requests and opens a new thread for each socket
connection. */
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadMathServer extends MathServer implements Runnable {
	public void run() {
		execute();
	}
	
	public static void main(String [] args)throws Exception {
		int port = 6666;

		System.out.println("Multi Threaded Server started...");
		ServerSocket serverSocket = new ServerSocket(port);
		
		while(true){
			//waiting for client connection
			Socket socket = serverSocket.accept();
			socket.setSoTimeout(14000);
			MultiThreadMathServer server = new MultiThreadMathServer();
			server.setMathService(new PlainMathService());
			server.setSocket(socket);
			
			//start a new server thread...
			Thread t = new Thread(server);
			t.start();
			System.out.println("Thread #"  + t.getId());
		}
		
	}
}