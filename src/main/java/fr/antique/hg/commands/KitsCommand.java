package fr.antique.hg.commands;

import fr.antique.hg.HG;
import fr.antique.hg.commands.framework.Command;
import fr.antique.hg.commands.framework.CommandArgs;
import fr.antique.hg.listeners.menuHUB.infos.Kits;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KitsCommand {

    private HG INSTANCE;

    public KitsCommand(HG INSTANCE){
        this.INSTANCE = INSTANCE;
    }

    @Command(name = "kit", aliases = {"k"})
    public void onStart(CommandArgs args) {
        CommandSender sender = args.getSender();
        if ((sender instanceof Player)) {

            Player player = (Player) sender;
            Kits.KIT.open(player);
            player.sendMessage("§i kit open ");

        }
    }
}


