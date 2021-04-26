public class StudentTest {
    public static void main(String[] args) {
        Student person1 = new Student();
        Student person2 = new Student();
        Student person3 = new Student();

        person1.firstName = "Ivan";
        person1.lastName = "Georgiev";
        person1.course = 3;
        person1.program = "Architecture";
        person1.university = "UACG";
        person1.email = "igeorgiev@gmail.com";
        person1.telNumber = 252525656;
        person1.friends = new Student[]{person2,person3};


        person2.firstName = "Kalina";
        person2.lastName = "Ivanova";
        person2.course = 4;
        person2.program = "Economy";
        person2.university = "UNSS";
        person2.email = "kivanova99@gmail.com";
        person2.telNumber = 84252587;
        person2.friends = new Student[]{person1, person3};

        person3.firstName = "Maria";
        person3.lastName = "Petrova";
        person3.course = 1;
        person3.program = "Computer science";
        person3.university = "TU";
        person3.email = "mariapertrova8@gmail.com";
        person3.telNumber = 9995747;
        person3.friends = new Student[]{person2, person1};

        person1.printStudetDetails();
        System.out.print("\n");
        person2.printStudetDetails();
        System.out.print("\n");
        person3.printStudetDetails();
    }
}
