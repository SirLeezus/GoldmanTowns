package lee.code.towns.listeners.chunks;

import lee.code.towns.Towns;
import lee.code.towns.database.CacheManager;
import lee.code.towns.enums.Flag;
import lee.code.towns.events.PvPEvent;
import lee.code.towns.lang.Lang;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvPListener implements Listener {

    private final Towns towns;

    public PvPListener(Towns towns) {
        this.towns = towns;
    }

    @EventHandler
    public void onEntityDamageByEntityListener(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player victim) {
            if (e.getDamager() instanceof Player attacker) {
                final PvPEvent pvpEvent = new PvPEvent(victim, attacker, victim.getLocation());
                Bukkit.getServer().getPluginManager().callEvent(pvpEvent);
                if (pvpEvent.isCancelled()) e.setCancelled(true);
            } else if (e.getDamager() instanceof Projectile projectile) {
                if (projectile.getShooter() instanceof Player projectileAttacker) {
                    final PvPEvent pvpEvent = new PvPEvent(victim, projectileAttacker, victim.getLocation());
                    Bukkit.getServer().getPluginManager().callEvent(pvpEvent);
                    if (pvpEvent.isCancelled()) e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onPvP(PvPEvent e) {
        final CacheManager cacheManager = towns.getCacheManager();
        final boolean result = cacheManager.checkPlayerLocationFlag(e.getVictim().getUniqueId(), e.getLocation(), Flag.PVP);
        e.setCancelled(result);
        if (result) {
            e.getAttacker().sendActionBar(Lang.ERROR_LOCATION_PERMISSION.getComponent(new String[] { cacheManager.getChunkTownName(e.getLocation()), Flag.PVP.name(), Lang.FALSE.getString() }));
            e.getVictim().sendActionBar(Lang.ERROR_LOCATION_PERMISSION.getComponent(new String[] { cacheManager.getChunkTownName(e.getLocation()), Flag.PVP.name(), Lang.FALSE.getString() }));
        }
    }
}