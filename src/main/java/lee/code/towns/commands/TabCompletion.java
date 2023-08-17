package lee.code.towns.commands;

import lee.code.towns.Towns;
import lombok.NonNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class TabCompletion implements TabCompleter {

    private final CommandManager commandManager;

    public TabCompletion(Towns towns) {
        this.commandManager = towns.getCommandManager();
    }

    @Override
    public List<String> onTabComplete(@NonNull CommandSender sender, @NonNull Command command, @NonNull String alias, String[] args) {
        for (SubCommand subCommand : commandManager.getSubCommands()) {
            if (args[0].equalsIgnoreCase(subCommand.getName())) {
                return subCommand.onTabComplete(sender, args);
            }
        }
        return null;
    }
}