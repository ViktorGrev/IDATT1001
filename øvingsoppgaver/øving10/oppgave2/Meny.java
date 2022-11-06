package oving10_oppgave2;

import java.util.ArrayList;

public class Meny {
    private String menyNavn;
    private ArrayList<Rett> menyRetter;

    /**
     * Henter inn verdiene fra paramenterne, og setter de inn i klasse variablene
     * @param menyNavn
     * @param menyRetter
     */
    public Meny(String menyNavn, ArrayList<Rett> menyRetter){
        this.menyNavn = menyNavn;
        this.menyRetter = menyRetter;
    }

    /**
     * Returnerer navnet på menyen
     * @return
     */
    public String getMenyNavn(){
        return menyNavn;
    }

    /**
     * Returnerer en dyp kopi av alle rettene i menyen
     * @return
     */
    public ArrayList<Rett> getMenyRetter(){
        ArrayList<Rett> getMenyRetterCopy = new ArrayList<Rett>();
        for (Rett rett : menyRetter) {
            getMenyRetterCopy.add(new Rett(rett.getRettNavn(), rett.getRettType(), rett.getRettPris()));
        }
        return getMenyRetterCopy;
    }

    /**
     * Totalprisen på menyen returneres ved å addere prisene til rettene i arraylisten
     * @return
     */
    public int getTotalPris(){
        int pris = 0;
        for(Rett rett : menyRetter){
            pris += rett.getRettPris();
        }
        return pris;
    }
    
    /**
     * Returenerer en string med menynavn og alle rettene som tilhører menyen
     */
    @Override
    public String toString() {
        String retter = "";
        for (Rett rett : menyRetter){
            retter += "-->" + rett.toString();
        }
        
        return "menyNavn: " + menyNavn + "\n" + retter;
    }
}
