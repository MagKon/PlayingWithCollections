package Main;

public class Student {
    private final String name;
    private final int id;
    public Student(String name, int i) {
        this.name = name;
        this.id = i;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", id=" + id + "]";
    }
}
