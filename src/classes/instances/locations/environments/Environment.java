package src.classes.instances.locations.environments;

import src.classes.instances.Instance;
import src.classes.instances.entities.*;
import src.classes.managers.instances.InstanceCollection;
import src.classes.managers.instances.ItemManager;
import src.classes.instances.items.Item;

public abstract class Environment extends Instance{
  protected ItemManager itemManager = ItemManager.getItemManager();
  protected Environment source;
  protected String[] entranceDialog;
  private InstanceCollection<Environment> rooms = new InstanceCollection<Environment>();
  private InstanceCollection<Instance> instances = new InstanceCollection<Instance>();
  private InstanceCollection<Entity> entities = new InstanceCollection<Entity>();
  private InstanceCollection<Item> items = new InstanceCollection<Item>();

  public Environment(String Name, String[] EntranceDialog) {
    super(Name);
    entranceDialog = EntranceDialog;
  }
  public Environment(String Name, Environment Source, String[] EntranceDialog) {
    super(Name);
    source = Source;
    entranceDialog = EntranceDialog;
  }


  /**
   * Dialog that will be displayed every time the Player Enters a location
   */
  public String[] getEntranceDialog() {
    return entranceDialog;
  }

  /// MARK - Instance Management
  public InstanceCollection<Instance> getInstances() {return instances;}
  private void addInstance(Instance Instance) {instances.add(Instance);}
  private void removeInstance(String Name) {instances.remove(instances.getInstance(Name));}

  /// MARK - Room Management
  public InstanceCollection<Environment> getRooms() {return rooms;}
  public void addRoom(Environment Room) {
    addInstance(Room);
    rooms.add(Room);
  }
  public void removeRoom(String Name) {
    Environment room = rooms.getInstance(Name);
    instances.remove(room);
    rooms.remove(room);
  }

  /// MARK - Entity Management
  public InstanceCollection<Entity> getEntities() {return entities;}
  public void addEntity(Entity Entity) {
    addInstance(Entity);
    entities.add(Entity);
  }
  public void removeEntity(String Name) {
    Entity entity = entities.getInstance(Name);
    entities.remove(entity);
    instances.remove(entity);
  }

  /// MARK - Item Managmement
  public InstanceCollection<Item> getItems() {return items;}
  public void addItem(Item Item) {
    addInstance(Item);
    items.add(Item);
  }
  public void removeItem(String Name) {
    removeInstance(Name);
    items.remove(items.getInstance(Name));
  }
  public void removeItem(Item item) {
    instances.remove(item);
    items.remove(item);
  }
  public Item retrieveItem(String Name) {
    Item item = items.getInstance(Name);
    removeItem(item);
    return item;
  }

}