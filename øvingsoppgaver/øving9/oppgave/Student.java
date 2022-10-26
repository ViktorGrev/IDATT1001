package oving9_oppgave1;

public class Student {
    private String navn;
    private String etternavn;
    private int antOppg;

    /**
     * Henter inn verdiene fra paramenterne, og setter de inn i klasse variablene
     * @param navn
     * @param etternavn
     * @param antOppg
     */
    public Student(String navn, String etternavn, int antOppg){
        this.navn = navn;
        this.etternavn = etternavn;
        this.antOppg = antOppg;
    }

    /**
     * getMetoden returnerer navn variablen
     * @return
     */
    public String getNavn(){
        return navn;
    }

    /**
     * getMetoden returnerer antOppg variablen
     * @return
     */
    public String getEtternavn(){
        return etternavn;
    }

    /**
     * getMetoden returnerer antOppg variablen
     * @return
     */
    public int getAntOppg(){
        return antOppg;
    }

    /**
     * Setter valgt antOppg (parameter) inn i klassens antOppg variabel
     * @param antOppg
     */
    public void setOppgaver(int antOppg){
        this.antOppg = antOppg;
    }

    /**
     * Adderer valgt antOppg (parameter) med eksisterende antOppga variabel inn i klassens antOppg variabel
     * @param antOppg
     */
    public void økAntOppg(int økning){
        antOppg += økning;
    }
}
