public class Person {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age > 100 || age < 0 ? 0 : age;
    }

    public boolean isTeen() {
        return this.age > 12 & this.age < 20;
    }

    public String getFullName() {
        if (this.firstName == null || this.firstName == "") {
            return this.lastName;
        } else if (this.lastName == null || this.lastName == "") {
            return this.firstName;
        } else if ((this.firstName == null || this.firstName == "") && (this.lastName == null || this.lastName == "")) {
            return "";
        }
        return this.firstName + " " + this.lastName;
    }

    private String firstName = "";
    private String lastName = "";
    private int age;
}
