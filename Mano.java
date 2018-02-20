import java.util.*;


public class Mano {
    
    private ArrayList m;
    
    public Mano() {
        this.m = new ArrayList(3);
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
    
    public Carta scegliCarta(Carta b){
        char semeBri=b.getSeme();
        int cont=0, min=11, val, pos=0;
        Carta c=new Carta();
        for(int i=0;i<m.size();i++)
            if(semeBri==((Carta)m.get(i)).getSeme())
                cont++;
        if(cont==m.size())
        //TRE BRISCOLE    
            {
            for(int i=0;i<m.size();i++)
                {
                val=0;
                switch(((Carta)m.get(i)).getValore())
                    {
                    case 1: val=11; break;
                    case 3: val=10; break;
                    case 10: val=4; break;
                    case 9: val=3; break;
                    case 8: val=2; break;
                    default: val=-10+((Carta)m.get(i)).getValore(); break;
                    }
                if(val<min)
                    {
                    min=val;
                    pos=i;
                    }
                } 
            c=(Carta)m.get(pos);
            m.remove(pos);
            return c;
            }
        else
            {
            if(cont==2)
                {
                min=11;
                for(int i=0;i<m.size();i++)
                    if(((Carta)m.get(i)).getSeme()!=semeBri && ((Carta)m.get(i)).getValore()!=1 && ((Carta)m.get(i)).getValore()!=3)
                        {
                        pos=i;
                        break;
                        }
                    else
                        if(((Carta)m.get(i)).getSeme()==semeBri)
                            {
                            switch(((Carta)m.get(i)).getValore())
                                {
                                case 1: val=11; break;
                                case 3: val=10; break;
                                case 10: val=4; break;
                                case 9: val=3; break;
                                case 8: val=2; break;
                                default: val=-10+((Carta)m.get(i)).getValore(); break;
                                }
                            if(val<min)
                                {
                                min=val;
                                pos=i;
                                }
                            }
                c=(Carta)m.get(pos);
                m.remove(pos);
                return c;
                }
            else
                if(cont==1)
                    {
                    min=11;    
                    for(int i=0;i<m.size();i++)
                        {
                        if(((Carta)m.get(i)).getSeme()!=semeBri)    
                            {
                            switch(((Carta)m.get(i)).getValore())
                                {
                                case 1: val=11; break;
                                case 3: val=10; break;
                                case 10: val=4; break;
                                case 9: val=3; break;
                                case 8: val=2; break;
                                default: val=-10+((Carta)m.get(i)).getValore(); break;
                                }
                            if(val<min)
                                {
                                min=val;
                                pos=i;
                                }
                            }
                        }
                    if(min>=10)
                        for(int i=0;i<m.size();i++)
                            if(((Carta)m.get(i)).getSeme()==semeBri)
                                {
                                pos=i;
                                break;
                                }
                    c=(Carta)m.get(pos);
                    m.remove(pos);
                    return c;
                    }
                else
                    {
                    min=11;    
                    for(int i=0;i<m.size();i++)
                        {
                        switch(((Carta)m.get(i)).getValore())
                            {
                            case 1: val=11; break;
                            case 3: val=10; break;
                            case 10: val=4; break;
                            case 9: val=3; break;
                            case 8: val=2; break;
                            default: val=-10+((Carta)m.get(i)).getValore(); break;
                            }
                        if(val<min)
                            {
                            min=val;
                            pos=i;
                            }   
                        }
                    c=(Carta)m.get(pos);
                    m.remove(pos);
                    return c;
                    }    
            }
    }
    
    public Carta rispondiCarta(Carta briscola, Carta Gioc){
        int valGioc=0, maxB=-10, maxNB=-10, minB=12, minNB=12, posMB=-1, posMNB=-1, posmB=-1, posmNB=-1, val=0; 
        Carta c=new Carta();
        char semeGioc=Gioc.getSeme(), semeBri=briscola.getSeme();
        boolean scelta=false;
        switch(Gioc.getValore())
            {
            case 1: valGioc=11; break;
            case 3: valGioc=10; break;
            case 10: valGioc=4; break;
            case 9: valGioc=3; break;
            case 8: valGioc=2; break;
            default: valGioc=-10+Gioc.getValore(); break;
            }
        //MAX BRISCOLA
        for(int i=0;i<m.size();i++)
            if(((Carta)m.get(i)).getSeme()==semeBri)
                {
                switch(((Carta)m.get(i)).getValore())
                    {
                    case 1: val=11; break;
                    case 3: val=10; break;
                    case 10: val=4; break;
                    case 9: val=3; break;
                    case 8: val=2; break;
                    default: val=-10+((Carta)m.get(i)).getValore(); break;
                    }
                if(val>maxB)
                    {
                    maxB=val;
                    posMB=i;
                    }   
                }
        val=0;
        //MAX NON BRISCOLA
        for(int i=0;i<m.size();i++)
            if(((Carta)m.get(i)).getSeme()!=semeBri)
                {
                switch(((Carta)m.get(i)).getValore())
                    {
                    case 1: val=11; break;
                    case 3: val=10; break;
                    case 10: val=4; break;
                    case 9: val=3; break;
                    case 8: val=2; break;
                    default: val=-10+((Carta)m.get(i)).getValore(); break;
                    }
                if(val>maxNB)
                    {
                    maxNB=val;
                    posMNB=i;
                    }   
                }
        val=0;
        //MIN BRISCOLA 
        for(int i=0;i<m.size();i++)
            if(((Carta)m.get(i)).getSeme()==semeBri)
                {
                switch(((Carta)m.get(i)).getValore())
                    {
                    case 1: val=11; break;
                    case 3: val=10; break;
                    case 10: val=4; break;
                    case 9: val=3; break;
                    case 8: val=2; break;
                    default: val=-10+((Carta)m.get(i)).getValore(); break;
                    }
                if(val<minB)
                    {
                    minB=val;
                    posmB=i;
                    }   
                }
        val=0;
        //MIN NON BRISCOLA
        for(int i=0;i<m.size();i++)
            if(((Carta)m.get(i)).getSeme()!=semeBri)
                {
                switch(((Carta)m.get(i)).getValore())
                    {
                    case 1: val=11; break;
                    case 3: val=10; break;
                    case 10: val=4; break;
                    case 9: val=3; break;
                    case 8: val=2; break;
                    default: val=-10+((Carta)m.get(i)).getValore(); break;
                    }
                if(val<minNB)
                    {
                    minNB=val;
                    posmNB=i;
                    }   
                }     
        //INIZIO RAGIONAMENTO
        //CERCO LO STROZZO NORMALE O DI CARICO DI BRISCOLA
        if(semeGioc!=semeBri)
            if(posMNB!=-1)
                if(((Carta)m.get(posMNB)).getSeme()==semeGioc)
                    if(maxNB>valGioc)
                        {
                        c=(Carta)m.remove(posMNB);
                        scelta=true;
                        }
        else
            if(valGioc==10)
                if(maxB>valGioc)
                    {
                    c=(Carta)m.remove(posMB);
                    scelta=true;
                    }
        if(scelta)
            return c;
        else
            {
            //GIOCATORE 1 HA GIOCATO UNA BRISCOLA E IO NON HO STROZZATO
            if(semeGioc==semeBri)
                if(minNB<=4)
                    c=(Carta)m.remove(posmNB);
                else
                    if(minB<12)
                        c=(Carta)m.remove(posmB);
                    else
                        c=(Carta)m.remove(posmNB);
            //GIOCATORE 1 NON HA GIOCATO UNA BRISCOLA E IO NON HO STROZZATO
            else
                if(valGioc>=10)
                    if(minB<12)
                        c=(Carta)m.remove(posmB);
                    else
                        c=(Carta)m.remove(posmNB);
                else
                    if(minNB<10)
                        c=(Carta)m.remove(posmNB);
                    else
                        if(minB<12)
                            c=(Carta)m.remove(posmB);
                        else
                            c=(Carta)m.remove(posmNB);
            return c;
            }
    }
}
