import java.util.*;

public class Mazzo {
    
    private ArrayList m;

    public Mazzo() {
        this.m = new ArrayList(52);
    }
    
    public void addCarta(Carta c){
        m.add(c);
    }
    
    public void creaMazzo(){
    for(int i=1;i<=52;i++)
        {
        Carta c=new Carta();
        if(i<=13)
            {
            c.setValore(i);
            c.setSeme('P');
            }
        else if(i<=26)
            { 
            c.setValore(i-13);
            c.setSeme('F');
            }
        else if(i<=39)
            {
            c.setValore(i-26);
            c.setSeme('C');
            }
        else
            {
            c.setValore(i-39);
            c.setSeme('Q');
            }
        c.setCodice(i);
        m.add(c);
        }
    }
    
    public void mescolaMazzo(){
        int par;
        Carta c;
        for(int i=0;i<m.size();i++)
            {
            par=(int)(Math.random()*52);
            c=(Carta)m.get(i);
            m.set(i,(Carta)m.get(par));
            m.set(par,c);
            }
    }
    
    public Carta getCarta(int i){
        Carta c=(Carta)m.get(i);
        m.remove(i);
        return c;
    }
    
    public int dimensioni(){
        return m.size();
    }
}
