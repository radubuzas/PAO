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

    public String getName() {
        return name;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public Set<String> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setStudents(Set<String> students) {
        this.students = students;
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }
}