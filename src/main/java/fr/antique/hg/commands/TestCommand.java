package fr.antique.hg.commands;

import fr.antique.hg.HG;
import fr.antique.hg.commands.framework.Command;
import fr.antique.hg.commands.framework.CommandArgs;
import fr.antique.hg.listeners.menuHUB.minigames.Kits;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand {

    private HG INSTANCE;

    public TestCommand(HG INSTANCE){
        this.INSTANCE = INSTANCE;
    }

    @Command(name = "test", aliases = {"t"})
    public void onStart(CommandArgs args) {
        CommandSender sender = args.getSender();
        if ((sender instanceof Player)) {

            Player player = (Player) sender;
            Kits.KIT.open(player);
            player.sendMessage("§i test ");

        }
    }
}


