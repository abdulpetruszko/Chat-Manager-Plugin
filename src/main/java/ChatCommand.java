import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatCommand implements CommandExecutor {
    Main plugin; //import your main class here

    public ChatCommand(Main m){
        plugin = m;
    }

    public static boolean chatEnabled = true;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("chat")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("enable")) {
                    chatEnabled = true;
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("chat.enable")));
                    return true;
                } else if (args[0].equalsIgnoreCase("disable")) {
                    chatEnabled = false;
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("chat.disable")));
                    return true;
                } else if (args[0].equalsIgnoreCase("clear")) {
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        for (int i = 0; i < 100; i++) {
                            Bukkit.broadcastMessage("");
                        }
                        players.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("chat.clear")));
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
