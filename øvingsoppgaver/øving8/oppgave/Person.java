package oving8_oppgave1;

/**
 * Klassen Person skal barne holde oversikt over informasjon over personen
 * Klassen kan sende ut verdiene som blir sendt gjennom i konstruktøren
 */
public class Person {
    private String fornavn;
    private String etternavn;
    private int fodselsaar;

    /**
     * Henter inn verdiene fra paramenterne, og setter de inn i klasse variablene
     * @param fornavn
     * @param etternavn
     * @param fodselsaar
     */
    public Person(String fornavn, String etternavn, int fodselsaar){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsaar = fodselsaar;
    }

    /**
     * Returnerer fornanvet til personen
     * @return
     */
    public String getFornavn(){
        return fornavn;
    }
    /**
     * Returnerer etternavnet til personen
     * @return
     */
    public String getEtternavn(){
        return etternavn;
    }
    /**
     * Returnerer fodelsåret til personen
     * @return
     */
    public int getFodselsaar(){
        return fodselsaar;
    }
}
