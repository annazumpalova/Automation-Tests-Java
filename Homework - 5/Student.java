public class Student {
    String firstName;
    String lastName;
    int course;
    String program;
    String university;
    String email;
    long telNumber;
    Student[] friends;

    void printStudetDetails() {
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Education year: " + course);
        System.out.println("Program name: " + program);
        System.out.println("University name: " + university);
        System.out.println("E-mail: " + email);
        System.out.println("Telephone number: " + telNumber);
        for (int i = 1; i <= friends.length; i++) {
            System.out.println(i + ". Friend: " + friends[i-1].firstName);
        }
    }
}
