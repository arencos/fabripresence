package dev.aren.fabripresence;

import dev.aren.fabripresence.gui.FabripresenceConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public class Fabripresence implements ModInitializer {
	
	private static DiscordRP discordRp;
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		AutoConfig.register(FabripresenceConfig.class, JanksonConfigSerializer::new);
		discordRp = new DiscordRP();

		System.out.println("Hello Fabric world!");
		
		if(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().on)
			discordRp.start();
		//FabripresenceConfig config = AutoConfig.getConfigHolder(FabripresenceConfig.class).getConfigClass();
		
	}
	
	
	
	public static DiscordRP getDiscordRp() {
		return discordRp;
	}
}
