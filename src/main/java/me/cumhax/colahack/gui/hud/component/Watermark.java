package me.cumhax.colahack.gui.hud.component;

import me.cumhax.colahack.module.Category;
import me.cumhax.colahack.module.Module;
import me.cumhax.colahack.setting.Setting;

public class Watermark
extends Module {
    public final Setting X_ = new Setting("X", this, 100, 0, 8000);
    public final Setting Y_ = new Setting("Y", this, 100, 0, 8000);

   public Watermark() {
      super("Watermark", "", Category.HUD);
        this.addSetting(this.X_);
        this.addSetting(this.Y_);
    }
}
