package me.cumhax.colahack.module.hud;

import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;

public class CulWatermark extends Module {
    public CulWatermark() {
        super("CulWatermark", "no explanation.", Category.HUD);
    }
    @SubscribeEvent
    public void draw(RenderGameOverlayEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        int[] counter = {1};

        mc.fontRenderer.drawStringWithShadow("ColaHack.eu | v0.0.1", 2, 2, rainbow(counter[0] * 300));
    }

    public static int rainbow(int rgbdelay) {
        double rainbowState = Math.ceil((System.currentTimeMillis() + rgbdelay) / 20.0);
        rainbowState %= 360;
        return Color.getHSBColor((float)(rainbowState / 360.0f), 0.5f, 1f).getRGB();
    }
}
