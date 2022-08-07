package me.cumhax.colahack.module.hud;

import me.cumhax.colahack.Client;
import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
public class HUDEditor extends Module {

	public HUDEditor() {
		super("HudEditor", "", Category.HUD);
    }

    @Override
    public void onEnable() {
        mc.displayGuiScreen(Client.hudEditor);
    }
}
