# zz_API
A plugin API for Minecraft, used for some of the plugins developed by me.
## zz_sell
**Example**:
```java
package com.you.plugin;

import com.zz.zz_API.Sell.SellAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AnotherPlugin extends JavaPlugin {

    private SellAPI sellAPI;

    @Override
    public void onEnable() {
        // Get SellAPI instance
        sellAPI = getServer().getServicesManager().load(SellAPI.class);
        if (sellAPI == null) {
            getLogger().warning("SellAPI not found!");
            return;
        }

        // use API
        Player player = getServer().getPlayer("SomePlayerName");
        if (player != null) {
            double price = sellAPI.getItemPrice(Material.DIAMOND);
            if (price > 0) {
                getLogger().info("The price of diamonds is:" + price);
                sellAPI.sellItemToServer(player, Material.DIAMOND, 5);
            } else {
                getLogger().info("Diamonds do not have a price set.");
            }
        }
    }
}
```
