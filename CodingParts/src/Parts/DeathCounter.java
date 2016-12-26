package Parts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
		if(Top == null){
			Top = new HashMap<UUID, Integer>();
		}
	}

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getLabel().toLowerCase().equalsIgnoreCase("killtop")){
			try{
				Object[] a = Top.entrySet().toArray();
				Arrays.sort(a, new Comparator() {
					public int compare(Object o1, Object o2) {
				        return ((Map.Entry<String, Integer>) o2).getValue()
				                   .compareTo(((Map.Entry<String, Integer>) o1).getValue());
				    }
				});
				int Counting = 1;
				for (Object e : a) {
				    sender.sendMessage(Counting + ". " + ((Map.Entry<String, Integer>) e).getKey() + " : " + ((Map.Entry<String, Integer>) e).getValue());
				    Counting++;
				}
			}catch(Exception e){ sender.sendMessage("Er is iets fout gegaan tijdens deze command!"); e.printStackTrace(); }
			
		}
		return true;
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
		if(p != null){
			int last = 0;
			if(Top.containsKey(p.getUniqueId())){
				last = Top.get(p.getUniqueId());
				Top.remove(p.getUniqueId());
			}
			Top.put(p.getUniqueId(), last + 1);
			p.sendMessage("Je hebt een extra kill! wouw!");
		}else{
			e.getEntity().sendMessage("Hmm, Beetje slecht dat je niet bij een speler vermoord bent.");
		}
	}
	
}
