package oving7_oppgave1;
public class Oppgave {
    public static void main(String[] args) {
        NyString ny = new NyString("jeg elsker java med Mohammad");
        System.out.println(ny.forkort());
        System.out.println(ny.fjern("e"));
    }
}
