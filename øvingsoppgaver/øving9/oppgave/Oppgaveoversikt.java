package oving9_oppgave1;
import java.util.ArrayList;
public class Oppgaveoversikt {
    private ArrayList<Student> studenter; // tabellen opprettes i konstruktøren
    //private Student student;
    private int antNyeStud = 0; // økes med 1 for hver ny student
    private String teksten = "";

    /**
     * Oppretter en arrayList i konstruktøren
     */
    public Oppgaveoversikt(){
        this.studenter = new ArrayList<Student>();
    }

    /**
     * Returnerer antall elimenter det er i arrayListen, som representerer antall studenter
     * @return
     */
    public int antallRegistrerteStudenter(){
        return studenter.size();
    }

    /**
     * Setter parameter variablene inn i klassen student, oppretter objektet student og legger den inn i arrayListen
     * Plusser også p antall studenter som har blitt registrert
     * Construction, ikke agrigering
     * @param navn
     * @param etternavn
     * @param antOppg
     */
    public void registrer(String navn, String etternavn, int antOppg){
        Student student = new Student(navn, etternavn, antOppg);
        studenter.add(student);
        antNyeStud += 1;
    }

    /**
     * Her kommer input fra bruker og sjekker om den stemmer med noen av verdiene fra arrayListen
     * Dersom verdiene stemmer returnerer metoden antall oppgaver studenten har løst til den studenten
     * som matchet med navn og etternavn
     * @param navn
     * @param etternavn
     * @return
     */
    public int antallOppgaver(String navn, String etternavn){
        int antall = -1;
        for (int j = 0; j < studenter.size(); j++) {
            if (studenter.get(j).getNavn().equalsIgnoreCase(navn) && studenter.get(j).getEtternavn().equalsIgnoreCase(etternavn)){
                antall =  studenter.get(j).getAntOppg();
                break;
            }
        }
        return antall;
    }

    /**
     * Henter ut antall oppgaver til personen ved hjelp av metoden antallOppgaver()
     * Finner derfor antall oppgaver opprinnelig og legger til antall opgpaver som kommer gjennom parametr variablet
     * Denne blir deretter satt inn i studentens antall oppgaver ved hjelp av setOppgaver()
     * @param navn
     * @param etternavn
     * @param okning
     */
    public void okningAntallOppgaver(String navn, String etternavn, int okning){
        if (okning < 0){
            throw new IllegalAccessError("Ikke gyldig økningsverdi");
        }
        int start = antallOppgaver(navn, etternavn);
        int slutt = start + okning;
        for (int j = 0; j < studenter.size(); j++) {
            if (studenter.get(j).getNavn().equalsIgnoreCase(navn)){
                studenter.get(j).setOppgaver(slutt);
            }
        }
    }

    /**
     * Returnerer arrayListen
     * @return
     */
    public ArrayList<Student> getList(){
        return studenter;
    }

    /**
     * getMetoden returnerer antNyeStud variablen
     * @return
     */
    public int getantNyeStud(){
        return antNyeStud;
    }

    /**
     * Returnerer en String bestående av alle verdiene man får av de forskjellige metodene
     */
    @Override
   public String toString() {
        for (int i = 0; i < studenter.size(); i++) {
            teksten += studenter.get(i).getNavn() + " " + studenter.get(i).getEtternavn() + " har løst: " + studenter.get(i).getAntOppg() + "\n";
        }
        return teksten;
   }
}


//Dyp kopiering
//Deep copy