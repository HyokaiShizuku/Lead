import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Lead extends JavaPlugin implements Listener{

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("このプラグインを有効にしました!");
		getServer().getPluginManager().registerEvents(this, this);
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLead(PlayerInteractEntityEvent event){
		if(event.getPlayer().getItemInHand().getType() == Material.LEAD && event.getRightClicked() instanceof Mob) {
			LivingEntity le = (LivingEntity) event.getRightClicked();
			le.setLeashHolder(event.getPlayer());
			event.setCancelled(true);
		}
	}
}s
