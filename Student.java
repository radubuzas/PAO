class Student extends Person {
    private int grade;
    private String school;
    private String classGroup;

    public Student(String CNP, String name, int dateOfBirth, String phoneNumber, String email, String username, String password, int grade, String school, String classGroup) {
        super(CNP, name, dateOfBirth, phoneNumber, email, username, password);
        this.grade = grade;
        this.school = school;
        this.classGroup = classGroup;
    }

    public Student() {
        super();
        this.grade = 0;
        this.school = "";
        this.classGroup = "";
    }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }

    public String getClassGroup() {
        return classGroup;
    }

    @Override
    public String toString() {
        return "CNP: " + this.getCNP() + "\nName: " + this.getName() + "\nDate of birth: " + this.getDateOfBirth()
                + "\nPhone number: " + this.getPhoneNumber() + "\nEmail: " + this.getEmail()
                + "\nUsername: " + this.getUsername() + "\nPassword: " + this.getPassword() + "\nGrade: " + this.getGrade()
                + "\nSchool: " + this.getSchool() + "\nClass group: " + this.getClassGroup();
    }
}