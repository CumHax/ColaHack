package me.cumhax.colahack.module.render;

import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;

public class FullBright extends Module {
	
	float old;
	
	public FullBright() {
		super("FullBright", "", Category.RENDER);
	}

	@Override
	public void onEnable() {
        old = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 666f;
    }
	
    public void onDisable() {
        mc.gameSettings.gammaSetting = old;
    }

}
