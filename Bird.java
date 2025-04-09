import org.code.theater.*;
import org.code.media.*;
import java.util.ArrayList;

public class Bird{

  private String name; // A String representing the bird's name
  private String family; // A String representing the bird's family
  private String food; // A String representing the bird's main food group
  private String status; // A String representing the birds extinction status
  private String image; // A String containing the bird's image file
  private Double wingspan; // A double representing the bird's wingspan in inches
  private int xPos; // An int representing the bird's starting x position at the start of the animation

  /*
  * The constructor for a typical bird object that includes all instance variables that receive special values
  */
  public Bird(String name, String family, String food, String status, String image, Double wingspan, int xPos){
    this.name = name;
    this.family = family;
    this.food = food;
    this.status = status;
    this.image = image;
    this.wingspan = wingspan.doubleValue();
    this.xPos = xPos;
  }

  /*
  * The constructor for a typical bird object that assigns the value "Unknown" to family if not provided
  */
  public Bird(String name, String food, String status, String image, Double wingspan, int xPos){
    this.name = name;
    family = "Unknown";
    this.food = food;
    this.status = status;
    this.image = image;
    this.wingspan = wingspan.doubleValue(); 
    this.xPos = xPos;
  }
  /*
  * The accessor method for the name instance variable
  */
  public String getName(){
    return name;
  }
 /*
  * The accessor method for the family instance variable
  */
   public String getFamily(){
    return family;
  }

 /*
  * The accessor method for the food instance variable
  */
   public String getFood(){
    return food;
  }

  /*
  * The accessor method for the status instance variable
  */
   public String getStatus(){
    return status;
  }

  /*
  * The accessor method for the image instance variable
  */
  public String getImageFile(){
    return image;
  }

  /*
  * The accessor method for the wingspan instance variable
  */
   public double getWingspan(){
    return wingspan;
  }

  /*
  * The accessor method for the xPos instance variable
  */
  public int getXPos(){
    return xPos;
  }

  /*
  * The mutator method for the xPos instance variable
  */
  public void setXPos(int newXPos){
    xPos = newXPos;
  }

  /*
  * Similar to a toString() method, this method formats all of the instance variable values in a bird
  * to be fully displayed on the animation to prevent any text disappearing from the animation
  */
  public ArrayList<String> createVariableArrayList(){
    ArrayList<String> results = new ArrayList<String>();
    results.add(getName());
    results.add(getFamily());
    results.add(getFood());
    results.add(getStatus());
    Double wingspan = new Double(getWingspan()); // wingspan used to create a double in order to convert the value into a String
    results.add(wingspan.toString());
    return results;
  }
}
