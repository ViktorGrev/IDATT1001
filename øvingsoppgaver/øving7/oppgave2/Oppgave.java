package oving7_oppgave2;

public class oppgave {
    public static void main(String[] args) {
        TekstBehandling behandle = new TekstBehandling("Hallo! Jeg, heter Viktor! Viktor! Viktor!");
        System.out.println("Antall ord: " + behandle.finnAntallOrd());
        System.out.println("Gjennomsnittlig lengde på ord: " + behandle.finnGjennomsnittLengdeOrd());
        System.out.println("Gjennomsnittlig ord i periode: " + behandle.finnAntallOrdIPeriode());
        System.out.println(behandle.endre("Viktor", "Emil"));
        System.out.println(behandle.getSetning());
        System.out.println(behandle.getSetningStor());
    }
}