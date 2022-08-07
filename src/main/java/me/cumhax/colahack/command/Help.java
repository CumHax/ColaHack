package me.cumhax.colahack.command;

import me.cumhax.colahack.Client;
import me.cumhax.colahack.command.Command;
import me.cumhax.colahack.util.LoggerUtil;

public class Help
extends Command {
    public Help(String name, String[] alias, String usage) {
        super(name, alias, usage);
    }

    @Override
    public void onTrigger(String arguments) {
        LoggerUtil.sendMessage("AcidCore");
        for (Command command : Client.commandManager.getCommands()) {
            LoggerUtil.sendMessage(command.getName() + " - " + command.getUsage());
        }
    }
}
