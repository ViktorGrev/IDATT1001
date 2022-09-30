package oving5_oppgave1;

public class Konvertering {
    int teller;
    int nevner;
    public Konvertering(int teller, int nevner){
        if(nevner == 0){
            throw new IllegalArgumentException();
        }
        else{
            this.teller = teller;
            this.nevner = nevner; 
        }
    }
    public Konvertering(int teller){
        this.teller = teller;
        this.nevner = 1;
    }

    public int getTeller(){
        return this.teller;
    }
    public int getNevner(){
        return this.nevner;
    }

    public void addisjon(int teller, int nevner){
        teller *= this.nevner;
        this.teller *= nevner;
        this.nevner *= nevner;
        this.teller += teller;
    }

    public void subtraksjon(int teller, int nevner){
        teller *= this.nevner;
        this.teller *= nevner;
        this.nevner *= nevner;
        this.teller -= teller;
    }
    public void multiplikasjon(int teller, int nevner){
        this.teller *= teller;
        this.nevner *= nevner;
    }
    public void dividere(int teller, int nevner){
        this.teller *= nevner;
        this.nevner *= teller;
    }
}
