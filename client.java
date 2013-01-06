// vereinfachter Import der Oberklassen
import java.io.*;
import java.net.*;
import java.util.*;


public class Client implements Runnable {
	// String NAME fürs Protokoll connect:NAME
	String NAME = new String();
	
	/**
	 * Main-Methode
	 */
	public static void main(String[] args) {
	 	new Thread(new Client()).start();
	 	
	}

	@Override
	public void run() {
		 //Scanner-Objekt um Eingaben einzulesen
		 Scanner eingabe = new Scanner(System.in);	
		 
	     // Socket für den Client im try-catch
		 try {
			Socket client = new Socket("localhost", 5555);
			System.out.println("Client is started");
			
			System.out.print("Username eingeben:");
			NAME = eingabe.nextLine();
			
			//Streams
			OutputStream out = client.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			
			InputStream in = client.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			//-------------------------------------------------------------------
			
			writer.write("connect:");
			
			System.out.print("Eingabe: ");
            String castToServer = eingabe.nextLine();			
			
			//Funktion um Nachrichten an den Server zu senden
			writer.write("message:"+NAME+":"+castToServer+"\n");
			writer.flush(); //Um zu aktualisieren
			
			String s = null;
			
			while((s = reader.readLine()) != null){
				System.out.println("message:"+NAME+": "+s);
			}
			
			//schließen des Writer und reader
			writer.close();
			reader.close();
			
		} catch (UnknownHostException e) {
			
			System.out.println("connect:Host is unknown");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Exception-Handling
			e.printStackTrace();
		}
	}

}
