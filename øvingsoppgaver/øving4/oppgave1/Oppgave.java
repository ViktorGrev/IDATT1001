package oving4_oppgave1;
import java.util.Scanner;
public class Kasse {
    public static void main(String[] args) {
        Valuta svensk = new Valuta(1.02);
        Valuta dollar = new Valuta(9.5);
        Valuta euro = new Valuta(10);
        

        Scanner input = new Scanner(System.in);
        String[] meny = {"EURO", "SVENSKE KRONER", "DOLLAR", "AVSLUTT"};
        for(int i = 1; i <= meny.length; i++){
            System.out.println(i + ". " + meny[i-1]);
        }
        System.out.printf("Hvilken valuta, skriv index her---> ");
        int index = input.nextInt();
        if (index > 0 && index < 4){
            System.out.printf("\n 1. Valgt valuta til norske \n 2. norske til valgt valuta \n  Hvilket valg velger du? ---> ");
            int valg = input.nextInt();

            System.out.printf("Hvor mye vil du konvertere?---> ");
            double antall = input.nextDouble();

            double nok;
            double utlandske;
            if(valg == 1){
                if (index == 1){
                    nok = euro.kalkulerNok(antall);
                    System.out.println("Du har nå:" + nok);
                }
                else if (index == 2){
                    nok = svensk.kalkulerNok(antall);
                    System.out.format("Du har nå: %.2f", nok);
                }
                else if (index == 3){
                    nok = dollar.kalkulerNok(antall);
                    System.out.println("Du har nå: " + nok);
                }
            }
            else if (valg == 2){
                if (index == 1){
                    utlandske = euro.kalkulerUtland(antall);
                    System.out.println("Du har nå: " +  utlandske);
                }
                else if (index == 2){
                    utlandske = svensk.kalkulerUtland(antall);
                    System.out.format("Du har nå: %.2f", utlandske);
                }
                else if (index == 3){
                    utlandske = dollar.kalkulerUtland(antall);
                    System.out.println(antall + " Du har nå: " + utlandske);
                }
            }
            else{
                System.out.println("Velg en av alternativene");
            }
        }
        else{
            System.out.println("Du har valgt å skru av programmet");
        }

        input.close();

    }
}
