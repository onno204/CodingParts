package MrWouter;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventories {
	
	public static Inventory KleurSelector;
	public Inventories(Player p){
		KleurSelector = Bukkit.createInventory(null, 36, "§a" + p.getName() + " kleur beheer scherm.");
		int Slot = 10;
		KleurSelector.setItem(Slot, GetItem("1")); 
		Slot++;
		KleurSelector.setItem(Slot, GetItem("2")); 
		Slot++;
		KleurSelector.setItem(Slot, GetItem("3")); 
		Slot++;
		KleurSelector.setItem(Slot, GetItem("4")); 
		Slot++;
		KleurSelector.setItem(Slot, GetItem("5")); 
		Slot++;
		KleurSelector.setItem(Slot, GetItem("6")); 
		Slot++;
		KleurSelector.setItem(Slot, GetItem("7")); 
		Slot++; //Slot 9
		Slot++; //slot 1
		Slot++; //slot 2
		KleurSelector.setItem(Slot, GetItem("8")); 
		Slot++;
		KleurSelector.setItem(Slot, GetItem("9")); 
		Slot++;
		KleurSelector.setItem(Slot, GetItem("a")); 
		Slot++;
		KleurSelector.setItem(Slot, GetItem("b")); 
		Slot++;
		KleurSelector.setItem(Slot, GetItem("c")); 
		Slot++;
		KleurSelector.setItem(Slot, GetItem("d")); 
		Slot++;
		KleurSelector.setItem(Slot, GetItem("e"));
		
	}
	
	public static Inventory GetInv(){ return KleurSelector; }
	
	public static ItemStack GetItem(String kleur){
		List<String> Lore = new ArrayList<String>();
		ItemMeta meta;

		ItemStack item = new ItemStack(Material.WOOL, 1);
		meta = item.getItemMeta();
		Lore.add("§" + kleur + "Kiest deze kleur.");
		meta.setDisplayName("§" + kleur + GetColorName(kleur));
		item.setDurability(Short.parseShort(GetWoolcolor(kleur)));
		meta.setLore(Lore);
		item.setItemMeta(meta);
		
		return item;
	}

	
	public static String GetWoolcolor(String MCColor){
		if(MCColor.equalsIgnoreCase("0")){ return "15";
		}else if(MCColor.equalsIgnoreCase("1")){ return "11";
		}else if(MCColor.equalsIgnoreCase("2")){ return "13";
		}else if(MCColor.equalsIgnoreCase("3")){ return "9";
		}else if(MCColor.equalsIgnoreCase("4")){ return "14";
		}else if(MCColor.equalsIgnoreCase("5")){ return "2";
		}else if(MCColor.equalsIgnoreCase("6")){ return "1";
		}else if(MCColor.equalsIgnoreCase("7")){ return "8";
		}else if(MCColor.equalsIgnoreCase("8")){ return "7";
		}else if(MCColor.equalsIgnoreCase("9")){ return "10";
		}else if(MCColor.equalsIgnoreCase("a")){ return "5";
		}else if(MCColor.equalsIgnoreCase("b")){ return "3";
		}else if(MCColor.equalsIgnoreCase("c")){ return "1";
		}else if(MCColor.equalsIgnoreCase("d")){ return "6";
		}else if(MCColor.equalsIgnoreCase("e")){ return "4";
		}else{ return "0"; }
	}
	
	public static String GetColorName(String MCColor){
		if(MCColor.equalsIgnoreCase("0")){ return "Zwart";
		}else if(MCColor.equalsIgnoreCase("1")){ return "Donkerblauw";
		}else if(MCColor.equalsIgnoreCase("2")){ return "Groen";
		}else if(MCColor.equalsIgnoreCase("3")){ return "Cyan";
		}else if(MCColor.equalsIgnoreCase("4")){ return "Rood";
		}else if(MCColor.equalsIgnoreCase("5")){ return "Paars";
		}else if(MCColor.equalsIgnoreCase("6")){ return "Oranje";
		}else if(MCColor.equalsIgnoreCase("7")){ return "Lichtgrijs";
		}else if(MCColor.equalsIgnoreCase("8")){ return "Grijs";
		}else if(MCColor.equalsIgnoreCase("9")){ return "LightDonkerblauw";
		}else if(MCColor.equalsIgnoreCase("a")){ return "LichtGroen";
		}else if(MCColor.equalsIgnoreCase("b")){ return "Lichtblauw";
		}else if(MCColor.equalsIgnoreCase("c")){ return "Lichtrood";
		}else if(MCColor.equalsIgnoreCase("d")){ return "Roze";
		}else if(MCColor.equalsIgnoreCase("e")){ return "Geel";
		}else{ return "0"; }
	}
	
	public static String GetMCcolor(String WoolColor){
		if(WoolColor.equalsIgnoreCase("0")){ return "f";
		}else if(WoolColor.equalsIgnoreCase("1")){ return "6";
		}else if(WoolColor.equalsIgnoreCase("2")){ return "5";
		}else if(WoolColor.equalsIgnoreCase("3")){ return "b";
		}else if(WoolColor.equalsIgnoreCase("4")){ return "e";
		}else if(WoolColor.equalsIgnoreCase("5")){ return "a";
		}else if(WoolColor.equalsIgnoreCase("6")){ return "d";
		}else if(WoolColor.equalsIgnoreCase("7")){ return "8";
		}else if(WoolColor.equalsIgnoreCase("8")){ return "7";
		}else if(WoolColor.equalsIgnoreCase("9")){ return "3";
		}else if(WoolColor.equalsIgnoreCase("10")){ return "9";
		}else if(WoolColor.equalsIgnoreCase("11")){ return "1";
		}else if(WoolColor.equalsIgnoreCase("12")){ return "0";
		}else if(WoolColor.equalsIgnoreCase("13")){ return "2";
		}else if(WoolColor.equalsIgnoreCase("14")){ return "4";
		}else if(WoolColor.equalsIgnoreCase("15")){ return "0";
		}else{ return "0"; }
	}
}
