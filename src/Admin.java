public class Admin extends Person {
    public Admin(String CNP, String name, int dateOfBirth, String phoneNumber, String email, String username, String password) {
        super(CNP, name, dateOfBirth, phoneNumber, email, username, password);
    }

    public Admin(Person person) {
        super(person);
    }

    public Admin(Admin admin) {
        super(admin);
    }

    public Admin(String username, String password) {
        super();
        this.setUsername(username);
        this.password = password;
    }

    public Admin() {
        super();
    }

    @Override
    public String toString() {
        return null;
    }

    public void addSubject(Catalog catalog, Subject subject) {
        catalog.addSubject(subject);
    }

    public void addAccount(Catalog catalog, Person account) {
        catalog.addAccount(account);
    }

    public void removeSubject(Catalog catalog, Subject subject) {
        catalog.removeSubject(subject);
    }

    public void removeAccount(Catalog catalog, Person account) {
        catalog.removeAccount(account);
    }

    public void updateSubject(Catalog catalog, Subject subject) {
        catalog.updateSubject(subject);
    }

    public void updateAccount(Catalog catalog, Person account) {
        catalog.updateAccount(account);
    }

}
