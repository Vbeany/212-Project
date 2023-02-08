 import com.google.common.graph.*; /** imports guava graph class  */
import java.util.Scanner; /** imports scanner class  */
import java.util.*; /** imports util class  */
import java.util.ArrayList; /** imports ArrayList class  */
import java.util.Arrays; /** imports Array class  */

/**
 *  Gameplay class for logic behind playing the game
 *
 *  @author  Venus Nguyen & Diana Diaz
 *  @version CSC 212, April 2022
 */
class Gameplay {
//----------------------------------------------------
  /** Room var for a room on the graph  */
  static Rooms Mainrm1;
  /** Room var for a room on the graph  */
  static Rooms Leftrm1;
  /** Room var for a room on the graph  */
  static Rooms Rightrm1;
  /** Room var for a room on the graph  */
  static Rooms Lockedrm1;
  /** Room var for a room on the graph  */
  static Rooms Elevator1;
  /** Room var for a room on the graph  */
  static Rooms SecondFlrrm1;
  /** Room var for a room on the graph  */
  static Rooms Humanoidrm1;
  /** Room var for a room on the graph  */
  static Rooms Historyrm1;
  /** Room var for a room on the graph  */
  static Rooms Basementrm1;
  /** Room var for a room on the graph  */
  static Rooms Disheveledrm1;
  /** Room var for a room on the graph  */
  static Rooms North1rm1;
  /** Room var for a room on the graph  */
  static Rooms North2rm1;
  /** Room var for a room on the graph  */
  static Rooms South1rm1;
  /** Room var for a room on the graph  */
  static Rooms South2rm1;
  /** Room var for a room on the graph  */
  static Rooms East1rm1;
  /** Room var for a room on the graph  */
  static Rooms East2rm1;
  /** Room var for a room on the graph  */
  static Rooms Penthouse1;
  /** Room var for a room on the graph  */
  static Rooms Dead;
  /** Room var for a room on the graph  */
  static Rooms Closet1;

  /** myObj holds  user input  */
  static Scanner myObj = new Scanner(System.in);
  
  /** userReply holds  user input  */
  static String userReply;

  /** ArrayList for holding certain items to be checked through a method */
    static ArrayList<String> look = new ArrayList<String>(Arrays.asList("window","mirror"));
  
  /** ArrayList for holding certain items to be checked through a method */
  static ArrayList<String> onoffObj = new ArrayList<String>(Arrays.asList("radio"));

  /** ArrayList for holding certain items to be checked through a method */
  static ArrayList<String> permRemoval = new ArrayList<String>(Arrays.asList("water bottle","pickle jar","ensure milk", "activia yogurt","poison","half drunk caramel iced coffee","bag of apples","orange juice","bunch of grapes","hershey bar","limes","baby humanoid","baby humanoids"));

  /** ArrayList for holding certain items to be checked through a method */
  static ArrayList<String> pdObjs = new ArrayList<>(Arrays.asList("tape","acid","batteries","box cutter","baby humanoid","knife","scrub daddy","dead plants","advil","skeleton","new mars map","historical document","flyer","rhinestones","pile of clothes","radio", "button", "family stock photo","gnomes", "spider","tv","playstation","keyboard","water bottle","pickle jar","ensure milk", "activia yogurt","poison","half drunk caramel iced coffee","bag of apples","orange juice","bunch of grapes","hershey bar","limes","kid"));

  /** ArrayList for holding certain items to be checked through a method */
  static ArrayList<String> opClobj = new ArrayList<>(Arrays.asList("fridge","big cage","kitchen drawer","desk drawer"));

  /** ArrayList for holding certain items to be checked through a method */
  static ArrayList<String> chill = new ArrayList<>(Arrays.asList("couch","table","chair"));

  /** ArrayList for holding child to be checked through leavechild method */
  static ArrayList<String> kid = new ArrayList<>(Arrays.asList("kid"));
  
  /** ArrayList for holding certain items to be checked through a method */
  static ArrayList<String> vrooms = new ArrayList<>(Arrays.asList( "vMainrm", "vLeftrm", "vRightrm","vSecondFlrrm","vHumanoidrm", "vHistoryrm", "vBasementrm", "vDisheveledrm", "vNorth1rm", "vNorth2rm", "vSouth1rm", "vSouth2rm","vEast1rm", "vEast2rm", "vPenthouse"));


//----------------------------------------------------  
  /** Method dealing with setting up the storyline and game */
  public static void play(ImmutableGraph theGraph, Rooms Mainrm, Rooms Leftrm, Rooms Rightrm, Rooms Lockedrm, Rooms Elevator, Rooms SecondFlrrm, Rooms Humanoidrm, Rooms Historyrm, Rooms Basementrm, Rooms Disheveledrm, Rooms North1rm, Rooms North2rm, Rooms South1rm, Rooms South2rm, Rooms East1rm, Rooms East2rm, Rooms Penthouse, Rooms Closet) {

    Mainrm1 = Mainrm;  
    Leftrm1 = Leftrm; 
    Lockedrm1 = Lockedrm; 
    Rightrm1 = Rightrm;  
    Elevator1 = Elevator; 
    SecondFlrrm1 = SecondFlrrm; 
    Humanoidrm1 = Humanoidrm; 
    Historyrm1 = Historyrm;
    Basementrm1 = Basementrm;
    Disheveledrm1 = Disheveledrm;
    North1rm1 = North1rm;
    North2rm1 = North2rm;
    South1rm1 = South1rm;
    South2rm1 = South2rm;
    East1rm1 = East1rm;
    East2rm1 = East2rm;
    Penthouse1 = Penthouse;
    Closet1 = Closet;
    
    Roach Player = new Roach("Player", new ArrayList<>(Arrays.asList("Backpack")));
    Roach Roomholder = new Roach("Roomholder", new ArrayList<>(Arrays.asList("Bagpack")));
    
    Rooms location = Mainrm1;
    Rooms previousloc = location;
    System.out.println(" ");
    System.out.println("!!!TYPE HELP TO CHECK WHAT THE COMMANDS ARE!!! ");
    System.out.println(" ");
    System.out.println(" ");
    System.out.println("You've been kidnapped and you wake up in some sort of facility. You seem to be waiting in some sort of line.. Looking ahead you notice people wearing white pjs.You notice you too are wearing one. Looking ahead of the line you notice people are being injected with a syringe one by one. In seconds those people start mutating into some sort of saggy dumpy alien. Not willing to stay and wait your turn you look to run to the nearest exit..");
    System.out.println(" ");
    System.out.println("You find yourself sprinting down a long bright white corridor, everything seems to be circling around you. You run into the nearest closed door. With no one in sight you take the chance to catch your breathe. Looking around you find yourself wound up in some sort of room which resembles a meeting room of some sort...");
    System.out.println(" ");
    
    while (location != Lockedrm1 && location != South2rm1 && location != Dead) {
      Rooms[] ans = Currloc(location, Player, Roomholder, previousloc);
      location = ans[0];
      previousloc = ans[1];
    }

    if (location == Dead) {
      System.out.println("You Died X_X");
    }
    else {
      System.out.println("");
      System.out.println("******************************************");
      System.out.println("Currrent location: Garage"); 
      System.out.println("******************************************");
      System.out.println("");
      System.out.println("The door shuts behind you tightly. Looks like theres no way back.. Looking around it seems like you've made it into some sort of garage? The room is finished with concrete for the floors and walls... Taking in the room you notice escape pods lined up on each side of the room. \"This is it I can use those!\"");
      if (Roomholder.inventory.contains("kidused")) {
        System.out.println("I just remembered. I could've also used tape to hold that button too escape.. Oh well..");
      }
      
      int hold = 1;
      while (hold == 1) {
        userReply = myObj.nextLine();
        userReply = userReply.toLowerCase();
        System.out.println(" ");        
        if (userReply.equals("use escape pods")) {
          if (Player.inventory.contains("kid")) {
            hold = 0;
            System.out.println("Whoo hoo! You escaped and saved the kid!");
            System.out.println("");
            System.out.println("Exiting Game..");
          }
          else {
            hold = 0;
            System.out.println("Whoo hoo u escaped!");
            System.out.println("");
            System.out.println("Exiting Game..");
          } 
        }
        else {
          System.out.println("\"Better get out of here sooner rather than later..\"");
        }
      }
    }   
  }
//----------------------------------------------------
  /** Method dealing movement mechanics */
  public static Rooms[] Currloc(Rooms curRoom, Roach Player, Roach Roomholder, Rooms previousloc)
    {
    Rooms[] ans = new Rooms[2];
    
    if (curRoom == Mainrm1) {
      System.out.println("");
      System.out.println("******************************************");
      System.out.println("Currrent location: Meeting Room"); 
      System.out.println("******************************************");
      System.out.println("");
      System.out.println("There are two hallways parting from this room. On your right one hallway reads \"Recreational room\" above it and on the left reads \"Labratory\". A table is centered in the room. Food scattered throughout the table..and A DEAD MARTIAN?! ");
   
      while (curRoom == Mainrm1) {
      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }
  
        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + Mainrm1.inventory);
        }
        else if (userReply.equals("fight dead martian") || userReply.equals("fight martian")) {
          System.out.println("Wait.. did I really just try to FIGHT a corpse.. I must be unwell.");
        }
        else if (userReply.equals("talk to dead martian") || userReply.equals("talk to martian")) {
          System.out.println("Wait.. did I really just try to TALK to a corpse.. I must be unwell.");
        } 
        else if (userReply.equals("help")) {
          help();
        }
        else if (userReply.equals("eat grape")) {
          if (!Player.inventory.contains("Key")) {
            System.out.println("KurK! OW! ...why is there a key in this grape.. guess I'll hold on to it for now");
          Player.inventory.add("Key");
          }
          else {
            System.out.println("Hmm Yum!");
          }
          
        }

        else if (userReply.contains("eat")) {
          permRemoval(curRoom);
        }
        else if (userReply.contains("use mirror")) {
          System.out.println("You are looking rough. Haven't slept in days, hair all over the place, some drool, and definitely dark circles. It looks like you're barely hanging in there, might as well become an humanoid, it could be a makeover opportunity");
        }
        else if (userReply.contains("take mirror")) {
          System.out.println("Too heavy to take..");
        }
        else if (userReply.contains("take dead martian") || userReply.contains("take martian") ) {
          System.out.println("Attempting to carry the deceased martian. As you begin to pick it up you notice that there are a variety of bodily fluids left beneath where the martian was and you immidiately drop them back into place because ewww.");
        }  
        else if (userReply.contains("push dead martian") || userReply.contains("push martian")) {
          if (Roomholder.inventory.contains("pushed")){
            System.out.println("Getting ready to shove the martian again you stop yourself in your tracks.. Did I really try and to push the martian corpse again.. I must be unwell.");
          }
          else {
            System.out.println("Congratualations, you've just disturbed the peace of a dead defenseless martian and something falls out of their pocket in the process. You have just received sepcial access to a room with this card, good luck!");
            System.out.println("Obtained KeyCard.");
          Player.inventory.add("KeyCard");
          Roomholder.inventory.add("pushed"); 
          }
        }
        else if (userReply.contains("take")||userReply.contains("drop")) {
          pdObjs(curRoom,Player);
        } 
        else if (userReply.contains("leave kid")||userReply.contains("abandon")) {
          rleavekid(curRoom,Player);
        } 
        else if (userReply.contains("take kid")) {
          pdObjs(curRoom,Player);
        }
        else if (userReply.equals("go left")) { //goes to left room
          
          previousloc = Mainrm1;
          curRoom = Leftrm1;
        }   
        else if (userReply.equals("go right")) { //goes to right room
          
          previousloc = Mainrm1;
          curRoom = Rightrm1;
        }
        else if (userReply.equals("go back")) { //goes back to previous room
          
          if (previousloc == Mainrm1) {
            System.out.println("Wait where was I going back..?");
          }
          else {
            
            Rooms holder = curRoom;
            curRoom = previousloc;
            previousloc = holder;
          }
        }         
        else {
          System.out.println("Action not possible..");
        }
      }
    }

 //----------------------------------------------------     
    else if (curRoom == Rightrm1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: Recreational Room");
      System.out.println("******************************************");
      System.out.println("");      
      if (!Roomholder.inventory.contains("vRightrm")){
          System.out.println("The Recreational Room.. The room is painted in a sad gray color fitting for such an empty room. To the left you notice a hallway leading to the \"Meeting Room\" the sign beside it read, stairs leading up somewhere and a janky looking elevator that you might be able to use?");
        System.out.println("");
        System.out.println("As soon as you walk in you make eye contact with what looks like a small kid. As soon as the kid realizes that you are in front of them, they lunge at you and cling to you crying. You quickly take a step back away from the Poor kid and they began to cry harder.");
          Roomholder.inventory.add("vRightrm");
        }
      else {
        if (!Roomholder.inventory.contains("kidkey")){
          System.out.println("Entering back into the Recreational Room.. the room is painted in a sad gray color fitting for such an empty room. To the left is a hallway leading to the \"Meeting Room\" the sign beside it read, stairs leading up somewhere and a janky looking elevator you might be able to use?");
          System.out.println("...");
          System.out.println("The feeling of eyes staring at you are on the back of your head is prominent... The kid stares teary eyed at you. \"What a sore eye..\" you mumble..");
        }
        else {
          if (Roomholder.inventory.contains("kidkey")){
            System.out.println("Entering back into the Recreational Room.. you look at the spot the kid stood at where you first met them.. What a shame but then again you weren't taking chances. To the left is a hallway leading to the \"Meeting Room\" the sign beside it read, stairs leading up somewhere and a janky looking elevator you might be able to use?");
          }
          else {
          System.out.println("Entering back into the Recreational Room.. To the left is a hallway leading to the \"Meeting Room\" the sign beside it read, stairs leading up somewhere and a janky looking elevator you might be able to use?");
          }
        }  
      }
      
      while (curRoom == Rightrm1) {
      
      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }
        else if (userReply.equals("help")) {
          help();
        }
        else if (userReply.equals("talk to kid") || userReply.equals("talk to child")) {
          if (Player.inventory.contains("kid")){
            System.out.println("\"thwank you..\" the kid sniffles..");
          }
          else {
            System.out.println("\"WUahhhAh.. plwease hurlp me. I wan aray and I'm scured. Teake me wit you plwease...\"");
          }
        }            
        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + curRoom.inventory);
        } 
        else if (userReply.equals("fight kid")|| userReply.equals("fight child")) {
          System.out.println("Come on you know better now..");
        } 
        else if (userReply.equals("take kid") || userReply.equals("grab kid") || userReply.equals("grab child")|| userReply.equals("take child") ) {
          System.out.println("You take the kid..");
          Player.inventory.add("kid");
          Roomholder.inventory.add("kidkey");
          Rightrm1.inventory.remove("kid");
        }    

        else if (userReply.equals("leave kid")|| userReply.equals("leave child")) {
          System.out.println("You leave the kid..");
          if (Player.inventory.contains("kid")) {
            Rightrm1.inventory.add("kid");
            Player.inventory.remove("kid");
          }
        }    
       
        else if (userReply.equals("go back")) { //goes to previous room
          Rooms holder = curRoom;
          curRoom = previousloc;
          previousloc = holder;
        }    

        else if (userReply.equals("go left")) { //goes to main room
          
          previousloc = Rightrm1;
          curRoom = Mainrm1;
        } 
        else if (userReply.equals("use elevator")) { //goes to elevator  
          if (Player.inventory.contains("KeyCard")) {
            System.out.println("Bleep...You went into the Elevator");
          previousloc = Rightrm1;
          curRoom = Basementrm1;
          }
          else {
            System.out.println("Hmm.. looks like I need a keyCard... Maybe I can push that dead Martian and see what they have..");
          }
        }     
        else if (userReply.equals("go up")) { //up the stairs to SecondFlrrm1
          
          previousloc = Rightrm1;
          curRoom = SecondFlrrm1;
        }
        else {
          System.out.println("Action not possible..");
        }
      }
    }

//----------------------------------------------------      
    else if (curRoom == Leftrm1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: Labratory Room");
      System.out.println("******************************************");
      System.out.println("");

      if (!Roomholder.inventory.contains("vLeftrm")){
        System.out.println("Entering the Labratory you are meet with a brightly lit room. There are random objects around the room. The shiniest rhinestones you've ever seen, some random food scattered around, and a pile of clothes stinking up the room from the distant corner that it is at. You notice  stairs leading to a locked room and on the right a hallway leading to \"Meeting Room\" the sign read beside it..");
        Roomholder.inventory.add("vLeftrm");
      }
      else {
        System.out.println("Entering the Labratory you are meet with a brightly lit room. You notice  stairs leading to a locked room and on the right a hallway leading to \"Meeting Room\" the sign read beside it..");
      }
      
      while (curRoom == Leftrm1) {

      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }

        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + curRoom.inventory);
        }
        else if (userReply.equals("help")) {
          help();
        }
          
        else if (userReply.contains("eat")|| userReply.contains("drink")) {
          permRemoval(curRoom);
        }
        else if (userReply.contains("take")||userReply.contains("drop")) {
          pdObjs(curRoom,Player);
        }
        else if (userReply.contains("leave kid")||userReply.contains("abandon")) {
          rleavekid(Leftrm1,Player);
        } 
        else if (userReply.contains("take kid")) {
          pdObjs(Leftrm1,Player);
        }          

        else if (userReply.equals("go back")) { //goes back to previous room
          
          Rooms holder = curRoom;
          
          curRoom = previousloc;
          previousloc = holder;
        }
        else if (userReply.equals("go right")) { //goes to main room w/o back
          
          previousloc = Leftrm1;
          curRoom = Mainrm1;
        }
        else if (userReply.equals("go down")) { //goes down to locked room 
          if (Player.inventory.contains("Key")) {
            curRoom = Lockedrm1;
          }
          else {
            System.out.println("Hmm.. looks like I need a key.");
          }
        }
        else {
          System.out.println("Action not possible..");
        }
      }
    }


//----------------------------------------------------     
    else if (curRoom == SecondFlrrm1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: Homey Room");
      System.out.println("******************************************");
      System.out.println("");
      if (!Roomholder.inventory.contains("vSecondFlrrm")){
        System.out.println("You haven't really had a chance to fully process and understand your surroundings. Upon entering this room you notice a homey atmosphere in this room... You come across some limes and are brought back to reality. Limes are the most normal thing I have seen here.. There's also a couple of other familiar objects throughout the room. There are stairs leading down back to the Recreational Room, a disheveled looking room towards the right, and a tunnel leading off somewhere on your left leading you to what the sign says above \"Humanoid Lab..\" it read. ");
        Roomholder.inventory.add("vSecondFlrrm");
      }
      else {
        System.out.println("Back into the homey room... There are stairs leading down to the Recreational Room, a disheveled looking room towards the right, and a tunnel on your left leading you to what the sign says above \"Humanoid Lab...\" it read. ");
      }
      while (curRoom == SecondFlrrm1) {

      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }

        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + curRoom.inventory);
        }
        else if (userReply.equals("help")) {
          help();
        }
        else if (userReply.contains("eat")) {
          permRemoval(SecondFlrrm1);
        }
        else if (userReply.contains("use keyboard")) {
          System.out.println("\"Clunkk click clack..\"");
        }
          
        else if (userReply.contains("take")||userReply.contains("drop")) {
          pdObjs(SecondFlrrm1,Player);
        }
        else if (userReply.contains("leave kid")||userReply.contains("abandon")) {
          rleavekid(SecondFlrrm1,Player);
        } 
        else if (userReply.contains("take kid")) {
          pdObjs(SecondFlrrm1,Player);
        } 

        else if (userReply.equals("go back")) { // goes back to previous room 
          
          Rooms holder = curRoom;
          curRoom = previousloc;
          previousloc = holder;
        }    
        else if (userReply.equals("go left")) { //goes to humanoid room
          
          previousloc = SecondFlrrm1;
          curRoom = Humanoidrm1;
        }
        else if (userReply.equals("go right")) { //goes to dishevled room
          
          previousloc = SecondFlrrm1;
          curRoom = Disheveledrm1;
        } 
        else if (userReply.equals("go up")) { //goes to penthouse room
          
          previousloc = SecondFlrrm1;
          curRoom = Penthouse1;
        } 
        else if (userReply.equals("go down")) { //goes to Right room
          
          previousloc = SecondFlrrm1;
          curRoom = Rightrm1;
        } 
        else {
          System.out.println("Action not possible..");
        }
      }
    }
  
//----------------------------------------------------     
    else if (curRoom == Humanoidrm1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: Humanoid Room");
      System.out.println("******************************************");
      System.out.println("");

    if (!Roomholder.inventory.contains("vHumanoidrm")){
        System.out.println("Upon entering the first thing you notice is a collection of terrifiying looking beings throughout the room incased in sleeping pods. They don't seem to be sentient but they are everywhere, They look close to a human but you know they certainly aren't... There seems to be some food around, most likely for them. On the right a tunnel leads back to the homey room and to the left an ominous wooden door stands there.");
        Roomholder.inventory.add("vHumanoidrm");
      }
      else {
        System.out.println("Ughdhsjdshj this room is terrifiying... I gotta stop going in here. On the right a tunnel leads back to the homey room and to the left an ominous wooden door stands there.");
      }
      while (curRoom == Humanoidrm1) {

      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }
        else if (userReply.equals("help")) {
          help();
        }
        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + curRoom.inventory);
        }
        else if (userReply.equals("drink poison")) {
          System.out.println("The room begins to wobble.. \"Now why did you think this was a good idea a voice whispers.. \"");
          curRoom = Dead;
        }   
        
        else if (userReply.contains("take")||userReply.contains("drop")) {
          pdObjs(Humanoidrm1, Player);
        }
          
        else if (userReply.contains("eat")|| userReply.contains("drink")) {
          permRemoval(Humanoidrm1);
        }
        else if (userReply.contains("leave kid")||userReply.contains("abandon")) {
          rleavekid(Humanoidrm1,Player);
        } 
        else if (userReply.contains("take kid")) {
          pdObjs(Humanoidrm1,Player);
        }                     

        else if (userReply.equals("go back")) { // goes back to previous room 
          
          Rooms holder = curRoom;
          curRoom = previousloc;
          previousloc = holder;
        }    
        else if (userReply.equals("go right")) { //goes to Second Room Floor
          
          previousloc = Humanoidrm1;
          curRoom = SecondFlrrm1;
        } 
        else if (userReply.equals("go left")) { //goes to History Room
          
          previousloc = Humanoidrm1;
          curRoom = Historyrm1;
        } 
        else {
          System.out.println("Action not possible..");
        }
      }
    }
  
//----------------------------------------------------     
    else if (curRoom == Historyrm1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: History Room");
      System.out.println("******************************************");
      System.out.println("");
 
      if (!Roomholder.inventory.contains("vHistoryrm")){
          System.out.println("Entering the room you are hit with the scent of some sort of aroma that smells sweet and famailar... Scanning quickly around the room a desk sat towards the center. A half drunken caramel iced cofee sits on the desk and a bunch of documents it seems. It looks like you could learn about what's going on by reading some of them. There seems to be some information around. On the right stands the doorway you came from.");
          Roomholder.inventory.add("vHistoryrm");
        }
      else {
        System.out.println("\"Man...this place reminds me of my principals office..\" You mumble to yourself. On the right stands the doorway back to that lab.");
      }
      while (curRoom == Historyrm1) {

      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }
        else if (userReply.contains("read new mars map")) {
      System.out.println("You look hungrily for tips on your escape. The map contains an image of a deserted land, displaying a vast land covered in orange sand, there seems to be nothing but sand. Scanning the map you attempt to read weird symbols but at last you are unable to decipher it. Your heart sinks as you realize the gravity of your current situation");
    }
      else if (userReply.contains("read historical document")) {
        System.out.println("Mars Martian Galatical Station Founded in 2050. The creation of cities in Mars are rapidly growing as Earths resources are running scarce. Humans left behind on Earth are hanging on by a thread, from just a dollar a day for a living. We are telling you by importing your own human today you can save them from themselves by turning them into a humanoid. How about it fellow Martians?");
      }
      else if (userReply.contains("turn on radio")||userReply.contains("turn radio on")||userReply.contains("play radio")) {
        System.out.println("It begins blasting the loudest static noise you have ever heard. Right now is not the time. You quickly turn down the volume and notice bursts of coherant phrases including, \"-mission almost complete-\" \"-Earth 80% destroyed-\" \"-humans will be new and improved-\" \"-there is nothing superior to Martians-\" before it turns to dead silence, turning itself off. You get a shiver down your spine");
      }
        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + curRoom.inventory);
        } 
        else if (userReply.equals("help")) {
          help();
        }
        else if (userReply.contains("eat") || userReply.contains("drink")) {
          permRemoval(Historyrm1);
        }
        else if (userReply.contains("open")||userReply.contains("close")) {
          opClobj();
        }

        else if (userReply.contains("take")||userReply.contains("drop")) {
          pdObjs(Historyrm1, Player);
        }
        else if (userReply.contains("leave kid")||userReply.contains("abandon")) {
          rleavekid(Historyrm1,Player);
        } 
        else if (userReply.contains("take kid")) {
          pdObjs(Historyrm1,Player);
        }
                            
        else if (userReply.equals("go back")) { // goes back to previous room 
          
          Rooms holder = curRoom;
          curRoom = previousloc;
          previousloc = holder;
        }    
        else if (userReply.equals("go right")) { //goes to Humanoid Room
          
          previousloc = Historyrm1;
          curRoom = Humanoidrm1;
        } 
        else {
          System.out.println("Action not possible..");
        }
      }
    }  
 
//----------------------------------------------------     
    else if (curRoom == Disheveledrm1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: Dishevled Room");
      System.out.println("******************************************");
      System.out.println("");      

      if (!Roomholder.inventory.contains("vDisheveledrm")){
          System.out.println("Upon entering this room you whip the door open and dust from the ceiling falls on your head.. This room is a mess. Things scattered everywhere. Humanoids seem to have no regard for organization. With darting eyes you take a peek at an oil painting that reads \"I love our overlord \"... which we might just have to move painting since it's terrifying to keep looking at. To your left a doorway back to the homey room stands and a closet is tucked between the corner of the room.");
          Roomholder.inventory.add("vDisheveledrm");
        }
      else {
        System.out.println("Back in this messy room. You notice rats running about. To your left a doorway stands back to the homey room.");
      }
      while (curRoom == Disheveledrm1) {

      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }
        else if(userReply.contains("read flyer")) {
          System.out.println("The flyer contains an ad that proposes why you should turn into a humanoid. It claims life is just easier that way!");
        }
        else if(userReply.contains("move painting")){
          System.out.println("As soon as you take the painting you see a message written behind it. The folllowing meesage reads \"Get out as soon as you can. So far I've heard from the others that there is a way out somewhere in the basement. I don't think that I will be making it far. I am too injured for that, just please do not stop trying\" You dont know what to make of this message. You place the painting back");
          }
        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + curRoom.inventory);
        }
        else if (userReply.contains("leave kid")||userReply.contains("abandon")) {
          rleavekid(Disheveledrm1,Player);
        } 
        else if (userReply.contains("take kid")) {
          pdObjs(Disheveledrm1,Player);
        }           
        else if (userReply.equals("help")) {
          help();
        }      
        else if(userReply.contains("open closet")){
          System.out.println("Opening the closet you see the following items: "+ Closet1.inventory);
          while(!Roomholder.inventory.contains("closet")){
            userReply = myObj.nextLine();
            userReply = userReply.toLowerCase();
            System.out.println(" ");
            if (userReply.contains("take")||userReply.contains("drop")) {
          pdObjs(Closet1, Player);
            }

            else if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
            }
              
            else if (userReply.equals("check closet")) {
          System.out.println("Closet: " + Closet1.inventory);
            }
            else if(userReply.contains("close closet")) {
              System.out.println("You closed the closet");
              Roomholder.inventory.add("closet");
            }
            else {
          System.out.println("Action not possible.. Make sure to close the closet when finished.");
        }
          }
          Roomholder.inventory.remove("closet");
          }
        else if (userReply.contains("open")||userReply.contains("close")){
          opClobj();
        }
        
        else if (userReply.contains("take")||userReply.contains("drop")) {
          pdObjs(Disheveledrm1, Player);
        }
        else if (userReply.equals("go back")) { // goes back to previous room 
          
          Rooms holder = curRoom;
          curRoom = previousloc;
          previousloc = holder;
        }    
        else if (userReply.equals("go left")) { //goes to Second Room Floor
          
          previousloc = Disheveledrm1;
          curRoom = SecondFlrrm1;
        } 
        else {
          System.out.println("Action not possible..");
        }
      }
    }  
  
//----------------------------------------------------     
    else if (curRoom == Penthouse1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: Penthouse");
      System.out.println("******************************************");
      System.out.println("");  
      
      if (!Roomholder.inventory.contains("vPenthouse")){
        if (Player.inventory.contains("kid")){
          System.out.println("As you go up the stairs you hear a commotion. Standing by the stairs you notice that the penthouse is packed with humans? They just seem to be chatting... They are behaving strangely however.. kinda sus you think. Should I try talking to the humans for help? tugging on your sleeve is the kid. Kinda forgot they were there.. \"We should leave.. I have a bad feeling about this..\" the kid frantically whispers. To your side a trash chute exist..");
          }
        else {
          System.out.println("As you go up the stairs you hear commotion. Standing by the stairs you notice that the penthouse is packed with humans? They just seem to be chatting... They are behaving strangely however.. kinda sus you think. Should I try talking to the humans for help? To your side a trash chute exist..");
        }
          Roomholder.inventory.add("vPenthouse");
        }
      else {
        if (Player.inventory.contains("kid")){
          System.out.println("Standing by the stairs the people still seem to not notice you... They just seem to be chatting... \"We should leave.. I have a bad feeling about this.. \" the kid frantically whispers. To your side a trash chute exist..");
          }
        else {
          System.out.println("Standing by the stairs the people still seem to not notice you... To your side a trash chute exist..");
        }
      }
      while (curRoom == Penthouse1) {

      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }

        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + curRoom.inventory);
        } 
        else if (userReply.equals("help")) {
          help();
        }
        else if (userReply.contains("leave kid")||userReply.contains("abandon")) {
          rleavekid(Penthouse1,Player);
        } 
        else if (userReply.contains("take kid")) {
          pdObjs(Penthouse1,Player);
        }
          
        else if (userReply.equals("talk to humans")) {
          System.out.println("\"I love our overlord.. overlord is great.. overlord is life..\" mumbled the humans. Whipping their heads towards you they grab you into their mosh pit..");
          curRoom = Dead;
        } 
        else if (userReply.equals("go back")) { // goes back to previous room 
          
          Rooms holder = curRoom;
          curRoom = previousloc;
          previousloc = holder;
        }    
        else if (userReply.equals("go down")) { //goes to Second Room Floor
          
          previousloc = Penthouse1;
          curRoom = SecondFlrrm1;
        } 
        else if (userReply.equals("use trash chute")) { //Goes to Main room      
          System.out.println("Opening up the trash chute you dive straight down the tight tunnel. THUnk.. THUmP.. CLUNK... You land back in the meeting room. Looking up you notice the vent that was once there is broken..");
          previousloc = Mainrm1;
          curRoom = Mainrm1;
        } 
        else {
          System.out.println("Action not possible..");
        }
      }
    }    

//----------------------------------------------------     
    else if (curRoom == Basementrm1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: Basement room");
      System.out.println("******************************************");
      System.out.println("");        
      if (!Roomholder.inventory.contains("vBasementrm")){
          System.out.println("The elevator brings you down and the doors open up to a typical unfinished basement... dead plants sat in a corner and chipped gnomes. Stepping out a \"AHASHUHCK\" A SPIDER SWINGS IN ON YOUR FACE. After wiping your face clean you notice a staircase leading down somwehere, the elevator you came from, a tunnel leading to the right somewhere and a moldy wet slide going down somewhere else...?");
          Roomholder.inventory.add("vBasementrm");
        }
      else {
        System.out.println("Stepping back in a \"AHASHUHCK\" A SPIDER SWINGS IN ON YOUR FACE AGAIN. \"What is with the SPIDERS!?\"After wiping your face clean you notice a staircase leading down somwehere, an elevator going back up, a tunnel leading to the right and a moldy wet slide going down somewhere.");
      }
      while (curRoom == Basementrm1) {

      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }

        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + curRoom.inventory);
        } 
        else if (userReply.equals("help")) {
          help();
        }
        else if (userReply.contains("leave kid")||userReply.contains("abandon")) {
          rleavekid(Basementrm1,Player);
        } 
        else if (userReply.contains("take kid")) {
          pdObjs(Basementrm1,Player);
        }
        
        else if (userReply.equals("fight spider")) {
          System.out.println("You swing at the spider but it shoots its web on your face and crawls away...");
        }           
        else if (userReply.contains("take")||userReply.contains("drop")) {
          pdObjs(Basementrm1, Player);
        }
          
        else if (userReply.equals("go back")) { // goes back to previous room 
          Rooms holder = curRoom;
          curRoom = previousloc;
          previousloc = holder;
        }
        
        else if (userReply.equals("go right")) { //goes to North1rm
          
          previousloc = Basementrm1;
          curRoom = North1rm1;
        }
        else if (userReply.equals("go down")) { //goes to East1rm
          
          previousloc = Basementrm1;
          curRoom = East1rm1;
        }
        else if (userReply.equals("use slide") || userReply.equals("slide down")) { //goes to South1rm
          
          previousloc = South1rm1;
          curRoom = South1rm1;
        }          
        else if (userReply.equals("use elevator")) { //goes to Right Room  
          if (Player.inventory.contains("KeyCard")) {
            System.out.println("Bleep... You went into the Elevator");
            previousloc = Basementrm1;
            curRoom = Rightrm1;
          }
          else {
            System.out.println("Hmm.. looks like I need a keyCard.");
          } 
        } 
        else {
          System.out.println("Action not possible..");
        }
      }
    }      

//----------------------------------------------------     
    else if (curRoom == North1rm1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: Living Quarters");
      System.out.println("******************************************");
      System.out.println("");         
      if (!Roomholder.inventory.contains("vNorth1rm")){
        System.out.println("Going through the twisty tunnel you stumble into a yellow soft lit room. \"Once a bandle gunner.. ALWAYS a bandle gunner!\" shouted from what looks like a pc? Hmm I wonder what kinda specs it has.. This room seems to be some sort of living quarter? Scanning around you notice tables and chairs scattered around. Towards the right on a door it reads \"POGCHAMPS ONLY!\", to the left is the doorway back to the basement");
          Roomholder.inventory.add("vNorth1rm");
        }
      else {
        System.out.println("Going through the twisty tunnel you stumble back into the living quarters. Towards the right on a door it reads \"POGCHAMPS ONLY!\", to the left is the doorway back to the basement");
      }
      while (curRoom == North1rm1) {

      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }

        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + curRoom.inventory);
        }
        else if (userReply.equals("help")) {
          help();
        }  
        else if (userReply.contains("leave kid")||userReply.contains("abandon")) {
          rleavekid(North1rm1,Player);
        } 
        else if (userReply.contains("take kid")) {
          pdObjs(North1rm1,Player);
        }
        else if (userReply.equals("use pc")) {
          System.out.println("The pc is running League of Legends! \"Whats the harm in playing one game..\"... \"DEFEAT\" \"Well...I never really liked this game anyways..\"");
        }
        else if (userReply.equals("use tv")) {
          System.out.println("Careful because you just turned it on but it is also a Martian tv. What if it alerts them.. You turn it off.");
        }
        else if (userReply.equals("use playstation")) {
          System.out.println("Is this really a playstation 60? I could've sworn the playstation 5 just came out last year...");
        } 
          
        else if (userReply.contains("sit")){
          chill();
        }

        else if (userReply.equals("go back")) { // goes back to previous room 
          
          Rooms holder = curRoom;
          curRoom = previousloc;
          previousloc = holder;
        }    
        else if (userReply.equals("go left")) { //goes to Basement room
          
          previousloc = North1rm1;
          curRoom = Basementrm1;
        } 
        else if (userReply.equals("go right")) { //goes to North2 room
          
          previousloc = North1rm1;
          curRoom = North2rm1;
        } 
        else {
          System.out.println("Action not possible..");
        }
      }
    }  


//----------------------------------------------------     
    else if (curRoom == East1rm1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: Kitchen");
      System.out.println("******************************************");
      System.out.println("");       
     
      if (!Roomholder.inventory.contains("vEast1rm")){
          System.out.println("You seem to have problems. Coming in here might have been a bad idea...");
          System.out.println("You see a guard sleeping to the right next to a doorway. Seems like something important is there... But to get there you have to pass the guard or take them out? Looking around you notice that you're in some sort of kitchen area? Now why is there a guard in a kitchen... Remember the stairs back up is always an option..");
          Roomholder.inventory.add("vEast1rm");
        }
      else {
        if (Roomholder.inventory.contains("pass")){
          System.out.println("Good thing that Guard is gone. Too bad about them though HAH.");
        }
        else{
           System.out.println("The guard is still sleeping well. That doorway to the right must be important.. There is a staircase leading up.");
        }
      }
          
      while (curRoom == East1rm1) {

      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }
        else if (userReply.equals("help")) {
          help();
        }  
        else if (userReply.contains("leave kid")||userReply.contains("abandon")) {
          rleavekid(East1rm1,Player);
        } 
        else if (userReply.contains("take kid")) {
          pdObjs(East1rm1,Player);
        }
        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + curRoom.inventory);
        } 
        else if (userReply.equals("help")) {
          help();
        }  

        else if (userReply.contains("open")||userReply.contains("close")){
          opClobj();
        }
        else if (userReply.contains("eat") || userReply.contains("drink")|| userReply.contains("consume")) {
          permRemoval(East1rm1);
        }       
        else if (userReply.contains("take")||userReply.contains("drop")) {
          pdObjs(East1rm1, Player);
        }          
        else if (userReply.equals("go back")) { // goes back to previous room 
          
          Rooms holder = curRoom;
          curRoom = previousloc;
          previousloc = holder;
        }    
        else if (userReply.equals("go up")) { //goes to Basement Room
          
          previousloc = East1rm1;
          curRoom = Basementrm1;
        } 
        else if (userReply.equals("go right")) { //goes to East2 Room
          if (Roomholder.inventory.contains("pass")){
            System.out.println("U went right");
          previousloc = East1rm1;
          curRoom = East2rm1;
          }
          else {
            System.out.println("Can't and won't. If that guard wakes up they would deck me in the face.");
          }
        } 
          
        else if (userReply.equals("fight guard")) { //goes to East2 Room
          if (Roomholder.inventory.contains("pass")) {
            System.out.println("Did you forget they ran off..?");
          }
            while (!Roomholder.inventory.contains("pass")) {
                System.out.println("Hmm what can I use..?");
            userReply = myObj.nextLine();
            userReply = userReply.toLowerCase();
            System.out.println(" ");          
            if (userReply.equals("use acid")) {
              if (Player.inventory.contains("acid")) {
                System.out.println("You throw acid on the guards face.. the guard screams in agony and runs past you up the stairs.. You take your chance to run into the next room.");
                System.out.println("");
          Player.inventory.remove("acid");
          Roomholder.inventory.add("pass");
          previousloc = East1rm1;
          curRoom = East2rm1;
              }
              else {
                System.out.println("What acid..? Let's fight them when we actually have some... Maybe I'll run away and find some.");
                System.out.println("");
              }
              
            }
            else if (userReply.equals("run away")){
              System.out.println("You scurry away back upstairs..");
              previousloc = East1rm1;
              curRoom = Basementrm1;
              break;
            }
            else if (userReply.equals("use knife")) {
              if (Player.inventory.contains("knife")) {
                System.out.println("You swing at the defenseless guard.. you manage to stab the guard in their knee. The Guard howls in pain. \"POW\" The Guard gets up and decks you in the face.. Dazed for a second you resume your stance and slice the guards eyes. the guard screams in agony and runs past you up the stairs.. You take your chance to advance into the next room.");
              System.out.println("");
          Roomholder.inventory.add("pass");
          previousloc = East1rm1;
          curRoom = East2rm1;
              }
              else {
                System.out.println("A knife would be nice. Let's fight them when we actually have one... Maybe I'll run away and fine one.");
                System.out.println("");
              }
            }
            else if (userReply.equals("use box cutter")) {
              if (Player.inventory.contains("box cutter")) {
                System.out.println("Really.. a box cutter? well alright... Maybe I'll run away and fine one.");
                System.out.println("You creep up to the guard. You then take a swing at the defenseless guard.. you manage to stab the guard on the side of the neck. The Guard howls in pain as blood gushes from their neck. \"Blood? are they human.?\" \"POW\" The Guard gets up and decks you in the face.. Dazed for a second you resume your stance and slice the guards eyes. the guard screams in agony and runs past you up the stairs.. You take your chance to advance into the next room.");
                Roomholder.inventory.add("pass");
                previousloc = East1rm1;
                curRoom = East2rm1;
              }
              else {
                System.out.println("What box cutter..? Let's fight them when we actually have one... Maybe I'll run away and fine one.");
                System.out.println("");
              }
            }   
            else {
              System.out.println("\"Can't use this.. Let's fight them when we actually have something... Maybe I'll run away and find something.");
            }
          }
        } 
        else {
          System.out.println("Action not possible..");
        }
      }
    } 

//----------------------------------------------------     
    else if (curRoom == South1rm1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: ??? Room");
      System.out.println("******************************************");
      System.out.println(""); 
      
      if (!Roomholder.inventory.contains("vSouth1rm")){
          System.out.println("Sliding down the moldy slide you land hard on your side. Looking back up you try and climb the slide. Nope no luck it is too slipery. Maybe don't take just any random slides... Should've thought that one through. You notice you are in a musty dimly lit room... Once your vision finally renders the room you notice a big cage with a SKELETON IN IT! \"I gotta get out of here.. chills literal chills\" You mumble and take a breather. You notice there seems to be small alley on the right standing menacingly...");
          Roomholder.inventory.add("vSouth1rm");
        }
      else{
        System.out.println("Idk why I'm in here again.. chills literal chills man. The alley on the right still stands menacingly... ");
      }
      while (curRoom == South1rm1) {

      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }

        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + curRoom.inventory);
        }
        else if (userReply.equals("help")) {
          help();
        }  
        else if (userReply.contains("leave kid")||userReply.contains("abandon")) {
          rleavekid(South1rm1,Player);
        } 
        else if (userReply.contains("take kid")) {
          pdObjs(South1rm1,Player);
        }                  
        else if (userReply.contains("take")||userReply.contains("drop")) {
          pdObjs(South1rm1, Player);
        }

        else if (userReply.contains("open")||userReply.contains("close")){
          opClobj();
        }

        else if (userReply.equals("go back")) { // goes back to previous room
          if (previousloc == South1rm1) {
            System.out.println("You can't go back up it is too slippery."); 
          }
          else {
            Rooms holder = curRoom;
            curRoom = previousloc;
            previousloc = holder;
          }
        }    
        else if (userReply.equals("go right")) { //goes to East1 Room
          
          previousloc = South1rm1;
          curRoom = East1rm1;
        } 
        else {
          System.out.println("Action not possible..");
        }
      }
    }       

//----------------------------------------------------     
    else if (curRoom == North2rm1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: Overlords ManCave");
      System.out.println("******************************************");
      System.out.println("");       
      if (!Roomholder.inventory.contains("vNorth2rm")){
          System.out.println("Opening the door you are faced to face with a terrifying looking Martian. You let it speak and act as careful as you possibly can");
        System.out.println("");
          Roomholder.inventory.add("vNorth2rm");
        }
      while (curRoom == North2rm1) {
        
        System.out.println("\"Well well well... What's a puny human doing here.. \" The door shuts tightly behind you. Behold you are standing face to face with the Overlord of the martians! \"Hmm.. Should I have a yummy snack today or..\" The Overlord creepily snickers.. ");
        System.out.println("");
        if (Player.inventory.contains("kid")){
          System.out.println("\"Ohoh HO? now why don't you let me have that kid there instead and how about I let you go? I may be THEE Overlord but I know how to make fair trades. Well yes or no?\""); 
          System.out.println("");
        userReply = myObj.nextLine();
        userReply = userReply.toLowerCase();
        System.out.println(" ");          
          if (userReply.equals("yes")) {
            System.out.println("\"Smart choice..\" the Overlord does not hesitate and snatches the kid from your side proceeding to gobble it down its throat.. ");
            System.out.println("");
            System.out.println("\"It's rude to stare.\" The Overlord smacks you with its toe and the room goes black.. Awaking you seem to find yourself back in the Meeting room..");
            System.out.println("");
            Player.inventory.remove("kid");
            previousloc = Mainrm1;
            curRoom = Mainrm1;
          }
          else {
            System.out.println("\"Hmm.. How bold guess you both want to die..\"");
            curRoom = Dead;
          }   
        }
        else {
          System.out.println("\"Hmm... nah, I'm hungry.. Come to papi's tummy!\"");
          curRoom = Dead;
        }
      }
    } 

//----------------------------------------------------     
    else if (curRoom == East2rm1) {
      System.out.println("******************************************");
      System.out.println("Currrent location: Martian Scientist Lab");
      System.out.println("******************************************");
      System.out.println("");       

      System.out.println("You enter into what looks like a Scientist Lab. \"Hummmmm.. Beep.. Hummmm.. \" There's machinary placed around the room. Scanning the room you notice a sign above a door with out a handle that reads \"Escape Pods\"");
      System.out.println("...");
      System.out.println("Well that was easy.. scanning the room you notice a red button on the opposite side of the locked door. The button has a note next to it that reads \"Button to open door..\"");
      System.out.println("...");
      System.out.println("Uh maybe not so easy.. to the left the doorway leading to the kitchen stands.");
      while (curRoom == East2rm1) {

      userReply = myObj.nextLine();
      userReply = userReply.toLowerCase();
      System.out.println(" ");
        if (userReply.equals("check inventory")) {
          System.out.println("Inventory: " + Player.inventory);
        }

        else if (userReply.equals("check room")) {
          System.out.println("Room Items: " + curRoom.inventory);
        } 
        else if (userReply.equals("help")) {
          help();
        }          
        else if (userReply.contains("leave kid")||userReply.contains("abandon")) {
          rleavekid(East2rm1,Player);
        } 
        else if (userReply.contains("take kid")) {
          pdObjs(East2rm1,Player);
        }
        else if (userReply.equals("go back")) { // goes back to previous room 
          
          Rooms holder = curRoom;
          curRoom = previousloc;
          previousloc = holder;
        }    
        else if (userReply.equals("go left")) { //goes to East1 room
          
          previousloc = East2rm1;
          curRoom = East1rm1;
        } 
        else if (userReply.equals("use button")) { //goes to South2 room       
          System.out.println("The door opens.. but as soon as I let go it closes..");
          System.out.println("Maybe if I had something to hold it down..");
        }
        else if (userReply.equals("use machinary")) { //goes to South2 room       
          System.out.println("Beep Beep..");
        }
        
        else if (userReply.equals("use kid")|| userReply.equals("grab child")) { //goes to South2 room
          if (Player.inventory.contains("kid")) {
            System.out.println("\"Hey Kid.. let's play a game. You stand here and hold this button and you see those doors over there? I'll go through them and take the candy from there. I'll come back and give it to you. How about that?\" you say. \"CANDY I LOVE CANDY. OKAY!\" the kid gleefully cheers. This didn't feel right but what has to be done has to be done..");
          System.out.println("The door opens and you walk through the door.. turning back you see the kid still holding the button and smiling and waving. What a naive kid..");
          Roomholder.inventory.add("kidused");
          Player.inventory.remove("kid");  
          previousloc = South2rm1;
          curRoom = South2rm1;
          }
          else {
            System.out.println("That kid..");
          }
        }  
        else if (userReply.equals("use tape")) { //goes to South2 room  
          if (Player.inventory.contains("tape")) {
            System.out.println("Smart! I'm glad I held on to this tape!");
            System.out.println("The door opens and you walk through the doors..");  
            Player.inventory.remove("tape");
            previousloc = South2rm1;
            curRoom = South2rm1;
          }
          else {
            System.out.println("Theres gotta be some around here.."); }
          }           
        else {
          System.out.println("Action not possible..");
        }
      }
    }  

//----------------------------------------------------
    ans[0] = curRoom ;
    ans[1] = previousloc;
    return ans; // end of checking all the rooms
  }
// ---------------------------METHODS---------------------------

  /** Method dealing with player input when looking at objs */
  public static String look() {
  
    if (userReply.contains("window")) {
      System.out.println("Cold, deserted, bleak, there's nothing but vastness, you need to get out!");
    }
    else if (userReply.contains("mirror")) {
      System.out.println("You are lookig rough. Have not slepped in days, hair all over the place, some drool, and definitely dark circles. It looks like you're barely hanging in there, might as well become an humanoid, it could be a makeover opportunity");
    }

    return userReply;
  }

  /** Method dealing with player input when pick uping up and droping objs */
  public static String pdObjs(Rooms r, Roach Player) {

    for (String i: pdObjs){
      if (userReply.contains(i)){
        
        if (r.inventory.contains(i)){
          if (userReply.contains("take") ){
            System.out.println("Obtained "+ i);
            r.inventory.remove(i);
            Player.inventory.add(i);
          }
        }

        else if (userReply.contains("drop")){
          System.out.println("Sucessfully droped "+ i);
          Player.inventory.remove(i);
          r.inventory.add(i);
        }
        else {
          System.out.println("That item does not exist here.");
        }
      }
    }
  return userReply;
}


  /** Method that permanately removes objects from room inventory */
  public static String permRemoval(Rooms r) {
    
    for (String i: permRemoval) {
      
      if(userReply.contains(i)){
        if (r.inventory.contains(i)) {
          if(i.equals("baby humanoid")){
            System.out.println("Oh god.. am I really going to do this.. if thats what the user wants.. I MEAN ME YEAH ME. You begin with the toes and.. I'll leave you to imagine the rest..");
            System.out.println("it is forever gone in your stomach...");
          r.inventory.remove(i);
          }
         else if(i.equals("baby humanoids")){
            System.out.println("It's not happening, I expeted better from you, go back to the main room to think about what you've done and eat a grape or something");
          }
          else {
            System.out.println("it is forever gone in your stomach...");
          r.inventory.remove(i);
          }          
        }
        else {
        System.out.println("Not Possible");
        }
      }
    }
    return userReply;
  }

  /** Method to allow users to sit on objs */
  public static String chill() {
    for (String i:chill){
      if (userReply.contains(i)) {
        System.out.println("Comfortable but maybe you shoud be more focused on leaving -_-");
      }
    }
    return userReply;
  }

  /** Method to allow user to abandon child */
  public static String rleavekid(Rooms r, Roach Player) {
    for (String i:kid){
      if (Player.inventory.contains(i)) {
        System.out.println("Sucessfully abandoned kid, they begin crying immidiately, how could you -_- ");
          Player.inventory.remove(i);
          r.inventory.add(i);
      }
    }
    return userReply;
  }

  
  
  /** Method to open and close objs */
  public static String opClobj(){
    for (String j:opClobj){
      // maybe randomize reply
      if (userReply.contains(j)){
          if(userReply.contains("open desk drawer")){
            System.out.println("Yay it opened");
            System.out.println("There is a historical document and a new mars map in here. This could give you a better idea of your current situation");
          }
          if(userReply.contains("open fridge")){
            System.out.println("It smells awful in there. The contents of the. fridge resmble baby humanoids a little too much, I wouldn't dare consume the baby humanoids -_-");
          }
          if(userReply.contains("kitchen drawer")){
            System.out.println("There is a knife and a scrub daddy in here");
          }

          if(userReply.contains("open big cage")){
            System.out.println("As soon as you open the cage, THUD, the skeleton flops to its side and you can't help but feel like you are in terrible danger.");
          }
      else if(userReply.contains("close")) {
        System.out.println("closed");
        } 
      }   
    }
    return userReply;
  }
  
  /** Method that prints our the commands that users can use */
  public static void help() {
    System.out.println("******************************************");
    System.out.println("Here are the commands! Remember to type help to view again");
    System.out.println("");
    System.out.println("Interact with Object: Take (obj), Open (obj), Close (obj), Leave (obj), Drink (obj), Eat (obj), Drop (obj), Use (obj)");
    System.out.println("");
    System.out.println("To Move: Go right, Go left, Go up, Go down, Go back");
    System.out.println("");
    System.out.println("Actions: Check inventory, Check room");
    System.out.println("");
    System.out.println("Special commands: Read (obj), Push (obj), Fight (obj), Sit on (obj), Talk to (obj), Run away");
    System.out.println("******************************************");
    System.out.println("");
  }

}
// history room on map