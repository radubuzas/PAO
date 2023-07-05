// i want to import all classes that ive done in the project
import java.util.Set;

class Teacher extends Person {
    private Set<Subject> subjects;
    private Set<String> classGroups;

    public Teacher(String CNP, String name, int dateOfBirth, String phoneNumber, String email, String username, String password, Set<Subject> subjects, Set<String> classGroups) {
        super(CNP, name, dateOfBirth, phoneNumber, email, username, password);
        this.subjects = subjects;
        this.classGroups = classGroups;
    }

    public Teacher() {
        super();
        this.subjects = null;
        this.classGroups = null;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubject(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
    }

    public Set<String> getClassGroups() {
        return classGroups;
    }
    public void setClassGroups(Set<String> classGroups) {
        this.classGroups = classGroups;
    }

    public void addClassGroup(String classGroup) {
        this.classGroups.add(classGroup);
    }

    public void removeClassGroup(String classGroup) {
        this.classGroups.remove(classGroup);
    }

    @Override
    public String toString() {
        return "CNP: " + this.getCNP() + "Name: " + this.getName() + "Date of birth: " + this.getDateOfBirth()
                + "Phone number: " + this.getPhoneNumber() + "Email: " + this.getEmail()
                + "Username: " + this.getUsername() + "Password: " + this.getPassword() + "Subject: " + this.getSubjects()
                + "Class group: " + this.getClassGroups();
    }
}
