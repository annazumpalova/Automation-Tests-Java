public class Library {
    String name;
    Book[] booksList = new Book[1];
    Customer[] customersList = new Customer[1];

    int indexBook = 0;
    int indexCustomer = 0;

    public Library() {
        name = "MyLibrary";
    }

    public Library(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        if (indexBook == booksList.length) {
            Book[] temp = new Book[booksList.length + 1];
            for (int k = 0; k < booksList.length; k++) {
                temp[k] = booksList[k];
            }
            booksList = temp;
        }
        booksList[indexBook] = book;
        indexBook++;
    }

    public String searchBookByAuthor(String autorName) {
        for (int i = 0; i < booksList.length; i++) {
            if (booksList[i].autor.equals(autorName)) {
                return booksList[i].autor;
            }
        }
        return "No maches";
    }

    public void printBookDetails(int ISBN) {
        for (int p = 0; p < booksList.length; p++) {
            if (booksList[p].isbnNumber == ISBN) {
                System.out.println("Book title: " + booksList[p].title);
                System.out.println("Book autor: " + booksList[p].autor);
                System.out.println("Book publisher: " + booksList[p].publisher);
                System.out.println("Book year of publishing : " + booksList[p].yearOfPublishing);
                System.out.println("Book ISBN: " + booksList[p].isbnNumber);
                System.out.println("Book price: " + booksList[p].rentalPrice);
                if (booksList[p].renter == null) {
                    System.out.println("Book customers: 0");
                } else {
                    System.out.println("Book customer: " + booksList[p].renter.name);
                }
            }
        }
    }

    public void removeBook(String title, int ISBN) {
        Book[] copy = new Book[booksList.length];
        for (int n = 0, j = 0; n < booksList.length; n++) {
            if (booksList[n].isbnNumber != ISBN) {
                copy[j] = booksList[n];
                j++;
            }
        }
        booksList = copy;
    }

    public void addCustomer(Customer c) {
        if (c.age < 7) {
            System.out.print("The customer cannot be added!");
        } else {
            if (indexCustomer == customersList.length){
                Customer[] temp = new Customer[customersList.length + 1];
                for (int k = 0; k < customersList.length; k++) {
                    temp[k] = customersList[k];
                }
                customersList = temp;
            }
            customersList[indexCustomer] = c;
            indexCustomer++;

        }
    }

    public void removeCustomerByCustomerId(int customerId) {
        Customer[] copy = new Customer[customersList.length - 1];
        for (int n = 0, j = 0; n < booksList.length; n++) {
            if (customersList[n].clientNumber != customerId) {
                copy[j++] = customersList[n];
            }
        }
        customersList = copy;
    }

    public void borrowBook(Book book, Customer customer) {
        for (int p = 0; p < booksList.length; p++) {
            if (booksList[p].title.equals(book.title)) {
                if (customer.money > book.rentalPrice && book.rentalPrice == 0 && customer.borrowedBooks.length < 5) {
                    book.renter = customer;
                    customer.addBook(book);
                }
            }
        }
    }
}
