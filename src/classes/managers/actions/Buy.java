package src.classes.managers.actions;

import src.classes.instances.entities.Merchant;
import src.classes.instances.items.Item;

/**
 * Class that handles buying items from merchants
 * @author Tristan
 */
public class Buy extends Action{
	
	// The merchant you are buying from
	private static Merchant merchant;

	/**
	 * Main buy method
	 * @param ItemName
	 */
  public static void buyShop(String ItemName){
		start();
		Boolean isFound = false;
		System.out.println(merchant.getShop().size());
		for(Item i:merchant.getShop()){
			if(i.getName().equals(ItemName)){
				isFound = true;
				if(player.spendMoney(i.getValue())){
					player.addInventory(i);
					merchant.removeItem(i);
					addText("You purchased the " + displayName(i.getName()) + " from " + displayName(merchant.getName()) +".");
					addText(displayName(merchant.getName()) + ": \"Alway's a pleasure doing business...\"");
				}
				else{
					addText(displayName(merchant.getName()) + ": \"You don't have enough money for this " + displayName(i.getName()) + ".\"");
				}
			}
		}
		if(!isFound) addText(displayName(ItemName) + " is not found.");
		end();
  }

	/**
	 * Set's the merchant you are buying from
	 */
	public static void setMerchant(Merchant Merchant){
		merchant = Merchant;
	}
	
}
