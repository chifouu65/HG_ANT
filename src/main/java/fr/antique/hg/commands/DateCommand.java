package fr.antique.hg.commands;

import fr.antique.hg.HG;
import fr.antique.hg.commands.framework.Command;
import fr.antique.hg.commands.framework.CommandArgs;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCommand {

    private HG INSTANCE;

    public DateCommand(HG INSTANCE) {
        this.INSTANCE = INSTANCE;
    }

    @Command(name = "date", aliases = {"d"})
    public void onStart(CommandArgs args) {
        CommandSender sender = args.getSender();
        if ((sender instanceof Player)) {

            Player player = (Player) sender;

            if (args.length() == 0) {
                player.sendMessage("Date is : " + Date());
            }
        }
    }

    public static String Date() {
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        Date d = new Date();
        String date = "§a" + format.format(d);
        return date;
    }

}