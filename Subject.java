public class Subject {
    private String name;
    private List<Teacher> teachers;
    private List<String> students;

    public Subject(String name, String teacher, List<String> students) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }

    public Subject() {
        this.name = "";
        this.teacher = "";
        this.students = null
    }
}