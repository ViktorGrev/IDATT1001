package oving10_oppgave1;
import java.util.*;

public class ArrangementRegister {
private ArrayList<Arrangement> arrang;

    /**
     * Konstruktører oppretter en liste med arrangementer
     */
    public ArrangementRegister(){
        this.arrang = new ArrayList<Arrangement>();
    }

    /**
     * Registrerer et arrament inn i en arrayList
     * @param number
     * @param name
     * @param place
     * @param organizer
     * @param type
     * @param time
     */
    public void registrer(int number, String name, String place, String organizer, String type, long time){
        Arrangement arrangement = new Arrangement(number, name, place, organizer, type, time);
        arrang.add(arrangement);
    }

    /**
     * Lager en dypkopi av arrang arrayListen
     * @param arrang
     * @return
     */
    private ArrayList<Arrangement> arrangCopy(ArrayList<Arrangement> arrang){
        ArrayList<Arrangement> arrangCopy = new ArrayList<Arrangement>();
        for (Arrangement arrangement : arrang) {
            arrangCopy.add(new Arrangement(arrangement.getNumber(), arrangement.getName(), arrangement.getPlace(), arrangement.getOrgenizer(), arrangement.getType(), arrangement.getDate()));
        }
        return arrangCopy;
    } 

    /**
     * Finner alle arrangement for et gitt sted med hjelp av en for each loop
     * @param place
     * @return
     */
    public String checkPlace(String place){
        StringBuilder text = new StringBuilder();
        for (Arrangement arrangement : arrang) {
            if (arrangement.getPlace() == place){
                text.append(arrangement.toString());
            }
        }
        return text.toString();
    }

    /**
     * Finner alle arrament som har en gitt dato
     * @return
     */
    public ArrayList<Arrangement> checkDate(long date){
        ArrayList<Arrangement> arrangCopy = new ArrayList<Arrangement>();
        for (Arrangement arrangement : arrang) {
            if (arrangement.getDate() == date){
                arrangCopy.add(arrangement);
            }
        }
        return arrangCopy(arrangCopy);
    }

    /**
     * Finner alle arrament mellom en gitt tidsinterval ved hjelp av en for loop og if setninger for å se om de er innenfor intervalet
     * @param start
     * @param end
     * @return
     */
    public String date(int start, int end){
        ArrayList<Arrangement> arrangClone = new ArrayList<Arrangement>();
        for (Arrangement arrangement : arrang) {
            int arrangDateInt = (int) (arrangement.getDate() / 10000);
            if(arrangDateInt >= start && arrangDateInt <= end){
                arrangClone.add(new Arrangement(arrangement.getNumber(), arrangement.getName(), arrangement.getPlace(), arrangement.getOrgenizer(), arrangement.getType(), arrangement.getDate()));
            }
        }

        arrangClone.sort(Comparator.comparing(Arrangement::getDate));
        return liste(arrangClone);
    }

    /**
     * Printer ut alle en liste med arrangementer som er sortert etter sted 
     * @return
     */
    public String sortByPlace(){
        ArrayList<Arrangement> arrangCopy = arrangCopy(arrang);
        arrangCopy.sort(Comparator.comparing(Arrangement::getPlace));
        return liste(arrangCopy);
    }

    /**
     * Printer ut alle en liste med arrangementer som er sortert etter type
     * @return
     */
    public String sortByType(){
        ArrayList<Arrangement> arrangCopy = arrangCopy(arrang);
        arrangCopy.sort(Comparator.comparing(Arrangement::getType));
        return liste(arrangCopy);
    }

    /**
     * Printer ut alle en liste med arrangementer som er sortert etter dato
     * @return
     */
    public String sortByDate(){
        ArrayList<Arrangement> arrangCopy = arrangCopy(arrang);
        arrangCopy.sort(Comparator.comparing(Arrangement::getDate));
        return liste(arrangCopy);
    }

    /**
     * Returnerer over en streng med alle objektene i arrayListen
     * @param sortArrang
     * @return
     */
    public String liste(ArrayList<Arrangement> sortArrang){
        String text = "";
        for (int i = 0; i < sortArrang.size(); i++) {
            text += sortArrang.get(i).toString() + "\n";
        }
        return text;
    }

    /**
     * Finner antall arrament som er registrert
     * @return
     */
    public int arrangSize(){
        return arrang.size();
    }
}
