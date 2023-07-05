import java.util.List;

public class Catalog {
    private String className;

    private List<Subject> subjects;
    private List<Person> accounts;

    public Catalog(String className, List<Subject> subjects, List<Person> persons) {
        this.className = className;
        this.subjects = subjects;
        this.accounts = persons;
    }

    public Catalog() {
        this.className = "";
        this.subjects = null;
        this.accounts = null;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Person> getAccounts() {
        return accounts;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setAccounts(List<Person> accounts) {
        this.accounts = accounts;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void addAccount(Person account) {
        this.accounts.add(account);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
    }

    public void removeAccount(Person account) {
        this.accounts.remove(account);
    }

    public void updateSubject(Subject subject) {
        for (Subject s : this.subjects) {
            if (s.getName().equals(subject.getName())) {
                s = subject;
            }
        }
    }

    public void updateAccount(Person account) {
        for (Person p : this.accounts) {
            if (p.getCNP().equals(account.getCNP())) {
                p = account;
            }
        }
    }
}
