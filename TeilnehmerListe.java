//Import
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class TeilnehmerListe {
        private static ArrayList<Teilnehmer> chatTeilehmer = new ArrayList<Teilnehmer>();
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
        public List<Teilnehmer> getTeilnehmerListe() {
                return chatTeilehmer;
        }
       
        public void addTeilnehmer(Teilnehmer c) {
                if(chatTeilehmer.size()>=size)throw new IllegalStateException();
                chatTeilehmer.add(c);
        }
       
        public void removeTeilnehmer(Teilnehmer c) {
                if(chatTeilehmer.size()<=0)throw new IllegalStateException();
                chatTeilehmer.remove(c);
        }
       
        public boolean contains(Teilnehmer c){
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
        public synchronized boolean isStarted() {
                return started;
        }
       
       
        public synchronized String gibUserListe(){
                StringBuilder userListe =new StringBuilder("");
                for (int i = 0; i < size; i++) {
                        userListe.append(chatTeilehmer.get(i));
                }
                return userListe.toString();
        }
       
       
        public synchronized Teilnehmer[] gibVerbindungen(){
               Teilnehmer[] ch = new Teilnehmer[size];
               
                for (int i = 0; i < size; i++) {
                        chatTeilehmer.get(i).broadcast();
                }
                return ch;
        }
       
}
