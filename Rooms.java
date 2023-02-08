import java.util.ArrayList; // import the ArrayList class

/**
 *  Rooms class for creating the Room's inventory
 *
 *  @author  Venus Nguyen & Diana Diaz
 *  @version CSC 212, April 2022
 */
public class Rooms {
  /** String for name of Room  */
  String name;
  /** ArrayList for Room's inventory  */
  ArrayList<String> inventory;

  /** Constructor for Rooms  */
  public Rooms(String name, ArrayList<String> inventory) {
    this.name = name;
    this.inventory = inventory;
  }

  /** Method for printing Room's name and inventory  */
  public String toString() {
    return name + " (" + inventory + ")";
  }
  
}