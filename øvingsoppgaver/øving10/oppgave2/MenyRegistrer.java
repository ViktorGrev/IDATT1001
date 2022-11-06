package oving10_oppgave2;
import java.util.*;

public class MenyRegistrer {
    private ArrayList<Rett> rettListe = new ArrayList<Rett>();
    private ArrayList<Meny> menyListe = new ArrayList<Meny>();
    private String text = "";

    /**
     * Legger til et Rett objekt inn i en arraylist ved å lage et objekt som blir lagt til
     * @param rettNavn
     * @param rettType
     * @param rettPris
     */
    public void registrerRett(String rettNavn, String rettType, int rettPris){
        Rett rett = new Rett(rettNavn, rettType, rettPris);
        this.rettListe.add(rett);
    }

    /**
     * Legger til et objekt meny ved at brukeren sender over meny navn og en liste over alle rettene til meneyen
     */
    public void registrerMeny(String menyNavn, ArrayList<Rett> menyRetter){
        Meny meny = new Meny(menyNavn, menyRetter);
        menyListe.add(meny);
    }

    /**
     * Returenerer et gitt Rett objekt ved å gå gjennom en 
     * for loop som sjekker om navnet fra brukeren matcher med noen av rettene
     * @param rettNavn
     * @return
     */
    public Rett finnRettObjekt(String rettNavn){
        for (Rett rett : rettListe){
            if (rett.getRettNavn().equalsIgnoreCase(rettNavn)){
                return new Rett(rett);
            }
        }
        return null;
    }

    /**
     * Finner en gitt rett
     * @param rettNavn
     * @return
     */
    public String finnRett(String rettNavn){
        for (Rett rett : rettListe){
            if (rett.getRettNavn().equalsIgnoreCase(rettNavn)){
                return rett.toString();
            }
        }
        return null;
    }
    
    /**
     * Returnerer alle retter som har en gitt type
     * @param rettType
     * @return
     */
    public String finnType(String rettType){
        text = "";
        for (Rett rett : rettListe){
            if (rett.getRettType().equalsIgnoreCase(rettType)){
                text += rett.toString();
            }
        }
        return text;
    }

    /**
     * Returnerer alle menyene som er innenfor en gitt prisklasse som brukeren sender inn
     * @param pris1
     * @param pris2
     * @return
     */
    public String finnMenyPris(int pris1, int pris2){
        text = "";
        for (Meny meny : menyListe){
            if (meny.getTotalPris() >= pris1 && meny.getTotalPris() <= pris2){
                text += meny.toString() + "Totalpris " +  meny.getTotalPris() + "\n\n";
            }
        }
        return text;
    }

    /**
     * Returener antall elementer det er i rettListe
     */
    public int rettListeSize(){
        return rettListe.size();
    }
}


