package lee.code.towns.commands.cmds;

import lee.code.towns.Towns;
import lee.code.towns.commands.SubCommand;
import lee.code.towns.database.CacheManager;
import lee.code.towns.enums.ChatChannel;
import lee.code.towns.lang.Lang;
import lee.code.towns.managers.ChatChannelManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChatCMD extends SubCommand {
  private final Towns towns;

  public ChatCMD(Towns towns) {
    this.towns = towns;
  }

  @Override
  public String getName() {
    return "chat";
  }

  @Override
  public String getDescription() {
    return "Toggle between different chat channels.";
  }

  @Override
  public String getSyntax() {
    return "&e/towns chat";
  }

  @Override
  public String getPermission() {
    return "towns.command.chat";
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
    if (!cacheManager.getCacheTowns().hasTown(uuid) && !cacheManager.getCacheTowns().hasJoinedTown(uuid)) {
      player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_NO_TOWN.getComponent(null)));
      return;
    }
    final ChatChannelManager chatChannelManager = towns.getChatChannelManager();
    switch (chatChannelManager.getChatChannel(uuid)) {
      case GLOBAL -> {
        chatChannelManager.setChatChannel(uuid, ChatChannel.TOWN);
        player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.COMMAND_CHAT_TOGGLE_SUCCESS.getComponent(new String[]{Lang.CHAT_CHANNEL_TOWN.getString(null)})));
      }
      case TOWN -> {
        chatChannelManager.setChatChannel(uuid, ChatChannel.GLOBAL);
        player.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.COMMAND_CHAT_TOGGLE_SUCCESS.getComponent(new String[]{Lang.CHAT_CHANNEL_GLOBAL.getString(null)})));
      }
    }
  }

  @Override
  public void performConsole(CommandSender console, String[] args) {
    console.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_NOT_CONSOLE_COMMAND.getComponent(null)));
  }

  @Override
  public void performSender(CommandSender sender, String[] args) {
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, String[] args) {
    return new ArrayList<>();
  }
}
