package me.cumhax.colahack.module.render;

import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import me.cumhax.colahack.setting.Setting;

public class CustomFont
extends Module {
    public final Setting fontsise = new Setting("Font Sise", this, 20, 14, 30);
    public final Setting yoffset = new Setting("Y-Offset", this, 0, -8, 8);

 	public CustomFont() {
		super("CustomFont", "", Category.RENDER);
        this.addSetting(this.fontsise);
        this.addSetting(this.yoffset);
    }

    @Override
    public void onUpdate() {
    }
}
