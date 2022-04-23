package src.classes.managers.instances;

import src.classes.instances.entitys.Merchant;
import src.classes.instances.entitys.BountyPlacer;
import src.classes.instances.items.Quest;

public class InstanceManager {
  private static final InstanceManager instanceManager = new InstanceManager();

  private EntityManager mgrEntity = EntityManager.getEntityManager();
  private ItemManager mgrItem = ItemManager.getItemManager();
  private LocationManager mgrLocation = LocationManager.getLocationManager();

  private InstanceManager() {
    /// Merchant that sells items
    Merchant john = mgrEntity.getMerchant("john");
    john.shop.add(mgrItem.getWeapon("bronze_sword"));
    john.shop.add(mgrItem.getWeapon("wood_club"));
    john.shop.add(mgrItem.getWeapon("hard_rock"));
    john.shop.add(mgrItem.getPotion("basic_healing_potion"));
    john.shop.add(mgrItem.getWeapon("obsidian_sword"));

    /// Creating bounty placer and adding bounties
    BountyPlacer wulfstan = BountyPlacer.getInstance();
    wulfstan.bounties.add(new Quest(mgrEntity.getEnemy("grunt"), 25));
    wulfstan.bounties.add(new Quest(mgrEntity.getEnemy("edrik"), 100));
    wulfstan.bounties.add(new Quest(mgrEntity.getEnemy("ethelred"), 1000000.00));
  }

  public static InstanceManager getInstanceManager() {
    return instanceManager;
  }
}
