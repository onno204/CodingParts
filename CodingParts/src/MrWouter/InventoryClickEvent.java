package MrWouter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class InventoryClickEvent implements Listener{

	@EventHandler
	public void ClickEvent(org.bukkit.event.inventory.InventoryClickEvent e){
		if(!e.getInventory().getTitle().contains("kleur beheer scherm")){ return; }
		e.setCancelled(true);
		if(e.getCurrentItem() == null){ return; }
		if(e.getCurrentItem().getItemMeta() == null){ return; }
		if(!(e.getWhoClicked() instanceof Player)){ e.setCancelled(true); e.getWhoClicked().sendMessage("§4Error§c, Je bent geen speler."); return; }
		String TPlayerName = e.getInventory().getTitle().replace(" kleur beheer scherm.", "").replace("§a", "");
		Player TP = Bukkit.getPlayer(TPlayerName);
		ItemStack item = e.getCurrentItem();
		Player p = (Player) e.getWhoClicked();
		if(!TP.isOnline()){ p.sendMessage("§4Error§c, de speler " + TP.getName() + " is niet online");return; }
		
		String kleur = item.getItemMeta().getDisplayName();
		p.sendMessage("§aDe kleur van §2" + TP.getName() + "§a is aangepast naar: " + kleur );
		p.performCommand("kleur " + TP.getName() + " " + kleur.substring(1, 2));
		e.setCancelled(true);
	}
	
}
