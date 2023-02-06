package Main;

import java.util.*;

public class PlayingWithCollections {

    public static void main(String[] args) {
        playWithLists();
        playWithSet();
        playWithMaps();
    }

    public static void playWithLists(){
        // Lav en LinkedList med Student-objekter. Fyld den op med objekter ved at kalde fillMyCollection

        // Print listen ud og læg mærke til rækkefølgen af objekterne

        // Tilføj et nyt Student-objekt objekt med metoden add().
        // Hvor i listen tror du, det bliver tilføjet? Test din teori ved at printe listen igen

        // Hvad sker der hvis vi tilføjer et nyt Student-objekt på index 3?
        // Prøv det af. Tænk over hvad du tror, der vil ske og print så ud for at se om du har ret

        // Hvad sker der hvis vi tilføjer to ens Student-objekter?

    }

    public static void playWithSet(){
        // Lav et HashSet med Student-objekter. Fyld det op ved at kalde fillMyCollection

        // Print listen ud og læg mærke til rækkefølgen af objekterne

        // Tilføj et nyt Student-objekt objekt med metoden add().
        // Hvor i settet tror du, det bliver tilføjet? Test din teori ved at printe settet igen

        // Hvad sker der hvis vi tilføjer to ens Student-objekter?

    }


    public static void playWithMaps(){
        // Lav et HashMap() med Student-objekter og Courses, hvor Student er key og Course er value
        // Fyld det op ved at kalde fillMyMap()

        // Print mappet ud og læg mærke til rækkefølgen af objekterne

        // Tilføj et nyt Student-objekt/Course-objekt par med metoden put().
        // Hvor i mappet tror du, det bliver tilføjet? Test din teori ved at printe settet igen

        // Hvad sker der hvis vi tilføjer to Student/Course par hvor Student-objekterne er ens?

        // Og hvad sker der hvis vi tilføjer to Student/Course par hvor Course-objekterne er ens?
    }

    public static void fillMyCollection(Collection<Student> c){
        String[] names = {"Sally", "Marley", "Jean-Luc", "Sigfried", "Kurt"};
        for(int i = 0; i < names.length; i++){
            c.add(new Student(names[i], i+1));
        }
    }


    public static void fillMyMap(Map<Student, Course> c){
        String[] names = {"Sally", "Marley", "Jean-Luc", "Sigfried", "Kurt"};

        for(int i = 0; i < names.length; i++){
            if(i % 2 == 0)
                c.put(new Student(names[i], i+1), new Course("DAT1"));
            else
                c.put(new Student(names[i], i+1), new Course("DAT2"));
        }
    }
}