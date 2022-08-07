package me.cumhax.colahack.module.combat;

import me.cumhax.colahack.module.Module;
import me.cumhax.colahack.module.Category;
import net.minecraft.item.ItemBow;
import net.minecraft.util.math.*;
import net.minecraft.network.*;
import net.minecraft.network.play.client.*;

public class BowSpam extends Module
{
    public BowSpam()
    {
        super("BowSpam", "spam arrows :^]", Category.COMBAT);
    }
    
    @Override
    public void onUpdate() {
        if (this.mc.player.getHeldItemMainhand().getItem() instanceof ItemBow && this.mc.player.isHandActive() && this.mc.player.getItemInUseMaxCount() >= 3) {
            this.mc.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, this.mc.player.getHorizontalFacing()));
            this.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(this.mc.player.getActiveHand()));
            this.mc.player.stopActiveHand();
        }
    }
}
