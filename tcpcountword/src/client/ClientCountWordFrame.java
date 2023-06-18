package client;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represents the window for the client side TCP application.
 * It displays the word count received from the server.
 * 
 * 
 * @author norbalqish
 *
 */
public class ClientCountWordFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    
    // Private frame components
    private JLabel lblWordCount;
    private JLabel lblStatusValue;  

    // Private attributes for frame size
    private int width = 700;
    private int height = 200;

    
    /**
     * The constructor that initializes and organizes the Swing components on the frame.
     */
    public ClientCountWordFrame() {
    	
        // Default frame setting
        this.setLayout(new BorderLayout());
        this.setTitle("TCP Application: Client Side");
        this.setSize(width, height);
        

        // Center the frame on the screen
        this.setLocationRelativeTo(null);

        // Initialize default value for labels
        lblWordCount = new JLabel("-");
        lblStatusValue = new JLabel("-");

        // Must close on X
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Organize components
        loadComponents();
    }

    
    
    /**
     * This method updates the value of the word count on the frame.
     * 
     * @param wordCount: Word count received from the server
     */
    public void updateWordCount(String txt) {
    	
    	// Count the number of words without count the space
    	int wordCount = txt.trim().split("\\s+").length;

    	// Display the word count in the label
    	lblWordCount.setText(String.valueOf(wordCount));
    }

    
    
    /**
     * This method updates the status of the connection to the server.
     * 
     * @param connStatus: Connection status (true/false)
     */
    public void updateConnectionStatus(boolean connStatus) {
    	
        // Default status. Assuming the worst-case scenario.
        String status = "No connection to server.";

        // Validate status of connection
        if (connStatus)
            status = "Connection has been established.";

        // Update the status on the frame
        lblStatusValue.setText(status);
    }
    
    

    /**
     * This method arranges the Swing components on the frame.
     */
    private void loadComponents() {
    	
        // Get font
        Font font = this.getFontStyle();

        // Get server status panel and add it to the frame
        JPanel northPanel = getConnectionStatusPanel(font);
        this.add(northPanel, BorderLayout.NORTH);
        // Get word count panel and add it to the frame
        
        JPanel center = getWordCountPanel(font);
        this.add(center, BorderLayout.CENTER);
        
    }
    
    

    /**
     * This method creates and arranges Swing components to display the status of
     * the client's connection to the server.
     * 
     * @param font
     * @return Swing components organized in a panel.
     */
    private JPanel getConnectionStatusPanel(Font font) {
    	
        // Create components
        JPanel panel = new JPanel();
        JLabel lblConnStatus = new JLabel("Connection status: ");

        // Style the components
        lblConnStatus.setFont(font);
        lblStatusValue.setFont(font);
        lblConnStatus.setBackground(Color.WHITE);
        lblConnStatus.setOpaque(true);
        lblStatusValue.setBackground(Color.WHITE);
        lblStatusValue.setOpaque(true);

        // Organize components into the panel
        panel.add(lblConnStatus);
        panel.add(lblStatusValue);

        return panel;
       
    }
    
    
    /**
     * This method creates and arranges Swing components to display the word count received
     * from the server.
     * 
     * @param font
     * @return Swing components organized in a panel.
     */

    private JPanel getWordCountPanel(Font font) {
        // Create components to display the word count received from the server
        JPanel panel = new JPanel();
        JLabel lblCount = new JLabel("Count Word: ");

        // Style the components
        lblCount.setFont(font);
        lblWordCount.setFont(font);
        lblCount.setBackground(Color.WHITE);
        lblCount.setOpaque(true);
        lblWordCount.setBackground(Color.WHITE);
        lblWordCount.setOpaque(true);

        // Organize components into the panel
        panel.add(lblCount);
        panel.add(lblWordCount);

        return panel;
    }

    
    
    /**
     * This method defines a font to a generic style.
     * 
     * @return font object
     */
    private Font getFontStyle() {
        Font font = new Font("Serif", Font.PLAIN, 30);
        return font;
    }

}
