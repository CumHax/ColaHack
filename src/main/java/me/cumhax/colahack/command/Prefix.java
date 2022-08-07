package me.cumhax.colahack.command;

import me.cumhax.colahack.Client;
import me.cumhax.colahack.command.Command;
import me.cumhax.colahack.util.LoggerUtil;

public class Prefix
extends Command {
    public Prefix(String name, String[] alias, String usage) {
        super(name, alias, usage);
    }

    @Override
    public void onTrigger(String arguments) {
        if (arguments.equals("")) {
            this.printUsage();
            return;
        }
        Client.commandManager.setPrefix(arguments);
        LoggerUtil.sendMessage("Prefix set to " + arguments);
    }
}
