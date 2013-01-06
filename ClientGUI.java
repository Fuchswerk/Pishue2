import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

  @SuppressWarnings("serial")
	public class ClientGUI extends JFrame implements ActionListener {
		// Feld für die Chat-Nachrichten
		JTextArea messages = new JTextArea();
		
		
		ClientGUI() {
			super("Chat Client");
                
			Client client = new Client();
			
			/** Erstellen des Textfeld User
			 *  Für Namenseingabe
			 *  @Reason Weil Extrabehandlung durch Speicherung des Usernamen
			 * 
			 */
			JTextField user = new JTextField("User1",8);
			
			// Hauptpanel der GUI-Oberfläche
			JPanel topPanel = new JPanel();
			//Hinzufügen der entsprechenden grafischen Elemente
			topPanel.add(new JLabel(" Server:"));
			topPanel.add(new JTextField("localhost", 10));
			topPanel.add(new JLabel(" Port:"));
			topPanel.add(new JTextField("7575", 4));
			topPanel.add(new JLabel(" User:"));
			topPanel.add(user);
			
			//Speicherung des Usernamen ins Objekt Client
			client.NAME = user.getText();
			
			JButton connectButton = new JButton("Connect");
			connectButton.setActionCommand("connect");
			connectButton.addActionListener(this);
			topPanel.add(connectButton);
			JButton disconnectButton = new JButton("Disconnect");
			disconnectButton.setActionCommand("disconnect");
			disconnectButton.addActionListener(this);
			topPanel.add(disconnectButton);

			messages.setEditable(false);

			// Liste der Chat-User
			JList users = new JList(new String[]{});
			users.setPrototypeCellValue("XXXXXXXXXXXXXXXX");
			
			// Textfeld für neue Nachrichten
			JTextField messageTextField = new JTextField();
			messageTextField.setActionCommand("send");
			messageTextField.addActionListener(this);


			// Frame
			add(topPanel, "North");
			add(new JScrollPane(users), "East");
			add(new JScrollPane(messages), "Center");
			add(messageTextField, "South"); // "South" == BorderLayout.SOUTH
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(600, 200);
			setVisible(true);
            
		}
		
		/** Methode zum Abfangen des ActionEvent
		 * @param e Ist ActionEvent
		 * @pre ActionEvent is sending
		 * @post ActionEvent wird durchgeführt
		 * 
		 */

		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			if (command.equals("connect")) {

				try {
					Socket client = new Socket("localhost", 5555);

				} catch (UnknownHostException e1) {
					// TODO ins Message-Feld schreiben
					// Kein Host da
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				

			} else if (command.equals("send")) {
				
				//....
				
			} // else ...

		}


		public static void main(String[] args) {
			new ClientGUI();

		}


}
