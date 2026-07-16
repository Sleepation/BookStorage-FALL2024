import java.util.Scanner;

//This program was created by Thomas Alexandrescu

public class BookDemo {
    public static void main(String[] args) {
        //Step 1: Get Scanner
        Scanner input = new Scanner(System.in);
        
        //Step 2: Create a book array
        Book[] bookArray = new Book[1];
        
        //Step 3: Create userInput String
        String userInput;
        
        //Step 4: Declare and initialize i to verify
        int i = 0;
        
        //Step 5: While loop for menu and input validation
        while(true){
            System.out.println("Choose from the following list of options (enter numbers):\n"
                    + "1) Add Books\n"
                    + "2) Get Sale info\n"
                    + "3) Get Price info\n"
                    + "4) Get Books details\n"
                    + "5) Modify the Author\n"
                    + "6) Modify the Publisher\n"
                    + "7) Quit");
            userInput = input.next();
            
            //If statement to see if the number of books added was 0 even after the method
            if(bookArray.length == 0){
                i = 0;
                bookArray = new Book[1];
            }
            
            //Input validation
            while((!(userInput.matches("(1|2|3|4|5|6|7)")) || (userInput.matches("(2|3|4|5|6)") && i == 0))){
                System.out.print("Your input is not on the list or you did not create a book. Try again: ");
                userInput = input.next();
            }
            input.nextLine();
            
            //Set the value of i to 1 to avoid telling to create a book when it is already created
            i = 1;
            
            //Spacing to clearly see the method use
            System.out.println();
            
            //Invoke methodInvocation and keep the values of the bookArray.
            bookArray = methodInvocation(userInput, bookArray);
        }
    }
    public static Book[] methodInvocation(String userInput, Book[] bookArray){
        //Step 1: Switch case for every option to invoke or exit
        switch(userInput){
            case "1":
                bookArray = addBooks(bookArray);
                break;
            case "2":
                getSaleInfo(bookArray);
                break;
            case "3":
                getPriceInfo(bookArray);
                break;
            case "4":
                getBooksDetails(bookArray);
                break;
            case "5":
                changeAuthor(bookArray);
                break;
            case "6":
                changePublisher(bookArray);
                break;
            case "7":
                System.exit(0);
        }
        
        //Step 2: Return the book array
        return bookArray;
    }
    public static Book[] addBooks(Book[] bookArray){
        //Step 1: Get Scanner
        Scanner input = new Scanner(System.in);
        
        //Step 2: Declare a temporary array responsible to expand the book array
        Book[] tempArray;
        
        //Step 3: Declare the user input string
        String userInput;
        
        //Step 4: Input for number of books to add to the list
        System.out.print("Enter the number of books you want to add: ");
        
        //Input validation for number of books to add
        do{
            userInput = input.next();
            if(!(userInput.matches("\\d+"))){
                System.out.print("Invalid input. Try again: ");
                continue;
            }
            break;
        } while(true);
        input.nextLine();
        
        //Step 5: Create the temporary array
        if(bookArray.length == 1 && bookArray[0] == null){
            tempArray = new Book[Integer.parseInt(userInput)];
        }
        
        //Adds more space to the tempArray (Linked with bookArray)
        else{
            tempArray = new Book[Integer.parseInt(userInput) + bookArray.length];
            
            for(int i = 0; i < bookArray.length; i++){
                tempArray[i] = bookArray[i];
            }
        }
        
        //Step 6: Declare title String (All variables declared are in order)
        String title;
        
        //Step 7: Declare variables to create an Author object
        String lastName;
        String firstName;
        String noOfBooks;
        
        //Step 8: Declare variables to create a Publisher object
        String pubName;
        String country;
        
        //Step 9: Declare variables used for the rest of the Book object's data
        String edition = "";
        String price;
        String saleNumbersInput;
        long[] saleNumbers = new long[6];
        
        
        //Step 10: For loop for each book in the bookArray
        for(int i = 0; i < tempArray.length; i++){
            
            if(i < bookArray.length){
                if(bookArray[i] != null){
                    continue;
                }
            }
            
            //Book number
            System.out.println("Book " + (i + 1) + ":");
            
            //Title input
            System.out.print("Enter the book's title: ");
            title = input.nextLine();
            
            //Input for Author object creation (We want it to be immutable)
            //Last Name input
            System.out.print("Enter the author's last name: ");
            lastName = input.nextLine();
            
            //First Name input
            System.out.print("Enter the author's first name: ");
            firstName = input.nextLine();
            
            //Number of Books input
            System.out.print("Enter the author's number of books: ");
            
            //noOfBooks input validation
            do{
                noOfBooks = input.next();
                if (!(noOfBooks.matches("\\d+"))){
                    System.out.print("Invalid input. Try again: ");
                    continue;
                }
                    break;
            } while(true);
            
            //Input for Publisher object creation
            //Publisher Name input
            System.out.print("Enter the publisher's name: ");
            input.nextLine();
            pubName = input.nextLine();
            
            //Publisher Country input 
            System.out.print("Enter the publisher's country: ");
            country = input.nextLine();
            
            //Input for the rest of the Book object
            
            //Edition input
            System.out.print("Enter the book's edition: ");
                    
            //Input validation for edition
                do{
                    edition = input.next();
                    if(!(edition.matches("\\d+") && Integer.parseInt(edition) > 0)){
                        System.out.print("You did not enter a number. Try again: ");
                        continue;
                    }
                    break;
                } while(true);
            
            //Price input
            System.out.print("Enter the price for the book (Enter a number with two decimal point): ");
                        
            //Input validation for price (If it has digits and .)
            do{
                price = input.next();
                input.nextLine();
                if (!(price.matches("\\d+[.]\\d\\d"))){
                    System.out.print("Invalid input, try putting a number like 1.50: ");
                    continue;
                }
                break;
            } while(true);
            
            //Creating the Author object and Publisher object inside the Book object
            Author tempAuthor = new Author(lastName, firstName, Integer.parseInt(noOfBooks));
            Publisher tempPublisher = new Publisher(pubName, country);
            
            //Constructors depending the number of books
            if(i > 1){
                tempArray[i] = new Book(title, tempAuthor, tempPublisher, Integer.parseInt(edition));
            }
            else{
                tempArray[i] = new Book(title, tempAuthor, tempPublisher);
            }
            
            //Sale numbers + input validation with for loop
            System.out.println("Enter the sale numbers in the first half of the year:");
            for(int j = 0; j < saleNumbers.length; j++){
                System.out.print(getMonthName(j + 1) + ": ");
                do{
                    saleNumbersInput = input.next();
                    if(!(saleNumbersInput.matches("\\d*"))){
                        System.out.print("Invalid input. Only put numbers without decimal point: ");
                        continue;
                    }
                        break;
                } while(true);
                saleNumbers[j] = Long.parseLong(saleNumbersInput);
                tempArray[i].setSaleNumbers(saleNumbers[j], j);
            }
            input.nextLine();
                       
            //Add the other attributes to the Book object
            
            //Edition for first 2 objects
            if(i < 1){
                tempArray[i].setEdition(Integer.parseInt(edition));
            }
            
            //Price
            tempArray[i].setPrice(Float.parseFloat(price));
                        
            //Create spacing for next book
            System.out.println();
        }
        
        //Step 11: Creating the book array and attribute its values to tempArray
        bookArray = new Book[tempArray.length];
        for(int i = 0; i < tempArray.length; i++){
            bookArray[i] = tempArray[i];
        }
        
        //Step 12: Spacing for going back to menu
        System.out.println();
        
        //Step 13: Return the bookArray to save it
        return bookArray;
    }
    public static void getSaleInfo(Book[] bookArray){
        //Step 1: Create a temporary Book object to use Selection Sort
        Book temp;
        
        //Step 2: Selection Sort
        for(int i = 0; i < bookArray.length; i++){
            for(int j = i + 1; j < bookArray.length; j++){
                if (bookArray[i].getTotalSold() < bookArray[j].getTotalSold()){
                    temp = bookArray[i];
                    bookArray[i] = bookArray[j];
                    bookArray[j] = temp;
                }
            }
        }
        
        //Step 3: For loop to print the output
        for(int i = 0; i < bookArray.length; i++){
            System.out.print(bookArray[i].getTitle() + ": ");
            System.out.printf("$%.2f", bookArray[i].getTotalSold());
            System.out.println();
        }
        
        //Step 4: Spacing for going back to the menu
        System.out.println();
    }
    public static void getPriceInfo(Book[] bookArray){
        //Step 1: Create a temporary Book object to use Selection Sort
        Book temp;
        
        //Step 2: Selection Sort
        for(int i = 0; i < bookArray.length; i++){
            for(int j = i + 1; j < bookArray.length; j++){
                if (bookArray[i].getPrice() < bookArray[j].getPrice()){
                    temp = bookArray[i];
                    bookArray[i] = bookArray[j];
                    bookArray[j] = temp;
                }
            }
        }
        
        //Step 3: For loop to print the output
        for(int i = 0; i < bookArray.length; i++){
            System.out.print(bookArray[i].getTitle() + ": ");
            System.out.printf("$%.2f", bookArray[i].getPrice());
            System.out.println();
        }
        
        //Step 4: Spacing for going back to the menu
        System.out.println();
    }
    public static void getBooksDetails(Book[] bookArray){
        //Step 1: For loop to print the output for each book
        for(int i = 0; i < bookArray.length; i++){
            System.out.println(bookArray[i].getTitle() + ":"
                    + "\nAuthor: " + bookArray[i].getAuthor().getFirstName() + " " + bookArray[i].getAuthor().getLastName() 
                    + "\nNumber of Books: " + bookArray[i].getAuthor().getNoOfBooks()
                    + "\nPublisher: " + bookArray[i].getPublisher().getPubName()
                    + "\nCountry: " + bookArray[i].getPublisher().getCountry());
            
            //Edition
            System.out.println("Edition: " + bookArray[i].getEdition());
                        
            //Price
            System.out.print("Price: $");
            System.out.printf("%.2f", bookArray[i].getPrice());
            System.out.println();
            
            //Sale numbers
            System.out.println("Sale numbers in the first half of the year: ");
            
            //For loop to get sale numbers for each month
            for(int j = 0; j < 6; j++){
                System.out.println(getMonthName(j + 1) + ": " + bookArray[i].getSaleNumbers(j));
            }
            
            //Total Books Sold
            System.out.println("Total books sold: " + bookArray[i].getTotalBooks());
            
            //Total Sold
            System.out.println("Total sold: " + bookArray[i].getTotalSold());
            
            //Spacing for menu
            System.out.println();
        }
    }
    public static String getMonthName(int month){
        //Method to get the month name
        switch (month){
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
        }
        
        //This return statement will never be returned in this program's case
        return "";
    }
    public static void changeAuthor(Book[] bookArray){
        //Step 1: Get Scanner
        Scanner input = new Scanner(System.in);
        
        //Step 2: Create the new author object
        Author changedAuthor = new Author("", "", 0);
        
        //Step 3: Declare the userInput string
        String userInput;
        
        //Step 4: Make the user select the book
        System.out.println("Select the book number referring to the title and author:");
        for(int i = 0; i < bookArray.length; i++){
            System.out.println((i+1) + ") " + bookArray[i].getTitle()
                    + " written by " + bookArray[i].getAuthor().getFirstName() + " " 
                    + bookArray[i].getAuthor().getLastName() 
                    + " ---- Number of books: " + bookArray[i].getAuthor().getNoOfBooks());
        }
        
        //Input validation for user selection
        do{
            userInput = input.next();
            if (!(userInput.matches("\\d") && Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= bookArray.length)){
                System.out.print("Invalid input. Try again: ");
                continue;
            }
            break;
        } while(true);
        input.nextLine();
        
        //Step 5: Get input for first name and set it
        System.out.print("Enter the new first name: ");
        changedAuthor.setFirstName(input.nextLine());
        
        //Step 6: Get input for last name and set it
        System.out.print("Enter the new last name: ");
        changedAuthor.setLastName(input.nextLine());
        
        //Step 7: Get input for number of books
        String noOfBooks;
        
        //Input validation for the new number of books
        System.out.print("Enter the new number of books: ");
        do{
            noOfBooks = input.next();
            if (!(userInput.matches("(\\d+)"))){
                System.out.print("Invalid input. Try again: ");
                continue;
            }
            break;
        } while(true);
        
        //Step 8: Set the number of books
        changedAuthor.setNoOfBooks(Integer.parseInt(noOfBooks));
        
        //Step 9: Set the author in the bookArray
        bookArray[Integer.parseInt(userInput) - 1].setAuthor(changedAuthor);
    }
    public static void changePublisher(Book[] bookArray){
        //Step 1: Get Scanner
        Scanner input = new Scanner(System.in);
        
        //Step 2: Create new Publisher object
        Publisher changedPublisher = new Publisher("", "");
        
        //Step 3: Declare userInput
        String userInput;
        
        //Step 4: Make the user select the book
        System.out.println("Select the book number referring to the title and publisher:");
        for(int i = 0; i < bookArray.length; i++){
            System.out.println((i+1) + ") " + bookArray[i].getTitle()
                    + " written by " + bookArray[i].getPublisher().getPubName()
                    + " ---- Country: " + bookArray[i].getPublisher().getCountry());
        }
        
        //Step 5: Input validation for user selection
        do{
            userInput = input.next();
            if (!(userInput.matches("\\d") && Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= bookArray.length)){
                System.out.print("Invalid input. Try again: ");
                continue;
            }
            break;
        } while(true);
        input.nextLine();
        
        //Step 6: Publisher name input and set it
        System.out.print("Enter the new publisher name: ");        
        changedPublisher.setPubName(input.nextLine());
        
        //Step 7: Country input and set it
        System.out.print("Enter the new country: ");
        changedPublisher.setCountry(input.nextLine());
        
        //Step 8: Set the publisher in the book array
        bookArray[Integer.parseInt(userInput) - 1].setPublisher(changedPublisher);
    }
}

