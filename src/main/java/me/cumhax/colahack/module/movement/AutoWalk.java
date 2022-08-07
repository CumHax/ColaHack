package me.cumhax.colahack.module.movement;

import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoWalk extends Module {
	public AutoWalk() {
		super("AutoWalk", "Walk Automatically", Category.MOVEMENT);
	}

	@SubscribeEvent
	public void onUpdateInput(final InputUpdateEvent event) {
		event.getMovementInput().moveForward = 1.0f;
	}
}
