package src.classes.managers.instances;
import src.classes.instances.entities.*;
import src.classes.managers.instances.InstanceCollection;

public class EntityManager {
  private InstanceManager instanceManager = InstanceManager.getInstanceManager();
  private static EntityManager entityManager = new EntityManager();

  private InstanceCollection<Entity> entities = new InstanceCollection<Entity>();

  private EntityManager() {
    // Creating enemies
    createEntity(new Enemy("grunt", 50.00));
    createEntity(new Enemy("edrik", 100.00));
    createEntity(new Enemy("king_ethelred", 250.00));
    createEntity(new Peasant("james"));
    createEntity(new Merchant("john"));
  }

  public static EntityManager getEntityManager() {
    return entityManager;
  }

  public Entity getEntity(String Name) {return entities.getInstance(Name);}

  public void createEntity(Entity Entity) {
    if (instanceManager.createInstance(Entity)) {
      entities.add(Entity);
    }
  }

  public void removeEntity(Entity Entity) {
    instanceManager.removeInstance(Entity);
    entities.remove(Entity);
  }

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

  public InstanceCollection<Enemy> getEnemies() {
    InstanceCollection<Enemy> enemies = new InstanceCollection<Enemy>();
    for (Entity entity : entities) {
      try {
        enemies.add((Enemy)entity);
      } catch (Exception e) {
        System.out.println("failed for " + entity.getName());
      }
    }
    return enemies;
  }

}
