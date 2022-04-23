package src.classes.managers.instances;
import src.classes.instances.entitys.*;
import src.classes.managers.instances.InstanceCollection;

public class EntityManager {
  private static EntityManager entityManager = new EntityManager();
  private InstanceCollection<Enemy> enemys = new InstanceCollection<Enemy>();
  private InstanceCollection<Entity> storyChars = new InstanceCollection<Entity>();
  private InstanceCollection<Merchant> merchants = new InstanceCollection<Merchant>();
  private ItemManager mgrItems = ItemManager.getItemManager();

  private EntityManager() {
    // Creating enemies
    enemys.add(new Enemy("grunt", 50.00));
    enemys.add(new Enemy("edrik", 100.00));
    enemys.add(new Enemy("king_ethelred", 250.00));
    merchants.add(new Merchant("john"));
  }

  public static EntityManager getEntityManager() {
    return entityManager;
  }

  public Enemy getEnemy(String Name) {return enemys.getInstance(Name);}

  public Merchant getMerchant(String Name) {return merchants.getInstance(Name);}
  
}
