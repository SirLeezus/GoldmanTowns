package lee.code.towns.commands;

import lee.code.towns.commands.cmds.Test;
import lee.code.towns.lang.Lang;
import lee.code.towns.utils.CoreUtil;
import lombok.Getter;
import lombok.NonNull;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements CommandExecutor {

    @Getter private final ArrayList<SubCommand> subCommands = new ArrayList<>();

    public CommandManager() {
        subCommands.add(new Test());
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, String[] args) {
        if (sender instanceof Player player) {
            if (args.length > 0) {
                for (SubCommand subCommand : subCommands) {
                    if (args[0].equalsIgnoreCase(subCommand.getName())) {
                        if (player.hasPermission(subCommand.getPermission())) subCommand.perform(player, args);
                        else player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_NO_PERMISSION.getComponent(null)));
                        return true;
                    }
                }
            }
            sendHelpMessage(player);
        } else if (args.length > 0) {
            for (SubCommand subCommand : subCommands) {
                if (args[0].equalsIgnoreCase(subCommand.getName())) {
                    subCommand.performConsole(sender, args);
                    return true;
                }
            }
        }
        return true;
    }

    public void sendHelpMessage(CommandSender sender) {
        int number = 1;
        final List<Component> lines = new ArrayList<>();
        lines.add(Lang.COMMAND_HELP_DIVIDER.getComponent(null));
        lines.add(Lang.COMMAND_HELP_TITLE.getComponent(null));
        lines.add(Component.text(""));

        for (SubCommand subCommand : subCommands) {
            if (sender.hasPermission(subCommand.getPermission())) {
                final String suggestCommand = CoreUtil.getTextBeforeCharacter(subCommand.getSyntax(), '&');
                final Component helpSubCommand = Lang.COMMAND_HELP_SUB_COMMAND.getComponent(new String[] { String.valueOf(number), subCommand.getSyntax() })
                        .clickEvent(ClickEvent.clickEvent(ClickEvent.Action.SUGGEST_COMMAND, suggestCommand))
                        .hoverEvent(Lang.COMMAND_HELP_SUB_COMMAND_HOVER.getComponent(new String[] { subCommand.getDescription() }));
                lines.add(helpSubCommand);
                number++;
            }
        }
        lines.add(Component.text(""));
        lines.add(Lang.COMMAND_HELP_DIVIDER.getComponent(null));
        for (Component line : lines) sender.sendMessage(line);
    }
}