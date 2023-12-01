import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;



public class DancingBadgers {
  private static PImage backgroundImage; // PImage object that represents the
  // background image
  private static Badger[] badgers; // perfect size array storing the badgers
  // present in this application
  private static Random randGen; // Generator of random numbers


  /**
   * 
   */
  public static void setup() {
    badgers = new Badger[5];
    randGen = new Random();

    // load the image of the background
    backgroundImage = Utility.loadImage("images" + File.separator + "background.png");
  
   



  }

  public static void draw() {
    Utility.background(Utility.color(255, 218, 185));
    // Draw the background image to the center of the screen
    Utility.image(backgroundImage, Utility.width() / 2, Utility.height() / 2);


    for (int i = 0; i < badgers.length; i++) {
     
      
      if (badgers[i] != null) {
        //badgers[i] = new Badger(Utility.width() / 2, Utility.height() / 2);
    
      
       // badgers[i].setX(randGen.nextInt(Utility.width() / 2));
       // badgers[i].setY(randGen.nextInt(Utility.width() / 2));
        badgers[i].draw();
      }
    }

  


  }

  /**
   * Checks if the mouse is over a specific Badger whose reference is provided as input parameter
   *
   * @param Badger reference to a specific Badger object
   * @return true if the mouse is over the specific Badger object passed as input (i.e. over the
   *         image of the Badger), false otherwise
   */

  public static boolean isMouseOver(Badger Badger) {
    if (Utility.mouseX() == Badger.getX() || Utility.mouseY() == Badger.getY() ) {
      
      return true;
    }

    return false;

  }

  /**
   * Callback method called each time the user presses the mouse
   */
  public static void mousePressed() {
    for (int i = 0; i <= badgers.length - 1; i++) {
      if (badgers[i] != null) {


        if (isMouseOver(badgers[i])) {
          badgers[i].startDragging();
          
          
          break;
        }
      }
    }
  }

  /**
   * Callback method called each time the mouse is released
   */
  public static void mouseReleased() {
    for (int i = 0; i <= badgers.length - 1; i++) {
      if (badgers[i] != null) {


        if (isMouseOver(badgers[i])) {
          badgers[i].stopDragging();

        }
      }
    }
  }

  /**
  * Callback method called each time the user presses a key
  */
  public static void keyPressed() {
   
    if(Utility.key() == 'b' || Utility.key()=='B') {

      for(int i=0; i< badgers.length; i++) {
          if(badgers[i] == null) {
          
           badgers[i] = new Badger() ;
           badgers[i].setX(randGen.nextInt(Utility.width())); 
           badgers[i].setY(randGen.nextInt(Utility.width())); 
          break;
          }
      }
      
  }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Utility.runApplication(); // starts the application
  }

}
