package oving9_oppgave1;
import java.util.*;

public class Oppgave {
    public static void main(String[] args) {

        Oppgaveoversikt oppgaveoversikt = new Oppgaveoversikt();
        oppgaveoversikt.registrer("Viktor", "Grevskott", 5 );
        oppgaveoversikt.registrer("Ramtin", "Samavat", 6);
        oppgaveoversikt.registrer("Jeffrey", "Tabiri", 2);
        oppgaveoversikt.registrer("Melisa", "Visnjic", 4);
        oppgaveoversikt.registrer("Vegard", "Udnes", 1);

        Scanner input = new Scanner(System.in);
        boolean value = true;
        while (value == true){
            int antOppgaver;
            System.out.printf("1.Registrer ny student\n2.Finn antall oppgaver til en person\n3.Øk antall oppgaver til en bestemt person\n4.Utfør\n");
            int valg2 = input.nextInt();
            String fornavn;
            String etternavn;

            switch (valg2) {
                case 1:
                    System.out.printf("Fornavn \n");
                    fornavn = input.next();
                    System.out.printf("Etternavn \n");
                    etternavn = input.next();
                    System.out.printf("Antall oppgaver\n");
                    antOppgaver = input.nextInt();
                    oppgaveoversikt.registrer(fornavn, etternavn, antOppgaver);
                    continue; 
                case 2:
                    System.out.printf("Fornavn \n");
                    fornavn = input.next();
                    System.out.printf("Etternavn \n");
                    etternavn = input.next();
                    if(oppgaveoversikt.antallOppgaver(fornavn, etternavn) != -1){
                        System.out.println(fornavn + " " + etternavn + " har løst: " + oppgaveoversikt.antallOppgaver(fornavn, etternavn));
                    }
                    else{
                        System.out.println("Personen finnes ikke");
                    }
                    continue;
                case 3:
                    System.out.printf("Fornavn \n");
                    fornavn = input.next();
                    System.out.printf("Etternavn \n");
                    etternavn = input.next();
                    System.out.printf("Hvor mange fler ønsker du å legge til? \n");
                    antOppgaver = input.nextInt();
                    if(oppgaveoversikt.antallOppgaver(fornavn, etternavn) != -1){
                        oppgaveoversikt.okningAntallOppgaver(fornavn, etternavn, antOppgaver);
                        System.out.println(fornavn + " " + etternavn + " har løst: " + oppgaveoversikt.antallOppgaver(fornavn, etternavn));
                    }
                    else{
                        System.out.println("Du kan ikke øke antall oppgaver til en personen som ikke finnes");
                    }
                    continue;
                case 4:
                    value = false;
                    break;
            }
        }
        input.close();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Antall studenter: " + oppgaveoversikt.antallRegistrerteStudenter());
        System.out.println("-----------------------------------------------------------------------\n");
        System.out.println(oppgaveoversikt.toString());
        System.out.println("-----------------------------------------------------------------------");
    }
}
