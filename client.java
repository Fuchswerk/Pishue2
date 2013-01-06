// vereinfachter Import der Oberklassen
import java.io.*;
import java.net.*;
import java.util.*;


public class Handler implements Runnable {
     
  private Socket client;
	
	/**Konstruktor
	* Erstellt ein Objekt der Klasse Handler 
	*/
	public Handler(Socket client){
		this.client = client;
	}
	
	@Override
	/** Methode run() des Interface Runnable
	 * @post führt den run() aus
	 */
	public void run() {
		
		try{
		//Streams
		OutputStream out = client.getOutputStream();
		PrintWriter writer = new PrintWriter(out);
		
		InputStream in = client.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		//-------------------------------------------------------------------
							
		String s = null;
		
		//Ausgabe der Zeilen in While-schleife
		while((s = reader.readLine()) != null){
			writer.write(s + "\n");
			writer.flush();
			System.out.println("Empfangen vom Client:" +s);
		}
		//schließen des Reader und des Writer
		writer.close();
		reader.close();
		
		//Schließen des Clients
		client.close();
		
		}
		catch (Exception e){
			
		}
		
	}
	public void broadcast(){
		
	}

}
