package lee.code.towns.database.cache.renters;

import lee.code.towns.database.DatabaseManager;
import lee.code.towns.database.cache.handlers.DatabaseHandler;
import lee.code.towns.database.cache.renters.data.OwnerListData;
import lee.code.towns.database.cache.renters.data.RenterListData;
import lee.code.towns.database.tables.RentTable;
import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CacheRenters extends DatabaseHandler {

    @Getter private final RenterListData renterListData;
    @Getter private final OwnerListData ownerListData;

    private final ConcurrentHashMap<String, RentTable> rentCache = new ConcurrentHashMap<>();

    public CacheRenters(DatabaseManager databaseManager) {
        super(databaseManager);
        this.renterListData = new RenterListData();
        this.ownerListData = new OwnerListData();
    }

    private RentTable getRentTable(String chunk) {
        return rentCache.get(chunk);
    }

    public void setRentTable(RentTable rentTable) {
     rentCache.put(rentTable.getChunk(), rentTable);
     ownerListData.addChunkList(rentTable.getOwner(), rentTable.getChunk());
     if (rentTable.getRenter() != null) renterListData.addChunkList(rentTable.getRenter(), rentTable.getChunk());
    }

    public void deleteAllRentData(UUID uuid) {
        if (!ownerListData.hasRentChunks(uuid)) return;
        for (String chunk : ownerListData.getChunkList(uuid)) {
            if (isRented(chunk)) renterListData.removeAllChunkList(getRenter(chunk));
            rentCache.remove(chunk);
        }
        ownerListData.removeAllChunkList(uuid);
        deleteAllRentDatabase(uuid);
    }

    private void createRentChunkTable(UUID uuid, String chunk, double price) {
        final RentTable rentTable = new RentTable(chunk, uuid, price);
        setRentTable(rentTable);
        createRentDatabase(rentTable);
    }

    public void setRentChunkPrice(UUID uuid, String chunk, double price) {
        if (!rentCache.containsKey(chunk)) {
            createRentChunkTable(uuid, chunk, price);
        } else {
            final RentTable rentTable = getRentTable(chunk);
            rentTable.setPrice(price);
            updateRentDatabase(rentTable);
        }
    }

    public void setRenter(UUID uuid, String chunk) {
        final RentTable rentTable = getRentTable(chunk);
        rentTable.setRenter(uuid);
        renterListData.addChunkList(uuid, chunk);
        updateRentDatabase(rentTable);
    }

    public void removeRenter(String chunk) {
        final RentTable rentTable = getRentTable(chunk);
        renterListData.removeChunkList(rentTable.getRenter(), chunk);
        rentTable.setRenter(null);
        updateRentDatabase(rentTable);
    }

    public void deleteRentableChunk(String chunk) {
        deleteRentDatabase(getRentTable(chunk));
        rentCache.remove(chunk);
    }

    public boolean isRented(String chunk) {
        return rentCache.containsKey(chunk) && getRentTable(chunk).getRenter() != null;
    }

    public UUID getRenter(String chunk) {
        return rentCache.get(chunk).getRenter();
    }

    public boolean isRentable(String chunk) {
        return rentCache.containsKey(chunk) && getRentTable(chunk).getRenter() == null;
    }

    public boolean hasRentData(String chunk) {
        return rentCache.containsKey(chunk);
    }

    public double getRentPrice(String chunk) {
        return getRentTable(chunk).getPrice();
    }

    public String getRenterName(String chunk) {
        return Bukkit.getOfflinePlayer(getRentTable(chunk).getRenter()).getName();
    }

    public boolean isPlayerRenting(UUID uuid, String chunk) {
        return getRentTable(chunk).getRenter().equals(uuid);
    }

}
