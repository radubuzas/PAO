import java.util.Set;

public class Subject {
    private String name;
    private Set<Teacher> teachers;
    private Set<String> students;

    public Subject(String name, Set<Teacher> teachers, Set<String> students) {
        this.name = name;
        this.teachers = teachers;
        this.students = students;
    }

    public Subject() {
        this.name = "";
        this.teachers = null;
        this.students = null;
    }
}