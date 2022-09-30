/*Oppgave 1
Lag en klasse for å regne med brøk.
Klassen skal ha to konstruktører:
• Den ene konstruktøren tar teller og nevner som argument. Hvis nevneren er 0, skal et
unntaksobjekt av typen IllegalArgumentException kastes.
• Den andre konstruktøren tar kun telleren som argument. Da skal nevneren settes lik 1.
Klassen skal ha get-metoder, men ikke set-metoder.
Klassen skal ha metoder for å summere, subtrahere, multiplisere og dividere en brøk (this)
med en annen brøk (parameter til metoden). Metodene har ikke returverdi, men etter at
operasjonen er utført, ligger resultatet i this.
Du kan se bort fra at resultatet av operasjonen bør forkortes.
Lag testklient som del av klassen.
Ekstraoppgave: Sørg for å forkorte brøkene. */
package oving5_oppgave1;
public class Oppgave {
    public static void main(String[] args) {
        Konvertering kon = new Konvertering(5, 0);

        //kon.addisjon(4,5);
        //kon.subtraksjon(4,5);
        //kon.multiplikasjon(4,5);
        kon.dividere(4,5);
        System.out.println(kon.getTeller() + " / " + kon.getNevner());
    }
}
