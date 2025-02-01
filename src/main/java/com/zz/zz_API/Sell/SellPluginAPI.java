package com.zz.zz_API.Sell;

import com.zz.zz_API.Sell.SellAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

public class SellPluginAPI implements SellAPI {

    private final FileConfiguration config;

    public SellPluginAPI(FileConfiguration config) {
        this.config = config;
    }

    @Override
    public double getItemPrice(Material material) {
        String itemName = material.toString();
        return config.getDouble("items." + itemName, 0.0);  // 返回物品的价格，若未设置则返回 0
    }

    @Override
    public boolean setItemPrice(Material material, double price) {
        if (price < 0) {
            return false;  // 价格不能为负数
        }
        String itemName = material.toString();
        config.set("items." + itemName, price);  // 设置物品的价格
        return true;  // 返回 true 表示设置成功
    }

    @Override
    public boolean sellItemToServer(Player player, Material material, int amount) {
        double price = getItemPrice(material);
        if (price == 0) {
            player.sendMessage("该物品没有设置价格！");
            return false;
        }

        // 检查玩家是否有足够的物品
        if (!player.getInventory().contains(material, amount)) {
            player.sendMessage("你没有足够的 " + material.toString() + " 可以出售！");
            return false;
        }

        // 移除物品
        player.getInventory().removeItem(new ItemStack(material, amount));

        // 给玩家金币
        double totalPrice = price * amount;
        // 假设你有一个给玩家金币的方法
        // givePlayerMoney(player, totalPrice);

        player.sendMessage("你成功出售了 " + amount + " 个 " + material.toString() + " 获得 " + totalPrice + " 金币！");
        return true;
    }
}