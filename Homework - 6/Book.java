public class Book {
    String title;
    String autor;
    String publisher;
    int yearOfPublishing;
    int isbnNumber;
    double rentalPrice;
    Customer renter;

    public Book(String title, String autor, String publisher, int yearOfFirstPublish,int ISBN){
        if (title == null || title.length() < 2){
            System.out.print("Invalid title! ");
        }else{
            this.title = title;
        }
        if (autor == null || autor.length() < 2){
            System.out.print("Invalid autor! ");
        }else{
            this.autor = autor;
        }
        if (publisher == null || publisher.length() < 2){
            System.out.print("Invalid publisher! ");
        }else{
            this.publisher = publisher;
        }
        if(yearOfFirstPublish > 2022){
            System.out.print("Invalid year of publish! ");
        }else{
            this.yearOfPublishing = yearOfFirstPublish;
        }
        if (String.valueOf(ISBN).length() > 7){
            System.out.print("Invalid ISBN!");
        }else{
            this.isbnNumber = ISBN;
        }
    }

    public Book(String title, String author, String publisher, int yearOfFirstPublish,int ISBN, Customer renter){
        this(title, author, publisher, yearOfFirstPublish, ISBN);
        this.renter = renter;
    }
}
