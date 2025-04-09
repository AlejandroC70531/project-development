import org.code.theater.*;
import org.code.media.*;
import java.util.ArrayList;

public class Strigidae extends Bird{

  private String isNocturnal; // A String representing whether or not the bird is nocturnal
  /*
  * The constructor method for birds in the Strigidae family that uses super to assign their name, family, food,
  * etc using the Bird class and assigns the Strigidae's unique instance variable a value
  */
  public Strigidae(String name, String family, String food, String status, String image, double wingspan, int xPos, String isNocturnal){
    super(name, family, food, status, image, wingspan, xPos);
    this.isNocturnal = isNocturnal;
  }

  /*
  * The accessor method for the isNocturnal instance variable
  */
  public String getIsNocturnal(){
    return isNocturnal;
  }
/*
 * An overidden method taken from the Bird superclass that also includes the isNocturnal instance variable
 */
  public ArrayList<String> createVariableArrayList(){
    ArrayList<String> results = new ArrayList<String>();
    results.add(getName());
    results.add(getFamily());
    results.add(getFood());
    results.add(getStatus());
    Double wingspan = new Double(getWingspan());
    results.add(wingspan.toString());
    results.add(getIsNocturnal());
    return results;
  }
}
