package src.classes.instances.locations.environments;

import src.classes.instances.Instance;
import src.classes.instances.entities.*;
import src.classes.managers.instances.EntityManager;
import src.classes.managers.instances.InstanceCollection;
import src.classes.managers.instances.ItemManager;
import src.classes.instances.items.Item;

public abstract class Environment extends Instance{
  /** Manages global items */
  protected ItemManager itemManager = ItemManager.getItemManager();
  /** Manages global entities */
  protected EntityManager entityManager = EntityManager.getEntityManager();
  /** The parent environment */
  protected Environment source;
  /**
   * What is spoken when first entering a new environment
   * Include hints about what the player can do within this environment
   */
  protected String[] entranceDialog;
  /** List of rooms within environment */
  private InstanceCollection<Environment> rooms = new InstanceCollection<Environment>();
  /** All instances within environment */
  private InstanceCollection<Instance> instances = new InstanceCollection<Instance>();
  /** All entities within environment */
  private InstanceCollection<Entity> entities = new InstanceCollection<Entity>();
  /** All items within environment */
  private InstanceCollection<Item> items = new InstanceCollection<Item>();

  /**
   * Constructors for environment
   * @param Name
   * @param EntranceDialog
   */
  public Environment(String Name, String[] EntranceDialog) {
    super(Name);
    entranceDialog = EntranceDialog;
  }
  public Environment(String Name, Environment Source, String[] EntranceDialog) {
    this(Name, EntranceDialog);
    source = Source;
  }


  /**
   * Dialog that will be displayed every time the Player Enters a location
   */
  public String[] getEntranceDialog() {
    return entranceDialog;
  }

  /// MARK - Instance Management
  public InstanceCollection<Instance> getInstances() {return instances;}

  /**
   * Add instance to instances within location
   * @param Instance
   */
  public void addInstance(Instance Instance) {instances.add(Instance);}

  /**
   * Remove instance from instances within location
   * @param Name
   */
  private void removeInstance(String Name) {instances.remove(instances.getInstance(Name));}
  private void removeInstance(Instance Instance) {instances.remove(Instance);}

  public Environment getSource() {return source;}

  /// MARK - Room Management
  public InstanceCollection<Environment> getRooms() {return rooms;}
  // Adds a sub-location to a location.
  public void addRoom(Environment Room) {
    addInstance(Room);
    rooms.add(Room);
  }

  /**
   * Remove a room from an environment. Can send object or string.
   * @param room
   */
  public void removeRoom(Environment room) {
    removeInstance(room);
    removeRoom(room);
  }
  public void removeRoom(String Name) {removeRoom(rooms.getInstance(Name));}

  /// MARK - Entity Management
  public InstanceCollection<Entity> getEntities() {return entities;}

  /**
   * Adds an entity to the list
   * @param Entity
   */
  public boolean addEntity(Entity Entity) {
    if (entityManager.hasEntity(Entity)) {
      addInstance(Entity);
      entities.add(Entity);
      return true;
    } else System.out.println("There is no instance of an entity that has been used");
    return false;
  }

  /**
   * Check to see in an entity is within an environment
   * @param Entity
   * @return
   */
  public boolean hasEntity(Entity Entity) {
    if (entities.contains(Entity)) return true;
    return false;
  }

  /**
   * Removes the entity from the list
   * @param entity
   */
  public void removeEntity(Entity entity) {
    removeInstance(entity);
    entities.remove(entity);
  }
  public void removeEntity(String Name) {removeEntity(entities.getInstance(Name));}

  /// MARK - Item Managmement
  /**
   * Get all items from the items list
   * @return
   */
  public InstanceCollection<Item> getItems() {return items;}

  /**
   * Add an item to the location
   * @param Item
   */
  public boolean addItem(Item Item) {
    if (itemManager.hasItem(Item)) {
      addInstance(Item);
      items.add(Item);
      return true;
    } else System.out.println("There is no instance of an item that has been used");
    return false;
  }

  /**
   * Remove an item from the env, can be done by object and by stirng.
   * @param Item
   */
  public void removeItem(Item Item) {
    removeInstance(Item);
    items.remove(Item);
  }
  public void removeItem(String Name) {
    removeInstance(Name);
    items.remove(items.getInstance(Name));
  }

  /**
   * Retrieve an object from the environment based on string
   * @param Name
   * @return
   */
  public Item retrieveItem(String Name) {
    Item item = items.getInstance(Name);
    removeItem(item);
    return item;
  }

}