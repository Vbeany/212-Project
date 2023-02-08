import com.google.common.graph.*;
import java.util.*;

/**
 *  Worldbuilder class for setting the graph
 *
 *  @author  Venus Nguyen & Diana Diaz
 *  @version CSC 212, April 2022
 */
class Worldbuilder {
  
  /** Code that creates needed rooms and a graph with those rooms*/
  public static void main() {

    //Instances of rooms needed are made here
    Rooms Mainrm = new Rooms("Main Room", new ArrayList<>(Arrays.asList("bag of apples","hershey bar","bunch of grapes","window","dead martian","mirror")));
    Rooms Leftrm = new Rooms("Left Room", new ArrayList<>(Arrays.asList("rhinestones", "water bottle","pickle jar","pile of clothes")));
    Rooms Rightrm = new Rooms("Right Room", new ArrayList<>(Arrays.asList("kid")));
    Rooms Lockedrm = new Rooms("Locked Room", new ArrayList<>());
    Rooms Elevator = new Rooms("Elevator", new ArrayList<>());
    Rooms SecondFlrrm = new Rooms("2nd Floor Room ", new ArrayList<>(Arrays.asList("limes","keyboard")));  
    Rooms Humanoidrm = new Rooms("Humanoid Room", new ArrayList<>(Arrays.asList("baby humanoid","ensure milk", "activia yogurt","poison", "advil")));
    Rooms Historyrm = new Rooms("History Room", new ArrayList<>(Arrays.asList("new mars map","window", "radio", "button", "desk","drawer","historical document", "half drunk caramel iced coffee", "family stock photo")));
    Rooms Basementrm = new Rooms("Basement Room", new ArrayList<>(Arrays.asList("dead plants","gnomes","spider")));
    Rooms Disheveledrm = new Rooms("Disheveled Room", new ArrayList<>(Arrays.asList("closet")));
    Rooms North1rm = new Rooms("North1 Room", new ArrayList<>(Arrays.asList("couch", "tv","playstation","pc and keyboard running legue of legends", "table", "chair")));
    Rooms North2rm = new Rooms("North2 Room", new ArrayList<>());
    Rooms South1rm = new Rooms("South1 Room", new ArrayList<>(Arrays.asList("big cage", "skeleton")));
    Rooms South2rm = new Rooms("South2 Room", new ArrayList<>(Arrays.asList("escape pod")));
    Rooms East1rm = new Rooms("East1 Room", new ArrayList<>(Arrays.asList("fridge","knife","scrub daddy","orange juice","bag of apples", "drawer")));
    Rooms East2rm = new Rooms("East2 Room", new ArrayList<>());
    Rooms Penthouse = new Rooms("Penthouse", new ArrayList<>(Arrays.asList("trash chute", "humans")));
    Rooms Closet = new Rooms("Closet", new ArrayList<>(Arrays.asList("acid", "tape", "batteries", "flyer", "box cutter", "I <3 our overlord painting")));

    
        
      // Builds the graph
    ImmutableGraph<Rooms> theGraph =
      GraphBuilder.directed()
      // Key: $ = first floor, @ = second floor, * = basement, ! = penthouse floor
      .<Rooms>immutable()
      .putEdge(Mainrm, Rightrm) //--> $
      .putEdge(Rightrm,  Mainrm)  //<-- $
      .putEdge(Mainrm, Leftrm)  //--> $
      .putEdge(Leftrm,  Mainrm)  //<-- $
      .putEdge(Leftrm, Lockedrm)  //--> $
      .putEdge(Rightrm, Elevator)  //--> $
      .putEdge(Elevator, Rightrm)  //<-- *
      .putEdge(Rightrm, SecondFlrrm)  //--> @
      .putEdge(SecondFlrrm, Rightrm)  //<-- @
      .putEdge(SecondFlrrm, Disheveledrm)  //--> @
      .putEdge(Disheveledrm, SecondFlrrm)  //<-- @
      .putEdge(SecondFlrrm, Humanoidrm)  //--> @
      .putEdge(Humanoidrm, SecondFlrrm)  //<-- @
      .putEdge(Humanoidrm, Historyrm)  //--> @
      .putEdge(Historyrm, Humanoidrm)  //<-- @
      .putEdge(SecondFlrrm, Penthouse)  //--> @
      .putEdge(Penthouse, SecondFlrrm)  //<-- !
      .putEdge(Penthouse,  Mainrm)  //--> (trash chute) 
      .putEdge(Elevator, Basementrm)  //--> *
      .putEdge(Basementrm, Elevator)  //<-- *
      .putEdge(Basementrm, North1rm)  //--> *
      .putEdge(North1rm, Basementrm)  //<-- *
      .putEdge(North1rm, North2rm)  //--> *
      .putEdge(Basementrm, East1rm)  //--> *
      .putEdge(East1rm, Basementrm)  //<-- *
      .putEdge(East1rm, East2rm)  //--> *
      .putEdge(East2rm, East1rm)  //<-- *
      .putEdge(East2rm, South2rm)  //--> * (exit)
      .putEdge(Basementrm, South1rm)  //--> *
      .putEdge(South1rm, Basementrm)  //<-- *
      .putEdge(South1rm, East1rm)  //--> *
      .putEdge(East1rm, South1rm)  //<-- *
      .build();
    
      //Calls the actual game
    Gameplay.play(theGraph, Mainrm, Leftrm, Rightrm, Lockedrm, Elevator, SecondFlrrm, Humanoidrm, Historyrm, Basementrm, Disheveledrm, North1rm, North2rm, South1rm, South2rm, East1rm, East2rm, Penthouse,Closet); 
  }
}
