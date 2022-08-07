package me.cumhax.colahack.module.misc;

import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import me.cumhax.colahack.event.PacketSendEvent;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.LinkedList;
import java.util.Queue;

public class Blink extends Module
{
    private final Queue<CPacketPlayer> packetQueue = new LinkedList<>();
    private EntityOtherPlayerMP player;

   public Blink()
   {
    super("Blink", "", Category.MISC);
    }

    @SubscribeEvent
    public void onPacketSend(PacketSendEvent event)
    {
        if (nullCheck()) return;

        if (isEnabled() && event.getPacket() instanceof CPacketPlayer)
        {
            event.setCanceled(true);
            packetQueue.add((CPacketPlayer) event.getPacket());
        }
    }

    @Override
    public void onEnable()
    {
        player = new EntityOtherPlayerMP(mc.world, mc.getSession().getProfile());
        player.copyLocationAndAnglesFrom(mc.player);
        player.rotationYawHead = mc.player.rotationYawHead;
        mc.world.addEntityToWorld(-100, player);
    }

    @Override
    public void onDisable()
    {
        while (!packetQueue.isEmpty()) mc.player.connection.sendPacket(packetQueue.poll());

        if (mc.player != null)
        {
            mc.world.removeEntityFromWorld(-100);
            player = null;
        }
    }
}
