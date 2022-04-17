package src.main;

import src.classes.characters.*;
import src.classes.items.weapons.*;
import src.classes.items.potions.*;
import src.views.*;
import src.classes.Bounty;
/**
 * Final Project: Text-based Game
 * Date: 2022-03-26
 * 
 * Class: #22569 | IT:Program: Part 4 (Java) 
 * Jacob Miranda | StudentID: 24272503
 * Tristan Butzine | StudentID: 24415685
 */

public class Application {
  public static void main(String[] args) {
    ViewController view = new ViewController();
    Start.printStart(view);
    Start.initializePlayer();

    // Set up - I don't know how we would manage the set up in the start class
    // it appears logic will be handled in the application class, if you know a way feel free to move it
  
    // Creating player -- I don't know why I need the full src.classes.characters it gets mad at just player.getInstance()
    Player player = src.classes.characters.Player.getInstance();
    
    // Creating weapons
    SharpObject bronzeSword = new SharpObject(100.00, "Bronze Sword", 32.5);
    BluntObject woodClub = new BluntObject(10.00, "Wood Club", 15.00);
    RangedObject rock = new RangedObject(2.00, "Hard Rock", 20.00);
    // Maybe final boss weapon, might take some balancing
    SharpObject obsidianSword = new SharpObject(1500.00, "Obsidian Sword", 50.00);
    HealingPotion basicHealingPotion = new HealingPotion(40.00, "Basic Healing Potion");

    // Creating mechant and adding weapons
    Merchant john = new Merchant("John");
    john.shop.add(bronzeSword);
    john.shop.add(woodClub);
    john.shop.add(rock);
    john.shop.add(basicHealingPotion);
    john.shop.add(obsidianSword);

    // Creating enemies
    Enemy Ethelred = new Enemy("King Ethelred", obsidianSword, 250.00);
    Enemy Edrik = new Enemy("Edrik", bronzeSword, 100.00);
    Enemy Grunt = new Enemy("Grunt", woodClub, 50.00);

    // Creating bounties
    Bounty contract3 = new Bounty(1000000.00, Ethelred);
    Bounty contract2 = new Bounty(100.00, Edrik);
    Bounty contract1 = new Bounty(25.00, Grunt);

    // Creating bounty placer and adding bounties
    BountyPlacer wulfstan = BountyPlacer.getInstance();
    wulfstan.setName("Wulfstan");
    wulfstan.bounties.add(contract1);
    wulfstan.bounties.add(contract2);
    wulfstan.bounties.add(contract3);
  }

  /**
   * A function to display help features, will flush out once controls are decided
   */
  public static void HelpButton(){
    //TO:DO code help buttons
  }

}