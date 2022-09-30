/*Oppgave 2
Skriv et program som regner om timer, minutter og sekunder til totalt antall sekunder. Sett
opp testdatasett og prøv ut programmet. */
public class oving1_oppgave2{
    public static void main(String[] args) {
      int timer =  2;
      int minutter = 25;
      int sekunder = 46;
      int totalSekunder = timer * 3600 + minutter * 60 + sekunder;
      System.out.println("Total sekunder er: " + totalSekunder); 
    }
  }