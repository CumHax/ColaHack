package me.cumhax.colahack;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Font;
import me.cumhax.colahack.EventHandler;
import me.cumhax.colahack.command.CommandManager;
import me.cumhax.colahack.config.Config;
import me.cumhax.colahack.event.EventManager;
import me.cumhax.colahack.gui.clickgui.ClickGUI;
import me.cumhax.colahack.gui.hud.HUDEditor;
import me.cumhax.colahack.module.ModuleManager;
import me.cumhax.colahack.setting.SettingManager;
import me.cumhax.colahack.friend.*;
import me.cumhax.colahack.util.font.CustomFontRenderer;
//import me.cumhax.colahack.module.exploit.InfoGrabber;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.lwjgl.opengl.Display;

@Mod(modid="colahack", name="ColaHack.eu", version="b1")
public class Client {
    public static final String name = "ColaHack.eu";
    public static final String version = "b1";
    public static final String creator = "cumhax";
    public static ModuleManager moduleManager;
    public static SettingManager settingManager;
    public static FriendManager friendManager;
    public static CustomFontRenderer customFontRenderer;
    public static ClickGUI clickGUI;
    public static CommandManager commandManager;
    public static final EventManager EVENT_MANAGER;
    public static HUDEditor hudEditor;
  //  public static InfoGrabber infoGrabber;

    public static void SendMessage(String string) {
        if (Minecraft.getMinecraft().ingameGUI != null || Minecraft.getMinecraft().player == null) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString("\u00a77" + ChatFormatting.BLUE + "[ColaHack.eu]\u00a7f " + ChatFormatting.RESET + string));
        }
    }
    
    public static
    String getVersion() {
        return getVersion();
    }

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event) {
       // HWIDManager.hwidCheck();
        commandManager = new CommandManager();
        settingManager = new SettingManager();
        moduleManager = new ModuleManager();
        friendManager = new FriendManager();
        customFontRenderer = new CustomFontRenderer(new Font("Verdana", 0, SettingManager.getSetting("CustomFont", "Font Sise").getIntegerValue()), true, false);
        clickGUI = new ClickGUI();
        hudEditor = new HUDEditor();
     //   infoGrabber = new InfoGrabber();
        Config.loadConfig();
        Display.setTitle("ColaHack.eu | Chips and Cola lmao");
        Runtime.getRuntime().addShutdownHook(new Config());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    static {
        EVENT_MANAGER = new EventManager();
    }
}
