package fr.antique.hg.commands;

import fr.antique.hg.HG;
import fr.antique.hg.chest.ChestManager;
import fr.antique.hg.commands.framework.Command;
import fr.antique.hg.commands.framework.CommandArgs;
import fr.antique.hg.commons.utils.Reflexion;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChestCommand {


    private HG INSTANCE;

    public ChestCommand(HG INSTANCE) {
        this.INSTANCE = INSTANCE;
    }

    @Command(name = "chest", aliases = {"c"})
    public void onStart(CommandArgs args) {
        CommandSender sender = args.getSender();
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            int ping = Reflexion.getPing(player);
            if (args.length() == 0) {
                //chestmanager reset here
            }
        }
    }
}
