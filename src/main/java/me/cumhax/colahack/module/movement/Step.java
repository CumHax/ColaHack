package me.cumhax.colahack.module.movement;

import java.util.Arrays;
import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import me.cumhax.colahack.setting.Setting;
import me.cumhax.colahack.event.MoveEvent;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Step extends Module
{
	private final Setting mode = new Setting("Mode", this, Arrays.asList("Vanilla", "Packet"));
    private final Setting height = new Setting("Height", this, 0, 2, 10);
	
    public Step() 
	{	
        super("Step", "", Category.MOVEMENT);
        addSetting(mode);
        addSetting(height);
        }

	@SubscribeEvent
	public void onMove(MoveEvent event)
	{
		if (mc.player == null || mc.world == null || mc.player.isDead) return;

		if(mode.getEnumValue().equals("Vanilla")) {
		
		mc.player.stepHeight = 0.5f;
		if (mc.player.collidedHorizontally && mc.player.onGround)
		{
			mc.player.stepHeight = 0.5f;
		}
		else
		{
			mc.player.stepHeight = 2.0f;
		}
		}
	}
	
	@SubscribeEvent
	public void onUpdate(final TickEvent.ClientTickEvent event) {
		if (mc.player == null || mc.world == null || mc.player.isDead || !mc.player.collidedHorizontally || !mc.player.onGround || mc.player.isOnLadder() || mc.player.isInWater() || mc.player.isInLava() || mc.player.movementInput.jump || mc.player.noClip) return;
        if (mc.player.moveForward == 0 && mc.player.moveStrafing == 0) return;

        if(mode.getEnumValue().equals("Packet")) {
        
        final double n = get_n_normal();
        
        if (n < 0 || n > 2) return;
        
        if (n == 2.0) {
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.42, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.78, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.63, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.51, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.9, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.21, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.45, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.43, mc.player.posZ, mc.player.onGround));
        	mc.player.setPosition(mc.player.posX, mc.player.posY + 2.0, mc.player.posZ);
            	}
        if (n == 1.5) {
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.41999998688698, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.7531999805212, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.00133597911214, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.16610926093821, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.24918707874468, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.1707870772188, mc.player.posZ, mc.player.onGround));
        	mc.player.setPosition(mc.player.posX, mc.player.posY + 1.0, mc.player.posZ);
        }
        if (n == 1.0) {
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.41999998688698, mc.player.posZ, mc.player.onGround));
        	mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.7531999805212, mc.player.posZ, mc.player.onGround));
        	mc.player.setPosition(mc.player.posX, mc.player.posY + 1.0, mc.player.posZ);
        }
        }
	}

	public double get_n_normal() {

        mc.player.stepHeight = 0.5f;

        double max_y = -1;

        final AxisAlignedBB grow = mc.player.getEntityBoundingBox().offset(0, 0.05, 0).grow(0.05);

        if (!mc.world.getCollisionBoxes(mc.player, grow.offset(0, 2, 0)).isEmpty()) return 100;

        for (final AxisAlignedBB aabb : mc.world.getCollisionBoxes(mc.player, grow)) {

            if (aabb.maxY > max_y) {
                max_y = aabb.maxY;
            }

        }

        return max_y - mc.player.posY;

    }
	
	@Override
	public void onDisable()
	{
		mc.player.stepHeight = (float) 0.5;
	}
}
