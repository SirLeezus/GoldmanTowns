package lee.code.towns.listeners.chunks;

import lee.code.towns.Towns;
import lee.code.towns.database.CacheManager;
import lee.code.towns.enums.Flag;
import lee.code.towns.events.InteractEvent;
import lee.code.towns.utils.ChunkUtil;
import lee.code.towns.utils.FlagUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {
  private final Towns towns;

  public InteractListener(Towns towns) {
    this.towns = towns;
  }

  @EventHandler
  public void onInteractListener(PlayerInteractEvent e) {
    if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
      if (e.getClickedBlock() == null) return;
      final InteractEvent interactEvent = new InteractEvent(e.getPlayer(), ChunkUtil.serializeChunkLocation(e.getClickedBlock().getLocation().getChunk()));
      Bukkit.getServer().getPluginManager().callEvent(interactEvent);
      if (interactEvent.isCancelled()) e.setCancelled(true);
    }
  }

  @EventHandler
  public void onInteractEntityListener(PlayerInteractEntityEvent e) {
    final InteractEvent interactEvent = new InteractEvent(e.getPlayer(), ChunkUtil.serializeChunkLocation(e.getRightClicked().getLocation().getChunk()));
    Bukkit.getServer().getPluginManager().callEvent(interactEvent);
    if (interactEvent.isCancelled()) e.setCancelled(true);
  }

  @EventHandler
  public void onInteractAtEntityListener(PlayerInteractAtEntityEvent e) {
    final InteractEvent interactEvent = new InteractEvent(e.getPlayer(), ChunkUtil.serializeChunkLocation(e.getRightClicked().getLocation().getChunk()));
    Bukkit.getServer().getPluginManager().callEvent(interactEvent);
    if (interactEvent.isCancelled()) e.setCancelled(true);
  }

  @EventHandler
  public void onPlayerBucketEmptyListener(PlayerBucketEmptyEvent e) {
    final InteractEvent interactEvent = new InteractEvent(e.getPlayer(), ChunkUtil.serializeChunkLocation(e.getBlock().getLocation().getChunk()));
    Bukkit.getServer().getPluginManager().callEvent(interactEvent);
    if (interactEvent.isCancelled()) e.setCancelled(true);
  }

  @EventHandler
  public void onInteract(InteractEvent e) {
    final CacheManager cacheManager = towns.getCacheManager();
    final boolean result = cacheManager.checkPlayerLocationFlag(e.getPlayer().getUniqueId(), e.getChunk(), Flag.INTERACT, true);
    e.setCancelled(result);
    if (result) FlagUtil.sendFlagErrorMessage(e.getPlayer(), Flag.INTERACT, cacheManager.getChunkTownName(e.getChunk()), cacheManager.getCacheRenters().getRenterName(e.getChunk()));
  }
}
