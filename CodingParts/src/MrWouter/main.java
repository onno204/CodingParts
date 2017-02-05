package MrWouter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		getDescription();
		System.out.println(getDescription().getFullName() + " Version " + getDescription().getVersion() + " is getting enabled.");
		
		Bukkit.getPluginManager().registerEvents(new InventoryClickEvent(), this);
		
		super.onEnable();
		super.setEnabled(true);
		System.out.println(getDescription().getFullName() + " Version " + getDescription().getVersion() + " is fully enabled.");
	}
    
	@Override
	public void onDisable() {
		System.out.println(getDescription().getFullName() + " Version " + getDescription().getVersion() + " is getting Disabled.");
		
		
		super.onDisable();
		super.setEnabled(false);
		System.out.println(getDescription().getFullName() + " Version " + getDescription().getVersion() + " is fully disabled.");
	}
	
	public static void Notify(String msg){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.sendMessage(msg);
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		new LevelSelector(p);
		p.openInventory(LevelSelector.GetInv());
		p.sendMessage("Uw inventory is geöpent");
		return true;
	}
	
}
