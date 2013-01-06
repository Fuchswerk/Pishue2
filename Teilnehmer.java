//import
import java.net.*;
public class Teilnehmer {
    private InetAddress ip;
    private String name;
    Socket s;
    boolean connected;
   
    /**
     * Methode zur Ausgabe des Namen
     * @return Name des Teilnehmers
     */
    public String getName(){
            return name;
    }
   
    /**
     * Methode zur Ausgabe des Namen
     * @return Name des Teilnehmers
     */
    public InetAddress getIP(){
            return ip;
    }
   
    /**
     * Methode zur Ausgabe des Namen
     * @pre Socket s : Client-Socket
     * @return Liefert ein Objekt der Klasse 
     */
    public void Teilnehmer(Socket s){
            this.ip = s.getInetAddress();
            this.name = "";
            connected = false;
            this.s = s;
    }
}
