/*Oppgave 1
Et år er skuddår dersom det er delelig med 4. Unntaket er hundreårene, de må være delelig
med 400.
Tegn aktivitetsdiagram som viser algoritmen for å finne ut om et år er skuddår. Årstallet skal
leses inn fra brukeren. Sett opp testdata. Lag og prøv ut programmet */
import java.util.Scanner;
public class oving2_oppgave1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("årstall: ");

        // String input
        int aarstall = input.nextInt();

        if (aarstall % 400 == 0){
            System.out.println(aarstall + " er et skudd år"); 
        }
        else if (aarstall % 100 == 0){
            System.out.println(aarstall + " er IKKE skudd år"); 
        }
        else if (aarstall%4 == 0){
            System.out.println(aarstall + " er et skudd år"); 
        }
        else{
            System.out.println(aarstall + " er IKKE skudd år"); 
        }
        input.close();
    }
}

