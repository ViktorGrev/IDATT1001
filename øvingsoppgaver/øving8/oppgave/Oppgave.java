package oving8_oppgave1;
import java.util.Scanner;

public class Oppgave {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Person person1 = new Person("Viktor", "Grevskott", 2003);
        ArbTaker arb = new ArbTaker(person1, 1232, 2019, 30000, 0.31);
        //Agrigering og komposisjon heter det når man bruker objekter i andre objekter
        int valg1 = 1;
        while (valg1 == 1){
            System.out.printf(arb.navn() + "\n");
            System.out.printf("ArbTakerNr: " + arb.getArbTakerNr() + " Ansettelsesår: " + arb.getAnsettelsesAar() + " Månedslønn: " + arb.getMaanedslon() + " Skatteprosent: " + arb.getSkatteprosent() + "\n");
            System.out.printf("1. endre\n2.fortsett \n");
            valg1 = input.nextInt();
            
            if(valg1 == 1){
                System.out.println("Hvilken del ønsker du å endre?");
                System.out.println("1.Månedslønn");
                System.out.println("2.Skatteprosent");
                System.out.println("3.Ønsker ikke å endre noe mer");
                int valg2 = input.nextInt();

                switch (valg2) {
                    case 1:
                        System.out.printf("Månedslønn: ");
                        int maanedslon = input.nextInt();
                        arb.setMaanedslon(maanedslon);
                        break;
                    case 2:
                        System.out.printf("Skatteprosent i desimal ");
                        double skatteprosent = input.nextDouble();
                        arb.setSkatteprosent(skatteprosent);
                        break;
                    case 3:
                        start(arb);
                        valg1 = 2;
                        break;
                }
            }
            else{
                start(arb);
            }
        }
        input.close();
    }

    public static void start(ArbTaker arb){
        System.out.println(arb.toString());
        if (arb.sjekkAntallAarAnsatt(2)){
            System.out.println("Hen har jobbet lengre");
        }
        else{
            System.out.println("Hen har jobbet lengre enn ");
        }
    }
}
