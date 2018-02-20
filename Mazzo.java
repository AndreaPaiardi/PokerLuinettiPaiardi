import java.util.*;

public class Mazzo {
    
    private ArrayList m;

    public Mazzo() {
        this.m = new ArrayList(40);
    }
    
    public void addCarta(Carta c){
        m.add(c);
    }
    
    public void creaMazzo(){
    for(int i=1;i<=40;i++)
        {
        Carta c=new Carta();
        if(i<=10)
            {
            c.setValore(i);
            c.setSeme('P');
            }
        else if(i<=20)
            { 
            c.setValore(i-10);
            c.setSeme('F');
            }
        else if(i<=30)
            {
            c.setValore(i-20);
            c.setSeme('C');
            }
        else
            {
            c.setValore(i-30);
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
            par=(int)(Math.random()*40);
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
    
    public boolean preso(Carta Pc,Carta Gioc,Carta briscola,boolean turno){
        char semeBri=briscola.getSeme(), semePc=Pc.getSeme(), semeGioc=Gioc.getSeme();
        int pc=Pc.getValore(), gioc=Gioc.getValore();
        switch(pc){
            case 1: pc=11; break;
            case 3: pc=10; break;
            case 10: pc=4; break;
            case 9: pc=3; break;
            case 8: pc=2; break;
            default: pc=-10+Pc.getValore(); break;
            }
        switch(gioc){
            case 1: gioc=11; break;
            case 3: gioc=10; break;
            case 10: gioc=4; break;
            case 9: gioc=3; break;
            case 8: gioc=2; break;
            default: gioc=-10+Gioc.getValore(); break;
            }
        if(turno)
            if(semeGioc==semeBri)
                if(semePc!=semeGioc)
                    return true;
                else
                    if(gioc>pc)
                        return true;
                    else
                        return false;
            else
                if(semePc==semeBri)
                    return false;
                else
                    if(semePc!=semeGioc)
                        return true;
                    else
                        if(gioc>pc)
                            return true;
                        else
                            return false;
        else
            if(semePc==semeBri)
                if(semeGioc!=semePc)
                    return false;
                else
                    if(pc>gioc)
                        return false;
                    else
                        return true;
            else
                if(semeGioc==semeBri)
                    return true;
                else
                    if(semeGioc!=semePc)
                        return false;
                    else
                        if(pc>gioc)
                            return false;
                        else
                            return true;
    }
}
