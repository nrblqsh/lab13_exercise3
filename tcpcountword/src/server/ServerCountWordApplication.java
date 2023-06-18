package server;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class launch the server side application using TCP.
 * The server generates current date.
 * Each connected client will received word count from the server.
 * 
 * @author norbalqish
 *
 */

public class ServerCountWordApplication {

	/**
	 * Main entry point to the server side application
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		ServerCountWordFrame serverFrame = new ServerCountWordFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other port no
		int portNo = 2115;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		WordCount wordCount = new WordCount();
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		
		// Server needs to be alive forever
		while (true) {
			
			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
			
			
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// get word
			String word = wordCount.getTxt();
			int countWords = word.split("\\s").length;
			
			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			// Send word count back to the client
			outputStream.writeInt(countWords);
			
			// Close the socket
			clientSocket.close();
		
			// Update the request status
			serverFrame.updateRequestStatus(
					"Data sent to the client: " + countWords);
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
		}
		
		

	}

}

