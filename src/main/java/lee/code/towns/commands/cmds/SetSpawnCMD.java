package lee.code.towns.commands.cmds;

import lee.code.towns.Towns;
import lee.code.towns.commands.SubCommand;
import lee.code.towns.database.cache.CacheManager;
import lee.code.towns.lang.Lang;
import lee.code.towns.utils.ChunkUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SetSpawnCMD extends SubCommand {

    private final Towns towns;

    public SetSpawnCMD(Towns towns) {
        this.towns = towns;
    }

    @Override
    public String getName() {
        return "setspawn";
    }

    @Override
    public String getDescription() {
        return "Set the spawn to your town.";
    }

    @Override
    public String getSyntax() {
        return "&e/towns spawn";
    }

    @Override
    public String getPermission() {
        return "towns.command.spawn";
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
        final CacheManager cacheManager = towns.getCacheManager();
        final UUID uuid = player.getUniqueId();
        if (!cacheManager.getCachePlayers().hasTown(uuid)) {
            player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_NOT_TOWN_OWNER.getComponent(null)));
            return;
        }
        final String chunk = ChunkUtil.serializeChunkLocation(player.getChunk());
        if (!cacheManager.getCacheChunks().isClaimed(chunk) || !cacheManager.getCacheChunks().getChunkOwner(chunk).equals(uuid)) {
            player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_SET_SPAWN_NOT_CLAIMED.getComponent(null)));
            return;
        }
        cacheManager.getCachePlayers().setTownSpawn(uuid, player.getLocation());
        player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.COMMAND_SET_SPAWN_SUCCESS.getComponent(null)));
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