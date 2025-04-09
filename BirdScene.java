import org.code.theater.*;
import org.code.media.*;
import java.util.Scanner;
import java.util.ArrayList;
public class BirdScene extends Scene{

  private ArrayList<Bird> birdList;
  private String backgroundImage;

/**
 * Constructs a BirdScene Object given data for each bird using the createBidrds method and the given background image
 *
 * Precondition: All files are .txt files and are created correctly
 * Postcondition: birdList contains all intended birds and are instantiated correctly
 * 
 * @param		String nameFile: The file containing all the bird names
 * @param   String familiesFile: The file containing all the birds' families
 * @param   String foodFile: The file containing all the birds' main food group
 * @param   String statusFile: The file containing all the birds' extinction statuses
 * @param   String imageFile: The file containing all the birds' images
 * @param   String wingspanFile: The file containing all the birds' wingspan as Strings
 * @param   String nocturnalFile: The file containing the Strigidae birds' statements on whether or not they're nocturnal
 * @param   String waterFile: The file containing all the Anatidae birds; statements on whether or not they can live in water
 * @param   String neckLengthFile: The file containing all the Ardeidae birds' neck lengths
 * @param   String glideFile: The file containing all the Accipitridae birds' top glide speeds
 * @param   String backgroundImage: The file for the background image
 */

  public BirdScene(String namesFile, String familiesFile, String foodFile, String statusFile, String imageFile, String wingspanFile, String nocturnalFile, String waterFile, String neckLengthFile, String glideFile, String backgroundImage){
    this.birdList = createBirds(namesFile, familiesFile, foodFile, statusFile, imageFile, wingspanFile, nocturnalFile, waterFile, neckLengthFile, glideFile);
    this.backgroundImage = backgroundImage;
  }

  /**
 * Creates the birdList for a BirdScene Object given data for each bird
 *
 * Precondition: All files are .txt files originating from the constructor and are created correctly
 * Postcondition: Each bird is instatiated correctly and added to birdList
 * 
 * @param		String nameFile: The file containing all the bird names
 * @param   String familiesFile: The file containing all the birds' families
 * @param   String foodFile: The file containing all the birds' main food group
 * @param   String statusFile: The file containing all the birds' extinction statuses
 * @param   String imageFile: The file containing all the birds' images
 * @param   String wingspanFile: The file containing all the birds' wingspan as Strings
 * @param   String nocturnalFile: The file containing the Strigidae birds' statements on whether or not they're nocturnal
 * @param   String waterFile: The file containing all the Anatidae birds; statements on whether or not they can live in water
 * @param   String neckLengthFile: The file containing all the Ardeidae birds' neck lengths
 * @param   String glideFile: The file containing all the Accipitridae birds' top glide speeds
 */
  public ArrayList<Bird> createBirds(String namesFile, String familiesFile, String foodFile, String statusFile, String imageFile, String wingspanFile, String nocturnalFile, String waterFile, String neckLengthFile, String glideFile){
    int waterIndex = 0;
    int glideSpeedIndex = 0;
    int neckLengthIndex = 0;
    int nocturnalIndex = 0;
    ArrayList<String> namesData = FileReader.toStringList(namesFile);
    ArrayList<String> familyData = FileReader.toStringList(familiesFile);
    ArrayList<String> foodData = FileReader.toStringList(foodFile);
    ArrayList<String> statusData = FileReader.toStringList(statusFile);
    ArrayList<String> imageFiles = FileReader.toStringList(imageFile);
    ArrayList<String> nocturnalData = FileReader.toStringList(nocturnalFile);
    ArrayList<String> waterData = FileReader.toStringList(waterFile);
    ArrayList<Double> wingspanData = FileReader.toDoubleList(wingspanFile);
    ArrayList<Double> neckLengthData = FileReader.toDoubleList(neckLengthFile);
    ArrayList<Integer> glideSpeedData = FileReader.toIntList(glideFile);
    ArrayList<Bird> newBirds = new ArrayList<Bird>();

    //If statements used to assign special values to unique instance varibales depending on the bird's family
    for(int i = 0; i < namesData.size(); i++){
      if(familyData.get(i).equals("Anatidae")){
        newBirds.add(new Anatidae(namesData.get(i), familyData.get(i), foodData.get(i), statusData.get(i), imageFiles.get(i), wingspanData.get(i), 0, waterData.get(waterIndex)));
        waterIndex++;
      } else if(familyData.get(i).equals("Accipitridae")){
        newBirds.add(new Accipitridae(namesData.get(i), familyData.get(i), foodData.get(i), statusData.get(i), imageFiles.get(i), wingspanData.get(i), 0, glideSpeedData.get(glideSpeedIndex).intValue()));
        glideSpeedIndex++;
      } else if(familyData.get(i).equals("Strigidae")){
        newBirds.add(new Strigidae(namesData.get(i), familyData.get(i), foodData.get(i), statusData.get(i), imageFiles.get(i), wingspanData.get(i), 30, nocturnalData.get(nocturnalIndex)));
        nocturnalIndex++;
      } else if(familyData.get(i).equals("Ardeidae")){
        newBirds.add(new Ardeidae(namesData.get(i), familyData.get(i), foodData.get(i), statusData.get(i), imageFiles.get(i), wingspanData.get(i), 0, neckLengthData.get(neckLengthIndex).doubleValue()));
        neckLengthIndex++;
      } else {
        newBirds.add(new Bird(namesData.get(i), familyData.get(i), foodData.get(i), statusData.get(i), imageFiles.get(i), wingspanData.get(i), 0));
      }
    }
    return newBirds;
  }

/**
 * Formats the text displayed in the animation
 *
 * Precondition: N/A
 * Postcondition: The text is displayed with all of these traits
 * 
 */

   private void formatText() {
    setTextStyle(Font.SANS, FontStyle.BOLD);
    setTextColor("black");
    setTextHeight(20);
  }

  /**
 * Draws the background image to cover the whole animation using the provided background image given during the construction of the object
 *
 * Precondition: backgroundImage is correctly assigned a value
 * Postcondition:
 * 
 */
  public void drawBackground() {
    drawImage(backgroundImage, 0, 0, getWidth());
  }

 /**
 * Draws the animation
 *
 * Precondition: The birdList is correctly instantiated with all the birds
 * Postcondition: Each part of the animation is displayed clearly and correctly
 * 
 */
  public void drawScene(){
    boolean[] displayConditions = createConditions(birdList.size());
    ArrayList<Bird> birdsToDisplay = new ArrayList<Bird>(); 
    drawImage("inside-lab.png", 0, 0, 400);
    formatText();
    drawText("Welcome to the", 150, 100);
    drawText("Ultimate Bird Presentation!", 150, 150);
    pause(5.0);
    for(int i = 0; i < birdList.size(); i++){
      Bird currentBird = birdList.get(i);
      clear("white");
      drawImage("Lab-Hymes.jpg", 0, 0, 400);
      playSound("bird-sound-310301.wav");
      if(currentBird.getFamily().equals("Anatidae") || currentBird.getFamily().equals("Ardeidae")){
        drawImage(currentBird.getImageFile(), currentBird.getXPos(), 300, 50);
        while(currentBird.getXPos() < 400){
          drawBackground();
          currentBird.setXPos(currentBird.getXPos() + 100);
          drawImage(currentBird.getImageFile(), currentBird.getXPos(), 300, 50);
          pause(0.5);
          if(displayConditions[i] == true && currentBird.getXPos() == 200){
            playSound("camera-shutter-6305.wav");
            birdsToDisplay.add(birdList.get(i));
          }
        }
      } else if(currentBird.getFamily().equals("Accipitridae")){
        while(currentBird.getXPos() < 400){
          drawBackground();
          drawImage(currentBird.getImageFile(), currentBird.getXPos(), 50, 50);
          currentBird.setXPos(currentBird.getXPos() + 100);
          pause(0.5);
          if(displayConditions[i] == true && currentBird.getXPos() == 200){
            playSound("camera-shutter-6305.wav");
            birdsToDisplay.add(birdList.get(i));
          }
        } 
      } else if(birdList.get(i).getFamily().equals("Strigidae")){
          drawImage(currentBird.getImageFile(), currentBird.getXPos(), 50, 50);
          pause(4.0);
          currentBird.setXPos(currentBird.getXPos() + 270);
          drawBackground();
          drawImage(currentBird.getImageFile(), currentBird.getXPos(), 50, 50);
          pause(2.0);
          if(displayConditions[i] == true){
            playSound("camera-shutter-6305.wav");
            birdsToDisplay.add(birdList.get(i));          }
      } else {
        drawImage(currentBird.getImageFile(), currentBird.getXPos(), 300, 50);
        while(currentBird.getXPos() < 400){
          drawBackground();
          currentBird.setXPos(currentBird.getXPos() + 100);
          drawImage(currentBird.getImageFile(), currentBird.getXPos(), 300, 50);
          pause(0.5);
          if(displayConditions[i] == true && currentBird.getXPos() == 200){
            playSound("camera-shutter-6305.wav");
            birdsToDisplay.add(birdList.get(i));
          }
         }
        } 
      }
      drawImage("inside-lab.png", 0, 0, 400);
      drawText("Now let's analyze our finds!", 150, 100);
      pause(5.0);
      drawBirdInfographic(birdsToDisplay);
    }

  /**
 * Creates a 1D Array of booleans dictating which birds will have a personal infographic at the end of the animation
 *
 * Precondition: size is greater than 0
 * Postcondition: The returned array contain only size amount of "true" or "false" elements
 * 
 * @param		int size: The size of how big the returned array should be
 * @return	An array containing size amount of boolean values
 */
  private boolean[] createConditions(int size){
    boolean[] results = new boolean[size];
    boolean foundTrue = false;
    for(int i = 0; i < size; i++){
      int num = (int) (Math.random() * 5);
      if(num % 2 == 1){
        results[i] = true;
      } else {
        results[i] = false;
      }
    }
    for (int j = 0; j < results.length; j++){
      if(results[j] == true && foundTrue == false){
        foundTrue = true;
      }
    }
    if(foundTrue == false){
      results[(int) size / 2] = true;
    }
    return results;
  }

/**
 * Draws an infographic for a selected bird (dictated by previous method) at the end of the animation
 * with all of their information
 *
 * Precondition: chosenBird is present in birdList
 * Postcondition: The infographic is presented clearly and correctly in the animation.
 * 
 * @param		int size: The size of how big the returned array should be
 */
  private void drawBirdInfographic(Bird chosenBird){
    clear("green");
    // Plays a sound when the infographic appears based on the bird's common species name
    if(getCommonSpeciesName(chosenBird.getName()).equals("Merganser")){
      playSound("duck-quack-112941.wav");
    } else if(getCommonSpeciesName(chosenBird.getName()).equals("Goose") || getCommonSpeciesName(chosenBird.getName()).equals("Swan")){
      playSound("084325_goose-86645.wav");
    } else if(getCommonSpeciesName(chosenBird.getName()).equals("Hawk") || getCommonSpeciesName(chosenBird.getName()).equals("Kite")){
      playSound("red-tailed-hawk-flying-away-94358.wav");
    } else if(getCommonSpeciesName(chosenBird.getName()).equals("Eagle")){
      playSound("eagle-scream-112940.wav");
    } else if(chosenBird.getFamily().equals("Strigidae")){
      playSound("owl-hooting-223549.wav");
    } else if(chosenBird.getFamily().equals("Ardeidae")){
      playSound("heron.wav");
    } else {
      playSound("bird-sound-310301.wav");
    }
    drawImage(chosenBird.getImageFile(), 150, 25, 150);
    formatDisplayText(chosenBird.createVariableArrayList());
    pause(5.0);
  }

/**
 * An overloaded method that draws an infographic for each selected bird using the previous method
 *
 * Precondition: chosenBirds are present in the birdList instance variable
 * Postcondition: The infographics presented clearly and correctly in the animation.
 * 
 * @param		ArrayList<Bird> chosenBirds: The size of how big the returned array should be
 */
  private void drawBirdInfographic(ArrayList<Bird> chosenBirds){
    for(int i = 0; i < chosenBirds.size(); i++){
      drawBirdInfographic(chosenBirds.get(i));
    }
  }

/**
 * An overloaded method that draws an infographic for each selected bird using the previous method
 *
 * Precondition: The bird's common species name (ex. Duck) is at the end of the name
 * Postcondition: Only the bird's common species name is returned; the bird's actual name variable isn't altered
 * 
 * @param		ArrayList<Bird> chosenBirds: The size of how big the returned array should be
 * @return  A String containing the second word in the bird's name
 */
  private String getCommonSpeciesName(String name){
    int spaceIndex = name.indexOf(" ");
    return name.substring(spaceIndex + 1);
  }

/**
 * An overloaded method that draws an infographic for each selected bird using the previous method
 *
 * Precondition: The ArrayList originates from a bird's createVariableArrayList() method
 * Postcondition: The values of the instance variables aren't altered and the text is displayed only on the infographic
 * 
 * @param		ArrayList<String> wordsToDisplay: The list of information that will be displayed on the infographic
 */
  private void formatDisplayText(ArrayList<String> wordsToDisplay){
      drawText("Name: " + wordsToDisplay.get(0), 100, 200);
      drawText("Family: " + wordsToDisplay.get(1), 100, 225);
      drawText("Food: " + wordsToDisplay.get(2), 100, 250);
      drawText("Status: " + wordsToDisplay.get(3), 100, 275);
      drawText("Wingspan: " + wordsToDisplay.get(4), 100, 300);
    // Finds the family of the bird in order to determine which special characteristic to display if needed
      if(wordsToDisplay.get(1).equals("Anatidae")){
        drawText("Lives in Water: " + wordsToDisplay.get(5), 100, 325);
      } else if(wordsToDisplay.get(1).equals("Accipitridae")){
        drawText("Glide Speed: " + wordsToDisplay.get(5), 100, 325);
      } else if(wordsToDisplay.get(1).equals("Strigidae")){
        drawText("Is Nocturnal: " + wordsToDisplay.get(5), 100, 325);
      } else if(wordsToDisplay.get(1).equals("Ardeidae")){
        drawText("Neck Length: " + wordsToDisplay.get(5), 100, 325);
      }
  }
}
