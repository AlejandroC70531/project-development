import org.code.theater.*;
import org.code.media.*;
import java.util.ArrayList;

public class Accipitridae extends Bird{

  private int glideSpeed; // An int that represents the top speed the bird can glide (mph)

  /*
  * The constructor method for birds in the Accipitridae family that uses super to assign their name, family, food,
  * etc using the Bird class and assigns the Accipitridae's unique instance variable a value
  */
  public Accipitridae(String name, String family, String food, String status, String image, double wingspan, int xPos, int glideSpeed){
    super(name, family, food, status, image, wingspan, xPos);
    this.glideSpeed = glideSpeed;
  }

  /*
  * The accessor method for the glideSpeed instance variable
  */
  public int getGlideSpeed(){
    return glideSpeed;
  }
/*
 * An overidden method taken from the Bird superclass that also includes the glideSpeed instance variable
 */
  public ArrayList<String> createVariableArrayList(){
    ArrayList<String> results = new ArrayList<String>();
    results.add(getName());
    results.add(getFamily());
    results.add(getFood());
    results.add(getStatus());
    Double wingspan = new Double(getWingspan());
    results.add(wingspan.toString());
    Integer glideSpeed = new Integer(getGlideSpeed());
    results.add(glideSpeed.toString());
    return results;
  }
}
