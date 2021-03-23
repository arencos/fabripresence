package dev.aren.fabripresence.mixin;

import dev.aren.fabripresence.Fabripresence;
import dev.aren.fabripresence.gui.FabripresenceConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    @Inject(at = @At("TAIL"), method = "onWorldBorder")
    private void onWorldBorder(CallbackInfo ci) {
        if(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().showDimension) {
            Fabripresence.getDiscordRp().update(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().flps, AutoConfig.getConfigHolder(FabripresenceConfig.class).get().slps + " (" + MinecraftClient.getInstance().player.world.getRegistryKey().getValue() + ")");
        } else if(!AutoConfig.getConfigHolder(FabripresenceConfig.class).get().showDimension) {
            Fabripresence.getDiscordRp().update(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().flps, AutoConfig.getConfigHolder(FabripresenceConfig.class).get().slps);
        }
    }


    @Inject(at = @At("TAIL"), method = "onGameJoin")
    private void onGameJoin(CallbackInfo ci) {
        if(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().showDimension) {
            Fabripresence.getDiscordRp().update(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().flps, AutoConfig.getConfigHolder(FabripresenceConfig.class).get().slps + " (" + MinecraftClient.getInstance().player.world.getRegistryKey().getValue() + ")");
        } else if(!AutoConfig.getConfigHolder(FabripresenceConfig.class).get().showDimension) {
            Fabripresence.getDiscordRp().update(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().flps, AutoConfig.getConfigHolder(FabripresenceConfig.class).get().slps);
        }
    }
}
