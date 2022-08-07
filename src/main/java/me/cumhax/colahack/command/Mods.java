package me.cumhax.colahack.command;

import me.cumhax.colahack.command.*;
import me.cumhax.colahack.util.LoggerUtil;
import java.awt.*;
import java.io.*;

public class Mods extends Command
{
    public Mods(String name, String[] alias, String usage) {
        super(name, alias, usage);
    }
    
    public void execute(final String[] commands) {
        try {
            Desktop.getDesktop().open(new File("mods/"));
            LoggerUtil.sendMessage("Mods folder opened!");
        }
        catch (IOException e) {
            LoggerUtil.sendMessage("Mods folder not opened!");
            e.printStackTrace();
        }
    }
}
