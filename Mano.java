import java.util.*;


public class Mano {
    
    private ArrayList m;
    
    public Mano() {
        this.m = new ArrayList(2);
    }
    
    public void addCarta(Carta c,int i){
        m.add(i,c);
    }
    
    public Carta giocaCarta(int i){
        Carta c=(Carta)m.get(i);
        m.remove(i);
        return c;
    }
    
    public int dimensioni(){
        return m.size();
    }
}
