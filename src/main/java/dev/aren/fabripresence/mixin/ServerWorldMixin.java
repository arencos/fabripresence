package dev.aren.fabripresence.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.aren.fabripresence.Fabripresence;
import dev.aren.fabripresence.gui.FabripresenceConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
	@Shadow
	private MinecraftServer server;
	
	@Inject(at = @At("HEAD"), method = "addPlayer")
	private void addPlayer(ServerPlayerEntity player, CallbackInfo ci) {
		if(server.isSinglePlayer()) {
			//Fabripresence.getDiscordRp().update(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().flps, AutoConfig.getConfigHolder(FabripresenceConfig.class).get().slps + " " + String.valueOf(player.world.getRegistryKey().getValue()));
			System.out.println(String.valueOf(player.world.getRegistryKey().getValue()));
		}
	}
}
