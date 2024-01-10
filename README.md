Recreating the popular game of Stick Hero in Java using JavaFX and SceneBuilder. Players can navigate through different platforms through the use of sticks.
Shrutya Chawla 
Prakhar Aggarwal 
Running the program:
The program should be run by going into the directory Stick_Hero in windows terminal
Type
mvn javafx:run
And the program will run
Concepts used:
1. Abstract class : Menu has been made to provide the basic structure to all the menus in the
game
2. Polymorphism:
The load_fxml method returns a value of type Menu which has been typecasted to the
profile_select class( inherits Menu) this has been done wherever we need to use the controller
class of the fxml.
3. Junit testing has been used to test:
● If the program doesn't have a null profile
● Check if no profiles exist(the game has not been played even once)
● Check if the profile is being serialized and deserialized correctly ( the profiles are same
or if there are changes in them)
4. Singleton Design Pattern : The BeginScreen class has been made a Singleton object so as to
ensure that only one Begin Screen can be created. As the other screens can exist in multiple
quantities but the Begin Screen can only be one otherwise multiple games would be created
which is not allowed.
5. Decorator: the StickController2 behaves as a decorator by overriding the Mute method from
the Menu class in order to add the functionality of pausing the sound effects related to growing
of the stick and death.
6. Sound Effects: background sound effects has been added, along with growing of the stick
and when the player dies.
7. A reviving feature has been added which will deduct 2 cherries and start the game again from
the previous current_score again , note that if the number of cherries is less than 2 then this will
not work.
8. Saving profiles: the player can save new profiles and create new files, the respective files will
be read each time the game restarts.
9. MultiThreading: has been done in order to play music in the game.
Note:
● While gaming please do not press on the rectangles
● Sometimes the cherries have the tendency to stick to the walls of the rectangles
Github Link : https://github.com/shrutya22487/Stick_Hero
