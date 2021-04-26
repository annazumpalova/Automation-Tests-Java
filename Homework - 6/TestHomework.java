import com.sun.security.ntlm.Client;

import java.sql.ClientInfoStatus;

public class TestHomework {
    public static void main(String[] args) {
        Library libraryOne = new Library("Burgas");

        Book b1 = new Book("B11", "A11", "P11", 1995, 5656585);
        Book b2 = new Book("B22", "A22", "P22", 1996, 5689884);
        Book b3 = new Book("B33", "A33", "P33", 1997, 5656777);
        Book b4 = new Book("B44", "A44", "P44", 1998, 5656888);
        Book b5 = new Book("B55", "A55", "P55", 1999, 5656444);
        Book b6 = new Book("B66", "A66", "P66", 1995, 565999);
        Book b7 = new Book("B77", "B77", "P77", 2000, 5656555);
        Book b8 = new Book("B88", "A88", "P88", 2001, 5656222);
        Book b9 = new Book("B99", "A99", "P99", 2002, 5656333);
        Book b10 = new Book("B10", "A10", "P10", 2003, 5656111);


        Customer c1 = new Customer("Anna", 23, 12345678);
        c1.money = 25;
        Customer c2 = new Customer("Ivan", 30, 223345557);
        c2.money = 20;
        Customer c3 = new Customer("Maria", 25, 55667722);
        c1.money = 30;

        libraryOne.addBook(b2);
        libraryOne.addBook(b5);
        libraryOne.addBook(b7);

        libraryOne.addCustomer(c1);
        libraryOne.addCustomer(c2);
        libraryOne.addCustomer(c3);


        libraryOne.borrowBook(b2, c1);
        libraryOne.borrowBook(b3, c2);
        libraryOne.borrowBook(b1, c3);

        // Different tests:
        libraryOne.removeBook("B11", 5656585);
        b2.rentalPrice = 5.50;
        libraryOne.printBookDetails(5689884);
        for(int i = 0; i < libraryOne.customersList.length; i++){
            System.out.println(i + 1 + " customer: " + libraryOne.customersList[i].name);
        }
    }
}
