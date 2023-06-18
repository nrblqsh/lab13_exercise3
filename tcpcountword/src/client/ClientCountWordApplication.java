package client;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This class launches the client side application using TCP.
 * The client connects to the server and receives the word count of a predefined text.
 * The received word count is displayed in the client GUI.
 * 
 * The text to be counted is predefined as "Hello World".
 * 
 * 
 * @author norbalqish
 *
 */
public class ClientCountWordApplication {

    public static void main(String[] args) throws UnknownHostException, IOException {
    	
        // Launch client-side frame
        ClientCountWordFrame clientCountWordFrame = new ClientCountWordFrame();
        clientCountWordFrame.setVisible(true);

        // Connect to the server @ localhost, port 2115
        Socket socket = new Socket(InetAddress.getLocalHost(), 2115);

        // Update the status of the connection
        clientCountWordFrame.updateConnectionStatus(socket.isConnected());

        // Predefined text to be counted
        String txt = "Hello World";

        // Send the text to the server
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.writeUTF(txt);

        // Read the word count from the server
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());

        clientCountWordFrame.updateWordCount(txt);

        // Close everything
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
