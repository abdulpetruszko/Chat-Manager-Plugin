import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static kutas.zvsv.Commands.ChatCommand.chatEnabled;

public class OnPlayerChat implements Listener {
    Main plugin;

    public OnPlayerChat(Main m){
        this.plugin = m;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();

        if (player.hasPermission("zvsv.chat.bypass") || player.isOp()) {
            return;
        }
        if (!chatEnabled) {
            event.setCancelled(true);
        }
    }
}
