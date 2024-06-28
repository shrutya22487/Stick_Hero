# Stick Hero Game
<div style="display: flex; align-items: center;">
  <img src="https://github.com/theshamiksinha/StickHero-Game-JavaFX/raw/main/src/main/resources/Images/StickHeroCharacter.png" alt="StickHero Logo" height="125" style="margin-right: 20px;">
  <span style="font-size: 48px; font-weight: bold;">.   .   .</span>
  <img src="https://github.com/theshamiksinha/StickHero-Game-JavaFX/raw/main/src/main/resources/Images/TitlePNG.png" alt="Title Logo" height="125" style="margin-left: 20px;">
  <span style="font-size: 48px; font-weight: bold;">.   .   .</span>
</div>



## Introduction

Welcome to Stick Hero, an exciting platformer game where you control Stick-Hero, navigating between pillars by extending a stick. Your objective is to collect cherries, reach the destination, and achieve the highest score possible. Embrace the challenge and enjoy the thrilling gameplay!

## Gameplay Showcase

### Images

<div style="display: flex; flex-wrap: wrap; gap: 20px;">

<img src="https://github.com/theshamiksinha/StickHero-Game-JavaFX/raw/main/src/main/resources/Images/gameImage1.png" alt="Gameplay Image 1" width="400">
<img src="https://github.com/theshamiksinha/StickHero-Game-JavaFX/raw/main/src/main/resources/Images/gameImage2.png" alt="Gameplay Image 2" width="400">

</div>

<div style="display: flex; flex-wrap: wrap; gap: 20px;">

<img src="https://github.com/theshamiksinha/StickHero-Game-JavaFX/raw/main/src/main/resources/Images/gameImage3.png" alt="Gameplay Image 3" width="400">
<img src="https://github.com/theshamiksinha/StickHero-Game-JavaFX/raw/main/src/main/resources/Images/gameImage4.png" alt="Gameplay Image 4" width="400">

</div>

<div style="display: flex; flex-wrap: wrap; gap: 20px;">

<img src="https://github.com/theshamiksinha/StickHero-Game-JavaFX/raw/main/src/main/resources/Images/gameImage5.png" alt="Gameplay Image 5" width="400">
<img src="https://github.com/theshamiksinha/StickHero-Game-JavaFX/raw/main/src/main/resources/Images/gameImage6.png" alt="Gameplay Image 6" width="400">

</div>


## Game Mechanics

1. **Stick-Hero Control:** Use keyboard input to stretch out a stick and bridge gaps between pillars.
   
2. **Multiple Pillars:** Navigate Stick-Hero through platforms of varying widths and heights.
   
3. **Reviving Feature:** Collect cherries to revive Stick-Hero once during gameplay. Cherries and related scores are deducted after revival.
   
4. **Timing is Crucial:** Time your stick extension carefully to land on the next platform. Failure results in Stick-Hero falling into the abyss, ending the game.
   
5. **Collect Rewards:** Flip Stick-Hero upside down to collect cherries and increase your score.
   
6. **Scoring System:** Aim for high scores by collecting rewards and challenge yourself to reach the top of the leaderboard.

## How to Play

### Controls

- Use arrow keys or designated keys to control Stick-Hero's movements and stick extension.
- Collect cherries and bridge gaps between platforms to score points and avoid falling into the abyss.

### Download and Setup

To download and play Stick Hero, follow these steps:

#### Prerequisites

1. **Java IDE:** Download and install [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) (or use your preferred Java IDE).
   
2. **JavaFX SDK:** Download the JavaFX SDK from [OpenJFX](https://openjfx.io/) according to your operating system and Java version.

#### Setup Instructions

1. **Clone the Repository:**
   - Open IntelliJ IDEA.
   - Go to `File` -> `New` -> `Project from Version Control` -> `Git`.
   - Enter `https://github.com/shrutya22487/Stick_Hero.git` as the Git repository URL and clone the project.

2. **Configure JavaFX SDK:**
   - Extract the downloaded JavaFX SDK to a preferred location on your computer.
   - Open the cloned project in IntelliJ IDEA.
   - Go to `File` -> `Project Structure` -> `Libraries`.
   - Click on the `+` icon and select `Java`.
   - Navigate to the `lib` folder of your extracted JavaFX SDK and add it as a library.

3. **Run the Game:**
   - In IntelliJ IDEA, open the `Main` class located in the project.
   - Configure the run configuration to specify the `Main` class as the main class.
   - Run the `Main` class to start playing Stick Hero!

#### Concepts used:
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
   

## Contribution

Contributions are welcome! If you have ideas for improvements or new features, feel free to fork the repository and submit a pull request.

## Credits

This game project is developed by Shrutya Chawla and Prakhar Aggarwal, inspired by the original Stick Hero game.
