package Parts;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerData implements Listener{
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void QuitEventHandler(PlayerJoinEvent e) {
		//Replace 'IdontHaveALife' with your plugin name
		File file = new File(Bukkit.getPluginManager().getPlugin("IdontHaveALife").getDataFolder().getPath(), e.getPlayer().getName() + ".yml");

		//Checking if the file Exists and creates if not
		try { if (file.createNewFile()) { System.out.println("File '" + file.getName() + "' is created!");} 
		} catch (IOException ee) { System.out.println("Something went wrong while creating player files");  }
		
		
		
		FileConfiguration IpRegister;

		//Loads the file
		IpRegister = YamlConfiguration.loadConfiguration( file );

		IpRegister.set("UUID", e.getPlayer().getUniqueId());
		IpRegister.set("Name", e.getPlayer().getName());
		IpRegister.set("ip", e.getPlayer().getAddress().getAddress().getHostAddress());
		IpRegister.set("Gamemode", e.getPlayer().getGameMode());
		IpRegister.set("IsOP", e.getPlayer().isOp());
		IpRegister.set("LocationXYZ", e.getPlayer().getLocation().getBlockX() + "," + e.getPlayer().getLocation().getBlockY() + "," + e.getPlayer().getLocation().getBlockZ() );
		
		
		
		try { IpRegister.save(file);
		} catch (IOException ee) { System.out.println("Something went wrong while saving player files");  }
	}

}
