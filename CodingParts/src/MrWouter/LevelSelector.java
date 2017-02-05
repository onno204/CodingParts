package MrWouter;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LevelSelector {
	
	public static Inventory LevelSelector;
	public LevelSelector(Player p){
		LevelSelector = Bukkit.createInventory(null, 45, "§a" + p.getName() + " level beheer scherm.");
		int Slot = 10;
		LevelSelector.setItem(Slot, GetItem("1")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("2")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("3")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("4")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("5")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("6")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("7")); 
		Slot++; //Slot 9
		Slot++; //slot 1
		Slot++; //slot 2
		LevelSelector.setItem(Slot, GetItem("8")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("9")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("10")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("11")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("12")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("13")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("14")); 
		Slot++; //Slot 9
		Slot++; //slot 1
		Slot++; //slot 2
		LevelSelector.setItem(Slot, GetItem("15")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("16")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("17")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("18")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("19")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("20")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("21")); 
		Slot++;
		LevelSelector.setItem(Slot, GetItem("22")); 
		
	}
	
	public static Inventory GetInv(){ return LevelSelector; }
	
	public static ItemStack GetItem(String Level){
		List<String> Lore = new ArrayList<String>();
		ItemMeta meta;

		ItemStack item = new ItemStack(Material.WOOL, 1);
		meta = item.getItemMeta();
		Lore.add("§7Zet het level naar: " + Level);
		meta.setDisplayName("§aLevel:  " + Level);
		item.setAmount(Integer.parseInt(Level));
		meta.setLore(Lore);
		item.setItemMeta(meta);
		
		return item;
	}

	
}
