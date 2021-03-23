package dev.aren.fabripresence.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import dev.aren.fabripresence.Fabripresence;
import dev.aren.fabripresence.gui.FabripresenceConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.network.ServerAddress;

@Mixin(ConnectScreen.class)
public class ConnectScreenMixin {
	@Inject(at = @At("HEAD"), method = "connect", locals = LocalCapture.CAPTURE_FAILHARD)
	private void connect(final String address, final int port, CallbackInfo ci) {
		if(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().showServerAddress) {
			Fabripresence.getDiscordRp().update(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().flpm, AutoConfig.getConfigHolder(FabripresenceConfig.class).get().slpm +  " (" + address + ")");
		} else {
			Fabripresence.getDiscordRp().update(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().flpm, AutoConfig.getConfigHolder(FabripresenceConfig.class).get().slpm);
		}
	}
}
