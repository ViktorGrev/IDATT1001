package oving10_oppgave1;
import java.util.*;

public class ArrangementRegister {
    /*Å registrere et nytt arrangement
• Å finne alle arrangementer på et gitt sted
• Å finne alle arrangementer på en gitt dato
• Å finne alle arrangementer innenfor et tidsintervall gitt ved to datoer. Listen skal
være sortert på tid.
• Å lage lister over alle arrangementer, sortert etter henholdsvis sted, type og
tidspunkt.*/
private ArrayList<Arrangement> arrang;
    public ArrangementRegister(){
        this.arrang = new ArrayList<Arrangement>();
    }

    public void registrer(int number, String name, String place, String organizer, String type, long time){
        Arrangement arrangement = new Arrangement(number, name, place, organizer, type, time);
        arrang.add(arrangement);
    }

    public int checkPlace(String place){
        int antallPlace = 0;
        for (int i = 0; i < arrang.size(); i++) {
            if (arrang.get(i).getPlace().equalsIgnoreCase(place)){
                antallPlace++;
            }
        }
        return antallPlace;
    }

    public int checkDate(long date){
        int antallPlace = 0;
        for (int i = 0; i < arrang.size(); i++) {
            if (arrang.get(i).getDate() == date){
                antallPlace++;
            }
        }
        return antallPlace;
    }

    public String date(long start, long end){
        arrang.sort(Comparator.comparing(Arrangement::getDate));
        String text = "";
        for (int i = 0; i < arrang.size(); i++) {
            String textDate = Long.toString(arrang.get(i).getDate());
            String[] arrayDate = textDate.split("(?<=\\G.{2})");
            if(arrang.get(i).getDate() >= start && arrang.get(i).getDate() <= end){
                text += arrang.get(i).getName() + ":\nSted: " + arrang.get(i).getPlace() + " | Organisert av: " + arrang.get(i).getOrgenizer() + " | " + arrayDate[0] + arrayDate[1] + "." + arrayDate[2] + "." + arrayDate[3] + " kl " + arrayDate[4] + arrayDate[5] + "\n";
            }
        }
        return text;
    }

    public String sortByPlace(){
        arrang.sort(Comparator.comparing(Arrangement::getPlace));
        return liste(arrang);
    }

    
    public String sortByType(){
        arrang.sort(Comparator.comparing(Arrangement::getType));
        return liste(arrang);
    }

    public String sortByDate(){
        arrang.sort(Comparator.comparing(Arrangement::getDate));
        return liste(arrang);
    }

    public String liste(ArrayList<Arrangement> sortArrang){
        String text = "";
        for (int i = 0; i < sortArrang.size(); i++) {
            String textDate = Long.toString(sortArrang.get(i).getDate());
            String[] arrayDate = textDate.split("(?<=\\G.{2})");
            text += sortArrang.get(i).getName() + ":\nSted: " + sortArrang.get(i).getPlace() + " | Organisert av: " + sortArrang.get(i).getOrgenizer() + " | Type: " + sortArrang.get(i).getType() + " | "  + arrayDate[0] + arrayDate[1] + "." + arrayDate[2] + "." + arrayDate[3] + " kl " + arrayDate[4] + arrayDate[5] + "\n";
        }
        return text;
    }

    public ArrayList<Arrangement> getArrang(){
        return arrang;
    }
}
