package oving10_oppgave1;
import java.util.Scanner;
public class Oppgave {
    public static void main(String[] args) {
        ArrangementRegister arrangementRegister = new ArrangementRegister();
        arrangementRegister.registrer(0, "Karneval", "Moholt", "Redbull", "Barneteater",  200311301800L);
        arrangementRegister.registrer(1, "Dancing", "Buran", "Redbull", "Konsert", 200311301800L);
        arrangementRegister.registrer(2, "Progging", "Lerkendal", "Trondheim kommune", "Foredrag", 200310301800L);
        arrangementRegister.registrer(3, "Dancing", "Marienborg", "Trondheim kommune", "Hellig", 200308301800L);
        arrangementRegister.registrer(4, "UKA", "Moholt", "Kiwi", "Konsert", 200309301800L);
        arrangementRegister.registrer(5, "Movie night", "Lerkendal", "Kiwi", "Barneteater", 200309301700L);
        arrangementRegister.registrer(6, "Sushidate", "Lerkendal", "Kreftforeningen", "Foredrag", 200210301800L);
        arrangementRegister.registrer(7, "Taylor Swift", "Studentersamfunnet", "NTNU", "Konsert", 200210301800L);
        arrangementRegister.registrer(8, "Ballin", "Studentersamfunnet", "NTNU", "Konsert", 200210301800L);
        arrangementRegister.registrer(9, "Karate med Mohammed", "Buran", "Oslo kommune", "Barneteater", 200210301800L);
        arrangementRegister.registrer(10, "Andrew Tate konsert", "Moholt", "Oslo kommune", "Konsert", 200210301800L);


        while (true){
            Scanner input = new Scanner(System.in);
            System.out.println("Hva ønsker du å gjøre: \n1.Registrere arrangement\n2.Finne arrangement ved et bestemt tids interval\n3.Sorte etter tid\n4.Sortere etter plass\n5.Sortere etter type\n6.Finn arrangent gitt dato\n7.Finn arrangement gitt plass\n8.Avslutt");
            int valg = input.nextInt();
            switch (valg) {
                case 1:
                    System.out.printf("Arrangement navn:  \n");
                    String name = input.next();
                    System.out.printf("Sted: \n");
                    String place = input.next();
                    System.out.printf("Organisator: \n");
                    String organizer = input.next();
                    System.out.printf("Type: \n");
                    String type = input.next();
                    System.out.printf("Tid: \n");
                    long date = input.nextLong();
                    arrangementRegister.registrer(arrangementRegister.arrangSize(), name, place, organizer, type, date);
                    System.out.println("Arrangamentet " + name + " har blitt lagt til");
                    continue; 
                case 2:
                    System.out.printf("Start tid \n");
                    int start = input.nextInt();
                    System.out.printf("Slutt tid \n");
                    int end = input.nextInt();
                    System.out.println(arrangementRegister.date(start, end));
                    continue;
                case 3:
                    System.out.println(arrangementRegister.sortByDate());
                    continue;
                case 4:
                    System.out.println(arrangementRegister.sortByPlace());
                    continue;
                case 5:
                    System.out.println(arrangementRegister.sortByType());
                    continue;
                case 6:
                    System.out.printf("Dato: \n");
                    int dato = input.nextInt();
                    System.out.println(arrangementRegister.checkDate(dato));
                case 7:
                    System.out.printf("Dato: \n");
                    String plass = input.next();
                    System.out.println(arrangementRegister.checkPlace(plass));
            }
            input.close();
        }
    }
}
