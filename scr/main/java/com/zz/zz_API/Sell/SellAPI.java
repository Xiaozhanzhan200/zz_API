package com.zz.zz_API.Sell;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public interface SellAPI {

    // 获取物品的价格
    double getItemPrice(Material material);

    // 设置物品的价格
    boolean setItemPrice(Material material, double price);

    // 出售物品给服务器
    boolean sellItemToServer(Player player, Material material, int amount);
}
