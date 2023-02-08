
## Classes we have:

***Main:***

This class is the first class that begins everything. In main the ***Worldbuilder class*** is called.
...........................................................................................................................

***Gameplay:***

This class is in charge of running the game itself. After everthing has finished being created in the ***Worldbuilder class*** this class prints the needed storyline and deals with the users input as well as their actions based on those inputs. This class is the last class called.
...........................................................................................................................

***Rooms:***

This class creates the room objects as well as thir attributes or characteristics like their inventory with the use of arraylists.

POGCHAMPS!!!
...........................................................................................................................

***Worldbuilder:***

This class is in charge of creating and setting up the needed things for the game to function such as the graph, and items as well as each rooms individual inventories by calling the ***Rooms class***. After creating all the necessary objects the ***Gameplay class*** is called.
...........................................................................................................................

***Roach:***

This class creates the player/user objects as well as thir attributes or characteristics like their inventory with the use of arraylists.


## Data structures we used:

Our main data structure we used was graphs. We implemented graphs with java. Some other data structeres we used were arrays and arraylists. Although we probably could've just done arraylists instead of arrays. By using the graphs we created the layout of how our game's map would look. We did not utilize the nodeadjacent methods from guava because we forgot. We started to in the beginning for our core method for movement. We somehow switched over to if else statments that works but the guava methods would've shortened our code for sure. The arraylist created the inventories for the players and rooms and the arrays
held the current room location as well as the previous room location.