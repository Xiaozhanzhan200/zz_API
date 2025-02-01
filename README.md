# zz_API
A plugin API for Minecraft, used for some of the plugins developed by me.
## use this API
### gradle
1. Add it in your root build.gradle at the end of repositories:
```
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```
2. Add the dependency
```
	dependencies {
	        implementation 'com.github.Xiaozhanzhan200:zz_API:1.0'
	}
```
### maven
1. Add the JitPack repository to your build file
```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
2. Add the dependency
```xml
	<dependency>
	    <groupId>com.github.Xiaozhanzhan200</groupId>
	    <artifactId>zz_API</artifactId>
	    <version>1.0</version>
	</dependency>
```
## Write in code
### zz_sell
**Example:**
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
