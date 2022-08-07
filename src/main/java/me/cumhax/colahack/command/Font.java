package me.cumhax.colahack.command;

import me.cumhax.colahack.Client;
import me.cumhax.colahack.command.Command;
import me.cumhax.colahack.util.LoggerUtil;
import me.cumhax.colahack.util.font.CustomFontRenderer;
import me.cumhax.colahack.util.font.FontUtil;

public class Font
extends Command {
    public Font(String name, String[] alias, String usage) {
        super(name, alias, usage);
    }

    @Override
    public void onTrigger(String arguments) {
        if (arguments.equals("")) {
            this.printUsage();
            return;
        }
        if (FontUtil.validateFont(arguments)) {
            try {
                Client.customFontRenderer = new CustomFontRenderer(new java.awt.Font(arguments, 0, 19), true, false);
                LoggerUtil.sendMessage("New font set to " + arguments);
            }
            catch (Exception e) {
                LoggerUtil.sendMessage("Failed to set font");
            }
        } else {
            LoggerUtil.sendMessage("Invalid font");
        }
    }
}
