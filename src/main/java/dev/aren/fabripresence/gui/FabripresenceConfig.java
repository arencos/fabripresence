package dev.aren.fabripresence.gui;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "fabripresence")
public class FabripresenceConfig implements ConfigData {
    public boolean on = true;
    public boolean showButtonInOptions = true;
    public boolean showServerAddress = false;
    public boolean showDimension = true;
    public boolean presenceHasImage = true;
    public String appid = "Default";
    public String largeImageKey = "large";
    public String flmm = "Playing Minecraft 1.16.5";
    public String slmm = "In the main menu";
    public String flsw = "Playing Minecraft 1.16.5";
    public String slsw = "In the select world screen";
    public String flom = "Playing Minecraft 1.16.5";
    public String slom = "In the options menu";
    public String flps = "Playing Minecraft 1.16.5";
    public String slps = "Playing Singleplayer";
    public String flm = "Playing Minecraft 1.16.5";
    public String slm = "In the multiplayer menu";
    public String flpm = "Playing Minecraft 1.16.5";
    public String slpm = "Playing Multiplayer";
}
