package Hotel;

import java.io.Serializable;

public class Worker implements Serializable {
    //private static final long serialVersionUID = 2041275512219239990L;
    int id;
    String firstName;
    String lastName;
    int age;
    int salary;
    String role;
    String phone;

    public Worker(){
        id = 0;
        firstName = "";
        lastName = "";
        age = 0;
        salary = 0;
        role = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
