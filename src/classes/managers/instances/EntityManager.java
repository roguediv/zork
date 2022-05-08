package src.classes.managers.instances;
import src.classes.instances.entities.*;
import src.classes.managers.instances.InstanceCollection;

/**
 * Manages all entities of the game.
 */
public class EntityManager {
  /**
   * Get the instance manager singleton class
   */
  private InstanceManager instanceManager = InstanceManager.getInstanceManager();

  /**
   * Singleton class
   */
  private static EntityManager entityManager = new EntityManager();

  /**
   * List of all entities
   */
  private InstanceCollection<Entity> entities = new InstanceCollection<Entity>();

  /**
   * Create starting entities
   */
  private EntityManager() {
    // Creating enemies
    createEntity(new Enemy("grunt", 50.00, 20.00));
    createEntity(new Enemy("edrik", 100.00, 50.00));
    createEntity(new Enemy("king_ethelred", 250.00, 200.00));
    createEntity(new Peasant("james", 50.00, 10.00));
    createEntity(new Merchant("john", 50.00, 10.00));
    createEntity(new Merchant("johnson", 50.00, 10.00));
  }

  /**
   * Return singleton class
   * @return Class
   */
  public static EntityManager getEntityManager() {return entityManager;}

  /**
   * Get an entity from the list
   * @param Name The name to be searched for
   * @return The entity that is found or null if none found
   */
  public Entity getEntity(String Name) {return entities.getInstance(Name);}

  /**
   * Create a new entitiy
   * Should be ran from env classes
   * @param Entity The entity to be created
   */
  public void createEntity(Entity Entity) {
    if (instanceManager.createInstance(Entity)) {
      entities.add(Entity);
    }
  }

    /**
   * Remove entity as object
   * @param Entity The entity object
   */
  public void removeEntity(String Name) {
    instanceManager.removeInstance(entities.getInstance(Name));
    entities.remove(entities.getInstance(Name));
  }
  /**
   * Remove entity as object
   * @param Entity The entity object
   */
  public void removeEntity(Entity Entity) {
    instanceManager.removeInstance(Entity);
    entities.remove(Entity);
  }

  /**
   * Get all merchants
   * @return All merchant entities
   */
  public InstanceCollection<Merchant> getMerchants() {
    InstanceCollection<Merchant> merchants = new InstanceCollection<Merchant>();
    for (Entity entity : entities) {
      try {
        merchants.add((Merchant)entity);
      } catch (Exception e) {
        //System.out.println("failed for " + entity.getName());
      }
    }
    return merchants;
  }

  /**
   * Get all enemies
   * @return All enemy entities
   */
  public InstanceCollection<Enemy> getEnemies() {
    InstanceCollection<Enemy> enemies = new InstanceCollection<Enemy>();
    for (Entity entity : entities) {
      try {
        enemies.add((Enemy)entity);
      } catch (Exception e) {}
    }
    return enemies;
  }

}
