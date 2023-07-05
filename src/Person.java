public abstract class Person {
    private String CNP;
    protected String name;
    protected int dateOfBirth;      //  Unix time
    protected String phoneNumber;
    protected String email;
    private static int numberOfPersons = 0;
    protected String username;
    protected String password;

    public Person(String CNP, String name, int dateOfBirth, String phoneNumber, String email, String username, String password) {
        this.CNP = CNP;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        numberOfPersons++;
    }

    public Person() {
        this.CNP = "";
        this.name = "";
        this.dateOfBirth = 0;
        this.phoneNumber = "";
        this.email = "";
        this.username = "";
        this.password = "";
        numberOfPersons++;
    }

    public Person(Person person) {
        this.CNP = person.CNP;
        this.name = person.name;
        this.dateOfBirth = person.dateOfBirth;
        this.phoneNumber = person.phoneNumber;
        this.email = person.email;
        this.username = person.username;
        this.password = person.password;
        numberOfPersons++;
    }

    public String getCNP() {
        return CNP;
    }
    protected void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name = name;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }
    protected void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    protected void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    protected void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    protected void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public static int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return CNP.equals(person.CNP);
    }

    @Override
    public abstract String toString();
}