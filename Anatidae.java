import org.code.theater.*;
import org.code.media.*;
import java.util.ArrayList;

public class Anatidae extends Bird{

  private String livesInWater; // A String representing whether or not the bird can live in water

  /*
  * The constructor method for birds in the Accipitridae family that uses super to assign their name, family, food,
  * etc using the Bird class and assigns the Anatidae's unique instance variable a value
  */
  public Anatidae(String name, String family, String food, String status, String image, double wingspan, int xPos, String livesInWater){
    super(name, family, food, status, image, wingspan, xPos);
    this.livesInWater = livesInWater;
  }

  /*
  * The accessor method for the livesInWater instance variable
  */
  public String getLivesInWater(){
    return livesInWater;
  }
/*
 * An overidden method taken from the Bird superclass that also includes the livesInWater instance variable
 */
  public ArrayList<String> createVariableArrayList(){
    ArrayList<String> results = new ArrayList<String>();
    results.add(getName());
    results.add(getFamily());
    results.add(getFood());
    results.add(getStatus());
    Double wingspan = new Double(getWingspan());
    results.add(wingspan.toString());
    results.add(getLivesInWater());
    return results;
  }
}
