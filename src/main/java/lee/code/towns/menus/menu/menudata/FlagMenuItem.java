package lee.code.towns.menus.menu.menudata;

import lee.code.towns.enums.Flag;
import lee.code.towns.lang.Lang;
import lee.code.towns.utils.ItemUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public enum FlagMenuItem {
  INVITE("&e&lInvite", "&7Able to invite players to the town.", Flag.INVITE),
  BUILD("&e&lBuild", "&7Anything that can be built by\n&7a player or mob.", Flag.BUILD),
  CHUNK_FLAGS_ENABLED("&e&lChunk Flags Enabled", "&7If chunk flags should be enabled. When\n&7enabled they override global town flags.\n&7These flags also include players not\n&7apart of your town.", Flag.CHUNK_FLAGS_ENABLED),
  BREAK("&e&lBreak", "&7Anything that can be broken by\n&7a player or mob.", Flag.BREAK),
  INTERACT("&e&lInteract", "&7Anything that can be interacted\n&7with by a player or mob.", Flag.INTERACT),
  DAMAGE("&e&lDamage", "&7Anything that inflicts damage\n&7that is not from a player.", Flag.DAMAGE),
  PVP("&e&lPvP", "&7Damage taken or inflicted by a player.", Flag.PVP),
  PVE("&e&lPvE", "&7Damage taken or inflicted by a mob.", Flag.PVE),
  MONSTER_SPAWNING("&e&lMonster Spawning", "&7Spawn hostile monsters.", Flag.MONSTER_SPAWNING),
  REDSTONE("&e&lRedstone", "&7If redstone can be used.", Flag.REDSTONE),
  EXPLOSION("&e&lExplosions", "&7Explosions from mobs or players.", Flag.EXPLOSION),
  TELEPORT("&e&lTeleport", "&7Ender pearl or chorus fruit usage.", Flag.TELEPORT),
  CHANGE_CHUNK_FLAGS("&e&lChange Chunk Flags", "&7Able to change town chunk flags.", Flag.CHANGE_CHUNK_FLAGS),
  CHANGE_GLOBAL_FLAGS("&e&lChange Global Flags", "&7Able to change global town flags.", Flag.CHANGE_GLOBAL_FLAGS),
  WITHDRAW("&e&lWithdraw", "&7Able to withdraw money from the town bank.", Flag.WITHDRAW),
  CLAIM("&e&lClaim", "&7Able to claim chunks for the town.", Flag.CLAIM),
  UNCLAIM("&e&lUnclaim", "&7Able to unclaim chunks from the town.", Flag.UNCLAIM),
  FIRE_SPREAD("&e&lFire Spread", "&7If fire should spread to other blocks.", Flag.FIRE_SPREAD),
  ICE_MELT("&e&lIce Melt", "&7If ice should be possible to melt.", Flag.ICE_MELT),

  ;
  private final String name;
  private final String lore;
  @Getter private final Flag flag;

  public ItemStack createItem(boolean result) {
    final Material material = result ? Material.LIME_STAINED_GLASS_PANE : Material.RED_STAINED_GLASS_PANE;
    final String enabled = result ? Lang.TRUE.getString() : Lang.FALSE.getString();
    return ItemUtil.createItem(material, name, lore + "\n \n" + Lang.MENU_FLAG.getString(new String[]{enabled}), 0, null);
  }
}
