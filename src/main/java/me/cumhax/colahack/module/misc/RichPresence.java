package me.cumhax.colahack.module.misc;

import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import me.cumhax.colahack.Discord;

public class RichPresence extends Module {
	
	public RichPresence() {
        super("RPC", "", Category.MISC);
    }

    public void enable() {
        Discord.start();
    }

    public void disable() {
        Discord.stop();
    }
}
