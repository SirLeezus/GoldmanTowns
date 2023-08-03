package lee.code.towns.commands.cmds;

import lee.code.towns.Towns;
import lee.code.towns.commands.SubCommand;
import lee.code.towns.database.cache.CacheChunks;
import lee.code.towns.database.cache.CacheTowns;
import lee.code.towns.lang.Lang;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InfoCMD extends SubCommand {

    private final Towns towns;

    public InfoCMD(Towns towns) {
        this.towns = towns;
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "Info about your town.";
    }

    @Override
    public String getSyntax() {
        return "/towns info";
    }

    @Override
    public String getPermission() {
        return "towns.command.info";
    }

    @Override
    public boolean performAsync() {
        return true;
    }

    @Override
    public boolean performAsyncSynchronized() {
        return false;
    }

    @Override
    public void perform(Player player, String[] args) {
        final CacheTowns cacheTowns = towns.getCacheManager().getCacheTowns();
        final CacheChunks cacheChunks = towns.getCacheManager().getCacheChunks();
        final UUID uuid = player.getUniqueId();
        if (cacheTowns.hasTown(uuid) || cacheTowns.hasJoinedTown(uuid)) {
            final List<Component> lines = new ArrayList<>();
            final UUID owner = cacheTowns.hasTown(uuid) ? uuid : cacheTowns.getJoinedTownOwner(uuid);
            lines.add(Lang.COMMAND_INFO_HEADER.getComponent(null));
            lines.add(Component.text(""));
            lines.add(Lang.COMMAND_INFO_TOWN_NAME.getComponent(new String[] { cacheTowns.getTown(owner) }));
            lines.add(Lang.COMMAND_INFO_TOWN_CITIZENS.getComponent(new String[] { cacheTowns.getCitizenNames(owner) }));
            lines.add(Lang.COMMAND_INFO_TOWN_CHUNKS.getComponent(new String[] { String.valueOf(cacheChunks.getChunkClaims(uuid)), String.valueOf(cacheTowns.getMaxChunkClaims(uuid)) }));
            lines.add(Component.text(""));
            lines.add(Lang.COMMAND_INFO_FOOTER.getComponent(null));
            for (Component line : lines) player.sendMessage(line);
        } else player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_NO_TOWN.getComponent(null)));
    }

    @Override
    public void performConsole(CommandSender console, String[] args) {
        console.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_NOT_CONSOLE_COMMAND.getComponent(null)));
    }

    @Override
    public void performSender(CommandSender sender, String[] args) { }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return new ArrayList<>();
    }
}
