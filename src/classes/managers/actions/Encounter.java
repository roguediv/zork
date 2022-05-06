package src.classes.managers.actions;

import src.classes.instances.entities.Enemy;
import src.classes.instances.entities.Entity;
import src.classes.instances.entities.Player;
import src.classes.instances.items.potions.HealingPotion;
import src.classes.instances.items.armor.Armor;
import src.classes.instances.entities.AI;

/**
 * The combat system, takes a player and an enemy player.
 * Prompts user for options and handles them, basic enemy logic
 * Enemy logic starts with basic attacks, can add using potions if time.
 */
public class Encounter extends Action {

  private static Entity enemy;
  private Encounter en;

  // Eagar initialization singleton pattern
  private static final Encounter mainEncounter = new Encounter();

  private Encounter() {
  }

  public static Encounter getInstance() {
    return mainEncounter;
  }

  public static void StartEncounter(String str){
    start();
    InputWatcher.changeInput(2);
    Entity e = location.getEntities().getInstance(str);
    try{
    enemy = (AI)e;
    } 
    catch(Exception exec){
      addText(displayName(e.getName()) + " is not able to battle");
    }
    MoveSelection();
    end();
  }

  public static void RunEncounter(String input){
    start();
    int i = 0;
    try{
      i = Integer.parseInt(input);
    }
    catch(Exception e){
    }
    switch(i){
      case -1:
        EnemyMove();
      case 1: 
        PlayerAttack();
        EnemyMove();
        break;
      case 2:
        
      case 3:

      default:
    }
    end();
  }

  public static void MoveSelection(){
    PickMove();
  }

  public static void PickMove(){
    addText("What move would you like to make?");
    addText("Swap to (weapon name)");
    addText("Use (potion name)");
    addText("Attack");
  }

  public static void EnemyMove(){
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
      EnemyAttack();
    }
    DisplayHealth();
    if(player.getHealth() > 0 && enemy.getHealth() <= 0){
      DisplayWin();
    }
    PickMove();
  }
  private static void DisplayWin(){
    addText("You win!");
    EndEncounter();
  }

  public static void DisplayHealth(){
    addText("Your health is " + player.getHealth());
    addText("The enemies health is " + enemy.getHealth());
  }

  public static void EnemyAttack(){
    // Gathering the total armor of the player
    double TotalArmor = 0.00;
    for(int i = 0; i < player.outfit.length; i++){
      TotalArmor += player.outfit[i].getDefense();
    }

    // Damaging the player the damage minus what the armor takes away.
    double damageDone = enemy.primary.getDamage() - (enemy.primary.getDamage() * TotalArmor);
    player.damage(damageDone);

    addText(enemy.getName() + "attacked and you took " + damageDone + ".");
  }

  public static void PlayerAttack(){
    try{
    // Gathering the total armor of the player
    double TotalArmor = 0.00;
    for(int i = 0; i < enemy.outfit.length; i++){
      TotalArmor += enemy.outfit[i].getDefense();
    }

    // Damaging the enemy the damage minus what the armor takes away.
    double damageDone = player.primary.getDamage() - (player.primary.getDamage() * TotalArmor);
    enemy.damage(damageDone);

    addText("You attacked and you did " + damageDone + ".");}
    catch(Exception e){
      addText("You don't have a weapon equipped.");
    }
  }

  public static void EndEncounter(){
    InputWatcher.changeInput(0);
  }
}
