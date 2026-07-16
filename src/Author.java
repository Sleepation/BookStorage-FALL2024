//This program was created by Thomas Alexandrescu

public class Author {
    //Data fields
    private String lastName;
    private String firstName;
    private int noOfBooks;
    
    //Constructor
    Author(String lastName, String firstName, int noOfBooks){
        this.lastName = lastName;
        this.firstName = firstName;
        this.noOfBooks = noOfBooks;
    }
    
    
    //Mutators
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setNoOfBooks(int noOfBooks){
        this.noOfBooks = noOfBooks;
    }
    
    //Accessors
    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public int getNoOfBooks(){//to see...
        return noOfBooks;
    }
}
