package oving11_oppgave1;
import java.util.*;

public class Oppgave {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EiendomRegister eiendomRegister = new EiendomRegister();

        eiendomRegister.eiendommenRegistrer(1445 , "Gloppen", 77, 631, 1017.6, "Viktor");
        eiendomRegister.eiendommenRegistrer(1445 , "Gloppen", 77, 131, "Syningom", 661.3, "Melissa");
        eiendomRegister.eiendommenRegistrer(1445 , "Gloppen", 75, 19, "Fugletun", 650.6, "Ramtin");
        eiendomRegister.eiendommenRegistrer(1445 , "Gloppen", 74, 188, 1457.2, "Trym");
        eiendomRegister.eiendommenRegistrer(1445 , "Gloppen", 69, 47, "Høiberg", 1339.4, "Wartis");
        
        boolean lokke = true;
        while(lokke){
            System.out.println("hva ønsker du å gjøre\n1.Registrer en eiendom\n2.Liste over alle registrerte eiendommer\n3.Finn en eiendom\n4.Gjennomsnitts areal\n5.Avslutt");
            int valg = input.nextInt();
            switch(valg){
                case 1:
                    System.out.println("Kommunenummer:");
                    int kommunenummer = input.nextInt();
                    System.out.println("Kommunenavn:");
                    String kommunenavn = input.next();
                    System.out.println("Gnr:");
                    int gnr = input.nextInt();
                    System.out.println("Bnr:");
                    int bnr = input.nextInt();
                    System.out.println("Bruksnanv:");
                    String bruksnavn = input.next();
                    System.out.println("Areal:");
                    double areal = input.nextDouble();
                    System.out.println("Eier:");
                    String eier = input.next();

                    if(!bruksnavn.equals("")){
                        eiendomRegister.eiendommenRegistrer(kommunenummer, kommunenavn, gnr, bnr, bruksnavn, areal, eier);
                    }
                    else{
                        eiendomRegister.eiendommenRegistrer(kommunenummer, kommunenavn, gnr, bnr, areal, eier);
                    }
                    continue;
                case 2:
                    System.out.println(eiendomRegister.registrerteEiendommer());
                    continue;
                case 3:
                    System.out.println("Kommunenummer:");
                    int kommunenummerSøk = input.nextInt();
                    System.out.println("Gnr:");
                    int gnrSøk = input.nextInt();
                    System.out.println("Bnr:");
                    int bnrSøk = input.nextInt();
                    System.out.println(eiendomRegister.eiendomSearch(kommunenummerSøk, gnrSøk, bnrSøk).toString());
                    continue;
                case 4:
                    System.out.println(eiendomRegister.gjennomsnittAreal());
                    continue;
                case 5:
                    lokke = false;
                    break;
            }
        }
        input.close();
    }
}