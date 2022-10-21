package oving8_oppgave1;

/**
 * Klassen ArbTaker henter inn verdier gjennom konstruktøren
 * Klassen har mange ulike metoder, og med disse verdiene skal man kunne utføre metodene
 */
public class ArbTaker {
    private Person person;
    private int arbtakernr;
    private int ansettelsesaar;
    private double maanedslon;
    private double skatteprosent;

    private java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
    private int år = kalender.get(java.util.Calendar.YEAR);

    /**
     * Henter inn verdiene fra paramenterne, og setter de inn i klasse variablene
     * @param person Person er et objekt av Person klassen
     * @param arbtakernr 
     * @param ansettelsesaar
     * @param maanedslon
     * @param skatteprosent
     */
    public ArbTaker(Person person, int arbtakernr, int ansettelsesaar, double maanedslon, double skatteprosent){
        this.person = person;
        this.arbtakernr = ansettelsesaar;
        this.ansettelsesaar = ansettelsesaar;
        this.maanedslon = maanedslon;
        this.skatteprosent = skatteprosent;
    }
    
    /**
     * Returnerer skatt per måned ved å ta månedslønnen og gange det med skatteprosenten (fkes: 20000 * 0,5)
     * @return
     */
    public double skattMnd(){
        return maanedslon * skatteprosent;
    }
    
    /**
     * Returnerer brutto årslønn ved å ta månedslønn og gange det med 12 
     * @return
     */
    public double bruttolonn(){
        return maanedslon * 12;
    }
    
    /**
     * Regner på skatt per år med å ta skatt per måned og gange det med 10.5 fordi visse måneder ikke har full skatt
     * @return
     */
    public double skattAar(){
        return skattMnd() * 10.5;
    }
    
    /**
     * Returnerer navnet og etternavnet med å kalle på personobjektet som ble sendt gjennom konstuktøren
     * @return
     */
    public String navn(){
        return person.getEtternavn() + ", " + person.getFornavn();
    }

    /**
     * Regner hvor gammel personen er ved å ta nåværende år minus fødselsåret
     * @return
     */
    public int alder(){
        return (år - person.getFodselsaar());
    }
    
    /**
     * Regner hvor lenge personen har jobbet med å ta nåværende år minus året personen ble ansatt
     * @return
     */
    public int antallAarAnsatt(){
        return (år - ansettelsesaar);
    }
    
    /**
     * Sjekker om antall år som arbeidstakeren har jobbet mer enn antall år som er i parameteren
     * @param aar
     * @return
     */
    public boolean sjekkAntallAarAnsatt(int aar){
        return antallAarAnsatt() > aar;
    }

    /**
     * Returnerer arbeidstakernummberet til arbeidstakeren
     * @return
     */
    public int getArbTakerNr(){
        return arbtakernr;
    }
    /**
     * Returnerer Ansettelsesåret til arbeidstakeren
     * @return
     */
    public int getAnsettelsesAar(){
        return ansettelsesaar;
    }
    /**
     * Returnerer månedslønnen til arbeidstakeren
     * @return
     */
    public double getMaanedslon(){
        return maanedslon;
    }
    /**
     * Returnerer skatteprosent verdien til arbeidstakeren
     * @return
     */
    public double getSkatteprosent(){
        return skatteprosent;
    }

    /**
     * Setter valgt månedslønn (parameter) inn i classens månedslønn variabel
     * @param maanedslon
     */
    public void setMaanedslon(int maanedslon){
        this.maanedslon = maanedslon;
    }
    /**
     * Setter valgt skatteprosent(parameter) inn i classens skatteprosent variabel
     * @param skatteprosent
     */
    public void setSkatteprosent(double skatteprosent){
        this.skatteprosent = skatteprosent;
    }

    /**
     * Returnerer alle verdiene fra alle metodene og gjør det om til en tekst
     * @return
     */
   @Override
   public String toString() {
       return "Skatt per måned: " + skattMnd() + "\nBrutto lønn: " + bruttolonn() + "\nSkatt per år: " + skattAar() + "\nNavnet til arbTaker: " + navn() + "\nArbTaker alder: " + alder() + "\nAntall år ansatt: " + antallAarAnsatt();
   }
    
}
