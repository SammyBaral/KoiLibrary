public class StudentPin {
    //Instance Variables
    private String id;
    private String pin;

    //Constructor
    public StudentPin(String id, String pin){
        this.id = id;
        this.pin = pin;
    }

    //Getter Methods
    public String getId(){
        return id;
    }
    
    public String getPin(){
        return pin;
    }
}
