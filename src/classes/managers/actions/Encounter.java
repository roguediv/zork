package src.classes.managers.actions;

// Internal imports
import src.classes.instances.entities.Entity;
import src.classes.instances.items.potions.HealingPotion;
import src.classes.managers.MasterMethods;
import src.classes.instances.entities.AI;

// External imports

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
      addSpace();
      addText("Battle with " + displayName(enemy.getName()) + " has begun.");
      PickMove();
    } 
    catch(Exception exec){
      addText(displayName(e.getName()) + " is not able to battle");
      endEncounter();
    }
    // Ends text input to our view controller
    end();
  }

  // Takes battle moves input from InputWatcher
  public static void runEncounter(String Input){
    int i = 0;
    try {
      i = Integer.parseInt(Input);
    } catch (Exception e) {}
    start();
    switch(i){
      // Case if item is used or weapon is swapped. Skips player's turn
      case -2:
        addSpace();
        PickMove();
        break;
      case -1:
        addSpace();
        EnemyMove(defensiveBuff);
        break;
      // Case for a normal attack.
      case 1: 
        playerAttack();
        checkHealth();
        if(battleActive)
          EnemyMove(defensiveBuff);
        break;
      // Case for a defensive move.
      case 2:
        // Gathering the total armor of the player
        double totalArmor = 0.00 + defensiveBuff;
        for(int j = 0; j < player.outfit.length; j++){
          totalArmor += player.outfit[j].getDefense();
        }
        // Don't want over buffing to immunity
        if(totalArmor < 75.00){
          defensiveMove();
          checkHealth();
          // Calls enemy move if battle is active
          if(battleActive)
            EnemyMove(defensiveBuff);
        }
        else{
          addText("Defense can't be buffed anymore");
          PickMove();
        }
        break;
      case 3:
        // Calls reckless attack
        recklessAttack();
        // Checks if health is above 0 and adjust battleActive accordingly
        checkHealth();
        // If battle is still going the enemy makes a move
        if(battleActive)
          EnemyMove(defensiveBuff);
        break;
      case 4:
        if(MasterMethods.getChance(50.00)){
          flee();
        }
        else{
          EnemyMove(defensiveBuff);
        }
        break;
      default:
        addText("Move " + Input + " could not be found.");
        PickMove();
    }

    end();
  }

  /**
   * Displays move options.
   */
  public static void PickMove(){
    addSpace();
    addText("What move would you like to make?");
    addText("-'Swap to {weapon name}'");
    addText("-'Use {potion name}'");
    addText("-'1' for basic attack");
    addText("-'2' for defensive move");
    addText("-'3' for reckless attack");
    addText("-'4' to attempt to flee");
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
      enemyAttack(defenseBuff);
    }
    displayHealth();
    checkHealth();
    if(battleActive)
      PickMove();
  }
  
  /**
   * Logic to handle a win
   */
  private static void displayWin(){
    addText("You win!");
    try{
      player.payMoney(enemy.getMoney());
      addText("You killed " + displayName(enemy.getName()) + " and found " + enemy.getMoney() + " gold.");
      addText("You now have " + player.getMoney() + " gold.");
      if(player.getQuest().getEnemy().getName() == enemy.getName()){
        addText("Congrats you killed " + displayName(enemy.getName()) + " talk to Wulfstan to claim reward");
        player.getQuest().setCompleted(true);
      }
    }
    catch(Exception e){}
    enemy.die();
    endEncounter();
  }

  /**
   * Logic to handle lose
   * @return battleActive which is a boolean
   */
  private static void displayLose(){

    addText("You have died.");
    addText("You have been set to the starting place.");
    addText("You will keep your inventory and bounty, but you will lose half your money");
    addText("You lost " + player.getMoney()/2 + " gold.");
    endEncounter();
    player.die();
  }

  private static Boolean checkHealth(){
    if(player.getHealth() <= 0){
      battleActive = false;
      displayLose();
    }
    else if(enemy.getHealth() <= 0){
      battleActive = false;
      displayWin();
    }
    return battleActive;
  }

  /**
   * Display's health of both players
   */
  public static void displayHealth(){
    addText("Your health is " + MasterMethods.Round(player.getHealth()));
    addText("The enemies health is " + MasterMethods.Round(enemy.getHealth()));
  }

  /**
   * Enemy's attack - enemy can only basic attack
   * @param defenseBuff player's current defensive buff;
   */
  public static void enemyAttack(double defenseBuff){
    // Gathering the total armor of the player
    double TotalArmor = 0.00 + defenseBuff;
    for(int i = 0; i < player.outfit.length; i++){
      TotalArmor += player.outfit[i].getDefense();
    }

    // enemyDamage calc, ensure that enemy has a primary weapon. If not, default 1
    double enemyDamage = enemy.primary != null ? enemy.primary.getDamage() : 1;
    // Damaging the player the damage minus what the armor takes away.
    double damageDone = enemyDamage - (enemyDamage * TotalArmor * 0.01);
    
    player.damage(damageDone);

    addText(displayName(enemy.getName()) + " attacked and you took " + MasterMethods.Round(damageDone) + ".");
  }

  /**
   * Defensive buff, increases player's defense by 6%, also resets reckless attack counter
   */
  public static void defensiveMove(){
    // Increasing defensive buff by 6% and stacking on past buffs.
    defensiveBuff = 6 + (defensiveBuff * 1.06);
    addText("Defense has been buffed.");
    addText("Your defense buff is now " + MasterMethods.Round(defensiveBuff) + "%");
    // Resetting reckless attack counters
    recklessAttackCounter = 0;
  }
  /**
   * Allows you to escape from battle.
   */
  public static void flee(){
    addText("You have successfully fled");
    addText(displayName(enemy.getName()) + ": I knew you were scared");
    endEncounter();
  }

  /**
   * Reckless attack - does 1.5 times damage but at the becomes less effective and deals more damage to self each use
   */
  public static void recklessAttack(){
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
  
      addText("You attacked and you did " + MasterMethods.Round(damageDone) + ", but took " + MasterMethods.Round(recklessDamage) + " damage");
    }
      catch(Exception e){
        addText("You don't have a weapon equipped.");
      }
  }

  /**
   * Basic player attack, does damage of weapon minus enemies armour.
   */
  public static void playerAttack(){
    try{
    // Gathering the total armor of the enemy
    double TotalArmor = 0.00;
    for(int i = 0; i < enemy.outfit.length; i++){
      TotalArmor += enemy.outfit[i].getDefense();
    }

    // Damaging the enemy the damage minus what the armor takes away.
    double damageDone = player.primary.getDamage() - (player.primary.getDamage() * TotalArmor);
    enemy.damage(damageDone);

    addText("You attacked and you did " + MasterMethods.Round(damageDone) + ".");}
    catch(Exception e){
      addText("You don't have a weapon equipped.");
    }
  }

  /**
   * Changes input type back to story type
   */
  public static void endEncounter(){
    InputWatcher.changeInput(0);
  }
}
