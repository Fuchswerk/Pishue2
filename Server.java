// vereinfachter Import der Oberklassen
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
  static int clients= 0;
	static ServerSocket server;
	static TeilnehmerListe teilnehmer;
	/**
	 * Main-Methode
	 * @param Normalaufruf der Server-Klasse
	 */
	public static void main (String[]args){
		try {
			
			ExecutorService executor = Executors.newFixedThreadPool(3);
			server = new ServerSocket(5555);//<-- Port vom Server für Socket des Client
			System.out.println("Server is listen on port: 5555.");
			if(clients <3){
			while(true){
					
				//ServerSocket für den Server
				//in try-catch Block
				try {
									
				//Client erzeugen
				Socket client = server.accept();		
			
				//neuer Client in den Thread-Pool
				executor.execute(new Handler(client));
						
				} catch (IOException e) {
					//TODO Auto-generated catch-block
                    e.printStackTrace();
			}
			clients++;
		  }
		}else{
		   Socket client = server.accept();
		   executor.execute(new Handler(client));
	       OutputStream out = client.getOutputStream();
	       PrintWriter writer = new PrintWriter(out);
	       writer.write("refused:too_many_users");
	       
		}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 			

	}
	
}
