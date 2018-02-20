public class Carta {
    
    private int valore, codice;
    private char seme;

    public Carta(int valore, char seme, int codice) {
        this.valore = valore;
        this.seme = seme;
        this.codice = codice;
    }

    public Carta() {
    }
    

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public char getSeme() {
        return seme;
    }

    public void setSeme(char seme) {
        this.seme = seme;
    }  

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }
    
    @Override
    public String toString(){
        String s=valore+" "+seme;
        return s;
    }
}
