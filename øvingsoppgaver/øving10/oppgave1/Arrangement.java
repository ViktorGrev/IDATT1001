package oving10_oppgave1;

public class Arrangement {
    private int number;
    private String name;
    private String place;
    private String organizer;
    private String type;
    private long date;

    /**
     * Henter inn verdiene fra paramenterne, og setter de inn i klasse variablene
     * @param number
     * @param name
     * @param place
     * @param organizer
     * @param type
     * @param date
     */
    public Arrangement(int number, String name, String place, String organizer, String type, long date) {
        this.number = number;
        this.name = name;
        this.place = place;
        this.organizer = organizer;
        this.type = type;
        this.date = date;
    }

    public Arrangement(Arrangement arrangement){
        this.number = arrangement.getNumber();
    }
    /**
     * Returnerer number variablen
     * @return
     */
    public int getNumber(){
        return number;
    }
    /**
     * Returnerer name variablen
     * @return
     */
    public String getName(){
        return name;
    }
    /**
     * Returnerer place variablen
     * @return
     */
    public String getPlace(){
        return place;
    }
    /**
     * Returenerer organizer variabelen
     * @return
     */
    public String getOrgenizer(){
        return organizer;
    }
    /**
     * Returnerer type variablen
     * @return
     */
    public String getType(){
        return type;
    }
    /**
     * Returnerer date variablen
     */
    public long getDate(){
        return date;
    }

    /**
     * Returnerer en streng med alle variablene i en generel setning for alle arrangement
     */
    @Override
    public String toString() {
        return "Arrangent: " + name + " | Plass: " + place + " | Orgenizer: " + organizer + " | Type: " + type + " | Date: " + Long.toString(date).substring(0,4) + " " + Long.toString(date).substring(4,6) + " " + Long.toString(date).substring(6,8) + " " + Long.toString(date).substring(8,12);
    }
}
