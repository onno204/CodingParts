package Parts;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathCounter extends JavaPlugin implements Listener{
	public static HashMap<UUID, Integer> Top = new HashMap<UUID, Integer>();
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void onEnable() {
		System.out.println("Death Top Enabled");
		Bukkit.getPluginManager().registerEvents(this, this);
		if(!this.getDataFolder().exists()){ this.getDataFolder().mkdir(); }
		reloadConfig();
		Object o = getConfig().get("TopKills");
		try{
			Top = (HashMap<UUID, Integer>) o;
		}catch(Exception e){ e.printStackTrace(); }
	}
	
	@Override
	public void onDisable() {
		System.out.println("Disabled");
		getConfig().set("TopKills", Top);
		saveConfig();
	}
	
	@EventHandler
	public static void DeathEvent(PlayerDeathEvent e){
		Player p = e.getEntity().getKiller();
		int last = 0;
		if(Top.containsKey(p.getUniqueId())){
			last = Top.get(p.getUniqueId());
			Top.remove(p.getUniqueId());
		}
		Top.put(p.getUniqueId(), last + 1);
	}
	
}
