//Import
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class TeilnehmerListe {
        private static ArrayList<Handler> chatTeilehmer = new ArrayList<Handler>();
        private int size;
        private Server csp;
       
        //Status des Servers
       
        boolean started;
       
       
        public void setChatServerPresenter(Server csp){
                this.csp = csp;
        }
       
        public TeilnehmerListe(int size){
                if(size==0)throw new IllegalArgumentException();
                this.size = size;
               
        }
        public List<Handler> getTeilnehmerListe() {
                return chatTeilehmer;
        }
       
        public void addTeilnehmer(Handler c) {
                if(chatTeilehmer.size()>=size)throw new IllegalStateException();
                chatTeilehmer.add(c);
        }
       
        public void removeTeilnehmer(Handler c) {
                if(chatTeilehmer.size()<=0)throw new IllegalStateException();
                chatTeilehmer.remove(c);
        }
       
        public boolean contains(Handler c){
                if(chatTeilehmer.contains(c)){
                        return true;
                }else{
                        return false;
                }
        }
       
       
        /**
        * Gibt den Zustand des Servers zurück.
        * @return true if server was started, otherwise false
        */      
        public boolean isStarted() {
                return started;
        }
       
       
        public String gibUserListe(){
                StringBuilder userListe =new StringBuilder("");
                for (int i = 0; i < size; i++) {
                        userListe.append(chatTeilehmer.get(i));
                }
                return userListe.toString();
        }
       
       
        public Handler[] gibVerbindungen(){
               Handler[] ch = new Handler[size];
               
                for (int i = 0; i < size; i++) {
                        chatTeilehmer.get(i).broadcast();
                }
                return ch;
        }
       
}
