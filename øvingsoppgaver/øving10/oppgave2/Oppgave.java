package oving10_oppgave2;
import java.util.*;

public class Oppgave {
    public static void main(String[] args) {
        MenyRegistrer menyRegistrer = new MenyRegistrer();

        //Retter
        menyRegistrer.registrerRett("Hamburger", "Hovedrett", 215);
        menyRegistrer.registrerRett("Torskesuppe", "Hovedrett", 200);
        menyRegistrer.registrerRett("Baligryte", "Hovedrett", 160);
        menyRegistrer.registrerRett("Sushi", "Hovedrett", 250);
        menyRegistrer.registrerRett("Pølse", "Hovedrett", 70);
        menyRegistrer.registrerRett("Våruller", "Forrett", 75);
        menyRegistrer.registrerRett("Brød", "Forrett", 30);
        menyRegistrer.registrerRett("Spekemat", "Forrett", 140);
        menyRegistrer.registrerRett("Soppsuppe", "Forrett", 85);
        menyRegistrer.registrerRett("Kake", "Dessert", 140);
        menyRegistrer.registrerRett("Iskrem", "Dessert", 40);
        menyRegistrer.registrerRett("Godis", "Dessert", 15);
        menyRegistrer.registrerRett("Bolle", "Dessert", 15);

        //1. Meny for å teste klassen
        ArrayList<Rett> meny1 = new ArrayList<Rett>();
        meny1.add(menyRegistrer.finnRettObjekt("Hamburger"));
        meny1.add(menyRegistrer.finnRettObjekt("Godis"));
        meny1.add(menyRegistrer.finnRettObjekt("Brød"));
        meny1.add(menyRegistrer.finnRettObjekt("Sushi"));
        menyRegistrer.registrerMeny("Limeted time", meny1);

        //2. Meny for å teste klassen
        ArrayList<Rett> meny2 = new ArrayList<Rett>();
        meny2.add(menyRegistrer.finnRettObjekt("Godis"));
        meny2.add(menyRegistrer.finnRettObjekt("Kake"));
        meny2.add(menyRegistrer.finnRettObjekt("Soppsuppe"));
        meny2.add(menyRegistrer.finnRettObjekt("Spekemat"));
        meny2.add(menyRegistrer.finnRettObjekt("Iskrem"));
        menyRegistrer.registrerMeny("Husetsspesial", meny2);

        Scanner input = new Scanner(System.in);

        boolean lokke = true;
        while(lokke){
            System.out.println("hva ønsker du å gjøre\n1.Registrer en rett\n2.Registrer en meny\n3.Finn en rett med navn\n4.Finn alle retter av samme type\n5.Finn meny gitt pris\n6.Avslutt");
            int valg = input.nextInt();
            switch(valg){
                case 1:
                    System.out.println("Navnet på retten du vil leggetil: ");
                    String rettNavn = input.nextLine();
                    System.out.println("Type: ");
                    String rettType = input.nextLine();
                    System.out.println("Pris: ");
                    int rettPris = input.nextInt();
                    menyRegistrer.registrerRett(rettNavn, rettType, rettPris);
                    continue;
                case 2:
                    ArrayList<Rett> sendRetter = new ArrayList<Rett>();
                    boolean case2 = true;
                    System.out.println("Navnet på menyen: "); 
                    String inputMenyNavn = input.nextLine();
                    while(case2){
                        sendRetter.clear();
                        System.out.println("1.Legg til retter i menyen:\n2.Lag menyen");
                        int valg2 = input.nextInt();
                        if(valg2 == 1){
                            System.out.println("Navnet på retten du vil leggetil: ");
                            String inputRett = input.next();
                            sendRetter.add(menyRegistrer.finnRettObjekt(inputRett));
                        }
                        else{
                            case2 = false;
                            menyRegistrer.registrerMeny(inputMenyNavn, sendRetter);
                        }
                    }
                    continue;
                case 3:
                    System.out.println("Søk på en rett: ");
                    String rettNavn3 = input.next();
                    System.out.println(menyRegistrer.finnRett(rettNavn3));
                    continue;
                case 4:
                    System.out.println("Søk etter alle typer retter: ");
                    String rettType4 = input.next();
                    System.out.println(menyRegistrer.finnType(rettType4));
                    continue;
                case 5:
                    System.out.println("Pris intervall 1");
                    int pris1 = input.nextInt();
                    System.out.println("Pris intervall 2");
                    int pris2 = input.nextInt();
                    System.out.println(menyRegistrer.finnMenyPris(pris1, pris2));
                    continue;
                case 6:
                    lokke = false;
                    break;
            }
        }
        input.close();
    }
}
