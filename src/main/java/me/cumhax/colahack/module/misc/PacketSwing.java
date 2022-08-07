package me.cumhax.colahack.module.misc;

import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import net.minecraft.item.ItemSword;
import org.lwjgl.input.Keyboard;

public class PacketSwing extends Module {

    public PacketSwing()
 {
        super("PacketSwing", "Swings with packets lol", Category.MISC);
    }

    @Override
    public void onUpdate() {
        if (PacketSwing.mc.player.getHeldItemMainhand().getItem() instanceof ItemSword && PacketSwing.mc.entityRenderer.itemRenderer.prevEquippedProgressMainHand >= 0.9) {
            PacketSwing.mc.entityRenderer.itemRenderer.equippedProgressMainHand = 1.0f;
            PacketSwing.mc.entityRenderer.itemRenderer.itemStackMainHand = PacketSwing.mc.player.getHeldItemMainhand();
        }
    }
}
