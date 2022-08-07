package me.cumhax.colahack.module.movement;

import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ReverseStep extends Module {

   public ReverseStep()
   {
    super("ReverseStep", "", Category.MOVEMENT);
	}

	@SubscribeEvent
	public void onUpdate(final TickEvent.ClientTickEvent event) {
		if(mc.world == null || mc.player.isInWater() || mc.player.isInLava()) return;
		if (mc.player.onGround) {
            mc.player.motionY -= 1.0;
        }
	}
	
}
