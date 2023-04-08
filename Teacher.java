class Teacher extends Person {
    private List<String> subjects;
    private List<String> schools;
    private List<String> classGroups;

    public Teacher(String CNP, String name, int dateOfBirth, String phoneNumber, String email, String username, String password, List<String> subjects, List<String> schools, List<String> classGroups) {
        super(CNP, name, dateOfBirth, phoneNumber, email, username, password);
        this.subjects = subjects;
        this.schools = schools;
        this.classGroups = classGroups;
    }

    public Teacher() {
        super();
        this.subjects = null;
        this.schools = null;
        this.classGroups = null;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubject(List<String> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(String subject) {
        this.subjects.add(subject);
    }

    public void removeSubject(String subject) {
        this.subjects.remove(subject);
    }

    public List<String> getSchools() {
        return schools;
    }
    public void setSchools(List<String> schools) {
        this.schools = schools;
    }

    public void addSchool(String school) {
        this.schools.add(school);
    }

    public List<String> getClassGroups() {
        return classGroups;
    }
    public void setClassGroups(List<String> classGroups) {
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
                + "School: " + this.getSchools() + "Class group: " + this.getClassGroups();
    }
}
