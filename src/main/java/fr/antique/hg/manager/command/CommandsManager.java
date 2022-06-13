package fr.antique.hg.manager.command;

import fr.antique.hg.HG;
import fr.antique.hg.commands.DateCommand;
import fr.antique.hg.commands.PingCommand;
import fr.antique.hg.commands.TestCommand;
import fr.antique.hg.commands.framework.CommandFramework;

public class CommandsManager {

    private static CommandFramework framework;

    public static void setupCommandsSystem(HG plugin) {
        framework = new CommandFramework(plugin);
        registerNewCommand(new TestCommand(plugin));
        registerNewCommand(new PingCommand(plugin));
        registerNewCommand(new DateCommand(plugin));
    }

    public static void registerNewCommand(Object object) {
        framework.registerCommands(object);
    }

}