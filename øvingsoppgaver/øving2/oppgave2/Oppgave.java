/*Oppgave 2
Lag et program som hjelper oss i forhold til følgende problemstilling: Kjøttdeig av merke A
koster kr 35,90 for 450 gram, mens kjøttdeig av merke B koster kr 39,50 for 500 gram.
Hvilket merke er billigst? */
import java.util.Scanner;
public class oving2_oppgave2 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Skriv pris på A: ");
        double prisA = input.nextDouble();
        System.out.printf("Skriv vekt på A: ");
        double vektA = input.nextDouble();
        System.out.printf("Skriv pris på B: ");
        double prisB = input.nextDouble();
        System.out.printf("Skriv vekt på B: ");
        double vektB = input.nextDouble();

        //Finner pris per gram
        double prisPerGramA = prisA / vektA;
        double prisPerGramB = prisB / vektB; 

        //Finner den billigste med Math.min
        double billigst = Math.min(prisPerGramA, prisPerGramB);

        if (prisPerGramA == billigst){
            System.out.println("produkt A er billigst"); 
        }
        else{
            System.out.println("produkt B er billigst");
        } 
        input.close();
    }
}
