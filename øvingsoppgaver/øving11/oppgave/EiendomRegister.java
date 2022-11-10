package oving11_oppgave1;
import java.util.*;

public class EiendomRegister {
    private ArrayList<Eiendom> eiendomListe;

    public EiendomRegister(){
        eiendomListe = new ArrayList<Eiendom>();
    }

    /**
     * Registrer en eiendom med bruksnavn inn i eiendomListe
     * @param kommunenummer
     * @param komunenavn
     * @param gnr
     * @param bnr
     * @param bruksnavn
     * @param areal
     * @param eier
     */
    public void eiendommenRegistrer(int kommunenummer, String komunenavn, int gnr, int bnr, String bruksnavn, double areal, String eier){
        Eiendom eiendom = new Eiendom(kommunenummer, komunenavn, gnr, bnr, bruksnavn, areal, eier);
        eiendomListe.add(eiendom);
    }

    /**
     * Registrer en eiendom uten bruksnavn inn i eiendomListe
     * @param kommunenummer
     * @param komunenavn
     * @param gnr
     * @param bnr
     * @param areal
     * @param eier
     */
    public void eiendommenRegistrer(int kommunenummer, String komunenavn, int gnr, int bnr, double areal, String eier){
        Eiendom eiendom = new Eiendom(kommunenummer, komunenavn, gnr, bnr, areal, eier);
        eiendomListe.add(eiendom);
    }

    /**
     * Liste over alle de registrerte eiendommene
     * @return
     */
    public String registrerteEiendommer(){
        StringBuilder output = new StringBuilder();
        for (Eiendom eiendom : eiendomListe) {
            output.append(eiendom.toString());
        }
        return output.toString();
    }

    /**
     * Finner et gitt objekt i arraylisten, ved hjelp av kommunenummer, gnr og bnr
     * @param kommunenummer
     * @param gnr
     * @param bnr
     * @return
     */
    public Eiendom eiendomSearch(int kommunenummer, int gnr, int bnr){
        for (Eiendom eiendom : eiendomListe) {
            if(eiendom.getKommuneNummer() == kommunenummer && eiendom.getGnr() == gnr && eiendom.getBnr() == bnr){
                return new Eiendom(eiendom);
            }
        }
        return null;
    }

    /**
     * Finner gjennomsnittsarealet ved å summere arealet til alle eiendommene og deretter det på antall eiendommer som er registrert
     * @return
     */
    public double gjennomsnittAreal(){
        double sumAreal = 0;
        for (Eiendom eiendom : eiendomListe) {
            sumAreal += eiendom.getAreal();
        }
        return sumAreal / eiendomListe.size();
    }

    /**
     * Skriver ut alle de globale variablene i en gitt streng
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Eiendom eiendom : eiendomListe) {
            output.append(eiendom.toString());
        }
        return output.toString();
    }
}
