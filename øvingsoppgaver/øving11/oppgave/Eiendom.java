package oving11_oppgave1;

public class Eiendom {
    private final int kommunenummer;
    private final String kommunenavn;
    private final int gnr;
    private final int bnr;
    private String bruksnavn;
    private double areal;
    private String eier;

    /**
     * Setter parametervariablene i de globale varablene
     * @param kommunenummer
     * @param komunenavn
     * @param gnr
     * @param bnr
     * @param bruksnavn
     * @param areal
     * @param eier
     */
    public Eiendom(int kommunenummer, String komunenavn, int gnr, int bnr, String bruksnavn, double areal, String eier){
        if (areal <= 0){
            throw new IllegalArgumentException("Arealet kan ikke være null");
        }
        this.kommunenummer = kommunenummer;
        this.kommunenavn = komunenavn;
        this.gnr = gnr;
        this.bnr = bnr;
        this.bruksnavn = bruksnavn;
        this.areal = areal;
        this.eier = eier;
    }

    /**
     * Setter parametervarablene inn i de globale variablene
     * @param kommunenummer
     * @param kommunenavn
     * @param gnr
     * @param bnr
     * @param areal
     * @param eier
     */
    public Eiendom(int kommunenummer, String kommunenavn, int gnr, int bnr, double areal, String eier){
      this(kommunenummer, kommunenavn, gnr, bnr, "Ingen bruksnavn", areal, eier);

    }

    /**
     * 
     * @param eiendom
     */
    public Eiendom(Eiendom eiendom){
        this(eiendom.getKommuneNummer(), eiendom.getKommuneNavn(), eiendom.getGnr(), eiendom.getBnr(), eiendom.getBruksnavn(), eiendom.getAreal(), eiendom.getEier());
    }

    /**
     * returnerer kommunenummeret til objektet
     * @return
     */
    public int getKommuneNummer(){
        return kommunenummer;
    }

    /**
     * returnerer kommunenavnet til objektet
     * @return
     */
    public String getKommuneNavn(){
        return kommunenavn;
    }

    /**
     * returnerer gårdsnummeret til objektet
     * @return
     */
    public int getGnr(){
        return gnr;
    }

    /**
     * returnerer bruksnummeret til objektet
     * @return
     */
    public int getBnr(){
        return bnr;
    }

    /**
     * returnerer bruksnavnet til objektet
     * @return
     */
    public String getBruksnavn(){
        return bruksnavn;
    }

    /**
     * returnerer arealet til objektet
     * @return
     */
    public double getAreal(){
        return areal;
    }

    /**
     * returnerer navnet på eieren til objektet
     * @return
     */
    public String getEier() {
        return  eier;
    }

    public void setEier(String eier){
        if (eier.isBlank()){
            throw new IllegalArgumentException();
        }
        this.eier = eier;
    }

    /**
     * returnerer de globale variablene i en gitt streng
     */
    @Override
    public String toString() {
        return kommunenavn + " " + kommunenummer + "-" + gnr + "/" + bnr + " | Bruksnavn: " + bruksnavn + " | Areal: " + areal + " | Eier: " + eier + "\n";
    }
}

