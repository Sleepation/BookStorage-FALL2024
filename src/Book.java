//This program was created by Thomas Alexandrescu

public class Book {
    //Data Fields
    private String title;
    private Author author;
    private Publisher publisher;
    private int edition;
    private double price;
    private long[] saleNumbers;
    
    //Constructors
    Book(String title, Author author, Publisher publisher){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        saleNumbers = new long[6];
    }
    
    Book(String title, Author author, Publisher publisher, int edition){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        saleNumbers = new long[6];
    }
    
    //Mutators
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setAuthor(Author author){
        this.author = author;
    }
    
    public void setPublisher(Publisher publisher){
        this.publisher = publisher;
    }
    
    public void setEdition(int edition){
        this.edition = edition;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setSaleNumbers(long numberOfBooksSold, int monthNumber){
        this.saleNumbers[monthNumber] = numberOfBooksSold;
    }
    
    //Accessors
    public String getTitle(){
        return title;
    }
    
    public Author getAuthor(){
        return author;
    }
    
    public Publisher getPublisher(){
        return publisher;
    }
    
    public int getEdition(){
        return edition;
    }
    
    public double getPrice(){
        return price;
    }
    
    public long getSaleNumbers(int month){
        return saleNumbers[month];
    }
    
    public long getTotalBooks(){
        int totalBooks = 0;
        for(int i = 0; i < saleNumbers.length; i++){
            totalBooks += saleNumbers[i];
        }
        return totalBooks;
    }
    
    public double getTotalSold(){
        return this.getPrice() * this.getTotalBooks();
    }
}