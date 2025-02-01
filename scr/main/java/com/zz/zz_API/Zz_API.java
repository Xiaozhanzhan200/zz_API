package com.zz.zz_API;

import com.zz.zz_API.Sell.SellAPI;
import com.zz.zz_API.Sell.SellPluginAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class Zz_API extends JavaPlugin {

    private SellAPI sellAPI;

    @Override
    public void onEnable() {
        // 创建 SellPluginAPI 实现类
        sellAPI = new SellPluginAPI(getConfig());

        // 将 SellAPI 注册到服务管理器中
        getServer().getServicesManager().register(SellAPI.class, sellAPI, this, org.bukkit.plugin.ServicePriority.Normal);
    }

    @Override
    public void onDisable() {
        // 在插件卸载时取消注册
        getServer().getServicesManager().unregister(SellAPI.class);

        // 保存配置文件
        saveConfig();
    }

    public SellAPI getSellAPI() {
        return sellAPI;
    }
}