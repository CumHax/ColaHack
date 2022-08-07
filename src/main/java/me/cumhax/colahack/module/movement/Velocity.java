package me.cumhax.colahack.module.movement;

import me.cumhax.colahack.event.PacketEvent;
import me.cumhax.colahack.event.PacketReceiveEvent;
import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;


public class Velocity extends Module {

    public Velocity() {
        super("Velocity", "", Category.MOVEMENT);
    }
    @SubscribeEvent
    public void onUpdate(final PacketEvent.Receive event) {
        if (event.getPacket() instanceof SPacketExplosion || event.getPacket() instanceof SPacketEntityVelocity) {
            event.setCanceled(true);
        }
    }
}
