package oving10_oppgave1;

public class Arrangement {
    private int number;
    private String name;
    private String place;
    private String organizer;
    private String type;
    private long date;

    public Arrangement(int number, String name, String place, String organizer, String type, long date) {
        this.number = number;
        this.name = name;
        this.place = place;
        this.organizer = organizer;
        this.type = type;
        this.date = date;
    }

    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }
    public String getPlace(){
        return place;
    }
    public String getOrgenizer(){
        return organizer;
    }
    public String getType(){
        return type;
    }
    public long getDate(){
        return date;
    }


}
