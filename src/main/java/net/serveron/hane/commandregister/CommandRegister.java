package net.serveron.hane.commandregister;

import net.serveron.hane.commandregister.command.TemplateCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandRegister extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new TemplateCommand(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
