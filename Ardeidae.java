import org.code.theater.*;
import org.code.media.*;
import java.util.ArrayList;

public class Ardeidae extends Bird{

  private double neckLength; // A double representing the bird's neck length in inches
  
  /*
  * The constructor method for birds in the Ardeidae family that uses super to assign their name, family, food,
  * etc using the Bird class and assigns the Ardeidae's unique instance variable a value
  */
  public Ardeidae(String name, String family, String food, String status, String image, double wingspan, int xPos, double neckLength){
    super(name, family, food, status, image, wingspan, xPos);
    this.neckLength = neckLength;
  }

  /*
  * The accessor method for the neckLength instance variable
  */
  public double getNeckLength(){
    return neckLength;
  }
/*
 * An overidden method taken from the Bird superclass that also includes the neckLength instance variable
 */
  public ArrayList<String> createVariableArrayList(){
    ArrayList<String> results = new ArrayList<String>();
    results.add(getName());
    results.add(getFamily());
    results.add(getFood());
    results.add(getStatus());
    Double wingspan = new Double(getWingspan());
    results.add(wingspan.toString());
    Double neckLength = new Double(getNeckLength());
    results.add(neckLength.toString());
    return results;
  }
}
