package src.classes.managers.actions;

import src.classes.instances.entities.Merchant;
import src.classes.instances.items.Item;

/**
 * Class that handles buying items from merchants
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
		System.out.println("Item name: " + ItemName);
		for(Item i:merchant.getShop()){
			System.out.println(i.getName());
			if(i.getName().equals(ItemName)){
				isFound = true;
				if(player.spendMoney(i.getValue())){
					player.addInventory(i);
					merchant.removeItem(i);
				}
				else{
					addText("You can't afford " + displayName(i.getName()) + ".");
				}
			}
		}
		if(!isFound) addText(displayName(ItemName) + " is not found.");
		InputWatcher.changeInput(0);
		end();
  }

	/**
	 * Set's the merchant you are buying from
	 */
	public static void setMerchant(Merchant Merchant){
		merchant = Merchant;
	}
}
