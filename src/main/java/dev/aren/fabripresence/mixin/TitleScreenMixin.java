package dev.aren.fabripresence.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.aren.fabripresence.Fabripresence;
import dev.aren.fabripresence.gui.FabripresenceConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.gui.screen.TitleScreen;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
	@Inject(at = @At("HEAD"), method = "init")
	private void init(CallbackInfo info) {
		if(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().on)
			Fabripresence.getDiscordRp().update(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().flmm, AutoConfig.getConfigHolder(FabripresenceConfig.class).get().slmm);
	}
}