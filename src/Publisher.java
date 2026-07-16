//This program was created by Thomas Alexandrescu

public class Publisher {
    //Data fields
    private String pubName;
    private String country;
    
    //Constructor
    Publisher(String pubName, String country){
        this.pubName = pubName;
        this.country = country;
    }
        
    //Mutators
    public void setPubName(String pubName){
        this.pubName = pubName;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
    
    //Accessors
    public String getPubName(){
        return pubName;
    }
    
    public String getCountry(){
        return country;
    }
}
