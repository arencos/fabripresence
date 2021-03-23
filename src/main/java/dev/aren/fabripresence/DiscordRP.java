package dev.aren.fabripresence;

import club.minnced.discord.rpc.*;
import dev.aren.fabripresence.gui.FabripresenceConfig;
import me.shedaniel.autoconfig.AutoConfig;

public class DiscordRP {
	
	public static DiscordRPC lib = DiscordRPC.INSTANCE;
	public static DiscordRichPresence presence = new DiscordRichPresence();
	public static String applicationId = AutoConfig.getConfigHolder(FabripresenceConfig.class).get().appid.equals("Default") ? "818194591723028510" : AutoConfig.getConfigHolder(FabripresenceConfig.class).get().appid;
	// 818194591723028510


	public static void start() {
		DiscordEventHandlers handlers = new DiscordEventHandlers();
		handlers.ready = (user) -> System.out.println("Ready.");
		lib.Discord_Initialize(applicationId, handlers, true, null);
		presence.startTimestamp = System.currentTimeMillis() / 1000;
		presence.details = "";
		presence.state = "Starting game.";
		if(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().presenceHasImage)
			presence.largeImageKey = AutoConfig.getConfigHolder(FabripresenceConfig.class).get().largeImageKey;
		lib.Discord_UpdatePresence(presence);

		Thread t = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				lib.Discord_RunCallbacks();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					lib.Discord_Shutdown();
					break;
				}
			}
		}, "RPC-Callback-Handler");
		t.start();
	}

	public static void update(String firstLine, String secondLine) {
		presence.details = firstLine;
		presence.state = secondLine;
		lib.Discord_UpdatePresence(presence);
	}

}
