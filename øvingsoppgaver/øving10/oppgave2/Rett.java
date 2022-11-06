package oving10_oppgave2;

public class Rett {
    String rettNavn;
    String rettType;
    int rettPris;
    
    /**
     * Henter inn verdiene fra paramenterne, og setter de inn i klasse variablene
     * @param rettNavn
     * @param rettType
     * @param rettPris
     */
    public Rett(String rettNavn, String rettType, int rettPris){
        this.rettNavn = rettNavn;
        this.rettType = rettType;
        this.rettPris = rettPris;

    }

    /**
     * 
     * @param rett
     */
    public Rett(Rett rett) {
        this(rett.getRettNavn(), rett.getRettType(), rett.getRettPris());
    }

    /**
     * returnerer rettNavn variablen
     * @return
     */
    public String getRettNavn(){
        return rettNavn;
    }
    /**
     * returnerer rettType variablen
     * @return
     */
    public String getRettType(){
        return rettType;
    }
    /**
     * returnerer rettPris variablen
     * @return
     */
    public int getRettPris(){
        return rettPris;
    }

    /**
     * Returnerer alle variablene i en gitt string
     */
    @Override
    public String toString() {
        return "Rett: " + rettNavn + " | rettType: " + rettType + " | rettpris: " + rettPris + "\n";
    }
}
