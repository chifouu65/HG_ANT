package fr.antique.hg.commands;

import fr.antique.hg.HG;
import fr.antique.hg.commands.framework.Command;
import fr.antique.hg.commands.framework.CommandArgs;
import fr.antique.hg.commons.utils.Reflexion;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand {
    private HG INSTANCE;

    public PingCommand(HG INSTANCE) {
        this.INSTANCE = INSTANCE;
    }

    @Command(name = "ping", aliases = {"p"})
    public void onStart(CommandArgs args) {
        CommandSender sender = args.getSender();
        if ((sender instanceof Player)) {

            Player player = (Player) sender;
            int ping = Reflexion.getPing(player);

            if (args.length() == 0) {
                player.sendMessage("§l§ePing :§r " + ping);
            }
        }
    }
}
