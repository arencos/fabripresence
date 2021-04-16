package dev.aren.fabripresence.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.aren.fabripresence.Fabripresence;
import dev.aren.fabripresence.gui.FabripresenceConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.options.OptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

@Mixin(OptionsScreen.class)
public class OptionsScreenMixin extends Screen {
	protected OptionsScreenMixin(Text title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	@Inject(at = @At("HEAD"), method = "init")
	private void addCustomButton(CallbackInfo ci) {
		if(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().on)
			Fabripresence.getDiscordRp().update(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().flom, AutoConfig.getConfigHolder(FabripresenceConfig.class).get().slom);

		if(AutoConfig.getConfigHolder(FabripresenceConfig.class).get().showButtonInOptions) {
			this.addButton(new ButtonWidget(this.width - 150, this.height - (this.height), 150, 20, Text.of("Fabripresence"), (buttonWidget) -> {
				MinecraftClient.getInstance().openScreen(AutoConfig.getConfigScreen(FabripresenceConfig.class, this).get());
			}));
		}
	}

}
