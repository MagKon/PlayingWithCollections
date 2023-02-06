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
        LinkedList<Student> list = new LinkedList<Student>();
        fillMyCollection(list);
        // Print listen ud og læg mærke til rækkefølgen af objekterne
        for (Student student : list) {
            System.out.println(student);
        }
        makeWhiteSpace();

        // Tilføj et nyt Student-objekt objekt med metoden add().
        // Hvor i listen tror du, det bliver tilføjet? Test din teori ved at printe listen igen
        list.add(new Student("Magnus", 6)); // Tilføjer til slutningen af listen
        for (Student student : list) {
            System.out.println(student);
        }
        makeWhiteSpace();

        // Hvad sker der hvis vi tilføjer et nyt Student-objekt på index 3?
        // Prøv det af. Tænk over hvad du tror, der vil ske og print så ud for at se om du har ret
        list.add(3, new Student("Kasper", 7)); // Tilføjer på index 3 dvs 4. plads da index starter på 0
        for (Student student : list) {
            System.out.println(student);
        }
        makeWhiteSpace();

        // Hvad sker der hvis vi tilføjer to ens Student-objekter?
        list.add(new Student("Magnus", 6)); // Tilføjer til slutningen af listen og kan tilføjes flere gange. List kræver ikke at objekterne er unikke
        for (Student student : list) {
            System.out.println(student);
        }
        makeWhiteSpace();
    }

    public static void playWithSet(){
        // Lav et HashSet med Student-objekter. Fyld det op ved at kalde fillMyCollection
        HashSet<Student> set = new HashSet<Student>();
        fillMyCollection(set);

        // Print listen ud og læg mærke til rækkefølgen af objekterne
        for (Student student : set) {
            System.out.println(student);
            System.out.println(student.hashCode()); // Placeringen af et objekt i et HashSet er baseret på objektets hashcode. Hvis du kører programmet flere gange vil du se at objekterne bliver placeret samme sted hvis de deler hashcode
        }
        makeWhiteSpace();

        // Tilføj et nyt Student-objekt objekt med metoden add().
        // Hvor i settet tror du, det bliver tilføjet? Test din teori ved at printe settet igen
        set.add(new Student("Magnus", 6)); // Det nye objekt bliver tilføjet et "tilfældigt" sted i settet. Sets er baseret på hashcodes og derfor er der ingen garanti for hvor objekterne bliver placeret
        for (Student student : set) {
            System.out.println(student);
            System.out.println(student.hashCode());
        }
        makeWhiteSpace();
        // Hvad sker der hvis vi tilføjer to ens Student-objekter?
        Student s = new Student("Magnus", 6);
        set.add(s); // Tilføjer et nyt objekt da vi bruger new Student. Det betyder at det for et nyt hashcode og derfor bliver placeret i settet.
        for (Student student : set) {  // Set kræver at objekterne er unikke men hvis du laver et nyt objekt med samme enskaber vil det alligevel blive tilføjet til settet
            System.out.println(student);
            System.out.println(student.hashCode());
        }
        makeWhiteSpace();

        set.add(s); // Her tilføjes ikke et nyt objekt da der genbruges det samme som allerede er i settet.
        for (Student student : set) {
            System.out.println(student);
            System.out.println(student.hashCode());
        }
        makeWhiteSpace();

        // Hvis man manipulerer .equals() metoden i Student metoden kan der ændres til at i stedet for at kigge på hashcode så kigges der på id eller name eller en anden attribut.
    }


    public static void playWithMaps(){
        // Lav et HashMap() med Student-objekter og Courses, hvor Student er key og Course er value
        // Fyld det op ved at kalde fillMyMap()
        HashMap<Student, Course> map = new HashMap<Student, Course>();
        fillMyMap(map);

        // Print mappet ud og læg mærke til rækkefølgen af objekterne
        for (Student student : map.keySet()) {
            System.out.println(student + " " + map.get(student));
        }
        makeWhiteSpace();

        // Tilføj et nyt Student-objekt/Course-objekt par med metoden put().
        // Hvor i mappet tror du, det bliver tilføjet? Test din teori ved at printe settet igen
        Student s = new Student("Magnus", 6);
        map.put(s, new Course("DAT1")); // Mappet er baseret på hashcodes og derfor er der ingen garanti for hvor objekterne bliver placeret i mappet.
        for (Student student : map.keySet()) {
            System.out.println(student + " " + map.get(student));
        }
        makeWhiteSpace();

        // Hvad sker der hvis vi tilføjer to Student/Course par hvor Student-objekterne er ens?
        map.put(s, new Course("DAT2")); // Tilføjer ikke et nyt objekt da denne Key allerede eksisterer. I stedet bliver Course-objektet erstattet med det nye Course-objekt
        for (Student student : map.keySet()) {
            System.out.println(student + " " + map.get(student));
        }
        makeWhiteSpace();
        // Og hvad sker der hvis vi tilføjer to Student/Course par hvor Course-objekterne er ens?
        Course c = new Course("DAT1");
        map.put(new Student("Magnus2", 7), c);
        map.put(new Student("Magnus3", 8), c);
        for (Student student : map.keySet()) { // Tilføjer to nye objekter da Maps bruger .equals() på dets Key. Value bliver ikke brugt til at bestemme om et objekt er unikt.
            System.out.println(student + " " + map.get(student));
        }
        makeWhiteSpace();
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

    public static void makeWhiteSpace() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
}