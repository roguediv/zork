# Zork
roguediv/zork is a text-based game similar to Zork that takes place in medieval times. You are a lawless assassin visiting a castle with a vengeance. You must fit in, accept contracts to make money, and buy improvements to your gear so you'll have the stength to take down the corrupt king. Talk to the peasents to gain knowledge of your target's locations. Sneak attack your targets when they least expect it using the intel you've gathered. Battle law enforcement who hunt you down using a turn based battle system. Explore the open world of the castle as you please.

## Game Features
* **Open World RPG.** Takes place during medieval times. Explore a castle and hunt down targets. 
* **Speech System.** Use your charisma skills to gather intel. 
* **Battle system.** Random encounters from law enforcement. You can optionally gather intel about your targets by participating in battles if your charisma fails. 
* **Upgrade Gear.** Use coin to purchase new and better items from the shop. This is how you progress dynamically through the game. Some targets are too tough to take down without upgraded gear. 
* **Dynamic Database.** Database is backed up to json data. Saves your inventory, targets you've assassinated, and location you are in. 

## Coding Standards:
* Use 2-spaces for indenting
* Camel-case for variables and functions
* Capitalization Camel-case for class and file names
* Lowercase for foldernames, use _ between words

## TODO List
### Keyword Recognization - In Progress (Jake)  
> STARTED: 2022-04-10 | DUE: 2022-04-17
  * [X] Loop through input to find specific keywords
  * [X] Remove filler words that don't matter from input 
  * [X] Create a class for each type of action that can be taken by the player 
  * [X] Recognize words around action phrases to complete tasks
  * [ ] Create a class for battle sequences that recognized battles-related keywords and disables the keywords for the overworld
  * [ ] Create a class for the convesation sequence that recognizes conversation-related keywords and disables the keywords for the overworld and battle sequence
  * [ ] Create a helper class that manages the sequences of gameplay 
### Item Classes - In Progress (Tristan)  
> STARTED: 2022-04-10 | DUE: 2022-04-17
  * Feel free to write your tasks here, Tristan.  
### Environment Classes - In Progress (Brian)   
 > STARTED: 2022-04-10 | DUE: 2022-04-17
  * [ ] Create an abstract Environment class with a list for rooms
  * [ ] Create an abstract Room class that a player can navigate through
  * [ ] Create a Places class that holds all the environments of the game
    * i.e. shop, house1, house2, overworld, castle, etc... 
    * Set up these environments with rooms; for overworld: castleWalls, housingDistrict, commons, etc...
  * [ ] Create a helper class that manages how the player moves through environments