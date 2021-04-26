public class Customer {
    String name;
    int age;
    int clientNumber;
    double money;
    Book[] borrowedBooks = new Book[1];

    int indexBook = 0;

    public Customer(String name, int age) {
        if (name.length() < 2) {
            System.out.print("Invalid name!");
        } else {
            this.name = name;
        }
        if (age < 1 || age > 150) {
            System.out.print("Invalid age!");
        } else {
            this.age = age;
        }
    }

    public Customer(String name, int age, int customerId) {
        this(name, age);
        if (String.valueOf(customerId).length() < 6) {
            System.out.print("Invalid customer ID!");
        } else {
            this.clientNumber = customerId;
        }
    }

    public void addBook(Book book) {
        if (borrowedBooks.length < 5) {
            if (indexBook == borrowedBooks.length) {
                Book[] temp = new Book[borrowedBooks.length + 1];
                for (int k = 0; k < borrowedBooks.length; k++) {
                    temp[k] = borrowedBooks[k];
                }
                borrowedBooks = temp;
            }
            borrowedBooks[indexBook] = book;
            indexBook++;
        } else {
            System.out.print("The max number of books is reached!");
        }
    }
}
