package src.classes.managers.actions;

import src.classes.instances.entities.Enemy;
import src.classes.instances.entities.Entity;
import src.classes.instances.entities.Player;
import src.classes.instances.items.potions.HealingPotion;
import src.classes.instances.items.armor.Armor;

import java.text.DecimalFormat;

import src.classes.instances.entities.AI;

/**
 * The combat system, takes a player and an enemy player.
 * Prompts user for options and handles them, basic enemy logic
 * Enemy logic starts with basic attacks, can add using potions if time.
 */
public class Encounter extends Action {

  private static Entity enemy;

  private static Boolean battleActive = true;
  private static double defensiveBuff = 0.00;
  // Counting reckless attacks in a row.
  private static int recklessAttackCounter = 0;
  // For formatting output
  private static DecimalFormat decFormat = new DecimalFormat("#.##");
  /**
   * Starts encounter or battle
   * @param str the name of the enemy we are fighting
   */
  public static void StartEncounter(String str){
    // This is allowing text to be added to view controller
    start();
    // Resetting defensive buff
    defensiveBuff = 0.00;
    // Reckless attack counter
    recklessAttackCounter = 0;
    // This is changing the input to receive battle related input from player
    InputWatcher.changeInput(2);
    // Here we are getting the entity we are battling and assigning the enemy variable.
    Entity e = location.getEntities().getInstance(str);
    try{
      // Cast to AI to implement battle lines
      enemy = (AI)e;
    } 
    catch(Exception exec){
      addText(displayName(e.getName()) + " is not able to battle");
    }
    PickMove();
    // Ends text input to our view controller
    end();
  }

  // Takes battle moves input from InputWatcher
  public static void RunEncounter(String input){
    start();
    // i is the input number
    int i = 0;
    try{
      i = Integer.parseInt(input);
      switch(i){
        // Case if item is used or weapon is swapped. Skips player's turn
        case -1:
          EnemyMove(defensiveBuff);
          break;
        // Case for a normal attack.
        case 1: 
          PlayerAttack();
          CheckHealth();
          if(battleActive)
            EnemyMove(defensiveBuff);
          break;
        // Case for a defensive move.
        case 2:
          // Don't want over buffing
          if(defensiveBuff < 75.00){
            DefensiveMove();
            CheckHealth();
            if(battleActive)
              EnemyMove(defensiveBuff);
          }
          else{
            addText("Defense can't be buffed anymore");
            addText("Try using '1' for an attack, '2' for a defensive buff, and '3' for a reckless attack");
          }
          break;
        case 3:
          RecklessAttack();
          CheckHealth();
          if(battleActive)
            EnemyMove(defensiveBuff);
          break;
        default:
          break;
      }
    }
    catch(Exception e){
      addText("Move " + input + " could not be found.");
      addText("Try using '1' for an attack, '2' for a defensive buff, and '3' for a reckless attack");
    }
    end();
  }

  /**
   * Displays move options.
   */
  public static void PickMove(){
    addText(" ");
    addText("What move would you like to make?");
    addText("-'Swap to {weapon name}'");
    addText("-'Use {potion name}'");
    addText("-'1' for basic attack");
    addText("-'2' for defensive move");
    addText("-'3' for reckless attack");
  }
  
  /**
   * Enemy picking whether to attack or use potion if it has one.
   * @param defenseBuff player's defensive buff.
   */
  public static void EnemyMove(double defenseBuff){
    // First checking if we have a healing potion
    boolean potionFound = false;
    int location = -1;
    for(int i = 0; i < enemy.inventory.size(); i++){
      if(enemy.inventory.get(i) instanceof HealingPotion){
        potionFound = true;
        location = i;
      }
    }
    // If the health is at 40%, we want to use a healing potion if we have one.
    if((enemy.getHealth() < (enemy.getMaxHealth() * 0.4)) && potionFound){
      enemy.inventory.get(location).useItem(enemy);
    }
    else{
      EnemyAttack(defenseBuff);
    }
    DisplayHealth();
    CheckHealth();
    if(battleActive)
      PickMove();
  }
  
  /**
   * Logic to handle a win
   */
  private static void DisplayWin(){
    addText("You win!");
    enemy.die();
    EndEncounter();
  }

  /**
   * Logic to handle lose
   * @return battleActive which is a boolean
   */
  private static void DisplayLose(){
    addText("You have died.");
    EndEncounter();
    player.die();
  }

  private static Boolean CheckHealth(){
    if(player.getHealth() <= 0){
      battleActive = false;
      DisplayLose();
    }
    else if(enemy.getHealth() <= 0){
      battleActive = false;
      DisplayWin();
    }
    return battleActive;
  }

  /**
   * Display's health of both players
   */
  public static void DisplayHealth(){
    addText("Your health is " + decFormat.format(player.getHealth()));
    addText("The enemies health is " + decFormat.format(enemy.getHealth()));
  }

  /**
   * Enemy's attack - enemy can only basic attack
   * @param defenseBuff player's current defensive buff;
   */
  public static void EnemyAttack(double defenseBuff){
    // Gathering the total armor of the player
    double TotalArmor = 0.00 + defenseBuff;
    for(int i = 0; i < player.outfit.length; i++){
      TotalArmor += player.outfit[i].getDefense();
    }

    // Damaging the player the damage minus what the armor takes away.
    double damageDone = enemy.primary.getDamage() - (enemy.primary.getDamage() * TotalArmor * 0.01);
    player.damage(damageDone);

    addText(enemy.getName() + " attacked and you took " + decFormat.format(damageDone) + ".");
  }

  /**
   * Defensive buff, increases player's defense by 5%, also resets reckless attack counter
   */
  public static void DefensiveMove(){
    // Increasing defensive buff by 5% and stacking on past buffs.
    defensiveBuff = 5 + (defensiveBuff * 1.05);
    addText("Defense has been buffed.");
    addText("Your defense buff is now " + decFormat.format(defensiveBuff));
    // Resetting reckless attack counters
    recklessAttackCounter = 0;
  }

  /**
   * Reckless attack - does 1.5 times damage but at the becomes less effective and deals more damage to self each use
   */
  public static void RecklessAttack(){
    try{
      recklessAttackCounter++;
      // Player takes 20 percent of base weapon damage time the number of times reckless attack has been used.
      // The counter resets to 0 when defensive move is used.
      double recklessDamage = (0.2 * player.primary.getDamage()) * recklessAttackCounter;
      // Gathering the total armor of the enemy
      double TotalArmor = 0.00;
      for(int i = 0; i < enemy.outfit.length; i++){
        TotalArmor += enemy.outfit[i].getDefense();
      }
  
      // Damaging the enemy the damage minus what the armor takes away. Damage also has reckless attack included.
      double damageDone = (player.primary.getDamage() * (1.6 - (recklessAttackCounter * 0.1))- (player.primary.getDamage() * (TotalArmor * 0.01)));
      enemy.damage(damageDone);
      player.damage(recklessDamage);
  
      addText("You attacked and you did " + decFormat.format(damageDone) + ", but took " + decFormat.format(recklessDamage) + " damage");
    }
      catch(Exception e){
        addText("You don't have a weapon equipped.");
      }
  }

  /**
   * Basic player attack, does damage of weapon minus enemies armour.
   */
  public static void PlayerAttack(){
    try{
    // Gathering the total armor of the enemy
    double TotalArmor = 0.00;
    for(int i = 0; i < enemy.outfit.length; i++){
      TotalArmor += enemy.outfit[i].getDefense();
    }

    // Damaging the enemy the damage minus what the armor takes away.
    double damageDone = player.primary.getDamage() - (player.primary.getDamage() * TotalArmor);
    enemy.damage(damageDone);

    addText("You attacked and you did " + decFormat.format(damageDone) + ".");}
    catch(Exception e){
      addText("You don't have a weapon equipped.");
    }
  }

  /**
   * Changes input type back to story type
   */
  public static void EndEncounter(){
    InputWatcher.changeInput(0);
  }
}
