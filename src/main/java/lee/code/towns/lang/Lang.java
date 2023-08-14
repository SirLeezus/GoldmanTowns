package lee.code.towns.lang;

import lee.code.towns.utils.CoreUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.kyori.adventure.text.Component;

@AllArgsConstructor
public enum Lang {
    PREFIX("&e&lTowns &6➔ "),
    USAGE("&6&lUsage&7: "),
    VALUE_FORMAT("&6${0}"),
    ON("&2&lON"),
    OFF("&c&lOFF"),
    TRUE("&2true"),
    FALSE("&cfalse"),
    ACCEPT("&2[&aAccept&2]"),
    CONFIRM("&2[&aConfirm&2]"),
    DENY("&4[&cDeny&4]"),
    PUBLIC("&2&lPublic"),
    PRIVATE("&c&lPrivate"),
    CLICK("&9&lClick &b➔ "),
    AUTO_MESSAGE_TOWN("&eWelcome to town &6&l{0}&e!"),
    AUTO_MESSAGE_RENTABLE("&eChunk is rentable for {0} &ea day!"),
    AUTO_MESSAGE_RENTED("&eChunk is being rented by &6{0}&e!"),
    MESSAGE_HOVER("&6&lPlayer&7: {display-name}\n&6&lTown&7: {town}\n&6&lTown Role&7: {role}"),
    RENT_COLLECTION_FINISHED("&aRent has been collected!"),
    COMMAND_PUBLIC_SUCCESS("&aYour town status is now set to {0}&a."),
    COMMAND_HELP_DIVIDER("&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"),
    COMMAND_HELP_TITLE("                      &2-== &6&l&nTowns Help&r &2==-"),
    COMMAND_HELP_SUB_COMMAND("&3{0}&b. &e{1}"),
    COMMAND_HELP_SUB_COMMAND_HOVER("&6{0}"),
    COMMAND_CREATE_ANNOUNCEMENT_TOWN_CREATED("&aThe player &6{0} &ahas created the town &3{1}&a!"),
    COMMAND_CREATE_SUCCESS("&aYou successfully created the town &3{0}&a!"),
    COMMAND_BORDER_SUCCESS("&aYou successfully toggled &3{0} &aborder on!"),
    COMMAND_BORDER_OFF_SUCCESS("&aYou successfully toggled your border off!"),
    COMMAND_CLAIM_SUCCESS("&aYou successfully claimed the chunk &3{0}&a. &b(&3{1}&7/&3{2}&b)"),
    COMMAND_CLAIM_OUTPOST_SUCCESS("&aYou successfully claimed outpost chunk &3{0}&a. &b(&3{1}&7/&3{2}&b)"),
    COMMAND_UNCLAIM_SUCCESS("&aYou successfully unclaimed the chunk &3{0}&a."),
    COMMAND_MAP_HEADER("&a----------- &7[ &2&lMap Key &7] &a-----------"),
    COMMAND_MAP_FOOTER("&a----------------------------------"),
    COMMAND_MAP_LINE_1("    &e\\ {0}&lN &e/ &6&lYOU&7: &9■ &6&lOWNER&7: &2■ &6&lWILD&7: &7■"),
    COMMAND_MAP_LINE_2("    {0}&lW &6&l• {1}&lE &6&lCITIZEN&7: &a■ &6&lCLAIMED&7: &c■"),
    COMMAND_MAP_LINE_3("    &e/ {0}&lS &e\\"),
    COMMAND_SPAWN_SUCCESS("&aYou successfully teleported to your town spawn."),
    COMMAND_INFO_TOWN_NAME("&6&lTown Name&7: &3{0}"),
    COMMAND_INFO_TOWN_OWNER("&6&lTown Mayor&7: &3{0}"),
    COMMAND_INFO_TOWN_CITIZENS("&6&lTown Citizens&7: &3{0}"),
    COMMAND_INFO_TOWN_CHUNKS("&6&lTown Chunks&7: &3{0}&7/&3{1}"),
    COMMAND_INFO_TOWN_OUTPOSTS("&6&lTown Outposts&7: &3{0}&7/&3{1}"),
    COMMAND_INFO_TOWN_RENT("&6&lRent Collection&7: {0}"),
    COMMAND_INFO_TOWN_PUBLIC("&6&lTown Status&7: {0}"),
    COMMAND_INFO_HEADER("&a---------- &7[ &2&lTown Info &7] &a----------"),
    COMMAND_INFO_FOOTER("&a----------------------------------"),
    COMMAND_CHUNK_INFO_CHUNK("&6&lChunk&7: &3{0}"),
    COMMAND_CHUNK_INFO_TOWN_OWNER("&6&lTown Owner&7: &3{0}"),
    COMMAND_CHUNK_INFO_TOWN_ESTABLISHED_CHUNK("&6&lEstablished Chunk&7: {0}"),
    COMMAND_CHUNK_INFO_RENTER("&6&lRenting&7: &3{0}"),
    COMMAND_CHUNK_INFO_RENT_COST("&6&lDaily Rent Cost&7: {0}"),
    COMMAND_CHUNK_INFO_HEADER("&a---------- &7[ &2&lChunk Info &7] &a----------"),
    COMMAND_CHUNK_INFO_FOOTER("&a-----------------------------------"),
    COMMAND_RENT_PRICE_SUCCESS("&aYou successfully set chunk &3{0} &adaily rent price to {1}&a!"),
    COMMAND_RENT_REMOVE_SUCCESS("&aYou successfully removed chunk &3{0} &afrom being rentable."),
    COMMAND_RENT_CLAIM_SUCCESS("&aYou are now renting chunk &3{0}&a!"),
    COMMAND_RENT_UNCLAIM_SUCCESS("&aYou are no longer renting chunk &3{0}&a!"),
    COMMAND_RENT_CLAIM_DENY_SUCCESS("&aYou successfully denied renting chunk &3{1}&a."),
    COMMAND_RENT_UNCLAIM_DENY_SUCCESS("&aYou successfully denied unclaiming rented chunk &3{1}&a."),
    COMMAND_RENT_CLAIM_WARNING("&aAre you sure you want to rent chunk &3{0} &afor &6{1} &aa day?"),
    COMMAND_RENT_UNCLAIM_WARNING("&aAre you sure you want to unclaim the rented chunk &3{0}&a?"),
    COMMAND_RENT_TRUST_ADD_SUCCESS("&aYou successfully added player &6{0} &ato your rent trusted list!"),
    COMMAND_RENT_TRUST_REMOVE_SUCCESS("&aYou successfully removed player &6{0} &afrom your rent trusted list."),
    CONFIRM_RENT_CLAIM_HOVER("&aClick to confirm rent chunk!"),
    DENY_RENT_CLAIM_HOVER("&cClick to deny rent chunk!"),
    CONFIRM_RENT_UNCLAIM_HOVER("&aClick to confirm unclaiming rented chunk!"),
    DENY_RENT_UNCLAIM_HOVER("&cClick to deny unclaiming rented chunk!"),
    COMMAND_SET_SPAWN_SUCCESS("&aYou successfully set your town spawn!"),
    COMMAND_SPAWN_FAILED("&cFailed to teleport to town spawn."),
    COMMAND_AUTO_CLAIM_SUCCESS("&aYou successfully toggled auto claim {0}&a."),
    COMMAND_ROLE_SET_SUCCESS("&aYou successfully set player &6{0} &ato the town role &3{1}&a."),
    COMMAND_ROLE_CREATE_SUCCESS("&aYou successfully created the town role &3{0}&a."),
    COMMAND_ROLE_DELETE_SUCCESS("&aYou successfully deleted the town role &3{0}&a."),
    COMMAND_ROLE_COLOR_SUCCESS("&aYou successfully set role &3{0} &acolor to {1}{2}&a."),
    COMMAND_INVITE_TARGET_SUCCESS("&aWould you like to join the town &6{0}&a?"),
    COMMAND_INVITE_ACCEPT_TARGET_SUCCESS("&aThe player &6{0} &aaccepted your town invite!"),
    COMMAND_INVITE_ACCEPT_SUCCESS("&aYou accepted &6{0} &atown invite!"),
    COMMAND_INVITE_ACCEPT_JOINED_TOWN("&aThe player &6{0} &ahas joined the town!"),
    CONFIRM_ABANDON_HOVER("&aClick to abandon your town!"),
    DENY_ABANDON_HOVER("&cClick to deny abandoning your town!"),
    COMMAND_ABANDON_WARNING("&aAre you sure you want to abandon your town &6{0}&a?"),
    COMMAND_INVITE_DENY_TARGET_SUCCESS("&7The player &6{0} &7denied your town invite."),
    COMMAND_INVITE_DENY_SUCCESS("&7You denied &6{0}'s &7town invite."),
    COMMAND_INVITE_SUCCESS("&aYou successfully invited &6{0} &ato your town."),
    COMMAND_ACCEPT_INVITE_HOVER("&aClick to accept &6{0}'s &atown invite!"),
    COMMAND_DENY_INVITE_HOVER("&cClick to deny &6{0}'s &ctown invite."),
    COMMAND_ABANDON_TOWN_MESSAGE("&cThe mayor has abandoned the town."),
    COMMAND_ABANDON_SUCCESS("&aYou successfully abandoned your town &3{0}&a."),
    COMMAND_ABANDON_DENY("&aYou successfully denied abandoning your town."),
    COMMAND_LEAVE_SUCCESS("&aYou successfully left the town &6{0}&a."),
    COMMAND_LEAVE_DENY("&aYou successfully denied leaving the town &6{0}&a."),
    COMMAND_LEAVE_PLAYER_LEFT_TOWN("&7The player &6{0} &7has left the town."),
    COMMAND_LEAVE_WARNING("&aAre you sure you want to leave your town &6{0}&a?"),
    COMMAND_LEAVE_HOVER_CONFIRM("&aLeave the town &3{0}&a!"),
    COMMAND_LEAVE_HOVER_DENY("&cDeny leaving the town &3{0}&c."),
    COMMAND_CHAT_TOGGLE_SUCCESS("&aYou are now in chat channel {0}&a."),
    CHAT_CHANNEL_GLOBAL_PREFIX("&a[&2G&a]"),
    CHAT_CHANNEL_GLOBAL("&2&lGlobal"),
    CHAT_CHANNEL_TOWN_PREFIX("&b[&3T&b]"),
    CHAT_CHANNEL_TOWN("&3&lTown"),
    TELEPORT_CHUNK_SUCCESS("&aYou successfully teleported the chunk &3{0}&a."),
    TELEPORT_CHUNK_FAILED("&cFailed to teleport to chunk &3{0}&c."),
    MENU_FLAG_MANAGER_TITLE("&2&lFlag Manager"),
    MENU_FLAG_MANAGER_CHUNK_TITLE("&2&lChunk Flag Manager"),
    MENU_FLAG_MANAGER_GLOBAL_TITLE("&2&lGlobal Flag Manager"),
    MENU_FLAG_MANAGER_ROLE_TITLE("&2&lRole Flag Manager"),
    MENU_ROLE_SELECTION_MANAGER_TITLE("&2&lRole Selection Manager"),
    MENU_FLAG("&aEnabled&8: {0}"),
    MENU_ROLE_NAME("&e&l{0}"),
    CHAT_GLOBAL("{display-name}&7: &f{message}"),
    CHAT_TOWN("{channel} &7[&e{role}&7] {display-name}&7: &3{message}"),
    ERROR_LOCATION_PERMISSION("&2&lTown&7: &6{0} &8| &2&l{1}&7: &6{2}"),
    ERROR_NO_PERMISSION("&cYou sadly do not have permission for this."),
    ERROR_NOT_CONSOLE_COMMAND("&cThis command does not work in console."),
    ERROR_ONE_COMMAND_AT_A_TIME("&cYou're currently processing another town command, please wait for it to finish."),
    ERROR_CREATE_HAS_TOWN("&cYou already own a town called &3{0}&c, if you want to create a new town you'll need to disband your current town."),
    ERROR_CREATE_HAS_JOINED_TOWN("&cYou are currently in the town &3{0}&c. You'll need to leave it before creating your own town."),
    ERROR_CREATE_ALREADY_EXIST("&cThe town name &3{0} &chas already been used, you'll need to choose a different name."),
    ERROR_CREATE_CHUNK_CLAIMED("&cThe chunk you're standing on is already owned by &3{0}&c, you need to find a location in the wild to create a town."),
    ERROR_CLAIM_ALREADY_CLAIMED("&cThe chunk &3{0} &cis already owned by the town &3{1}&c."),
    ERROR_CLAIM_NOT_CONNECTED_CHUNK("&cThe chunk &3{0} &cis not connected to any of your town chunks."),
    ERROR_CLAIM_MAX_CLAIMS("&cYou have already reached your town's max chunk claims of &3{0}&c."),
    ERROR_CLAIM_MAX_OUTPOSTS("&cYou have already reached your town's max outpost claims of &3{0}&c."),
    ERROR_CLAIM_OUTPOST_CONNECTED("&cOutposts are claims that don't need to be connected to current town claims."),
    ERROR_AUTO_CLAIM_MAX_CLAIMS("&cYou have already reached your town's max chunk claims of &3{0}&c. Auto claim has been disabled."),
    ERROR_AUTO_CLAIM_NOT_OWNER("&cYou can only toggle on auto claim when you're within your town."),
    ERROR_SET_SPAWN_NOT_CLAIMED("&cYou can only set your town spawn in chunks you own."),
    ERROR_NO_TOWN("&cYou're currently not apart of a town so you can't run this command."),
    ERROR_NOT_TOWN_OWNER("&cYou need to be the town owner to run this command."),
    ERROR_UNCLAIM_NOT_CLAIMED("&cThe chunk &3{0} &cis not claimed."),
    ERROR_UNCLAIM_NOT_OWNER("&cYou're not the owner of chunk &3{0} &cso you can't unclaim it."),
    ERROR_UNCLAIM_AUTO_CLAIM_ON("&cYou can't run this command while auto claim is active."),
    ERROR_UNCLAIM_ESTABLISHED_CHUNK("&cYou can't unclaim your town's established chunk, this is the chunk your town was created on."),
    ERROR_UNCLAIM_UNSAFE("&cYou can't unclaim chunk &3{0} &cbecause is would disconnect other chunks from your town's established chunk."),
    ERROR_UNCLAIM_RENTABLE("&cThe chunk &3{0} &cis rentable, remove it from being rentable to unclaim this chunk."),
    ERROR_UNCLAIM_RENTED("&cThe chunk &3{0} &cis currently being rented by &6{0} &cso it can't be unclaimed."),
    ERROR_AUTO_CLAIM_RANGE("&cYou are now out of range from your last auto claim, auto claim has been toggled {0}&c."),
    ERROR_FLAG_MANAGER_CHUNK_NOT_TOWN("&cThe chunk you're standing is not apart of your town."),
    ERROR_FLAG_MANAGER_CHUNK_NOT_CLAIMED("&cThe chunk you're standing on is not claimed."),
    ERROR_FLAG_MANAGER_GLOBAL_NO_PERMS("&cYou do not have permission to change global town flags."),
    ERROR_FLAG_MANAGER_CHUNK_NO_PERMS("&cYou do not have permission to change town chunk flags."),
    ERROR_FLAG_MANAGER_CHUNK_RENTED("&cThe chunk &3{0} &cis being rented by &6{1} &cso you can't change the chunk flags, only the renter can."),
    ERROR_FLAG_MANAGER_ROLE_NOT_OWNER("&cOnly the mayor can change role flags."),
    ERROR_PLAYER_NOT_FOUND("&cThe player &6{0} &ccould not be found."),
    ERROR_ROLE_ROLE_NOT_FOUND("&cYou do not have a town role called &3{0}&c."),
    ERROR_ROLE_COLOR_NOT_FOUND("&cThe color &3{0} &cis not a valid option."),
    ERROR_ROLE_SET_PLAYER_NOT_CITIZEN("&cThe player &6{0} &cis not a town citizen, the player needs to be apart of the town before you can set a town role for the player."),
    ERROR_ROLE_SET_PLAYER_ALREADY_HAS_ROLE("&cThe player &6{0} &calready has the town role {1}&c."),
    ERROR_ROLE_CREATE_ROLE_EXISTS("&cThe role &3{0} &calready exists."),
    ERROR_ROLE_CREATE_MAX_ROLES("&cYou have already reached the max roles you can create."),
    ERROR_INVITE_TIMEOUT_PLAYER("&7Your town invite to the player &6{0} &7has expired."),
    ERROR_INVITE_TIMEOUT_TARGET("&7The town invite from the player &6{0} &7has expired."),
    ERROR_INVITE_INVALID("&cYou currently do not have a town invite."),
    ERROR_INVITE_PENDING("&cYou already have a town invite pending for the player &6{0}&c."),
    ERROR_INVITE_SELF("&cYou can't invite yourself."),
    ERROR_INVITE_APART_OF_TOWN("&cThe player &6{0} &cis already in a town."),
    ERROR_INVITE_NO_TOWN("&cYou need to be apart of a town to invite players to it."),
    ERROR_PLAYER_NOT_ONLINE("&cThe player &6{0} &cis currently not online."),
    ERROR_CHUNK_INFO_NOT_CLAIMED("&cThe chunk you're standing on is not claimed."),
    ERROR_RENT_NOT_CLAIMED("&cYou can only perform this command on a claimed chunk."),
    ERROR_RENT_PRICE_NOT_OWNER("&cOnly the mayor of the town can set rent prices for town chunks."),
    ERROR_RENT_REMOVE_NOT_OWNER("&cOnly the mayor of the town can remove the ability to rent a chunk."),
    ERROR_RENT_REMOVE_NOT_RENTABLE("&cThe chunk &3{0} &cis not rentable already."),
    ERROR_RENT_REMOVE_BEING_RENTED("&cThe chunk &3{0} &cis currently being rented by &6{1} &cso you can't remove it from being rentable until they unclaim it."),
    ERROR_RENT_CLAIM_NOT_CITIZEN("&cYou are not apart of the town &3{0} &cso you can't rent this chunk."),
    ERROR_RENT_CLAIM_NOT_RENTABLE("&cThe chunk &3{0} &cis currently not rentable."),
    ERROR_RENT_UNCLAIM_NOT_RENTED("&cThe chunk &3{0} &cis currently not being rented."),
    ERROR_RENT_UNCLAIM_NOT_RENTED_BY_PLAYER("&cThe chunk &3{0} &cis currently not being rented by you so you can't unclaim it."),
    ERROR_RENT_PRICE_INVALID("&cThe input &6{0} &cis not an acceptable value."),
    ERROR_VALUE_INVALID("&cThe input &6{0} &cis not an acceptable value."),
    ERROR_TOWN_OWNER_LEAVE("&cYou are the owner of the town, if you want to leave you'll need to abandon the town."),
    ERROR_BORDER_NONE_RENTED("&cYou currently don't have any rented chunks."),
    ;
    @Getter private final String string;

    public String getString(String[] variables) {
        String value = string;
        if (variables == null || variables.length == 0) return value;
        for (int i = 0; i < variables.length; i++) value = value.replace("{" + i + "}", variables[i]);
        return value;
    }

    public Component getComponent(String[] variables) {
        String value = string;
        if (variables == null || variables.length == 0) return CoreUtil.parseColorComponent(value);
        for (int i = 0; i < variables.length; i++) value = value.replace("{" + i + "}", variables[i]);
        return CoreUtil.parseColorComponent(value);
    }
}
