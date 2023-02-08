import java.util.ArrayList; // import the ArrayList class

/**
 *  Roach class for creating the players inventory
 *
 *  @author  Venus Nguyen & Diana Diaz
 *  @version CSC 212, April 2022
 */
public class Roach {

  /** String for name of Player  */
  String username;
  /** ArrayList for Player's inventory  */
  ArrayList<String> inventory;

  /** Constructor for Player  */
  public Roach(String username, ArrayList<String> inventory) {
    this.username = username;
    this.inventory = inventory;
  }
  /** Method for printing Player's name and inventory  */
  public String toString() {
    return username + " (" + inventory + ")";
  }
  
}